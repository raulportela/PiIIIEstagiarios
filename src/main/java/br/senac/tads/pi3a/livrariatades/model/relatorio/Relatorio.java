/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.model.relatorio;

import java.time.LocalDate;

/**
 *
 * @author Raul de Paula
 */
public class Relatorio {
    private LocalDate dia;
    private float totalDia;
    private int qtdProdutos;

    public int getQtdProdutos() {
        return qtdProdutos;
    }

    public void setQtdProdutos(int qtdProdutos) {
        this.qtdProdutos = qtdProdutos;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public float getTotalDia() {
        return totalDia;
    }

    public void setTotalDia(float totalDia) {
        this.totalDia = totalDia;
    }

}
