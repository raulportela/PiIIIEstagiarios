package br.senac.tads.pi3a.livrariatades.db.dao.frase;

import br.senac.tads.pi3a.livrariatades.db.utils.ConnectionUtils;
import br.senac.tads.pi3a.livrariatades.model.filial.Filial;
import br.senac.tads.pi3a.livrariatades.model.frase.Frase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Raul Portela
 */
public class DaoFrase {

    public static Frase procurar(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Frases\n"
                + "Where id = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            result = preparedStatement.executeQuery();

            if (result.next()) {
                Frase frase = new Frase();
                frase.setId(result.getInt("id"));
                frase.setFrase(result.getString("frase"));
                frase.setAutor(result.getString("autor"));
                return frase;
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
