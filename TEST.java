public class TEST {
    public static void main(String[] args) {
        long sum = 0;
        for (int i = 1; i <= 677_000; i++) {
            long square = (long) i * i;
            if (square % 2 != 0) {
                sum += square;
            }
        }
        System.out.println("The sum of all the odd squares among the first 677 thousand square numbers is: " + sum);
    }
}



/* 
cd /d "C:\Users\Jorge Diogo\Documents\POAO\Ficha_04"
javac Exercicio_03\*.java
java Exercicio_03.AppCombustiveis
*/