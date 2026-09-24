public class Exercicio_02 {

	public static void main(String[] args) {
		int totalFalhasComboio = 0;
		boolean comboioInterditado = false;

		for (int carruagem = 1; carruagem <= 6; carruagem++) {
			int falhasCarruagem = 0;

			System.out.println("Carruagem " + carruagem);

			for (int componente = 1; componente <= 10; componente++) {
				int estado = (int) (Math.random() * 2);

				System.out.println("Estado do componente " + componente + ": " + estado);

				if (estado == 0) {
					falhasCarruagem++;
				}
			}

			totalFalhasComboio += falhasCarruagem;

			System.out.println("Total de falhas da carruagem: " + falhasCarruagem);

			if (falhasCarruagem >= 3) {
				System.out.println("Carruagem INTERDITADA");
				comboioInterditado = true;
			} else {
				System.out.println("Carruagem APROVADA");
			}

			System.out.println();
		}

		if (totalFalhasComboio >= 10) {
			comboioInterditado = true;
		}

		System.out.println("Total de falhas do comboio: " + totalFalhasComboio);

		if (comboioInterditado) {
			System.out.println("Comboio INTERDITADO");
		} else {
			System.out.println("Comboio APROVADO");
		}
	}
}
