public class Exercicio_03 {

    public static void processarColocacoes(
            int[] vagasEscolas,
            double[] notasCandidatos,
            int[] escolasPretendidas) {

        int numeroCandidatos = notasCandidatos.length;
        boolean[] processados = new boolean[numeroCandidatos];

        // Guardamos as escolhas antes de substituir o vetor pelos resultados.
        int[] escolasEscolhidas = new int[numeroCandidatos];

        for (int i = 0; i < numeroCandidatos; i++) {
            escolasEscolhidas[i] = escolasPretendidas[i];
        }

        // Analisamos os candidatos do que tem melhor nota para o que tem pior.
        for (int ordem = 0; ordem < numeroCandidatos; ordem++) {
            int melhorCandidato = -1;

            for (int candidato = 0; candidato < numeroCandidatos; candidato++) {
                if (!processados[candidato]
                        && (melhorCandidato == -1
                        || notasCandidatos[candidato] > notasCandidatos[melhorCandidato])) {
                    melhorCandidato = candidato;
                }
            }

            processados[melhorCandidato] = true;

            int escola = escolasEscolhidas[melhorCandidato];

            // O candidato fica colocado se a escola escolhida ainda tiver vagas.
            if (escola >= 0 && escola < vagasEscolas.length && vagasEscolas[escola] > 0) {
                escolasPretendidas[melhorCandidato] = 1;
                vagasEscolas[escola]--;
            } else {
                escolasPretendidas[melhorCandidato] = 0;
            }
        }
    }

    public static void main(String[] args) {
        // As escolas são identificadas pelos índices 0, 1 e 2.
        int[] vagasEscolas = {2, 1, 3};

        double[] notasCandidatos = {18.5, 16.0, 15.0, 14.8, 12.5};

        // Cada valor indica a escola escolhida pelo candidato correspondente.
        int[] escolasPretendidas = {1, 1, 1, 0, 2};

        processarColocacoes(vagasEscolas, notasCandidatos, escolasPretendidas);

        System.out.println("RESULTADO DO CONCURSO");

        for (int candidato = 0; candidato < notasCandidatos.length; candidato++) {
            String resultado;

            if (escolasPretendidas[candidato] == 1) {
                resultado = "COLOCADO";
            } else {
                resultado = "NAO COLOCADO";
            }

            System.out.println("Candidato " + candidato
                    + " (nota " + notasCandidatos[candidato] + "): "
                    + resultado);
        }

        System.out.println("\nVagas que sobraram:");

        for (int escola = 0; escola < vagasEscolas.length; escola++) {
            System.out.println("Escola " + escola + ": " + vagasEscolas[escola]);
        }
    }
}