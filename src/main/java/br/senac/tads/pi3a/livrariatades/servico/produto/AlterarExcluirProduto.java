/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.servico.produto;

import br.senac.tads.pi3a.livrariatades.db.dao.produto.DaoProduto;
import br.senac.tads.pi3a.livrariatades.model.produto.Produto;
import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet(name = "AlterarExcluirProduto", urlPatterns = {"/produto/alterar"})
public class AlterarExcluirProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Produto produto = new Produto();
        
        if (request.getParameter("opcao") != null & request.getParameter("id") != null) {

            String opcao = request.getParameter("opcao");
            int id = Integer.parseInt(request.getParameter("id"));

            if (opcao.equals("1")) {
                try {
                    produto = DaoProduto.procurar(id);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(AlterarExcluirProduto.class.getName()).log(Level.SEVERE, null, ex);
                }

                request.setAttribute("produto", produto);

                RequestDispatcher dispatcher = request.getRequestDispatcher(
                        "/WEB-INF/jsp/produto/alterarProduto.jsp");
                dispatcher.forward(request, response);
            } else if (opcao.equals("2")) {
                try {
                    DaoProduto.excluir(id);
                    response.sendRedirect(request.getContextPath() + "/produto/listar");
                } catch (Exception ex) {
                    Logger.getLogger(AlterarExcluirProduto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Produto produto = new Produto();

        produto.setDisponivel(true);
        produto.setId(Integer.parseInt(request.getParameter("cod")));
        produto.setEditora(request.getParameter("editora"));
        produto.setAutor(request.getParameter("autor"));
        produto.setTitulo(request.getParameter("titulo"));
        produto.setDescricao(request.getParameter("descricao"));
        produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
        produto.setValor(Float.parseFloat(request.getParameter("valorunitario")));
        
        try {
            DaoProduto.atualizar(produto);
            
        } catch (Exception ex) {
            Logger.getLogger(AlterarExcluirProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect(request.getContextPath() + "/produto/listar");
    }

}
