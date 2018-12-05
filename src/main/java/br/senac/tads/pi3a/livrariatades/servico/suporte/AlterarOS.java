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
@WebServlet(name = "AlterarOS", urlPatterns = {"/protegido/suporte/alterar"})
public class AlterarOS extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Suporte suporte = null;
        
        if (request.getParameter("opcao") != null & request.getParameter("id") != null) {

            String opcao = request.getParameter("opcao");
            int id = Integer.parseInt(request.getParameter("id"));
            if (opcao.equals("1")) {
                try {
                    suporte = DaoSuporte.procurar(id);
                } catch (Exception ex) {
                    Logger.getLogger(AlterarOS.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("suporte", suporte);
                RequestDispatcher dispatcher = request.getRequestDispatcher(
                        "/WEB-INF/jsp/suporte/alterarOS.jsp");
                dispatcher.forward(request, response);
            } else if (opcao.equals("2")) {
                try {
                    DaoSuporte.finalizar(id);
                    response.sendRedirect(request.getContextPath() + "/protegido/suporte/listar");
                } catch (Exception ex) {
                    Logger.getLogger(AlterarOS.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Suporte suporte = new Suporte();

        suporte.setId(Integer.parseInt(request.getParameter("id")));
        suporte.setCodFuncionario(Integer.parseInt(request.getParameter("codfuncionario")));
        suporte.setStatusChamado(true);
        suporte.setNomeChamado(request.getParameter("nomechamado"));
        suporte.setDetalhe(request.getParameter("detalhe"));
        
        try {
            DaoSuporte.atualizar(suporte);
            response.sendRedirect(request.getContextPath() + "/suporte/listar");
        } catch (Exception ex) {
            Logger.getLogger(AlterarOS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
