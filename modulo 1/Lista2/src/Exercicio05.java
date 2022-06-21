import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] valores = new int[20];

        for (int i = 0; i < valores.length; i++) {
            System.out.println("Informe o " + (i + 1) + "° valor: ");
            valores[i] = scanner.nextInt();
        }

        System.out.println("A ordem contrária dos números informados é: ");

        for (int j = valores.length - 1; j >= 0; j--) {
            System.out.println(valores[j]);
        }

    }
}
