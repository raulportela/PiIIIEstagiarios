/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.model.venda;

import br.senac.tads.pi3a.livrariatades.model.produto.Produto;

/**
 *
 * @author Raul de Paula
 */
public class ItemVendido {
    private Produto produto;
    private int quantidade;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int qtd) {
        this.quantidade = qtd;
    }
}
