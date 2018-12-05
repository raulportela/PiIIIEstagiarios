/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.servico.produto;

import br.senac.tads.pi3a.livrariatades.db.dao.produto.DaoProduto;
import br.senac.tads.pi3a.livrariatades.model.produto.Produto;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raul de Paula
 */
@WebServlet(name = "CadastrarProduto", urlPatterns = {"/protegido/produto/cadastrar"})
public class CadastrarProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/WEB-INF/jsp/produto/cadastrarProduto.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Produto produto = new Produto();

        produto.setDisponivel(true);
        produto.setCodFilial(Integer.parseInt(request.getParameter("filial")));
        produto.setEditora(request.getParameter("editora"));
        produto.setAutor(request.getParameter("autor"));
        produto.setTitulo(request.getParameter("titulo"));
        produto.setDescricao(request.getParameter("descricao"));
        int quantidade = 0;
        if (request.getParameter("quantidade") != null) {
            quantidade = Integer.parseInt(request.getParameter("quantidade"));
        }
        produto.setQuantidade(quantidade);
        float valor = 0;
        if (request.getParameter("valorunitario") != null) {
            valor = Float.parseFloat(request.getParameter("quantidade"));
        }
        produto.setValor(Float.parseFloat(request.getParameter("valorunitario")));

        try {
            DaoProduto.inserir(produto);
        } catch (Exception ex) {
            Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect(request.getContextPath() + "/protegido/produto/listar");
    }

}
