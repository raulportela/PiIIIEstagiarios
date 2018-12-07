/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.servico.venda;

import br.senac.tads.pi3a.livrariatades.db.dao.pessoa.DaoPessoa;
import br.senac.tads.pi3a.livrariatades.db.dao.produto.DaoProduto;
import br.senac.tads.pi3a.livrariatades.db.dao.venda.DaoVenda;
import br.senac.tads.pi3a.livrariatades.model.pessoa.cliente.Cliente;
import br.senac.tads.pi3a.livrariatades.model.pessoa.funcinario.Funcionario;
import br.senac.tads.pi3a.livrariatades.model.produto.Produto;
import br.senac.tads.pi3a.livrariatades.model.venda.ItemVendido;
import br.senac.tads.pi3a.livrariatades.model.venda.Venda;
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
        float valorTotal;
        int contador;
        String cpf = request.getParameter("cpf");
        HttpSession sessao = request.getSession();
        Funcionario funcionario = (Funcionario) sessao.getAttribute("funcionario");

        List<ItemVendido> listaVenda = (List<ItemVendido>) sessao.getAttribute("listaVenda");

        if (request.getParameter("opcao") != null) {
            switch (opcao) {
                case "1":
                    if (produtoId != null) {
                        ItemVendido itemVenda = new ItemVendido();
                        try {
                            Produto produto = DaoProduto.procurar(Integer.parseInt(produtoId), funcionario.getCodFilial());
                            itemVenda.setProduto(produto);
                            itemVenda.setQuantidade(1);

                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(EfetuarVenda.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(EfetuarVenda.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (listaVenda != null) {
                            valorTotal = (Float) sessao.getAttribute("valorTotal");
                            valorTotal += (itemVenda.getProduto().getValor() * itemVenda.getQuantidade());
                            listaVenda.add(itemVenda);
                            sessao.setAttribute("listaProduto", listaVenda);
                            sessao.setAttribute("valorTotal", valorTotal);

                        } else {
                            listaVenda = new ArrayList<>();
                            listaVenda.add(itemVenda);
                            sessao.setAttribute("listaVenda", listaVenda);
                            sessao.setAttribute("valorTotal", (itemVenda.getProduto().getValor() * itemVenda.getQuantidade()));
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
                    valorTotal = (Float) sessao.getAttribute("valorTotal");
                    contador = 0;
                    for (int i = 0; i < listaVenda.size(); i++) {
                        ItemVendido itemVendido = listaVenda.get(contador);
                        if (itemVendido.getProduto().getId() == Integer.parseInt(produtoId)) {
                            valorTotal -= (itemVendido.getProduto().getValor() * itemVendido.getQuantidade());
                            listaVenda.remove(contador);
                        }
                        contador++;
                    }
                    sessao.setAttribute("valorTotal", valorTotal);
                    sessao.setAttribute("listaVenda", listaVenda);
                    break;
                case "4":
                    sessao.setAttribute("clienteVenda", null);
                    break;
                case "5":
                    listaVenda = (List<ItemVendido>) sessao.getAttribute("listaVenda");
                    valorTotal = (Float) sessao.getAttribute("valorTotal");
                    produtoId = request.getParameter("produtovenda");
                    contador = 0;
                    for (int i = 0; i < listaVenda.size(); i++) {
                        ItemVendido itemVendido = listaVenda.get(contador);
                        if (itemVendido.getProduto().getId() == Integer.parseInt(produtoId)) {
                            valorTotal -= (itemVendido.getProduto().getValor() * itemVendido.getQuantidade());
                            itemVendido.setQuantidade(itemVendido.getQuantidade()-1);
                            if(itemVendido.getQuantidade() == 0){
                                listaVenda.remove(contador);
                            }else {
                                valorTotal += (itemVendido.getProduto().getValor() * itemVendido.getQuantidade());
                            }
                        }
                        contador++;
                    }
                    sessao.setAttribute("valorTotal", valorTotal);
                    sessao.setAttribute("listaVenda", listaVenda);
                    break;
                case "6":
                    listaVenda = (List<ItemVendido>) sessao.getAttribute("listaVenda");
                    valorTotal = (Float) sessao.getAttribute("valorTotal");
                    produtoId = request.getParameter("produtovenda");
                    contador = 0;
                    for (int i = 0; i < listaVenda.size(); i++) {
                        ItemVendido itemVendido = listaVenda.get(contador);
                        if (itemVendido.getProduto().getId() == Integer.parseInt(produtoId)) {
                            valorTotal -= (itemVendido.getProduto().getValor() * itemVendido.getQuantidade());
                            itemVendido.setQuantidade(itemVendido.getQuantidade()+1);
                            valorTotal += (itemVendido.getProduto().getValor() * itemVendido.getQuantidade());
                        }
                        contador++;
                    }
                    sessao.setAttribute("valorTotal", valorTotal);
                    sessao.setAttribute("listaVenda", listaVenda);
                case "":
                default:
                    request.setAttribute("opcao", null);
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

        HttpSession sessao = request.getSession();
        Funcionario funcionario = (Funcionario) sessao.getAttribute("funcionario");
        Cliente cliente = (Cliente) sessao.getAttribute("clienteVenda");
        List<ItemVendido> listaVenda = (List<ItemVendido>) sessao.getAttribute("listaVenda");
        float valorTotal = (Float) sessao.getAttribute("valorTotal");

        if (cliente != null) {
            if (listaVenda != null) {
                Venda venda = new Venda();
                venda.setCliente(cliente);
                venda.setCodFilial(funcionario.getCodFilial());
                try {
                    venda.setNotaFiscal("" + DaoVenda.numeroNota(funcionario.getCodFilial()));
                } catch (Exception ex) {
                    Logger.getLogger(EfetuarVenda.class.getName()).log(Level.SEVERE, null, ex);
                }
                venda.setValorTotal(valorTotal);
                venda.setListaItensVendidos(listaVenda);

                try {
                    DaoVenda.inserir(venda);
                } catch (Exception ex) {
                    Logger.getLogger(EfetuarVenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                sessao.setAttribute("msgErroVenda", "Selecione ao menos um produto.");
                return;
            }
        } else {
            sessao.setAttribute("msgErroVenda", "Selecione um Cliente.");
            return;
        }
        sessao.setAttribute("clienteVenda", null);
        sessao.setAttribute("listaVenda", null);
        sessao.setAttribute("valorTotal", null);
        response.sendRedirect(request.getContextPath() + "/protegido/home");
    }

}
