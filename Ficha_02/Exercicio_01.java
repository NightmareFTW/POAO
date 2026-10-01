import java.util.Scanner;

public class Exercicio_01 {
    static final int NUM_SENSORES = 10;
    static final double DISTANCIA = 10.0;

    public static double calcularMedia(double[] velocidades) {
        double soma = 0;

        for (int i = 0; i < velocidades.length; i++) {
            soma += velocidades[i];
        }

        return soma / velocidades.length;
    }

    public static double calcularDuracao(double velocidadeMedia) {
        return (DISTANCIA / velocidadeMedia) * 60;
    }

    public static void imprimirCarruagem(int[][] lugares) {
        System.out.println("Lugar\tJanela\tCorredor");

        for (int fila = 0; fila < lugares.length; fila++) {
            System.out.print((fila + 1) + "\t");

            for (int coluna = 0; coluna < lugares[fila].length; coluna++) {
                if (lugares[fila][coluna] == 0) {
                    System.out.print("LIVRE\t");
                } else {
                    System.out.print(lugares[fila][coluna] + "\t");
                }
            }

            System.out.println();
        }
    }

    // Define a prioridade de embarque: seniores, menores e restantes adultos.
    public static int prioridade(int idade) {
        if (idade >= 65) {
            return 0;
        } else if (idade < 18) {
            return 1;
        } else {
            return 2;
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Exercício 1: velocidades dos sensores
        double[] velocidades = new double[NUM_SENSORES];

        System.out.println("CONTROLO DE VELOCIDADE");

        for (int i = 0; i < velocidades.length; i++) {
            System.out.print("Velocidade do sensor " + (i + 1) + " (km/h): ");
            velocidades[i] = teclado.nextDouble();
        }

        double mediaAntes = calcularMedia(velocidades);
        double duracaoAntes = calcularDuracao(mediaAntes);

        System.out.printf("Velocidade media: %.2f km/h%n", mediaAntes);
        System.out.printf("Duracao prevista: %.2f minutos%n", duracaoAntes);

        int sensor;
        do {
            System.out.print("Numero do sensor a recalibrar (1 a 10): ");
            sensor = teclado.nextInt();
        } while (sensor < 1 || sensor > NUM_SENSORES);

        double novaVelocidade;
        do {
            System.out.print("Nova velocidade para o sensor " + sensor + ": ");
            novaVelocidade = teclado.nextDouble();
        } while (novaVelocidade <= 0);

        velocidades[sensor - 1] = novaVelocidade;

        double mediaDepois = calcularMedia(velocidades);
        double duracaoDepois = calcularDuracao(mediaDepois);
        double diferencaDuracao = Math.abs(duracaoAntes - duracaoDepois);

        System.out.printf("Nova velocidade média: %.2f km/h%n", mediaDepois);
        System.out.printf("Nova duracao prevista: %.2f minutos%n", duracaoDepois);
        System.out.printf("Diferenca entre as duracoes: %.2f minutos%n", diferencaDuracao);

        int infracoes = 0;
        for (int i = 0; i < velocidades.length; i++) {
            if (velocidades[i] > 120) {
                infracoes++;
            }
        }

        System.out.println("Sensores com infrações: " + infracoes);

        // Exercício 2: lugares da carruagem
        System.out.println("\nORGANIZACAO DA CARRUAGEM");

        int[][] lugares = new int[4][2];

        for (int fila = 0; fila < lugares.length; fila++) {
            for (int coluna = 0; coluna < lugares[fila].length; coluna++) {
                System.out.print("Idade no lugar " + (fila + 1)
                        + ", " + (coluna == 0 ? "janela" : "corredor")
                        + " (0 se estiver livre): ");
                lugares[fila][coluna] = teclado.nextInt();
            }
        }

        System.out.println("\nTabela inicial:");
        imprimirCarruagem(lugares);

        int ocupados = 0;
        for (int fila = 0; fila < lugares.length; fila++) {
            for (int coluna = 0; coluna < lugares[fila].length; coluna++) {
                if (lugares[fila][coluna] != 0) {
                    ocupados++;
                }
            }
        }

        System.out.println("Lugares ocupados: " + ocupados);

        // Copia as idades dos passageiros para um vetor.
        int[] idades = new int[ocupados];
        int posicao = 0;

        for (int fila = 0; fila < lugares.length; fila++) {
            for (int coluna = 0; coluna < lugares[fila].length; coluna++) {
                if (lugares[fila][coluna] != 0) {
                    idades[posicao] = lugares[fila][coluna];
                    posicao++;
                }
            }
        }

        // Ordenação simples, usando a prioridade de embarque.
        for (int i = 0; i < idades.length - 1; i++) {
            for (int j = 0; j < idades.length - 1 - i; j++) {
                if (prioridade(idades[j]) > prioridade(idades[j + 1])) {
                    int temporaria = idades[j];
                    idades[j] = idades[j + 1];
                    idades[j + 1] = temporaria;
                }
            }
        }

        // Coloca as idades ordenadas numa nova tabela.
        int[][] tabelaEmbarque = new int[4][2];
        posicao = 0;

        for (int fila = 0; fila < tabelaEmbarque.length && posicao < idades.length; fila++) {
            for (int coluna = 0; coluna < tabelaEmbarque[fila].length
                    && posicao < idades.length; coluna++) {
                tabelaEmbarque[fila][coluna] = idades[posicao];
                posicao++;
            }
        }

        System.out.println("\nTabela organizada para o embarque:");
        imprimirCarruagem(tabelaEmbarque);

        teclado.close();
    }
}