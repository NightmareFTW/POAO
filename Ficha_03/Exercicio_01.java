import java.util.Scanner;

public class Exercicio_01 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduza o codigo do comboio: ");
        String codigo = teclado.nextLine().trim();

        // O codigo deve ter quatro campos separados por hifens.
        String[] campos = codigo.split("-", -1);

        if (campos.length != 4) {
            System.out.println("Codigo invalido: deve conter quatro campos separados por hifens.");
            teclado.close();
            return;
        }

        String tipo = campos[0].trim().toUpperCase();
        String origem = campos[1].trim().toUpperCase();
        String destino = campos[2].trim().toUpperCase();
        String numero = campos[3].trim();

        boolean valido = true;

        // Verifica se a origem e o destino contem apenas letras.
        if (!origem.matches("[A-Z]+")) {
            System.out.println("Erro: o local de origem deve conter apenas letras.");
            valido = false;
        }

        if (!destino.matches("[A-Z]+")) {
            System.out.println("Erro: o local de destino deve conter apenas letras.");
            valido = false;
        }

        // Verifica o tipo de comboio e obtem a sua designacao completa.
        String designacaoTipo = "";

        if (!tipo.matches("[A-Z]+")) {
            System.out.println("Erro: o tipo de comboio deve conter apenas letras.");
            valido = false;
        } else if (tipo.equals("IC")) {
            designacaoTipo = "INTERCIDADES";
        } else if (tipo.equals("R")) {
            designacaoTipo = "REGIONAL";
        } else {
            System.out.println("Erro: o tipo de comboio deve ser IC ou R.");
            valido = false;
        }

        // O numero deve ter exatamente tres digitos.
        if (!numero.matches("[0-9]{3}")) {
            System.out.println("Erro: o numero do comboio deve ter exatamente tres digitos.");
            valido = false;
        }

        if (valido) {
            System.out.println("O comboio " + designacaoTipo
                    + " numero " + numero
                    + " realiza uma viagem de " + origem
                    + " para " + destino + ".");
        } else {
            System.out.println("O codigo do comboio e invalido.");
        }

        teclado.close();
    }
}