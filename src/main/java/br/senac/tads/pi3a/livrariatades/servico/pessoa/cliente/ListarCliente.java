/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.servico.pessoa.cliente;

import br.senac.tads.pi3a.livrariatades.db.dao.pessoa.DaoPessoa;
import br.senac.tads.pi3a.livrariatades.model.pessoa.cliente.Cliente;
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
@WebServlet(name = "ListarCliente", urlPatterns = {"/cliente/listar"})
public class ListarCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes = AtulizarLista();
        request.setAttribute("clientes", listaClientes);

//        String opcao = request.getParameter("opcao");
//        String cpf = request.getParameter("cpf");
//        if (opcao.equals("1")){
//            try {
//                Cliente cliente = DaoPessoa.procurarCliente(Integer.parseInt(cpf));
//                DaoCliente.excluir(cliente.getIdPessoa());
//                response.sendRedirect(request.getContextPath() + "cliente/listar");
//            } catch (Exception ex) {
//                Logger.getLogger(ListarCliente.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//        }
//        if (opcao != null) {
//            HttpSession sessao = request.getSession();
//            sessao.setAttribute("opcaoSelecionada", opcao);
//        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/WEB-INF/jsp/cliente/listarCliente.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/jsp/cliente/backupTela.jsp");
        
        dispatcher.forward(request, response);

    }

    public List AtulizarLista() {

        List<Cliente> listaClientes = null;
        try {

            listaClientes = DaoPessoa.listarCliente();

        } catch (Exception ex) {
            Logger.getLogger(ListarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaClientes;
    }

}
