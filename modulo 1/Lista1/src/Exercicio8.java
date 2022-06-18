import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o valor da base: ");
        double base = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Informe o valor da altura: ");
        double altura = scanner.nextDouble();
        scanner.nextLine();

        double area = base * altura;

        System.out.println("A área do retângulo é: " + area);
    }
}
