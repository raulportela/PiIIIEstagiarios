/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.servico.acesso;

import br.senac.tads.pi3a.livrariatades.db.dao.pessoa.funcionario.DaoFuncionario;
import br.senac.tads.pi3a.livrariatades.model.pessoa.funcinario.Funcionario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Jeferson Nolasco
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/jsp/acesso/login.jsp");
        dispatcher.forward(request, response);
      
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nomeUsuario = request.getParameter("nomeUsuario");
        String senhaAberta = request.getParameter("senhaAberta");
        
        Funcionario funcionario = null;
        try {
            funcionario = DaoFuncionario.procurarPorNomeUsuario(nomeUsuario);
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (funcionario != null) {
            boolean senhaValida = BCrypt.checkpw(senhaAberta, funcionario.getHashSenha());
            if (senhaValida) {
                HttpSession sessao = request.getSession();
                sessao.setAttribute("funcionario", funcionario);
                response.sendRedirect(request.getContextPath() + "/home");
                return;
            }
        }
        
        request.setAttribute("mensagemErro", "Usuário ou senha inválido");
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/jsp/acesso/login.jsp");
        dispatcher.forward(request, response);
        
    }

}
