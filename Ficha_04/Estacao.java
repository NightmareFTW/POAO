public class Estacao {
    private String nome;
    private double posicao;

    public Estacao(String nome, double posicao) {
        this.nome = nome;
        this.posicao = posicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPosicao() {
        return posicao;
    }

    public void setPosicao(double posicao) {
        this.posicao = posicao;
    }

    @Override
    public String toString() {
        return "Estacao de " + nome + ", km " + posicao;
    }
}