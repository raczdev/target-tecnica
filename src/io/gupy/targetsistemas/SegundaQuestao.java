package io.gupy.targetsistemas;

public class SegundaQuestao {

    private int primeiroNumero = 0;
    private int segundoNumero = 1;


    // Método para verificar se o número digitado faz parte da sequência Fibonacci.
    public void verificarPresencaNaFibonacci(int numeroProcurado) {

        // if para descobrir se o numero informado é 0 ou 1 (O Loop é iniciado pelo terceiro numero da sequência fibonacci).
        if(numeroProcurado == primeiroNumero) {
            System.out.printf("O numero informado %d é o primeiro da sequência Fibonacci", 
                numeroProcurado);
            return;
        } else if(numeroProcurado == segundoNumero) {
            System.out.printf("O numero informado %d é o segundo da sequência Fibonacci", 
                numeroProcurado);
            return;
        }

        // Print para os dois primeiros números da sequência.
        System.out.printf("A sequencia de Fibonacci se inicia pelos numeros %d, %d, ", 
            primeiroNumero, segundoNumero);

        // De fato o Loop Fibonacci, ele calcula o proximo número e então atualiza a versão das variaveis para a proxima iteração
        for (int i = 0; i < numeroProcurado; i++) {
            int proximoNumero = primeiroNumero + segundoNumero;
            System.out.print(proximoNumero);
            primeiroNumero = segundoNumero;
            segundoNumero = proximoNumero;

            // Verifica se o numero procurado foi encontrado na sequência.
            if(proximoNumero == numeroProcurado) {
                System.out.printf(" O número informado %d faz parte da sequência Fibonacci",
                    proximoNumero);
                break;
            // Verifica se o numero procurado é maior do que o numero atual da sequencia Fibonnaci (se ele não existe na sequência).
            } else if(proximoNumero > numeroProcurado) {
                System.out.printf(" O número informado %d não faz parte da sequência Fibonacci", 
                    proximoNumero);
            }

            System.out.print(", ");
        }
    }

    // Método para exibir a sequência Fibonacci até o limite especificado.
    public void exibirSequenciaFibonacci(int limite) {

        System.out.printf("A sequencia de Fibonacci se inicia pelos numeros %d, %d, ", primeiroNumero, segundoNumero);

        // Entra no loop para começar a calcular e exibir a sequência.
        while(true){
            int proximoNumero = primeiroNumero + segundoNumero;
            System.out.print(proximoNumero);

            // Verifica se o proximo numero ultrapassa o limite, caso ultrapasse ele para o loop com break - PS: optei por exibir o ultimo numero mais proximo do limite.
            if(proximoNumero > limite) break;
            
            System.out.print(", ");


            primeiroNumero = segundoNumero;
            segundoNumero = proximoNumero;            
        }
    }
}
