public class Exercicio_02 {
    public static void main(String[] args) {
        Estacao lisboa = new Estacao("Lisboa", 0);
        Estacao coimbra = new Estacao("Coimbra", 200);

        Comboio comboio = new Comboio(204, "R", 120, lisboa, coimbra);

        System.out.println(comboio);
        System.out.println("Distancia da viagem: "
                + comboio.calcularDistancia() + " km");
        System.out.println("Tempo minimo da viagem: "
                + comboio.tempoMinimoViagem() + " minutos");
    }
}