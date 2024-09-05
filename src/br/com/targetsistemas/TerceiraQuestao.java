package br.com.targetsistemas;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class TerceiraQuestao {

    /*
     * Lê e converte o arquivo json em um objeto JSONArray para manipulação de dados.
     * PS: Optei por utilizar essa abordagem por se tratar de um JSON simples, mas sei que em larga escala não seria o ideal!
     */
    public JSONArray lerArquivoJson(String path) throws IOException {

        // Como diz na descrição desse método, ele lê todos os bytes de um arquivo e então eles são transformados em String.
        String content = new String(Files.readAllBytes(Paths.get(path)));

        // A String é convertida em um objeto JSONArray que nos permite acessar e manipular os dados do JSON
        return new JSONArray(content);
    }

    public String encontrarDiaComMenorFaturamento(JSONArray jsonArray) {

        // Coloquei o valor máximo que pode ser atribuido a um atributo (variável) double, achei melhor do que colocar um número "na mão".
        double valorMinimo = Double.MAX_VALUE; 
        int diaComMenorFaturamento = 0;

        // Loop para encontrar o dia com menor faturamento, armazenando valor e o dia.
        for (int i = 0; i < jsonArray.length(); i++) {

            // Percorre todo o array de objetos do arquivo json, especificando os campos que iremos utilizar por meio dos atributos;
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            int dia = jsonObject.getInt("dia");
            double valor = jsonObject.getDouble("valor");
            
            if(valor > 0.0 && valor < valorMinimo) {                
                diaComMenorFaturamento = dia;
                valorMinimo = valor;
            }
        }

        return String.format("O menor faturamento foi no dia %d, com o faturamento de %.2f R$!", 
            diaComMenorFaturamento, valorMinimo);

    }


    // O maior valor de faturamento ocorrido em um dia do mês.
    public String encontrarDiaComMaiorFaturamento(JSONArray jsonArray) {

        double valorMaximo = 0;
        int diaComMaiorFaturamento = 0;

        // Loop para encontrar o dia com o maior faturamento, armazenando valor e o dia.
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            int dia = jsonObject.getInt("dia");
            double valor = jsonObject.getDouble("valor");
            
            if(valor > 0.0 && valor > valorMaximo) {
                diaComMaiorFaturamento = dia;
                valorMaximo = valor;
            }
        }

        return String.format("O maior faturamento foi no dia %d, com o faturamento de %.2f R$!", 
            diaComMaiorFaturamento, valorMaximo);
    }


    // Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.
    public String contarDiasComFaturamentoAcimaDaMedia(JSONArray jsonArray) {
        
        double totalFaturamento = 0;
        int diasComFaturamento = 0;

        // Loop para encontrar a quantidade de dias onde o faturamento é maior que 0 (devem ser ignorados no cálculo da média) e a soma dos faturamentos.
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            double valor = jsonObject.getDouble("valor");

            if(valor > 0.0) {
                totalFaturamento += valor;
                diasComFaturamento += 1;
            }
        }

        // Verifico se existem dias com faturamento acima de 0 para não precisar percorrer o restante do código.
        if (diasComFaturamento == 0) return "Não existem dias com faturamento maior que 0";

        // Calculo a média
        double mediaFaturamento = totalFaturamento / diasComFaturamento;
        int diasAcimaDaMedia = 0;

        // Loop para encontrar a quantidade de dias onde o faturamento é maior que a média.
        for (int j = 0; j < jsonArray.length(); j++) {
            JSONObject jsonObject = jsonArray.getJSONObject(j);
            double valor = jsonObject.getDouble("valor");

            if(valor > mediaFaturamento) {
                diasAcimaDaMedia += 1;
            }
        }

        return String.format("O número de dias onde o valor do faturamento foi maior que a média foram: %d", 
            diasAcimaDaMedia);
    }

}
