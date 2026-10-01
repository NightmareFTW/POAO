package Exercicio_03;

public class PostoCombustivel {
    private String marca;
    private String localidade;
    private double precoGasolina;
    private double precoGasoleo;

    public PostoCombustivel(String marca, String localidade,
            double precoGasolina, double precoGasoleo) {
        this.marca = marca;
        this.localidade = localidade;
        this.precoGasolina = precoGasolina;
        this.precoGasoleo = precoGasoleo;
    }

    public double calcularCusto(TipoCombustivel tipo, double litros) {
        if (tipo == TipoCombustivel.GASOLINA) {
            return precoGasolina * litros;
        }

        return precoGasoleo * litros;
    }

    public String getMarca() {
        return marca;
    }

    public String getLocalidade() {
        return localidade;
    }

    public double getPrecoGasoleo() {
        return precoGasoleo;
    }

    public static PostoCombustivel compararPostos(PostoCombustivel[] postos) {
        if (postos == null || postos.length == 0) {
            return null;
        }

        PostoCombustivel maisBarato = postos[0];

        for (int i = 1; i < postos.length; i++) {
            if (postos[i].getPrecoGasoleo() < maisBarato.getPrecoGasoleo()) {
                maisBarato = postos[i];
            }
        }

        return maisBarato;
    }

    @Override
    public String toString() {
        return marca + " - " + localidade
                + " | Gasolina: " + precoGasolina
                + " euros/litro | Gasoleo: " + precoGasoleo + " euros/litro";
    }
}