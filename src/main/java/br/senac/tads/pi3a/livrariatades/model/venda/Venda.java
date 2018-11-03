/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.model.venda;

import br.senac.tads.pi3a.livrariatades.model.pessoa.cliente.Cliente;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Raul de Paula
 */
public class Venda {
    private int id;
    private int idPessoa;
    private String notaFiscal;
    private Date data;
    private float valorTotal;
    private Cliente cliente;
    private ArrayList<ItemVendido> listaItensVendidos = new ArrayList<ItemVendido>();

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
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

    public ArrayList<ItemVendido> getListaItensVendidos() {
        return listaItensVendidos;
    }

    public void setListaItensVendidos(ArrayList<ItemVendido> listaItensVendidos) {
        this.listaItensVendidos = listaItensVendidos;
    }
    
    
}
