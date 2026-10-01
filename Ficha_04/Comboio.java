public class Comboio {
    private int numero;
    private String tipo;
    private double velocidadeMaxima;
    private double velocidadeAtual;
    private Estacao origem;
    private Estacao destino;

    // Construtor do exercicio anterior.
    public Comboio(int numero, String tipo, double velocidadeMaxima) {
        this(numero, tipo, velocidadeMaxima, null, null);
    }

    public Comboio(int numero, String tipo, double velocidadeMaxima,
            Estacao origem, Estacao destino) {
        this.numero = numero;
        this.tipo = tipo;
        this.velocidadeMaxima = velocidadeMaxima;
        this.velocidadeAtual = 0.0;
        this.origem = origem;
        this.destino = destino;
    }

    public double calcularDistancia() {
        return Math.abs(destino.getPosicao() - origem.getPosicao());
    }

    public double tempoMinimoViagem() {
        return (calcularDistancia() / velocidadeMaxima) * 60;
    }

    public void acelerar(double valorAumento) {
        if (valorAumento > 0
                && velocidadeAtual + valorAumento <= velocidadeMaxima) {
            velocidadeAtual += valorAumento;
        }
    }

    public void travar(double valorTravagem) {
        if (valorTravagem > 0) {
            velocidadeAtual = Math.max(0, velocidadeAtual - valorTravagem);
        }
    }

    @Override
    public String toString() {
        String descricao = "O COMBOIO " + numero
                + ", TIPO " + tipo
                + ", viaja a velocidade de " + velocidadeAtual + " km/h";

        if (origem != null && destino != null) {
            descricao += ", de " + origem + " para " + destino;
        }

        return descricao;
    }
}