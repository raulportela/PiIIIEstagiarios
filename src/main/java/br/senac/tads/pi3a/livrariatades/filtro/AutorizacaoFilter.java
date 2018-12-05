/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.filtro;

import br.senac.tads.pi3a.livrariatades.model.pessoa.funcinario.Funcionario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maia's
 */
@WebFilter(filterName = "AutorizacaoFilter", servletNames = {"HomeServlet"},
        urlPatterns = {"/protegido/*"})
public class AutorizacaoFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        // CAST para objetos do tipo HttpServlet*
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Verifica se usuario ja esta logado
        HttpSession sessao = httpRequest.getSession();
        if (sessao.getAttribute("funcionario") == null) {
            // Redirecionar para tela de login
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            return;
        }

        // Verifica se o usuário possui o papel para acessar funcionalidade.
        Funcionario funcionario = (Funcionario) sessao.getAttribute("funcionario");

        if (listaDeAcesso (funcionario, httpRequest, httpResponse)) {
            // Requisicao pode seguir para o Servlet
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/erro/erro-nao-autorizado.jsp");
        }
    }

    private boolean listaDeAcesso(Funcionario funcinario,
            HttpServletRequest request,
            HttpServletResponse response) {

        String funcao = funcinario.getNivelFuncao();
        String pagina = request.getRequestURI();
//              TODAS PAGINAS
//            "/protegido/home"
//            "/protegido/funcionario/listar"
//            "/protegido/produto/listar"
//            "/protegido/venda/efetuar"
//            "/protegido/filiais/listar"
//            "/protegido/cliente/listar"
//            "/protegido/relatorio"
//            "/protegido/suporte"

        if (funcao.equals("root")) {
            return true;
        }
        if (funcao.equals("TI")) {
            List<String> listaPaginasRoot = new ArrayList();
            listaPaginasRoot.add("/protegido/home");
            listaPaginasRoot.add("/protegido/funcionario/listar");
            listaPaginasRoot.add("/protegido/suporte");

            for (int i = 0; i < listaPaginasRoot.size(); i++) {
                if (pagina.endsWith(listaPaginasRoot.get(i))) {
                    return true;
                }
            }
        }
        if (funcao.equals("VENDAS")) {
            List<String> listaPaginasRoot = new ArrayList();
            listaPaginasRoot.add("/protegido/home");
            listaPaginasRoot.add("/protegido/produto/listar");
            listaPaginasRoot.add("/protegido/venda/efetuar");
            listaPaginasRoot.add("/protegido/cliente/listar");

            for (int i = 0; i < listaPaginasRoot.size(); i++) {
                if (pagina.endsWith(listaPaginasRoot.get(i))) {
                    return true;
                }
            }
        }
        if (funcao.equals("ADMINISTRATIVO")) {
            List<String> listaPaginasRoot = new ArrayList();
            listaPaginasRoot.add("/protegido/home");
            listaPaginasRoot.add("/protegido/funcionario/listar");

            for (int i = 0; i < listaPaginasRoot.size(); i++) {
                if (pagina.endsWith(listaPaginasRoot.get(i))) {
                    return true;
                }
            }
        }
        if (funcao.equals("PRODUTO")) {
            List<String> listaPaginasRoot = new ArrayList();
            listaPaginasRoot.add("/protegido/home");
            listaPaginasRoot.add("/protegido/produto/listar");

            for (int i = 0; i < listaPaginasRoot.size(); i++) {
                if (pagina.endsWith(listaPaginasRoot.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}
