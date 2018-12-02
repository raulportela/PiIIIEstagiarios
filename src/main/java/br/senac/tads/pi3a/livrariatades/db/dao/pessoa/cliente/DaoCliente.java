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

    public static void atualizar(Cliente cliente, String cpf)
            throws SQLException, Exception {

        String sql = "UPDATE CLIENTE SET codCliente=?"
                + ", disponivel=?, totalCompras=?\n"
                + "WHERE id = (SELECT ID FROM PESSOA\n"
                + "						WHERE cpf=?);";
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, cliente.getCodCliente());
            preparedStatement.setBoolean(2, cliente.isDisponivel());
            preparedStatement.setInt(3, cliente.getTotalCompras());
            preparedStatement.setString(4, cpf);

            DaoContato.atualizar(cliente.getContato(), cpf);
            DaoEndereco.atualizar(cliente.getEndereco(), cpf);
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

    public static void mudarStatus(String cpf, String status)
            throws SQLException, Exception {

        String sql = "UPDATE CLIENTE C\n"
                + "SET C.DISPONIVEL = "+status+"\n"
                + "WHERE C.IDPESSOA = (SELECT ID FROM PESSOA p\n"
                + "							WHERE P.CPF=?);";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cpf);

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

    public static Cliente procurar(Cliente cliente)
            throws SQLException, Exception {
        String sql = "SELECT * FROM Cliente";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            result = preparedStatement.executeQuery();

            if (result.next()) {
                cliente.setCodCliente(result.getInt("codCliente"));
                cliente.setDisponivel(result.getBoolean("disponivel"));
                cliente.setTotalCompras(result.getInt("totalCompras"));

                cliente.setContato(DaoContato.procurar(cliente.getIdPessoa()));
                cliente.setEndereco(DaoEndereco.procurar(cliente.getIdPessoa()));

                return cliente;
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
        return null;
    }
}
