/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.db.dao.relatorio;

import br.senac.tads.pi3a.livrariatades.db.utils.ConnectionUtils;
import br.senac.tads.pi3a.livrariatades.model.relatorio.Relatorio;
import br.senac.tads.pi3a.livrariatades.model.venda.ItemVendido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raul de Paula
 */
public class DaoRelatorio {

    public static List<Relatorio> gerar(int codFilial) throws ClassNotFoundException, SQLException {
        String sql = "SELECT dtCompra FROM venda\n"
                + "WHERE codFIlial = ?\n"
                + "ORDER BY dtCompra ASC";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        List<Relatorio> listaRelatorio = new ArrayList();
        try {

            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, codFilial);

            result = preparedStatement.executeQuery();
            int contador = 0;
            boolean primeira = true;
            Relatorio relatorio = new Relatorio();
            while (result.next()) {
                Timestamp t = result.getTimestamp("dtCompra");
                if (primeira) {
                    relatorio.setDia(t.toLocalDateTime().toLocalDate());
                    relatorio.setQtdProdutos(DaoRelatorio.listarQtdProduto(t, codFilial));
                    relatorio.setTotalDia(DaoRelatorio.listarTotalDia(t, codFilial));
                    listaRelatorio.add(relatorio);
                    primeira = false;
                } else {
                    for (int i = 0; i < listaRelatorio.size(); i++) {
                        Relatorio rl = listaRelatorio.get(contador);
                        java.util.Date date = java.sql.Date.valueOf(rl.getDia());
                        Timestamp tr = new Timestamp(date.getTime());
                        if (!tr.equals(t)) {
                            relatorio.setDia(t.toLocalDateTime().toLocalDate());
                            relatorio.setQtdProdutos(DaoRelatorio.listarQtdProduto(t, codFilial));
                            relatorio.setTotalDia(DaoRelatorio.listarTotalDia(t, codFilial));
                            listaRelatorio.add(relatorio);
                        }
                        contador++;
                    }

                }
            }
            return listaRelatorio;

        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public static int listarQtdProduto(Timestamp t, int codFilial) throws ClassNotFoundException, SQLException {
        String sql = "SELECT SUM(quantidade) FROM itemVenda\n"
                + "WHERE idVenda IN (SELECT id FROM venda WHERE dtcompra = ?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        int qtdProduto = 0;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setTimestamp(1, t);

            result = preparedStatement.executeQuery();
            if (result.next()) {
                qtdProduto = result.getInt(1);
            }
            return qtdProduto;

        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public static float listarTotalDia(Timestamp t, int codFilial) throws ClassNotFoundException, SQLException {
        String sql = "SELECT SUM(valorTotal) AS VT FROM venda\n"
                + "WHERE codFIlial = ? AND dtCompra = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, codFilial);
            preparedStatement.setTimestamp(2, t);

            result = preparedStatement.executeQuery();
            
            if (result.next()) {
                float valor = result.getFloat("VT");
                System.out.println(valor);
                return valor;
            }
            return 0;

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
