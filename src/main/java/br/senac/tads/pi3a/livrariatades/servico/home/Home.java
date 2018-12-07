/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.servico.home;

import br.senac.tads.pi3a.livrariatades.db.dao.frase.DaoFrase;
import br.senac.tads.pi3a.livrariatades.model.frase.Frase;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;
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
@WebServlet(name = "Home", urlPatterns = {"/protegido/home"})
public class Home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Random r = new Random();
        int numero = r.nextInt(23);
        if(numero == 0){
            numero = 1;
        }
        Frase frase = null;
        try {
            frase = DaoFrase.procurar(numero);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        sessao.setAttribute("frase", frase);
        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/WEB-INF/jsp/home/home.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
