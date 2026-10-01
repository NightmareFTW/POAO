public static void main(String[] args) {
        // 0 representa um lugar livre; qualquer outro valor indica um lugar ocupado.
        int[][] lugares = {
            {25, 0, 34, 35},
            {11, 18, 0, 7},
            {0, 56, 65, 0},
            {56, 0, 0, 45},
            {13, 41, 51, 0}
        };

        boolean encontrados = false;
        int filaReserva = -1;
        int colReserva = -1;

        // Procura dois lugares livres consecutivos na mesma fila.
        for (int fila = 0; fila < lugares.length; fila++) {
            for (int coluna = 0; coluna < lugares[fila].length - 1; coluna++) {
                if (lugares[fila][coluna] == 0
                        && lugares[fila][coluna + 1] == 0) {
                    filaReserva = fila;
                    colReserva = coluna;
                    encontrados = true;
                    break;
                }
            }

            if (encontrados) {
                break;
            }
        }

        if (encontrados) {
            System.out.println("Bilhetes emitidos com sucesso!");
            System.out.println("Fila: " + (filaReserva + 1)
                    + " | Lugares: " + (colReserva + 1)
                    + " e " + (colReserva + 2));
        } else {
            System.out.println("Não existem dois lugares livres juntos nesta carruagem.");
        }
    }
