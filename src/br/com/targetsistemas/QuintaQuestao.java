package br.com.targetsistemas;

public class QuintaQuestao {
    
    
    public String inverterString(String string) {
        
        String stringInvertida = "";
        
        // Loop onde i começa com o valor do tamanho da string - 1 (para se adequar ao idex do array). E então percorre até a posição 0.
        for (int i = string.length() - 1; i >= 0; i--) {

            // Armazena o caractere da posição i no atributo (variável).
            stringInvertida = stringInvertida + string.charAt(i);
        }

        return stringInvertida;
    }
}
