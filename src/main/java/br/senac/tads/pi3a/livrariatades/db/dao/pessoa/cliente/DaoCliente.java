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
import br.senac.tads.pi3a.livrariatades.model.contato.Contato;
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
        String sql = "INSERT INTO cliente VALUES (0, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, ultimaChavePessoa);
            preparedStatement.setInt(2, cliente.getCodCliente());
            preparedStatement.setBoolean(3, cliente.isDisponivel());
            preparedStatement.setInt(4, cliente.getTotalCompras());

            DaoContato.inserirContato(cliente.getContato(), ultimaChavePessoa);
            DaoEndereco.inserir(cliente.getEndereco(), ultimaChavePessoa);

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

            DaoContato.atualizar(cliente.getContato(), cliente.getIdPessoa());
            DaoEndereco.atualizar(cliente.getEndereco(), cliente.getIdPessoa());
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

        String sql = "UPDATE Cliente SET dispinivel=? "
                + "WHERE (idPessoa=?)";

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

    public static List<Cliente> listar(List<Cliente> listaPessoa)
            throws SQLException, Exception {
        String sql = "SELECT * FROM Cliente";

        int contador = 0;
        Cliente cliente;
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
                int idPessoa;
                idPessoa = result.getInt("idPessoa");
                cliente = listaPessoa.get(contador);

                if (idPessoa == cliente.getIdPessoa()) {
                    cliente.setCodCliente(result.getInt("codCliente"));
                    cliente.setDisponivel(result.getBoolean("disponivel"));
                    cliente.setTotalCompras(result.getInt("totalCompras"));
                    cliente.setContato(DaoContato.procurar(idPessoa));
                    cliente.setEndereco(DaoEndereco.procurar(idPessoa));

                    listaClientes.add(cliente);
                }
                contador++;
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

    public static Cliente procurar(Cliente cliente)
            throws SQLException, Exception {
        String sql = "SELECT * FROM Cliente "
                + "WHERE idPessoa=?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cliente.getIdPessoa());

            result = preparedStatement.executeQuery();
            
            cliente.setCodCliente(result.getInt("codCliente"));
            cliente.setDisponivel(result.getBoolean("disponivel"));
            cliente.setTotalCompras(result.getInt("totalCompras"));

            cliente.setContato(DaoContato.procurar(cliente.getIdPessoa()));
            cliente.setEndereco(DaoEndereco.procurar(cliente.getIdPessoa()));

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
        return cliente;
    }

}
