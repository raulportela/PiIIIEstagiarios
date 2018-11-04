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
import java.util.Calendar;
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
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, venda.getNotaFiscal());
            if (venda.getData() == null) {
                Calendar hoje = Calendar.getInstance();
                Date dataHoje = hoje.getTime();
                Timestamp t = new Timestamp(dataHoje.getTime());
                preparedStatement.setTimestamp(2, t);
            } else {
                Timestamp t = new Timestamp(venda.getData().getTime());
                preparedStatement.setTimestamp(2, t);
            }
            preparedStatement.setFloat(3, venda.getValorTotal());

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
        String sql = "UPDATE Produto SET quantidade=?, disponivel=?"
                + "WHERE (id=?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            if (item.getProduto().getQuantidade() == 0) {
                preparedStatement.setInt(1, item.getProduto().getQuantidade());
                preparedStatement.setBoolean(2, false);
            }else if (item.getProduto().getQuantidade() > 0) {
                preparedStatement.setInt(1, item.getProduto().getQuantidade());
                preparedStatement.setBoolean(2, true);
            }
            preparedStatement.setInt(3, item.getProduto().getId());

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
}
