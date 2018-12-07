/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.servico.relatorio;

import br.senac.tads.pi3a.livrariatades.db.dao.relatorio.DaoRelatorio;
import br.senac.tads.pi3a.livrariatades.model.pessoa.funcinario.Funcionario;
import br.senac.tads.pi3a.livrariatades.model.relatorio.Relatorio;
import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet(name = "GerarRelatorio", urlPatterns = {"/protegido/relatorio"})
public class GerarRelatorio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Funcionario funcionario = (Funcionario) sessao.getAttribute("funcionario");
        List<Relatorio> listaRelatorio = null;
        try {
            listaRelatorio = DaoRelatorio.gerar(funcionario.getCodFilial());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GerarRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GerarRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        sessao.setAttribute("listaRelatorio", listaRelatorio);
        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/WEB-INF/jsp/relatorio/relatorio.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
