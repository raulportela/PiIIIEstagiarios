/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.validador.produto;

import br.senac.tads.pi3a.livrariatades.model.produto.Produto;

/**
 *
 * @author Raul de Paula
 */
public class ValidadorProduto {
    public static String validar (Produto produto){
        String mensagemErro = "Inforamar campos obrigatórios: ";
        boolean valido = true;
        
        if (produto == null) {
            mensagemErro = "Não foi informado um produto.";
            valido = false;
        }
        
        if (produto.getTitulo().equals("") || produto.getTitulo() == null) {
            mensagemErro += "\nTitulo";
            valido = false;
        } else if (produto.getTitulo().length() > 60) {
            mensagemErro += "\nTitulo excede limite máximo. 60 caracteres.";
        }
        
        if (produto.getAutor().equals("") || produto.getAutor() == null) {
            mensagemErro += "\nAutor.";
            valido = false;
        } else if (produto.getAutor().length() > 70) {
            mensagemErro += "\nAutor excede limite máximo. 70 caracteres.";
            valido = false;
        }
        
        if (produto.getEditora().equals("") || produto.getEditora() == null) {
            mensagemErro += "\nEditora";
            valido = false;
        } else if (produto.getEditora().length() > 50) {
            mensagemErro += "\nEditora excede limite máximo. 70 caracteres.";
            valido = false;
        }    
        
        if (produto.getDescricao().equals("") || produto.getDescricao() == null) {
            mensagemErro += "\nDescrição";
            valido = false;
        } else if (produto.getDescricao().length() > 300) {
            mensagemErro += "\nDescrição excede limite máximo. 60 caracteres.";
        }
        
        Integer validoQuantidade = produto.getQuantidade();
        if (validoQuantidade.equals("") || validoQuantidade == null) {
            mensagemErro += "\nQuantidade.";
            valido = false;
        } //Vamos delimitar a quantidade?
        
        if (produto.isDisponivel() == false) {
            mensagemErro += "\nNão há produtos em estoque.";
        }
        
        if (produto.getValor() > 9999.99) {
            mensagemErro += "\nValor unitário excede limite máximo.";
            valido = false;
        }
        
        if (valido == false) {
            return mensagemErro;
        } else {
            return null;
        }
    }
    
}
