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
 * @author Raul de Paula
 */
@WebServlet(name = "PesquisarFuncionario", urlPatterns = {"/funcionario/listar"})
public class listarFuncionario extends HttpServlet {

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Funcionario> listaFuncionarios = new ArrayList<>();
        listaFuncionarios = AtulizarLista();
        request.setAttribute("funcionarios", listaFuncionarios);

//        String opcao = request.getParameter("opcao");
//        String cpf = request.getParameter("cpf");
//        if (opcao.equals("1")) {
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
                "/WEB-INF/jsp/funcionario/listarFuncionario.jsp");
        dispatcher.forward(request, response);

    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public List AtulizarLista() {

        List<Funcionario> listaClientes = null;
        try {

            listaClientes = DaoPessoa.listarFuncionario();

        } catch (Exception ex) {
            Logger.getLogger(ListarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaClientes;
    }
}
