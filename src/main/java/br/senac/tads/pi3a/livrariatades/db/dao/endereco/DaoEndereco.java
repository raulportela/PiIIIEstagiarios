/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.db.dao.endereco;

import br.senac.tads.pi3a.livrariatades.db.utils.ConnectionUtils;
import br.senac.tads.pi3a.livrariatades.model.endereco.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Raul de Paula
 */
public class DaoEndereco {

    public static void inserir(Endereco endereco, int ultimaChavePessoa)
            throws SQLException, Exception {
        String sql = "INSERT INTO Endereco VALUES (0, ?, ?, ?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, ultimaChavePessoa);
            preparedStatement.setString(2, endereco.getRua());
            preparedStatement.setInt(3, endereco.getNumero());
            preparedStatement.setString(4, endereco.getBairro());
            preparedStatement.setInt(5, endereco.getCep());
            preparedStatement.setString(6, endereco.getComplemento());

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

    public static void atualizar(Endereco endereco, int idPessoa)
            throws SQLException, Exception {

        String sql = "UPDATE Endereco SET rua=?, numero=?, bairro=?, cep=?, complemento=? "
                + "WHERE (idPessoa=?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, endereco.getRua());
            preparedStatement.setInt(2, endereco.getNumero());
            preparedStatement.setString(3, endereco.getBairro());
            preparedStatement.setInt(4, endereco.getCep());
            preparedStatement.setString(5, endereco.getComplemento());
            preparedStatement.setInt(6, idPessoa);

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

    public static Endereco procurar(int idPessoa)
            throws SQLException, Exception {
        String sql = "SELECT * FROM Endereco"
                + "WHERE idPessoa=?";

        Endereco endereco = new Endereco();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idPessoa);
            
            result = preparedStatement.executeQuery();

            if (result.next()) {
                endereco.setRua(result.getString("rua"));
                    endereco.setNumero(result.getInt("numero"));
                    endereco.setBairro(result.getString("rua"));
                    endereco.setCep(result.getInt("cep"));
                    endereco.setComplemento(result.getString("complemento"));
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
        return endereco;
    }
}
