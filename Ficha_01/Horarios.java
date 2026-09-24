import java.util.*;

public class Horarios {
    public static void main(String[] args){

        int distancia, velocidade, duracaoMinutos;
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduza a distancia (em km)");
        distancia = sc.nextInt();

        System.out.println("Introduza a velocidade (em km/h)");
        velocidade = sc.nextInt();

        duracaoMinutos = (distancia * 60) / velocidade;
        System.out.println("Duracao prevista para o troço: " + duracaoMinutos + " minutos");

    sc.close();
    }
}