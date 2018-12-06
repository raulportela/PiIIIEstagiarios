/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.servico.venda;

import br.senac.tads.pi3a.livrariatades.db.dao.pessoa.DaoPessoa;
import br.senac.tads.pi3a.livrariatades.db.dao.produto.DaoProduto;
import br.senac.tads.pi3a.livrariatades.model.pessoa.cliente.Cliente;
import br.senac.tads.pi3a.livrariatades.model.pessoa.funcinario.Funcionario;
import br.senac.tads.pi3a.livrariatades.model.produto.Produto;
import br.senac.tads.pi3a.livrariatades.model.venda.ItemVendido;
import br.senac.tads.pi3a.livrariatades.servico.pessoa.cliente.ListarCliente;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Raul de Paula
 */
@WebServlet(name = "EfetuarVenda", urlPatterns = {"/protegido/venda/efetuar"})
public class EfetuarVenda extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcao = request.getParameter("opcao");
        String produtoId = request.getParameter("produtovenda");
        String vender = request.getParameter("vender");
        String cpf = request.getParameter("cpf");
        HttpSession sessao = request.getSession();
        Funcionario funcionario = (Funcionario) sessao.getAttribute("funcionario");
        List<ItemVendido> listaVenda = new ArrayList();

        if (request.getParameter("opcao") != null) {
            switch (opcao) {
                case "1":
                    if (produtoId != null) {
                        try {
                            Produto produto = DaoProduto.procurar(Integer.parseInt(produtoId), funcionario.getCodFilial());
                            ItemVendido itemVenda = new ItemVendido();
                            itemVenda.setProduto(produto);
                            itemVenda.setQuantidade(1);

                            if (sessao.getAttribute("listaProduto") != null) {
                                listaVenda = (List<ItemVendido>) sessao.getAttribute("listaVenda");
                                float valorTotal = Float.parseFloat((String) sessao.getAttribute("valorTotal"));
                                valorTotal += (itemVenda.getProduto().getValor()*itemVenda.getQuantidade());
                                sessao = request.getSession();
                                sessao.setAttribute("listaProduto", listaVenda);
                                
                            } else {
                                listaVenda.add(itemVenda);
                                sessao = request.getSession();
                                sessao.setAttribute("listaVenda", listaVenda);
                                sessao.setAttribute("valorTotal", (itemVenda.getProduto().getValor()*itemVenda.getQuantidade()));
                            }

                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(EfetuarVenda.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(EfetuarVenda.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    break;
                case "2":
                    if (vender != null && cpf != null) {
                        if (vender.equals("1")) {
                            Cliente cliente = null;
                            try {
                                cliente = DaoPessoa.procurarCliente(cpf);
                            } catch (Exception ex) {
                                Logger.getLogger(ListarCliente.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            sessao.setAttribute("clienteVenda", cliente);
                        }
                    }
                    break;
                case "3":
                    listaVenda = (List<ItemVendido>) sessao.getAttribute("listaVenda");
                    produtoId = request.getParameter("idProdutoVenda");
                    int contador = 0;
                    for (int i = 0; i < listaVenda.size(); i++) {
                        ItemVendido itemVendido = listaVenda.get(contador);
                        if (itemVendido.getProduto().getCodFilial() == Integer.parseInt(produtoId)) {
                            listaVenda.remove(contador);
                        }
                    }
                case "":
                default:
                    response.sendRedirect(request.getContextPath() + "/protegido/venda/efetuar");
                    break;
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/WEB-INF/jsp/venda/efetuar.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
