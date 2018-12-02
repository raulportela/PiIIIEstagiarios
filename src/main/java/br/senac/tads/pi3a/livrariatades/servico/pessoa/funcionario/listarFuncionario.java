/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.servico.pessoa.funcionario;

import br.senac.tads.pi3a.livrariatades.db.dao.pessoa.DaoPessoa;
import br.senac.tads.pi3a.livrariatades.model.pessoa.funcinario.Funcionario;
import br.senac.tads.pi3a.livrariatades.servico.pessoa.cliente.ListarCliente;
import java.io.IOException;
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
 * @author Raul de Paula
 */
@WebServlet(name = "PesquisarFuncionario", urlPatterns = {"/funcionario/listar"})
public class listarFuncionario extends HttpServlet {

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ordem = request.getParameter("ordem");
        
//        HttpSession sessao = request.getSession();
//        if (sessao.getAttribute("usuario") == null) {
//            response.sendRedirect(request.getContextPath() + "/login");
//            return;
//        }

        List<Funcionario> listaFuncionarios;
        listaFuncionarios = AtulizarLista(ordem);
        request.setAttribute("funcionarios", listaFuncionarios);
        
        if(ordem != null){
            response.sendRedirect(request.getContextPath() + "/funcionario/listar");
            return;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/WEB-INF/jsp/funcionario/listarFuncionario.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    public List AtulizarLista(String ordem) {

        List<Funcionario> listaClientes = null;
        
        try {

            listaClientes = DaoPessoa.listarFuncionario(ordem);

        } catch (Exception ex) {
            Logger.getLogger(ListarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaClientes;
    }
}
