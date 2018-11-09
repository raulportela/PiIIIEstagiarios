/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.servico.suporte;

import br.senac.tads.pi3a.livrariatades.db.dao.suporte.DaoSuporte;
import br.senac.tads.pi3a.livrariatades.model.suporte.Suporte;
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
@WebServlet(name = "CadastrarOS", urlPatterns = {"/suporte/cadastrar"})
public class CadastrarOS extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/WEB-INF/jsp/suporte/cadastrarOS.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Suporte suporte = new Suporte();

        suporte.setCodFuncionario(Integer.parseInt(request.getParameter("codfuncionario")));
        suporte.setStatusChamado(true);
        suporte.setNomeChamado(request.getParameter("nomechamado"));
        suporte.setDetalhe(request.getParameter("detalhe"));
        
        try {
            DaoSuporte.inserir(suporte);
            response.sendRedirect(request.getContextPath() + "/suporte/listar");
        } catch (Exception ex) {
            Logger.getLogger(CadastrarOS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
