/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.db.dao.suporte;

import br.senac.tads.pi3a.livrariatades.db.utils.ConnectionUtils;
import br.senac.tads.pi3a.livrariatades.model.suporte.Suporte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Raul de Paula
 */
public class DaoSuporte {

    public static void inserir(Suporte suporte)
            throws SQLException, Exception {
        String sql = "INSERT INTO Suporte VALUES (0, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql, preparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, suporte.getCodFuncionario());
            preparedStatement.setBoolean(2, true);
            preparedStatement.setString(3, suporte.getNomeChamado());
            Timestamp t = new Timestamp(new Date().getTime());
            preparedStatement.setTimestamp(4, t);
            preparedStatement.setTimestamp(5, null);
            preparedStatement.setString(6, suporte.getDetalhe());
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
        String sql = "UPDATE SUPORTE SET nomeChamado=?, detalhe=?\n"
                + "WHERE (id=?);";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, suporte.getNomeChamado());
            preparedStatement.setString(2, suporte.getDetalhe());
            preparedStatement.setInt(3, suporte.getId());
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
    
    public static void finalizar(int id)
            throws SQLException, Exception {
        String sql = "UPDATE SUPORTE SET statusChamado=0, dataFechamento=?\n"
                + "WHERE (id=?);";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            Timestamp t = new Timestamp(new Date().getTime());
            preparedStatement.setTimestamp(1, t);
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
    
    public static List<Suporte> listar()
            throws SQLException, Exception {
        String sql = "SELECT * FROM SUPORTE";

        ArrayList<Suporte> listaSuporte = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        Suporte suporte;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            result = preparedStatement.executeQuery();

            while (result.next()) {
                suporte = new Suporte();

                suporte.setId(result.getInt("id"));
                suporte.setCodFuncionario(result.getInt("codFuncionario"));
                suporte.setStatusChamado(result.getBoolean("statusChamado"));
                suporte.setNomeChamado(result.getString("nomeChamado"));
                suporte.setDataAbertura(result.getDate("dataAbertura"));
                suporte.setDataFechamento(result.getDate("dataFechamento"));
                suporte.setDetalhe(result.getString("detalhe"));

                listaSuporte.add(suporte);
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

    public static Suporte procurar(int id)
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
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeQuery();

            if (result.next()) {
                suporte = new Suporte();

                suporte.setId(result.getInt("id"));
                suporte.setCodFuncionario(result.getInt("codFuncionario"));
                suporte.setStatusChamado(result.getBoolean("statusChamado"));
                suporte.setNomeChamado(result.getString("nomeChamado"));
                suporte.setDataAbertura(result.getDate("dataAbertura"));
                suporte.setDataFechamento(result.getDate("dataFechamento"));
                suporte.setDetalhe(result.getString("detalhe"));
            }
            return suporte;
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
}
