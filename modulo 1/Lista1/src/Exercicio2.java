import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("######################");

        System.out.println("Digite a primeira nota: ");
        double nota1 = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Digite a segunda nota: ");
        double nota2 = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Digite a terceira nota: ");
        double nota3 = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Digite a quarta nota: ");
        double nota4 = scanner.nextDouble();
        scanner.nextLine();

        double media = (nota1 + nota2 + nota3 + nota4) / 4;

        if (media <= 5.0) {
            System.out.println("Sua média foi " + media + " , você esta Reprovado");
        } else if (media <= 6.9) {
            System.out.println("Sua média foi " + media + " , você esta em exame");
        } else {
            System.out.println("Sua média foi " + media + " , você esta aprovado");
        }
    }
}
