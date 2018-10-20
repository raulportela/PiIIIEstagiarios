/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.servico;

import br.senac.tads.pi3a.livrariatades.dao.DaoCliente;
import br.senac.tads.pi3a.livrariatades.model.pessoa.cliente.Cliente;
import com.sun.org.apache.bcel.internal.generic.D2F;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.security.Timestamp;
import java.util.Date;
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
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String cpf = request.getParameter("cpf");
        
        Date dateNasc = new Date();
        String email = request.getParameter("email");
        Integer tel = Integer.parseInt(request.getParameter("tel"));
        Integer cel = Integer.parseInt(request.getParameter("cel"));
        String end = request.getParameter("end");
        System.out.println("nome do bizonho " +nome);
        System.out.println("chegeou aqui ");
        
        Cliente cliente = new Cliente(nome, sobrenome, cpf, dateNasc, email, tel, cel, end);
        
        System.out.println("nome do clienet " + cliente.getNome());
    
       
        
        try {
            DaoCliente daoCli = new DaoCliente();
            daoCli.inserir(cliente);
        } catch (Exception ex) {
            Logger.getLogger(InclusaoClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("cli", cliente);
        
        RequestDispatcher dispatcher = 
                request.getRequestDispatcher(
                        "/WEB-INF/jsp/cliente/resultadoCliente.jsp");
        dispatcher.forward(request, response);
        
        
        
        
        
        
        
        
        
        
    }

}
