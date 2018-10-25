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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author erikapalms
 */

public class DaoProduto {

    public static void inserir(Produto produto) throws SQLException, Exception {
        
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
            
            if (preparedStatement != null && !preparedStatement.isClosed()){
                preparedStatement.close();
            }
            
            if (connection != null && !connection.isClosed()){
                connection.close();
            }
        }
    }

    public static void atualizar(Produto produto) throws SQLException, Exception {

            String sql = "UPDATE Livro SET disponivel=?, titulo=?, descricao=?, "
                + "quantidade=?, valor=? WHERE (id=?)";
            String sql2 = "UPDATE Autor SET nomeCompleto=? WHERE (id=?)";
            String sql3 = "UPDATE Editora SET nome=? WHERE (id=?)";
            String sql4 = "SELECT idAutor, idEditora FROM Livro";

            Connection connection = null;
            PreparedStatement preparedStatement = null;
        
        try {
            //long id, id2;
            
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setBoolean(1, produto.isDisponivel());
            preparedStatement.setString(2, produto.getTitulo());
            preparedStatement.setString(3, produto.getDescricao());
            preparedStatement.setInt(4, produto.getQuantidade());
            preparedStatement.setFloat(5, produto.getValor());
            preparedStatement.setFloat(6, produto.getId());
            
            preparedStatement.execute();
            
            // chamada para pegar os id's
            preparedStatement = connection.prepareStatement(sql4);
           // id = preparedStatement.getId();
            preparedStatement.execute();
            
           
            
            // execução da segunda inserção
            preparedStatement = connection.prepareStatement(sql2);
            
            preparedStatement.setString(2, produto.getEditora());
            preparedStatement.setFloat(6, produto.getId());
            
            preparedStatement.execute();
            
            // execução da terceira inserção
            preparedStatement = connection.prepareStatement(sql3);
            
            preparedStatement.setString(2, produto.getAutor());

            preparedStatement.execute();
            
            } finally {
                  
                if (preparedStatement != null && !preparedStatement.isClosed()){
                    preparedStatement.close();
                }
                  
                if (connection != null && !connection.isClosed()){
                    connection.close();
                }
            }
        }
    
    public static void excluir(Integer id) throws SQLException, Exception {
        
        String sql = "UPDATE Livro SET disponivel=? WHERE (id=?)";
        
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
    
    public static List<Produto> listar() throws SQLException, Exception {
        
        String sql = "SELECT * FROM Livro WHERE (disponivel=?)";
        List<Produto> listaProdutos = null;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        
        try {

            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, true);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                
                if (listaProdutos == null) {
                    listaProdutos = new ArrayList<Produto>();
                }
                
                Produto produto = new Produto();
                //produto.setId(result.getInt("cliente_id"));
                produto.setTitulo(result.getString("titulo"));
                produto.setDescricao(result.getString("descricao"));
                produto.setDisponivel(result.getBoolean("disponivel"));                
                produto.setQuantidade(result.getInt("quantidade"));
                produto.setValor(result.getFloat("valor"));

                listaProdutos.add(produto);
                //String titulo, String autor, String editora, String descricao,
            //Integer quantidade, boolean disponivel, Float valor)
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
        
        return listaProdutos;
    }

}
