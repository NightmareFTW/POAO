public class Exercicio_01 {
    public static void main(String[] args) {
        Comboio comboio = new Comboio(204, "R", 120);

        System.out.println(comboio);

        comboio.acelerar(100);
        System.out.println("Depois de acelerar:");
        System.out.println(comboio);

        // Esta alteracao e ignorada porque excede a velocidade maxima.
        comboio.setVelocidadeAtual(150);
        System.out.println("Depois de tentar definir 150 km/h:");
        System.out.println(comboio);
    }
}

class Comboio {
    private int numero;
    private String tipo;
    private double velocidadeMaxima;
    private double velocidadeAtual;

    public Comboio(int numero, String tipo, double velocidadeMaxima) {
        this.numero = numero;
        this.tipo = tipo;
        this.velocidadeMaxima = velocidadeMaxima;
        this.velocidadeAtual = 0.0;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(double velocidadeMaxima) {
        if (velocidadeMaxima >= velocidadeAtual && velocidadeMaxima > 0) {
            this.velocidadeMaxima = velocidadeMaxima;
        }
    }

    public double getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public void setVelocidadeAtual(double velocidadeAtual) {
        if (velocidadeAtual >= 0 && velocidadeAtual <= velocidadeMaxima) {
            this.velocidadeAtual = velocidadeAtual;
        }
    }

    public void acelerar(double valorAumento) {
        if (valorAumento > 0) {
            setVelocidadeAtual(velocidadeAtual + valorAumento);
        }
    }

    public void travar(double valorTravagem) {
        if (valorTravagem > 0) {
            setVelocidadeAtual(velocidadeAtual - valorTravagem);
        }
    }

    @Override
    public String toString() {
        return "O COMBOIO " + numero
                + ", TIPO " + tipo
                + ", viaja a velocidade de "
                + velocidadeAtual + " km/h";
    }
}