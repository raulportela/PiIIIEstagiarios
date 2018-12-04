/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.servico.filial;

import br.senac.tads.pi3a.livrariatades.db.dao.filial.DaoFilial;
import br.senac.tads.pi3a.livrariatades.model.filial.Filial;
import java.io.IOException;
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

/**
 *
 * @author Jeferson Nolasco
 */
@WebServlet(name = "ListarFilial", urlPatterns = {"/protegido/filial/listar"})
public class ListarFilial extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String ordem = request.getParameter("ordem");
        
        List<Filial> listaFiliais = new ArrayList<>();
        listaFiliais = AtulizarLista(ordem);
        request.setAttribute("filiais", listaFiliais);

        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/WEB-INF/jsp/filial/listarFilial.jsp");
        dispatcher.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/jsp/filial/listar.jsp");//

        dispatcher.forward(request, response);

    }

    public List AtulizarLista(String ordem) {

        List<Filial> listaFiliais = null;
        try {

            listaFiliais = DaoFilial.listar(ordem);

        } catch (Exception ex) {
            Logger.getLogger(ListarFilial.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaFiliais;
    }

}
