/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.validador.contato;

import br.senac.tads.pi3a.livrariatades.model.contato.Contato;

/**
 *
 * @author Maia
 */
public class ValidadorContato {

    public static String validar(Contato contato) {

        String mensagemErro = "Informar Campos Obrigatórios: ";
        boolean valido = true;

        if (contato == null) {
            mensagemErro += "Não foi informado um Contato";
            return mensagemErro;
        }

        if (Long.toString(contato.getCelular()).equals("")) {
            mensagemErro += "\nCelular.";
            valido = false;
        } else if (Long.toString(contato.getCelular()).length() > 11) {
            mensagemErro += "Telefone celular excede limite máximo. 11 caracteres.";
            valido = false;
        }
        
        if (Long.toString(contato.getTelefone()).equals("")) {
            mensagemErro += "\nTelefone.";
            valido = false;
        } else if (Long.toString(contato.getTelefone()).length() > 10) {
            mensagemErro += "Telefone fixo excede limite máximo. 10 caracteres.";
            valido = false;
        }
        
        if (contato.getEmail().equals("")) {
            mensagemErro += "\nE-mail";
            valido = false;
        } else if (contato.getEmail().length() > 60) {
            mensagemErro += "\nE-mail excede o limite máximo. 60 caracteres.";
            valido = false;
        }
        
        if (valido == false) {
            return mensagemErro;
        } else {
            return null;
        }
    }
}
