import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o número total de eleitores: ");
        double totalEleitores = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Informe o número de votos em branco: ");
        double totalVotosEmBranco = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Informe o número de votos nulos: ");
        double totalVotosNulos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Informe o número de votos válidos: ");
        double totalVotosValidos = scanner.nextInt();
        scanner.nextLine();

        double percentualVotosBranco = (totalVotosEmBranco / totalEleitores) * 100;
        double percentualVotosNulos = (totalVotosNulos / totalEleitores) * 100;
        double percentualVotosValidos = (totalVotosValidos / totalEleitores) * 100;

        System.out.println("O percentual de votos em branco foi " + percentualVotosBranco + " %");
        System.out.println("O percentual de votos nulos foi " + percentualVotosNulos + " %");
        System.out.println("O percentual de votos válidos foi " + percentualVotosValidos + " %");
    }
}
