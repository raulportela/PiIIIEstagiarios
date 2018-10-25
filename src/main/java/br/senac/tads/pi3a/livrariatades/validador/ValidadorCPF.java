/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.validador;

/**
 *
 * @author Raul de Paula
 */
public class ValidadorCPF {

    public static boolean validadorCPF(String CPF) {
        boolean valido = true;
        boolean digitosIguais = false;
        int somaMultiplicacoes = 0;
        int charNumero;
        int multiplicador = 10;
        int resto;
        
        do{
            int nx;
            int ny;
            if(somaMultiplicacoes <=9){
                nx = Character.getNumericValue(CPF.charAt(somaMultiplicacoes));
                ny = Character.getNumericValue(CPF.charAt(somaMultiplicacoes+1));
                if (nx != ny){
                    digitosIguais = false;
                    somaMultiplicacoes = 0;
                }
            }else if(somaMultiplicacoes >= 10){
                return false;
            }
            somaMultiplicacoes++;
        }while(digitosIguais == true);
        
        for (int i = 0; i < 9; i++) {
            charNumero = Character.getNumericValue(CPF.charAt(i));
            somaMultiplicacoes += (charNumero * multiplicador);
            multiplicador--;
        }
        multiplicador = 11;
        resto = (somaMultiplicacoes % 11);
        somaMultiplicacoes = 0;
        charNumero = Character.getNumericValue(CPF.charAt(9));
        if (((11 - resto) == charNumero) || (resto == 0)) {
            for (int i = 0; i < 10; i++) {
                charNumero = Character.getNumericValue(CPF.charAt(i));
                somaMultiplicacoes += (charNumero * multiplicador);
                multiplicador--;
            }
            charNumero = Character.getNumericValue(CPF.charAt(10));
            resto = (somaMultiplicacoes%11);
            if (((11 - resto) == charNumero) || (resto == 0)){
                return valido;
            }
        } else {
            return !valido;
        }
        return !valido;
    }
}
