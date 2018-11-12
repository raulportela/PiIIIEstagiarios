/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.validador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Maia
 */
public class ValidadorData {
    public boolean validar(String data) {
        //DateTimeFormatter tem uma função identica ao SimpleDateFormatter, mas escolhi usar ele
        //pois ele trabalha junto com o LocalDate que facilita muito trabalhar com datas
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        //Aqui eu converto uma data em LocalDate e digo que quero no formato do DateTimeFormatter
        //que criei acima
        LocalDate dataVerificada = LocalDate.parse(data, dtf);
        //Esse comando pega a data de hoje
        LocalDate hoje = LocalDate.now();
        //Se dataVerificada comparada com hoje é menor ou igual a zero então retorna verdadeiro,
        //senão, retorna falso
       // com LocalDate não tem como comparar assim: data1 < data2
       //Tem que ser assim: data1.compareTo(data2)
       //quando a data1 é menor isso retorna -1, quando é maior retorna 1, e quando é igual retorna 0
       //por isso eu comparei com <=0 abaixo
        return dataVerificada.compareTo(hoje) <= 0;
    }
}
