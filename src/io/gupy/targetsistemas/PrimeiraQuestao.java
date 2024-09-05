package io.gupy.targetsistemas;

public class PrimeiraQuestao {
    private int indice = 13;
    private int k = 0;
    private int soma = 0;
    
    public String calcularSoma(){
        while(k < indice) {
            k = k + 1;
            soma = soma + k;
        }

        return "O valor da variável SOMA é: " + soma;
    }
}
