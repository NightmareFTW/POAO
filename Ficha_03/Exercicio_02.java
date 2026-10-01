import java.util.Scanner;

public class Exercicio_02 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduza o codigo do troco: ");
        String codigo = teclado.nextLine().trim();

        if (codigo.length() != 12) {
            System.out.println("Codigo invalido: deve ter exatamente 12 caracteres.");
        } else if (!codigo.matches("[A-Za-z0-9]+")) {
            System.out.println("Codigo invalido: so pode conter letras e numeros.");
        } else {
            String codigoInvertido = new StringBuilder(codigo).reverse().toString();

            if (codigo.equalsIgnoreCase(codigoInvertido)) {
                System.out.println("Codigo valido.");
            } else {
                System.out.println("Codigo invalido: nao e igual nos dois sentidos.");
            }
        }

        teclado.close();
    }
}