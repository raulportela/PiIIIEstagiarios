/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.validador.pessoa.funcionario;

import br.senac.tads.pi3a.livrariatades.model.pessoa.funcinario.Funcionario;

/**
 *
 * @author Raul de Paula
 * @author Leonardo Maia
 */
public class ValidadorFuncionario {
    public static String validadorFuncionario (Funcionario funcionario){
        String mensagemErro = "Informar Campos Obrigatórios: ";
        boolean valido = true;
        
        
        if (funcionario == null) {
            mensagemErro += "Não foi informado um Funcionario";
            return mensagemErro;
        }
        
        if (funcionario.getNomeUsuario()== null || "".equals(funcionario.getNomeUsuario())) {
            mensagemErro += "\nNome de usuário";
        } else if (funcionario.getNomeUsuario().length() > 20) {
            mensagemErro += "\nNome de usário deve conter menos de 20 caracteres";
        }
        
        if (funcionario.getSenha() > 0) {
            //trocar tudo o que usa senha para String
        }
        
        if (funcionario.getRg() == null) {
            mensagemErro += "\nRG";
        }else if (funcionario.getRg().length() > 20) {
            mensagemErro += "RG excede o limite permitido. Máximo 20 caracteres";
        }
        
        
        
        
            
        if (valido == false) {
            return mensagemErro;
        } else {
            return null;
        }
    }
}
