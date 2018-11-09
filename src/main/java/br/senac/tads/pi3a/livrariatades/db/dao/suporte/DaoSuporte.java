/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.db.dao.suporte;

import br.senac.tads.pi3a.livrariatades.db.utils.ConnectionUtils;
import br.senac.tads.pi3a.livrariatades.model.pessoa.cliente.Cliente;
import br.senac.tads.pi3a.livrariatades.model.suporte.Suporte;
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
public class DaoSuporte {
    public static void inserir(Suporte suporte)
            throws SQLException, Exception {
        String sql = "INSERT INTO Suporte VALUES (0, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql, preparedStatement.RETURN_GENERATED_KEYS);

//            preparedStatement.setString(1, pessoa.getNome());

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

    public static void atualizar(Suporte suporte)
            throws SQLException, Exception {
        String sql = "UPDATE SUPORTE SET nome=?, sobrenome=?, cpf=?, dataNascimento=?\n"
                + "WHERE (cpf=?);";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, pessoa.getNome());
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

    public static List<Suporte> listar()
            throws SQLException, Exception {
        String sql = "SELECT * FROM SUPORTE P\n"
                + "WHERE (C.DISPONIVEL=?)";

        ArrayList<Suporte> listaSuporte = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        Cliente cliente;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
          preparedStatement.setBoolean(1, true);

            result = preparedStatement.executeQuery();

            while (result.next()) {

                cliente = new Cliente();

                cliente.setIdPessoa(result.getInt("id"));
            }
            return listaSuporte;
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

    }

    public static Suporte procurar(String cpf)
            throws SQLException, Exception {
        String sql = "SELECT * FROM SUPORTE\n"
                + "WHERE (ID = ?)";

        Suporte suporte = new Suporte();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cpf);

            result = preparedStatement.executeQuery();

            if (result.next()) {

                suporte.setId(result.getInt("id"));

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
        return suporte;
    }

}
