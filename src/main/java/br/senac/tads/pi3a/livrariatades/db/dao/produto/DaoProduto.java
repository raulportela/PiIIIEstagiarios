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

        String sql = "INSERT INTO Editora VALUES (0, ?)";
        String sql2 = "INSERT INTO Autor VALUES (0, ?)";
        String sql3 = "INSERT INTO Livro VALUES (0, ?, ?, ?, ?, ?, ?)";
        String sql4 = "INSERT INTO FilialTemLivro VALUES (0, ?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql, preparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, produto.getEditora());
            preparedStatement.execute();
            int chaveEditora = 0;
            ResultSet chaveGeradaEditora = preparedStatement.getGeneratedKeys();
            if (chaveGeradaEditora.next()) {
                chaveEditora = chaveGeradaEditora.getInt(1);
            }

            if (!preparedStatement.isClosed()) {
                preparedStatement.close();
            }

            // execução da segunda inserção
            preparedStatement = connection.prepareStatement(sql2, preparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, produto.getAutor());
            preparedStatement.execute();
            int chaveAutor = 0;
            ResultSet chaveGeradaAutor = preparedStatement.getGeneratedKeys();
            if (chaveGeradaAutor.next()) {
                chaveAutor = chaveGeradaAutor.getInt(1);
            }
            if (!preparedStatement.isClosed()) {
                preparedStatement.close();
            }

            // execução da terceira inserção
            preparedStatement = connection.prepareStatement(sql3, preparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, chaveEditora);
            preparedStatement.setInt(2, chaveAutor);
            preparedStatement.setInt(3, produto.getCodFilial());
            preparedStatement.setBoolean(4, produto.isDisponivel());
            preparedStatement.setString(5, produto.getTitulo());
            preparedStatement.setString(6, produto.getDescricao());
            preparedStatement.execute();

            int chaveLivro = 0;
            ResultSet chaveGeradaLivro = preparedStatement.getGeneratedKeys();
            if (chaveGeradaLivro.next()) {
                chaveLivro = chaveGeradaLivro.getInt(1);
            }

            if (!preparedStatement.isClosed()) {
                preparedStatement.close();
            }

            preparedStatement = connection.prepareStatement(sql4);
            preparedStatement.setInt(1, produto.getCodFilial());
            preparedStatement.setInt(2, chaveLivro);
            preparedStatement.setInt(3, produto.getQuantidade());
            preparedStatement.setFloat(4, produto.getValor());
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

    public static void atualizar(Produto produto) throws SQLException, Exception {

        String sql = "UPDATE EDITORA SET NOME=?\n"
                + "WHERE (ID = ?)";
        String sql2 = "UPDATE AUTOR SET NOMECOMPLETO=?\n"
                + "WHERE (ID = ?)";
        String sql3 = "UPDATE LIVRO SET IDEDITORA=?, IDAUTOR=?, CODFILIAL=?, DISPONIVEL=?, TITULO=?, DESCRICAO=?\n"
                + "WHERE (ID = ?)";
        String sql4 = "UPDATE FILIALTEMLIVRO FT SET QUANTIDADE=?, VALOR=?\n"
                + "WHERE IDLIVRO = (SELECT  ID FROM LIVRO WHERE ID = ?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = ConnectionUtils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, produto.getEditora());
            preparedStatement.setInt(2, produto.getIdEditora());
            preparedStatement.execute();
            if (!preparedStatement.isClosed()) {
                preparedStatement.close();
            }

            // execução da segunda inserção
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setString(1, produto.getAutor());
            preparedStatement.setInt(2, produto.getIdAutor());
            preparedStatement.execute();
            if (!preparedStatement.isClosed()) {
                preparedStatement.close();
            }

            // execução da terceira inserção
            preparedStatement = connection.prepareStatement(sql3);
            preparedStatement.setInt(1, produto.getIdEditora());
            preparedStatement.setInt(2, produto.getIdAutor());
            preparedStatement.setInt(3, produto.getCodFilial());
            preparedStatement.setBoolean(4, produto.isDisponivel());
            preparedStatement.setString(5, produto.getTitulo());
            preparedStatement.setString(6, produto.getDescricao());
            preparedStatement.setInt(7, produto.getCodFilial());
            preparedStatement.execute();
            if (!preparedStatement.isClosed()) {
                preparedStatement.close();
            }

          
             // execução da qaurta inserção
            preparedStatement = connection.prepareStatement(sql4);
            preparedStatement.setInt(1, produto.getQuantidade());
            preparedStatement.setFloat(2, produto.getValor());
            preparedStatement.setInt(3, produto.getId());
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

    public static void excluir(int id) throws SQLException, Exception {

        String sql = "UPDATE LIVRO SET DISPONIVEL=0\n"
                + "WHERE (ID = ?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

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

    public static List<Produto> listar(String ordem, int codFilial) throws SQLException, Exception {

        if (ordem == null) {
            ordem = "L.titulo ASC";
        }
        String sql = "SELECT * FROM LIVRO L\n"
                + "JOIN EDITORA E\n"
                + "ON L.IDEDITORA = E.ID\n"
                + "JOIN AUTOR A\n"
                + "ON L.IDAUTOR = A.ID\n"
                + "JOIN FILIALTEMLIVRO FT\n"
                + "ON FT.IDLIVRO = L.ID\n"
                + "WHERE L.CODFILIAL = ? \n"
                + "ORDER BY " + ordem;
        List<Produto> listaProdutos = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, codFilial);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                Produto produto = new Produto();

                produto.setId(result.getInt("L.id"));
                produto.setTitulo(result.getString("L.titulo"));
                produto.setDescricao(result.getString("L.descricao"));
                produto.setDisponivel(result.getBoolean("L.disponivel"));
                produto.setQuantidade(result.getInt("FT.quantidade"));
                produto.setValor(result.getFloat("FT.valor"));

                produto.setIdEditora(result.getInt("L.idEditora"));
                produto.setEditora(result.getString("E.nome"));
                produto.setIdAutor(result.getInt("L.idAutor"));
                produto.setAutor(result.getString("A.nomeCompleto"));

                listaProdutos.add(produto);
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

    public static Produto procurar(int id, int codFilial) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM LIVRO L\n"
                + "JOIN EDITORA E\n"
                + "ON L.IDEDITORA = E.ID\n"
                + "JOIN AUTOR A\n"
                + "ON L.IDAUTOR = A.ID\n"
                + "JOIN FILIALTEMLIVRO FT\n"
                + "ON FT.IDLIVRO = L.ID\n"
                + "WHERE L.CODFILIAL = ? \n"
                + "AND L.ID = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, codFilial);
            preparedStatement.setInt(2, id);

            result = preparedStatement.executeQuery();

            if (result.next()) {
                Produto produto = new Produto();

                produto.setId(result.getInt("L.id"));
                produto.setTitulo(result.getString("titulo"));
                produto.setDescricao(result.getString("descricao"));
                produto.setDisponivel(result.getBoolean("disponivel"));
                produto.setQuantidade(result.getInt("quantidade"));
                produto.setValor(result.getFloat("valor"));

                produto.setIdEditora(result.getInt("idEditora"));
                produto.setEditora(result.getString("nome"));
                produto.setIdAutor(result.getInt("idAutor"));
                produto.setAutor(result.getString("nomeCompleto"));

                return produto;
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
