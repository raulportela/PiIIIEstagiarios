/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.model.suporte;

import java.util.Date;

/**
 *
 * @author Raul de Paula
 */
public class Suporte {

    private int id;
    private int codFuncionario;
    private boolean statusChamado;
    private String nomeChamado; //50
    private Date dataAbertura;
    private Date dataFechamento;
    private String Detalhe; //300

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public boolean isStatusChamado() {
        return statusChamado;
    }

    public void setStatusChamado(boolean statusChamado) {
        this.statusChamado = statusChamado;
    }

    public String getNomeChamado() {
        return nomeChamado;
    }

    public void setNomeChamado(String nomeChamado) {
        this.nomeChamado = nomeChamado;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public String getDetalhe() {
        return Detalhe;
    }

    public void setDetalhe(String Detalhe) {
        this.Detalhe = Detalhe;
    }
}
