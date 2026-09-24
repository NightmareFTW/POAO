import java.util.Scanner;


public class Exercicio_01 {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduza a distância entre estações (km):");
        double distancia = sc.nextDouble();

        System.out.println("Introduza a velocidade média prevista (km/h):");
        double velocidade = sc.nextDouble();

        if (velocidade <= 0) {
            System.out.println("A velocidade deve ser maior que zero.");
            sc.close();
            return;
        }

        double duracaoPrevistaMinutos = (distancia / velocidade) * 60;
        System.out.println("Duração prevista da viagem: " + duracaoPrevistaMinutos + " minutos");

        System.out.println("Introduza a hora real da partida (hh):");
        int horaPartida = sc.nextInt();

        System.out.println("Introduza os minutos reais da partida (mm):");
        int minutoPartida = sc.nextInt();

        System.out.println("Introduza a hora real da chegada (hh):");
        int horaChegada = sc.nextInt();

        System.out.println("Introduza os minutos reais da chegada (mm):");
        int minutoChegada = sc.nextInt();

        int duracaoRealMinutos = calcDurViagem(horaPartida, minutoPartida, horaChegada, minutoChegada);
        System.out.println("Duração real da viagem: " + duracaoRealMinutos + " minutos");

        double diferenca = duracaoRealMinutos - duracaoPrevistaMinutos;

        if (diferenca > 0) {
            System.out.println("Há um desvio positivo de " + diferenca + " minutos em relação ao horário planeado.");
        } else if (diferenca < 0) {
            System.out.println("Há um desvio negativo de " + (-diferenca) + " minutos em relação ao horário planeado.");
        } else {
            System.out.println("A viagem está de acordo com o horário planeado.");
        }

        sc.close();
    }

    public static int calcDurViagem(int horaPartida, int minutoPartida, int horaChegada, int minutoChegada) {
        int partidaTotalMinutos = horaPartida * 60 + minutoPartida;
        int chegadaTotalMinutos = horaChegada * 60 + minutoChegada;

        if (chegadaTotalMinutos < partidaTotalMinutos) {
            chegadaTotalMinutos += 24 * 60;
        }

        return chegadaTotalMinutos - partidaTotalMinutos;
    }
}