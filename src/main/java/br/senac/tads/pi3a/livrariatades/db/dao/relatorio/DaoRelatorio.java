/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.db.dao.relatorio;

import br.senac.tads.pi3a.livrariatades.db.dao.produto.DaoProduto;
import br.senac.tads.pi3a.livrariatades.db.utils.ConnectionUtils;
import br.senac.tads.pi3a.livrariatades.model.produto.Produto;
import br.senac.tads.pi3a.livrariatades.model.relatorio.Relatorio;
import br.senac.tads.pi3a.livrariatades.model.venda.ItemVendido;
import br.senac.tads.pi3a.livrariatades.model.venda.Venda;
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
    private static int qtdProduto;

    public static int getQtdProduto() {
        return qtdProduto;
    }

    public static void setQtdProduto(int qtdProduto) {
        DaoRelatorio.qtdProduto = qtdProduto;
    }
    public static  List<Relatorio> gerar(int codFilial) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Venda V\n"
                + "JOIN itemVenda IV\n"
                + "ON v.id = iv.idvenda\n"
                + "JOIN livro l\n"
                + "ON iv.idLivro = l.id\n"
                + "WHERE V.codFIlial = ?\n"
                + "ORDER BY V.DATACOMPRA ASC";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        List<Relatorio> listaRelatorio = new ArrayList();
        try {

            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, codFilial);

            result = preparedStatement.executeQuery();

            Relatorio relatorio = new Relatorio();
            Venda venda = new Venda();
            ItemVendido itemVenda = new ItemVendido();
            while (result.next()) {
                venda.setId(result.getInt("v.id"));
                venda.setIdPessoa(result.getInt("v.idPessoa"));
                venda.setNotaFiscal(result.getString("v.NotaFiscal"));
                Timestamp t = result.getTimestamp("dataNascimento");
                venda.setData(t.toLocalDateTime().toLocalDate());
                venda.setValorTotal(result.getFloat("v.valorTotal"));
                venda.setCodFilial(result.getInt("v.codFilial"));
                List<ItemVendido> listaItens = DaoRelatorio.listarItens(venda.getId(), codFilial);
                venda.setListaItensVendidos(listaItens);
                relatorio.setQtdProdutos(relatorio.getQtdProdutos() + getQtdProduto());
                relatorio.setDia(t.toLocalDateTime().toLocalDate());
                relatorio.setVenda(venda);
                listaRelatorio.add(relatorio);
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

    public static List<ItemVendido> listarItens(int idVenda, int codFilial) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM ItemVenda Iv\n"
                + "WHERE Iv.idVenda = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {

            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, idVenda);

            result = preparedStatement.executeQuery();
            List<ItemVendido> listaItens = new ArrayList();
            ItemVendido itemVenda = new ItemVendido();
            while (result.next()) {
                int idProduto =result.getInt("Iv.idLivro");
                Produto produto = DaoProduto.procurar(idProduto, codFilial);
                itemVenda.setProduto(produto);
                itemVenda.setQuantidade(result.getInt("Iv.quantidade"));
                setQtdProduto(getQtdProduto() + itemVenda.getQuantidade());
                listaItens.add(itemVenda);
            }
            return listaItens;

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
