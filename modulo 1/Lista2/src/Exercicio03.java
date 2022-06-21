import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nome = "";
        double altura, peso, alturaMaiorJogador = 0, jogadorMaisPesado = 0, somaAlturaJogadores = 0, mediaAlturaJogadores = 0;
        int idade, qtdeJogadoresCadastrados = 0, jogadorMaisVelho = 0;

        System.out.println("CADASTRO DE JOGADORES DO TIME DE BASQUETE");
        System.out.println("Para finalizar, digite SAIR no nome do jogador.");
        System.out.println("------------------------------------------");

        while (!nome.equalsIgnoreCase("sair")) {
            System.out.println("Informe o nome do jogador: ");
            nome = scanner.nextLine();
            if (nome.equalsIgnoreCase("sair")) {
                break;
            } else {
                qtdeJogadoresCadastrados++;
            }
            System.out.println("Informe a altura do jogador: ");
            altura = scanner.nextDouble();
            System.out.println("Informe a idade do jogador: ");
            idade = scanner.nextInt();
            System.out.println("Informe o peso do jogador: ");
            peso = scanner.nextDouble();
            somaAlturaJogadores += altura;
            mediaAlturaJogadores = somaAlturaJogadores / qtdeJogadoresCadastrados;

            if (altura > alturaMaiorJogador) {
                alturaMaiorJogador = altura;
            }

            if (idade > jogadorMaisVelho) {
                jogadorMaisVelho = idade;
            }

            if (peso > jogadorMaisPesado) {
                jogadorMaisPesado = peso;
            }

            scanner.nextLine();

        }

        System.out.printf("Quantidade de jogadores cadastrados: " + qtdeJogadoresCadastrados +
                "\nAltura do maior Jogador: " + alturaMaiorJogador +
                "\nJogador mais velho: " + jogadorMaisVelho +
                "\nJogador mais pesado: " + jogadorMaisPesado +
                "\nMédia das alturas dos jogadores: %.2f", mediaAlturaJogadores);
    }
}
