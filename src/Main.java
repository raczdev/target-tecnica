import org.json.JSONArray;

import io.gupy.targetsistemas.PrimeiraQuestao;
import io.gupy.targetsistemas.QuartaQuestao;
import io.gupy.targetsistemas.QuintaQuestao;
import io.gupy.targetsistemas.SegundaQuestao;
import io.gupy.targetsistemas.TerceiraQuestao;

public class Main {
    public static void main(String[] args) {
        
        //Primeira Questão
        System.out.println("PRIMEIRA QUESTÃO: ");

        PrimeiraQuestao primeiraQuestao = new PrimeiraQuestao();
        // Printa o resultado da soma.
        System.out.println(primeiraQuestao.calcularSoma());




        // Segunda Questão
        System.out.println("SEGUNDA QUESTÃO: ");

        SegundaQuestao segundaQuestao = new SegundaQuestao();
        // Informar o número que deseja verificar se existe na sequência Fibonacci.
        segundaQuestao.verificarPresencaNaFibonacci(13);
        System.out.println();
        // Exibe a sequência Fibonacci até atingir o limite informado.
        segundaQuestao.exibirSequenciaFibonacci(10000);
        System.out.println();




        // Terceira Questão
        System.out.println("TERCEIRA QUESTÃO: ");

        TerceiraQuestao terceiraQuestao = new TerceiraQuestao();
        try {
            // Informa o arquivo JSON a ser lido.
            JSONArray dadosFaturamento = terceiraQuestao.lerArquivoJson("src/resources/dadosTerceiraQuestao.json");

            String diaMenorFaturamento  = terceiraQuestao.encontrarDiaComMenorFaturamento(dadosFaturamento);
            String diaMaiorFaturamento  = terceiraQuestao.encontrarDiaComMaiorFaturamento(dadosFaturamento);
            String diasAcimaDaMedia  = terceiraQuestao.contarDiasComFaturamentoAcimaDaMedia(dadosFaturamento);

            // Printa, em sequência, o menor valor, o maior valor e o numero de dias, conforme solicitado.
            System.out.println(diaMenorFaturamento);
            System.out.println(diaMaiorFaturamento);
            System.out.println(diasAcimaDaMedia);

        } catch (Exception e) {
            e.printStackTrace();
        }


        

        // Quarta Questão
        System.out.println("QUARTA QUESTÃO: ");

        QuartaQuestao quartaQuestao = new QuartaQuestao();
        try {
            // Informa o arquivo JSON a ser lido.
            JSONArray dadosPercentuais  = quartaQuestao.lerArquivoJson("src/resources/dadosQuartaQuestao.json");
            // Calcula os percentuais de cada estado, conforme solicitado.
            quartaQuestao.calcularPercentualFaturamento(dadosPercentuais );

        } catch (Exception e) {
            e.printStackTrace();
        }




        // Quinta Questão
        System.out.println("QUINTA QUESTÃO: ");

        QuintaQuestao quintaQuestao = new QuintaQuestao();
        // Informe a string que deseja inverter.
        String stringInvertida = quintaQuestao.inverterString("abcdefghijklmnopqrstuvwxyz");
        // Printa a string invertida.
        System.out.println("String invertida: " + stringInvertida);        
    }
}
