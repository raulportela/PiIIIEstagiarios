/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.db.dao.pessoa;

import br.senac.tads.pi3a.livrariatades.model.pessoa.cliente.Cliente;
import br.senac.tads.pi3a.livrariatades.db.utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raul de Paula
 */
public class DaoPessoa {
    public static void inserirPessoa(Cliente cliente)
            throws SQLException, Exception {
        Cliente c1 = cliente;

        String sql = "INSERT INTO Pessoa VALUES (0, ?, ?, ?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getSobrenome());
            preparedStatement.setInt(3, cliente.getCpf());
            Timestamp t = new Timestamp(cliente.getDataNascimento().getTime());
            preparedStatement.setTimestamp(4, t);
            
            preparedStatement.execute();
            int ultimaChave;
            ResultSet chaveGeradaVenda = preparedStatement.getGeneratedKeys();
            
            
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

        String sql = "UPDATE cliente SET NomeCliente=?, CPF=?, DataNasc=?, Email=?, Telefone1=?, Telefone2=?, Endereço=? WHERE (cliente_id=?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(2, cliente.getNome());
            preparedStatement.setString(3, cliente.getCpf());
//            Timestamp t = new Timestamp(cliente.getDataNascimento().getTime());
//            preparedStatement.setTimestamp(4, t);
            preparedStatement.setString(5, cliente.getEmail());
            preparedStatement.setInt(6, cliente.getTelefone());
            preparedStatement.setInt(7, cliente.getCelular());
            preparedStatement.setString(8, cliente.getEndereco());

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
                
                long codCliente = result.getLong("CodCliente");
                String nome = result.getString("NomeCliente");
                String sobrenome = result.getString("Sobrenome");
                String cpf = result.getString("Cpf");
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
                
               
                Cliente cliente = new Cliente(nome, sobrenome, cpf, null, null, 0, 0, null);
                cliente.setId(codCliente);

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
