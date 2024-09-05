package br.com.targetsistemas;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class QuartaQuestao {

    /*
     * Como não havia sido especificado como os dados deveriam ser lidos, optei por criar um arquivo JSON.
     * Em java, eu também poderia criar uma classe específica para os dados e então instância-los com seus respectivos valores.
     */
    public JSONArray lerArquivoJson(String path) throws IOException {

        // Como diz na descrição desse método, ele lê todos os bytes de um arquivo e então eles são transformados em String.
        String content = new String(Files.readAllBytes(Paths.get(path)));

        // A String é convertida em um objeto JSONArray que nos permite acessar e manipular os dados do JSON
        return new JSONArray(content);
    }

    public void calcularPercentualFaturamento(JSONArray jsonArray) {

        double totalFaturamento = 0.0;

        // Loop para descobrir o faturamento total.
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            double valor = jsonObject.getDouble("valor");

            totalFaturamento += valor;
        }

        // Loop para calcular e printar o percentual de cada estado com base no total faturado.
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            double valor = jsonObject.getDouble("valor");
            String estado = jsonObject.getString("estado");

            double percertualDoFaturamento = (valor / totalFaturamento) * 100;

            System.out.printf("O estado de %s representa %.2f%% do faturamento total", estado, percertualDoFaturamento);
            System.out.println();
        }
    }
}
