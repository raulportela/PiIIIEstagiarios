/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.db.dao.produto;

import br.senac.tads.pi3a.livrariatades.db.utils.ConnectionUtils;
import br.senac.tads.pi3a.livrariatades.model.produto.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author erikapalms
 */

public class DaoProduto {

    public static void inserir(Produto produto)
            
        throws SQLException, Exception {
        
            String sql = "INSERT INTO Livro VALUES ( '', '', ?, ?, ?, ?, ?)";
            String sql2 = "INSERT INTO Autor VALUES ('', ?)";
            String sql3 = "INSERT INTO Editora VALUES ('', ?)";
            
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            
        try {
            
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setBoolean(3, produto.isDisponivel());
            preparedStatement.setString(4, produto.getTitulo());
            preparedStatement.setString(5, produto.getDescricao());
            preparedStatement.setInt(6, produto.getQuantidade());
            preparedStatement.setFloat(7, produto.getValor());

            preparedStatement.execute();
            
            // execução da segunda inserção
            preparedStatement = connection.prepareStatement(sql2);
            
            preparedStatement.setString(2, produto.getEditora());

            preparedStatement.execute();
            
            // execução da terceira inserção
            preparedStatement = connection.prepareStatement(sql3);
            
            preparedStatement.setString(2, produto.getAutor());

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

}
