import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha um número para que alguem possa tentar advinhar: ");
        int numeroEscolhido = scanner.nextInt();

        System.out.println("Tente adivinhar o número escolhido pela primeira pessoa: ");
        int numeroSorte = scanner.nextInt();

        while (numeroSorte != numeroEscolhido) {

            if (numeroSorte < numeroEscolhido) {
                System.out.println("O número a ser encontrado é maior do que você digitou");
            } else {
                System.out.println("O número a ser encontrado é menor do que você digitou");
            }

            System.out.println("Você errou, tente novamente: ");
            numeroSorte = scanner.nextInt();
        }

        System.out.println("Parabéns você acertou! Os dois escolheram o número: " + numeroEscolhido);


    }
}
