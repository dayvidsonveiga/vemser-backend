import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = 10;
        int B = 20;

        int aux = A;

        A = B;

        B = aux;

        System.out.println("Valor de A: " + A + " Valor de B: " + B);
    }
}
