/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.validador.endereco;

import br.senac.tads.pi3a.livrariatades.model.endereco.Endereco;

/**
 *
 * @author Maia
 */
public class ValidadorEndereco {
    public static String validar (Endereco endereco){
        
        String mensagemErro = "Informar Campos Obrigatórios: ";
        boolean valido = true;
        
        if (endereco == null) {
            mensagemErro += "Não foi informado um Endereco";
            return mensagemErro;
        }
        
        if (endereco.getRua().equals("") || endereco.getRua() == null) {
            mensagemErro += "\nRua";
            valido = false;
        } else if (endereco.getRua().length() > 60) {
            mensagemErro += "\nRua exede o limite. Máximo 60 caracteres.";
            valido = false;
        }
        
        if (Integer.toString(endereco.getNumero()).equals("") || Integer.toString(endereco.getNumero()) == null ) {
            mensagemErro += "\nNumero.";
            valido = false;
        }
        
        if (endereco.getBairro().equals("") || endereco.getBairro() == null) {
            mensagemErro += "\nBairro.";
            valido = false;
        } else if (endereco.getBairro().length() > 30) {
            mensagemErro += "\nBairro excede o limite. Máximo 30 caracteres.";
            valido = false;
        }
        
        if (Integer.toString(endereco.getCep()).equals("") || Integer.toString(endereco.getCep()) == null ) {
            mensagemErro += "\nCep.";
            valido = false;
        } else if (Integer.toString(endereco.getCep()).length() > 8) {
            mensagemErro += "Cep excede o limite. Máximo 8 caracteres.";
            valido = false;
        }
        
        if (endereco.getComplemento().equals("") || endereco.getComplemento() == null) {
            mensagemErro += "\nBairro.";
            valido = false;
        } else if (endereco.getComplemento().length() > 30) {
            mensagemErro += "\nBairro excede o limite. Máximo 30 caracteres.";
            valido = false;
        }
        
        return "";
    }
    
}
