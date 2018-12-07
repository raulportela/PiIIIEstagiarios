/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.model.venda;

import br.senac.tads.pi3a.livrariatades.model.pessoa.cliente.Cliente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Raul de Paula
 */
public class Venda {

    private int id;
    private int idPessoa;
    private String notaFiscal;
    private LocalDate data;
    private float valorTotal;
    private Cliente cliente;
    private int codFilial;
    private List<ItemVendido> listaItensVendidos = new ArrayList();

    public int getCodFilial() {
        return codFilial;
    }

    public void setCodFilial(int codFilial) {
        this.codFilial = codFilial;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemVendido> getListaItensVendidos() {
        return listaItensVendidos;
    }

    public void setListaItensVendidos(List<ItemVendido> listaItensVendidos) {
        this.listaItensVendidos = listaItensVendidos;
    }

}
