/*
A number is a perfect square, or a square number, if it is the square of a positive integer.
For example, 25 is a square number because 5^2 = 25; it is also an odd square.

The first 5 square numbers are: 1, 4, 9, 16, 25, and the sum of the odd squares is 1 + 9 + 25 = 35.

Among the first 677 thousand square numbers, what is the sum of all the odd squares?
*/

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




cd /d "C:\Users\Jorge Diogo\Documents\POAO\Ficha_04"
javac Exercicio_03\*.java
java Exercicio_03.AppCombustiveis