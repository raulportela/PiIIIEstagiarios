/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.servicos;
 
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "InclusaoClienteServlet", urlPatterns = {"/cliente/inclusao"})
public class InclusaoClienteServlet extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher 
                = request.getRequestDispatcher(
        "/WEB-INF/jsp/cliente/cadastroCliente.jsp");
        dispatcher.forward(request, response);
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String nome = request.getParameter("nome");
//        String sobrenome = request.getParameter("sobrenome");
//        String cpf = request.getParameter("cpf");
//        String nasc = request.getParameter("nasc");
//        String email = request.getParameter("tel");
//        String tel = request.getParameter("cel");
//        String end = request.getParameter("end");
//        
//        
//        Cliente c1 = new Cliente();
//        
        
    }

    
    

}
