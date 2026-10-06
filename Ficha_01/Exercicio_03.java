import java.util.Scanner;

public class Exercicio_03 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("Introduza o nome do estudante:");
			String nome = sc.nextLine();

			System.out.println("Introduza o número do estudante (7 dígitos):");
			int numeroEstudante = sc.nextInt();

			System.out.println("Introduza o ano de nascimento:");
			int anoNascimento = sc.nextInt();

			System.out.println("Introduza o ano corrente:");
			int anoCorrente = sc.nextInt();

			System.out.println("Endereço de correio institucional: "
					+ gerarEmail(nome, numeroEstudante));
			System.out.println("Idade: " + calcularIdade(anoNascimento, anoCorrente) + " anos");

			if (validarNumeroEstudante(numeroEstudante)) {
				System.out.println("Número de estudante válido.");
			} else {
				System.out.println("Número de estudante inválido.");
				System.out.println("O dígito de controlo esperado é: "
						+ calcularDigitoControlo(numeroEstudante));
			}

		}
	}

	public static String gerarEmail(String nome, int numeroEstudante) {
		// O nome é normalizado para formar o endereço institucional.
		return nome.trim().toLowerCase().replace(" ", ".")
				+ "." + numeroEstudante + "@uc.pt";
	}

	public static int calcularIdade(int anoNascimento, int anoCorrente) {
		// A idade corresponde à diferença entre os dois anos.
		return anoCorrente - anoNascimento;
	}

	public static boolean validarNumeroEstudante(int numeroEstudante) {
		// O número deve conter exatamente sete dígitos.
		if (numeroEstudante < 1_000_000 || numeroEstudante > 9_999_999) {
			return false;
		}

		// O último dígito deve coincidir com o checksum calculado.
		return numeroEstudante % 10 == calcularDigitoControlo(numeroEstudante);
	}

	public static int calcularDigitoControlo(int numeroEstudante) {
		int somaDigitos = 0;
		int numero = numeroEstudante / 10;

		// Soma os seis dígitos anteriores ao dígito de controlo.
		for (int contador = 0; contador < 6; contador++) {
			somaDigitos += numero % 10;
			numero /= 10;
		}

		return somaDigitos % 10;
	}
}
