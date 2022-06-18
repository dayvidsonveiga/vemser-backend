import java.util.Scanner;

public class Exercicio9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ano, mes, dia;

        System.out.println("Escreva a sua idade (somente em anos) ");
        ano = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Escreva a sua idade (somente em meses) ");
        mes = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Escreva a sua idade (somente em dias) ");
        dia = scanner.nextInt();
        scanner.nextLine();

        dia = (dia + (ano * 365) + (mes * 30));
        System.out.println("Sua idade em dias é: " + dia);
    }
}
