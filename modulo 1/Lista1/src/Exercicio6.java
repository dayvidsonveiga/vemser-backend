import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a palavra que deseja traduzir: ");
        String palavra = scanner.nextLine();

        if (palavra.equalsIgnoreCase("Cachorro")) {
            System.out.println("Dog");
        } else if (palavra.equalsIgnoreCase("Tempo")) {
            System.out.println("Time");
        } else if (palavra.equalsIgnoreCase("Amor")) {
            System.out.println("Love");
        } else if (palavra.equalsIgnoreCase("Cidade")) {
            System.out.println("City");
        } else if (palavra.equalsIgnoreCase("Feliz")) {
            System.out.println("Happy");
        } else if (palavra.equalsIgnoreCase("Triste")) {
            System.out.println("Sad");
        } else if (palavra.equalsIgnoreCase("Deveria")) {
            System.out.println("Should");
        } else if (palavra.equalsIgnoreCase("Poderia")) {
            System.out.println("Could");
        } else if (palavra.equalsIgnoreCase("Dog")) {
            System.out.println("Cachorro");
        } else if (palavra.equalsIgnoreCase("Time")) {
            System.out.println("Tempo");
        } else if (palavra.equalsIgnoreCase("Love")) {
            System.out.println("Amor");
        } else if (palavra.equalsIgnoreCase("City")) {
            System.out.println("Cidade");
        } else if (palavra.equalsIgnoreCase("Happy")) {
            System.out.println("Feliz");
        } else if (palavra.equalsIgnoreCase("Sad")) {
            System.out.println("Triste");
        } else if (palavra.equalsIgnoreCase("Should")) {
            System.out.println("Deveria");
        } else if (palavra.equalsIgnoreCase("Could")) {
            System.out.println("Poderia");
        } else {
            System.out.println("Essa palavra não é válida.");
        }
    }
}
