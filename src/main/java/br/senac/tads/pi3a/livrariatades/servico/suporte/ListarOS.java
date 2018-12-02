/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.servico.suporte;

import br.senac.tads.pi3a.livrariatades.db.dao.suporte.DaoSuporte;
import br.senac.tads.pi3a.livrariatades.model.suporte.Suporte;
import br.senac.tads.pi3a.livrariatades.servico.produto.ListarProduto;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Raul de Paula
 */
@WebServlet(name = "ListarOS", urlPatterns = {"/suporte/listar"})
public class ListarOS extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        if (sessao.getAttribute("usuario") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        List<Suporte> listaSuporte;
        listaSuporte = AtulizarLista();
        request.setAttribute("suportes", listaSuporte);
        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/WEB-INF/jsp/suporte/listarOS.jsp");
        dispatcher.forward(request, response);

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    public List<Suporte> AtulizarLista() {
        List<Suporte> listaSuporte = null;
        try {
            listaSuporte = DaoSuporte.listar();
        } catch (Exception ex) {
            Logger.getLogger(ListarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaSuporte;
    }
}
