/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.db.dao.venda;

import br.senac.tads.pi3a.livrariatades.db.utils.ConnectionUtils;
import br.senac.tads.pi3a.livrariatades.model.venda.ItemVendido;
import br.senac.tads.pi3a.livrariatades.model.venda.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Raul de Paula
 */
public class DaoVenda {

    public static void inserir(Venda venda) throws SQLException, Exception {
        String sql = "INSERT INTO Venda VALUES (0, ?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql, preparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, venda.getIdPessoa());
            preparedStatement.setString(2, "" + venda.getNotaFiscal());
            Date data = new Date();
            Timestamp t = new Timestamp(data.getTime());
            preparedStatement.setTimestamp(3,  t);
            preparedStatement.setFloat(4, venda.getValorTotal());
            preparedStatement.execute();

            int ultimaChave = 0;
            ResultSet chaveGeradaVenda = preparedStatement.getGeneratedKeys();
            if (chaveGeradaVenda.next()) {
                ultimaChave = chaveGeradaVenda.getInt(1);
            }
            for (ItemVendido item : venda.getListaItensVendidos()) {
                inserirItemVenda(item, ultimaChave);
                decrementarEstoque(item);
            }
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public static void inserirItemVenda(ItemVendido itemVenda, int chaveVenda) throws SQLException, Exception {
        String sql = "INSERT INTO ItemVenda VALUES (0,?, ?, ?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, chaveVenda);
            preparedStatement.setInt(2, itemVenda.getProduto().getId());
            preparedStatement.setInt(3, itemVenda.getQuantidade());
            preparedStatement.setFloat(4, itemVenda.getProduto().getValor());

            preparedStatement.execute();
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.isClosed();
            }
            if (connection != null && !connection.isClosed()) {
                connection.isClosed();
            }
        }
    }

    public static void decrementarEstoque(ItemVendido item) throws SQLException, Exception {
        String sql = "UPDATE FilialTemLivro SET quantidade=?"
                + "WHERE (id=?)";
        String sql2 = "UPDATE Livro SET disponivel=?"
                + "WHERE (id=?)";
        boolean disponivel = false;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            if (item.getProduto().getQuantidade() == 0) {
                preparedStatement.setInt(1, item.getProduto().getQuantidade());
                preparedStatement.setInt(2, item.getProduto().getId());
                disponivel = false;
            } else if (item.getProduto().getQuantidade() > 0) {
                preparedStatement.setInt(1, item.getProduto().getQuantidade());
                preparedStatement.setInt(2, item.getProduto().getId());
                disponivel = true;
            }

            preparedStatement.execute();

            if (!preparedStatement.isClosed()) {
                preparedStatement.close();
            }

            preparedStatement = connection.prepareStatement(sql2);
            if (disponivel) {
                preparedStatement.setBoolean(1, true);
            } else {
                preparedStatement.setBoolean(1, false);
            }
            preparedStatement.setInt(2, item.getProduto().getId());

        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.isClosed();
            }

            if (connection != null && !connection.isClosed()) {
                connection.isClosed();
            }
        }
    }

    public static int numeroNota(int codFIlial) throws SQLException, Exception {
        String sql = "SELECT id FROM Venda\n"
                + "WHERE codFilial = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        int qtdNotas = 0;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, codFIlial);

            result = preparedStatement.executeQuery();

            if (result.next()) {
                qtdNotas = result.getInt(1);
            }
            return qtdNotas;
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.isClosed();
            }
            if (connection != null && !connection.isClosed()) {
                connection.isClosed();
            }
        }
    }
}
