/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.validador.pessoa.funcionario;

import br.senac.tads.pi3a.livrariatades.model.contato.Contato;
import br.senac.tads.pi3a.livrariatades.model.endereco.Endereco;
import br.senac.tads.pi3a.livrariatades.model.pessoa.funcinario.Funcionario;
import br.senac.tads.pi3a.livrariatades.validador.contato.ValidadorContato;
import br.senac.tads.pi3a.livrariatades.validador.endereco.ValidadorEndereco;

/**
 *
 * @author Raul de Paula
 */
public class ValidadorFuncionario {

    public static String validar(Funcionario funcionario) {
        String mensagemErro = "Informar Campos Obrigatórios: ";
        String validoContato, validoEndereco;
        boolean valido = true;

        if (funcionario == null) {
            mensagemErro += "\nNão foi informado um Funcionario";
            return mensagemErro;
        }

        if (funcionario.getNomeUsuario() == null || "".equals(funcionario.getNomeUsuario())) {
            mensagemErro += "\nNome de usuário";
            valido = false;
        } else if (funcionario.getNomeUsuario().length() > 20) {
            mensagemErro += "\nNome excede o limite. 20 caracteres";
            valido = false;
        }

        if (funcionario.getHashSenha()== null || "".equals(funcionario.getHashSenha())) {
            mensagemErro += "\nSenha";
            valido = false;
        } else if (funcionario.getHashSenha().length() < 6) {
            mensagemErro += "\nSenha deve possuir no mínimo 6 caracteres";
            valido = false;
        }

        if (funcionario.getRg() == null) {
            mensagemErro += "\nRG";
            valido = false;
        } else if (funcionario.getRg().length() > 20) {
            mensagemErro += "\nRG excede o limite. 20 caracteres";
            valido = false;
        }

        Contato contato = new Contato();
        contato.setCelular(funcionario.getContato().getCelular());
        contato.setEmail(funcionario.getContato().getEmail());
        contato.setTelefone(funcionario.getContato().getTelefone());
        validoContato = ValidadorContato.validar(contato);
        
        Endereco endereco = new Endereco();
        endereco.setBairro(funcionario.getEndereco().getBairro());
        endereco.setCep(funcionario.getEndereco().getCep());
        endereco.setComplemento(funcionario.getEndereco().getComplemento());
        endereco.setNumero(funcionario.getEndereco().getNumero());
        endereco.setRua(funcionario.getEndereco().getRua());
        validoEndereco = ValidadorEndereco.validar(endereco);
        
        if (validoContato != null) {
            mensagemErro += validoContato;
            valido = false;
        }
        if (validoEndereco != null) {
            mensagemErro += validoEndereco;
            valido = false;
        }

        if (valido == false) {
            return mensagemErro;
        } else {
            return null;
        }
    }
}
