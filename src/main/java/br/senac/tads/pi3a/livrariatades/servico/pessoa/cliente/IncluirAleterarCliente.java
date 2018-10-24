/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.servico.pessoa.cliente;

import br.senac.tads.pi3a.livrariatades.db.dao.pessoa.cliente.DaoCliente;
import br.senac.tads.pi3a.livrariatades.model.pessoa.cliente.Cliente;
import java.io.IOException;
import java.util.Date;
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
@WebServlet(name = "InclusaoClienteServlet", urlPatterns = {"/cliente/inclusao"})
public class IncluirAleterarCliente extends HttpServlet {
    private boolean modoEdicao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        List<Cliente> listaClientes = AtulizarLista();
//        request.setAttribute("listaCliente", listaClientes);
        
       
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

        Cliente cliente = new Cliente(nome, sobrenome, cpf, dateNasc, email, tel, cel, end);

        try {
            DaoCliente.inserir(cliente);
        } catch (Exception ex) {
            Logger.getLogger(IncluirAleterarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

//        List<Cliente> listaClientes = AtulizarLista();
//        request.setAttribute("listaCliente", listaClientes);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/jsp/cliente/cadastroCliente.jsp");
        dispatcher.forward(request, response);

    }

//    public List AtulizarLista() {
//
//        List<Cliente> listaClientes = null;
//        try {
//            DaoCliente daoCli = new DaoCliente();
//            listaClientes = daoCli.listar();
//
//        } catch (Exception ex) {
//            Logger.getLogger(IncluirAleterarCliente.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return listaClientes;
//    }

}
