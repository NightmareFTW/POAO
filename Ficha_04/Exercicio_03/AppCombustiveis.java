package Exercicio_03;

public class AppCombustiveis {
    public static void main(String[] args) {
        PostoCombustivel[] postos = {
            new PostoCombustivel("Marca A", "Lisboa", 1.82, 1.65),
            new PostoCombustivel("Marca B", "Coimbra", 1.79, 1.62),
            new PostoCombustivel("Marca C", "Porto", 1.85, 1.68),
            new PostoCombustivel("Marca D", "Aveiro", 1.80, 1.60),
            new PostoCombustivel("Marca E", "Leiria", 1.77, 1.64)
        };

        double litros = 40;

        for (int i = 0; i < postos.length; i++) {
            double custo = postos[i].calcularCusto(TipoCombustivel.GASOLINA, litros);
            System.out.println(postos[i].getMarca() + ": " + custo + " euros");
        }

        PostoCombustivel maisBarato = PostoCombustivel.compararPostos(postos);

        if (maisBarato != null) {
            System.out.println("Posto com o gasoleo mais barato:");
            System.out.println(maisBarato);
        }
    }
}