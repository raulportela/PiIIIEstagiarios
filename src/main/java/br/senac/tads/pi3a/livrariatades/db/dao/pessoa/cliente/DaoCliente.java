/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.db.dao.pessoa.cliente;

import br.senac.tads.pi3a.livrariatades.db.dao.contato.DaoContato;
import br.senac.tads.pi3a.livrariatades.db.dao.endereco.DaoEndereco;
import br.senac.tads.pi3a.livrariatades.model.pessoa.cliente.Cliente;
import br.senac.tads.pi3a.livrariatades.db.utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raul de Paula
 */
public class DaoCliente {

    public static void inserir(Cliente cliente, int ultimaChavePessoa)
            throws SQLException, Exception {
        String sql = "INSERT INTO cliente VALUES (0, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, ultimaChavePessoa);
            preparedStatement.setInt(2, cliente.getCodCliente());
            preparedStatement.setBoolean(3, cliente.isDisponivel());
            preparedStatement.setInt(4, cliente.getTotalCompras());
            
            DaoContato.inserirContato(cliente, ultimaChavePessoa);
            DaoEndereco.inserirEndereco(cliente, ultimaChavePessoa);
            
            preparedStatement.execute();
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
    
    public static void atualizar(Cliente cliente)
            throws SQLException, Exception {

        String sql = "UPDATE Cliente SET disponivel=?, totalCompras=? "
                + "WHERE (idPessoa=?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setBoolean(1, cliente.isDisponivel());
            preparedStatement.setInt(2, cliente.getTotalCompras());
            preparedStatement.setInt(3, cliente.getIdPessoa());
            
            DaoContato.atualizar(cliente);
            DaoEndereco.atualizar(cliente);
            preparedStatement.execute();

        } finally {

            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public static void excluir(Integer id)
            throws SQLException, Exception {

        String sql = "UPDATE cliente SET enabled=? WHERE (cliente_id=?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, false);
            preparedStatement.setInt(2, id);

            preparedStatement.execute();

        } finally {

            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public static List<Cliente> listar()
            throws SQLException, Exception {
        String sql = "SELECT * FROM cliente";
        List<Cliente> listaClientes = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                if (listaClientes == null) {
                    listaClientes = new ArrayList<Cliente>();
                }
                Cliente cliente = new Cliente();

//                cliente.setId(result.getLong("CodCliente"));
                cliente.setNome(sql = result.getString("NomeCliente"));
                cliente.setSobrenome(result.getString("Sobrenome"));
                cliente.setCpf(result.getString("Cpf"));
//                Data datanasc = result.getString("DataNascimento");
//                cliente.setSexo(result.getString("Sexo"));
//                cliente.setUfNascimento(result.getString("UfNascimento"));
//                cliente.setEstadoNascimento(result.getString("EstadoNascimento"));
//                cliente.setEstadoCivil(result.getString("EstadoCivil"));
//                cliente.setRua(result.getString("Rua"));
//                cliente.setNumero(result.getString("Numero"));
//                cliente.setBairro(result.getString("Bairro"));
//                cliente.setCep(result.getString("Cep"));
//                cliente.setComplemento(result.getString("Complemento"));
//                cliente.setUf(result.getString("Uf"));
//                cliente.setEstado(result.getString("Estado"));
//                cliente.setTelefone(result.getString("Telefone"));
//                cliente.setCelular(result.getString("Celular"));
//                cliente.setOutroContato(result.getString("OutroContato"));
//                cliente.setEmail(result.getString("Email"));

                listaClientes.add(cliente);
            }
        } finally {
            if (result != null && !result.isClosed()) {
                result.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return listaClientes;
    }

}
