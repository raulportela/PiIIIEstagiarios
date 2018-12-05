/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.servico.produto;

import br.senac.tads.pi3a.livrariatades.db.dao.produto.DaoProduto;
import br.senac.tads.pi3a.livrariatades.model.produto.Produto;
import java.io.IOException;
import java.util.List;
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
 * @author Jeferson Nolasco
 */
@WebServlet(name = "PesquisarProduto", urlPatterns = {"/protegido/produto/listar"})
public class ListarProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ordem = request.getParameter("ordem");
        List<Produto> listaProdutos;
        listaProdutos = AtulizarLista(ordem);
        request.setAttribute("produtos", listaProdutos);

        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/WEB-INF/jsp/produto/listarProduto.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String ordem = request.getParameter("ordem");
         
         AtulizarLista(ordem);
         
    }
    

    public List<Produto> AtulizarLista(String ordem) {
        List<Produto> listaProduto = null;
        try {

            listaProduto = DaoProduto.listar(ordem);
        } catch (Exception ex) {
            Logger.getLogger(ListarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProduto;
    }
}
