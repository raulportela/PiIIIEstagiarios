<%-- 
    Document   : cadastrarFuncionario
    Created on : 17/10/2018, 22:57:40
    Author     : dePaula
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/home/header.jsp" />
<div id="modelLista" role="dialog" >
    <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Lista de Funcionario</h5>
                </a>
            </div>
            <div class="modal-body">

                <table class="table table-hover">

                    <thead>

                        <tr>
                            <th scope="col"><a href="">CPF <i class="fa fa-angle-down"></i></a></th>
                            <th scope="col"><a href="">Nome <i class="fa fa-angle-down"></i></a></th>
                            <th scope="col"><a href="">Telefone <i class="fa fa-angle-down"></i></a></th>
                            <th scope="col"><a href="">E-mail <i class="fa fa-angle-down"></i></a></th>
                            <th scope="col"><a href="">Status <i class="fa fa-angle-down"></i></a></th>
                        </tr>

                    </thead>
                    <tbody>

                        <c:forEach items="${funcionarios}" var="funcionario"> 
                            <c:if test="${funcionario.getCpf() != 11111111111 && 
                                          funcionario.getCpf() != 22222222222 && 
                                          funcionario.getCpf() != 33333333333 && 
                                          funcionario.getCpf() != 44444444444}">

                                  <tr data-toggle="modal" data-target="#modelClient">
                                      <th><c:out value="${funcionario.getCpf()}" /></th>
                                      <td><c:out value="${funcionario.getNome()} ${funcionario.getSobrenome()} " /></td>
                                      <td><c:out value="${funcionario.getContato().getTelefone()}" /></td>
                                      <td><c:out value="${funcionario.getContato().getEmail()}" /></td>
                                      
                                      <c:if test="${funcionario.isDisponivel() == true }">
                                          <td style="color: #0AC740"><c:out value="Ativo" /></td>
                                            
                                      </c:if> 
                                      <c:if test="${funcionario.isDisponivel() == false}">
                                        <td style="color: red"><c:out value="Desativado" /></td>
                                      </c:if>    
                                                                              <td>
                                          <a href="${pageContext.request.contextPath}/funcionario/alterar?opcao=1&cpf=${funcionario.getCpf()}">
                                              <button type="button" class="btn btn-primary" data-dismiss="modal" >Detalhes</button>
                                          </a>
                                      </td>

                                      </tr>
                                  </c:if>

                        </c:forEach>

                    </tbody>
                </table>
            </div>

            <div class="modal-footer">
                <a href="${pageContext.request.contextPath}/home">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Sair</button>
                </a>
            </div>
        </div>
    </div>
</div>


<c:import url="/WEB-INF/jsp/home/footer.jsp" />
