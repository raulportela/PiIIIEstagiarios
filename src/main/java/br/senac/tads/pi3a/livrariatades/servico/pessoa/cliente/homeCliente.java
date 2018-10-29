/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.servico.pessoa.cliente;

import br.senac.tads.pi3a.livrariatades.db.dao.pessoa.cliente.DaoCliente;
import br.senac.tads.pi3a.livrariatades.db.dao.pessoa.cliente.DaoClienteProv1;
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
@WebServlet(name = "Clientehome", urlPatterns = {"/cliente/home"})
public class homeCliente extends HttpServlet {

    private boolean modoEdicao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = dispatcher = request.getRequestDispatcher(
                "/WEB-INF/jsp/cliente/home.jsp");
        dispatcher.forward(request, response);
        
        
           
        
       
//        if(comando.equals("cadastra")){
//            dispatcher = request.getRequestDispatcher(
//                "/WEB-INF/jsp/cliente/cadastraCliente.jsp");
//        dispatcher.forward(request, response);
        

         

       

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String comando = request.getParameter("comando");

        System.out.println(comando);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/jsp/cliente/cadastraCliente.jsp");
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
//            Logger.getLogger(ServicoCliente.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return listaClientes;
//    }
//        Cliente cliente = new Cliente();
//        
//        
//        cliente.setNome(request.getParameter("nome"));
//        cliente.setSobrenome(request.getParameter("sobrenome"));
//        cliente.setCpf(request.getParameter("cpf"));
//        cliente.setEmail(request.getParameter("email"));
//        cliente.setTelefone(Integer.parseInt(request.getParameter("tel")));
//        cliente.setCelular(Integer.parseInt(request.getParameter("cel")));
//        cliente.setEndereco(request.getParameter("end"));
//
//        try {
//            DaoClienteProv1.inserir(cliente);
//        } catch (Exception ex) {
//            Logger.getLogger(ServicoCliente.class.getName()).log(Level.SEVERE, null, ex);
//        }
}
