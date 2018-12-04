/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.servico.venda;

import br.senac.tads.pi3a.livrariatades.db.dao.pessoa.DaoPessoa;
import br.senac.tads.pi3a.livrariatades.model.pessoa.cliente.Cliente;
import br.senac.tads.pi3a.livrariatades.servico.pessoa.cliente.ListarCliente;
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
@WebServlet(name = "EfetuarVenda", urlPatterns = {"/protegido/venda/efetuar"})
public class EfetuarVenda extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                String vender = request.getParameter("vender");
        String cpf = request.getParameter("cpf");
        if (vender != null && cpf != null) {
            if (vender.equals("1")) {
                Cliente cliente = null;
                try {
                    cliente = DaoPessoa.procurarCliente(cpf);
                } catch (Exception ex) {
                    Logger.getLogger(ListarCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("clienteVenda", cliente);
                response.sendRedirect(request.getContextPath() + "/venda/efetuar");
            }
            return;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/WEB-INF/jsp/venda/efetuar.jsp");
        dispatcher.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }


}
