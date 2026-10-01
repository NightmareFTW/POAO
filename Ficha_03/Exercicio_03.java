public class Exercicio_03 {
    public static void main(String[] args) {
        String codigo = " ic-204 ";
        String destino = "Porto-Campanha";
        String plataforma = "P-07";

        String comboio = codigo.trim()
                .toUpperCase()
                .replace("-", "");

        String destinoMaiusculas = destino.toUpperCase();
        int posicaoHifen = destinoMaiusculas.indexOf("-");
        String cidade = destinoMaiusculas.substring(0, posicaoHifen);

        String numeroPlataforma = plataforma.replace("P-", "");
        int plataformaNumerica = Integer.parseInt(numeroPlataforma);

        String mensagem = "AVISO: Comboio " + comboio
                + " | Destino: " + cidade
                + " | Plataforma: " + plataformaNumerica;

        System.out.println(mensagem);
    }
}