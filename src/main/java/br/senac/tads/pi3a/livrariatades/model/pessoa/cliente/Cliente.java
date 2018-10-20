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
    private String endereco;
    private BigDecimal totalCompras;

    public Cliente(String nome, String sobrenome, String cpf,
            Date dataNascimento, String email, Integer telefone,
            Integer celular, String endereco) {
        super(nome, sobrenome, cpf, dataNascimento);
        {
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.cpf = cpf;
            this.dataNascimento = dataNascimento;
            this.email = email;
            this.telefone = telefone;
            this.celular = celular;
            this.endereco = endereco;
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", getNome(), getSobrenome(),
                getCpf(), getDataNascimento(), getEmail(), getTelefone(), getCelular(), getEndereco());

    }

}
