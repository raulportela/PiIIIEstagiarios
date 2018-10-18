/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.model.pessoa.cliente;

import br.senac.tads.pi3a.livrariatades.model.pessoa.Pessoa;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Jeferson Nolasco
 */
public class Cliente extends Pessoa {

    private String email;
    private Integer telefone;
    private Integer celular;
    private BigDecimal totalCompras;

    public Cliente(String nome, String sobrenome, String rg, String cpf,
            Date dataNascimento, String sexo, String email, Integer telefone,
            Integer celular, BigDecimal totalCompra) {
        super(nome, sobrenome, rg, cpf, dataNascimento, sexo);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public BigDecimal getTotalCompras() {
        return totalCompras;
    }

    public void setTotalCompras(BigDecimal totalCompras) {
        this.totalCompras = totalCompras;
    }
    


    
    
}
