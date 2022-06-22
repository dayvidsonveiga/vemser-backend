import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("################################");

        System.out.println("Escolha o estado: \n1 para RJ \n2 para SP \n3 para RS ");
        int estado = scanner.nextInt();
        scanner.nextLine();

        switch (estado) {
            case 1 -> {
                System.out.println("Escolha a cidade: \n1 para RIO DE JANEIRO \n2 para CAMPOS DOS GOYTACAZES");
                int cidade = scanner.nextInt();

                if (cidade == 1) {
                    System.out.println("População: 6,748 milhões (2020)");
                    System.out.println("Principal festa: Carnaval ");
                    System.out.println("IDH: 0,799");
                } else if (cidade == 2) {
                    System.out.println("População: 511.168 (2020)");
                    System.out.println("Principal festa: Festa do Santíssimo Salvador ");
                    System.out.println("IDH: 0,716");
                } else {
                    System.out.println("Escolha uma cidade válida.");
                }
            }
            case 2 -> {
                System.out.println("Escolha a cidade: \n1 para SÃO PAULO \n2 para CAMPINAS");
                int cidade = scanner.nextInt();

                if (cidade == 1) {
                    System.out.println("População: 12,33 milhões (2020)");
                    System.out.println("Principal festa: Festival Gastronômico Sabor ");
                    System.out.println("IDH: 0,783");
                } else if (cidade == 2) {
                    System.out.println("População: 1.213.792 (2020)");
                    System.out.println("Principal festa: BENDITA FEIJUCA ");
                    System.out.println("IDH: 0,816");
                } else {
                    System.out.println("Escolha uma cidade válida.");
                }

            }
            case 3 -> {
                System.out.println("Escolha a cidade: \n1 para PORTO ALEGRE \n2 para CANOAS");
                int cidade = scanner.nextInt();

                if (cidade == 1) {
                    System.out.println("População: 1.483.771 (2020)");
                    System.out.println("Principal festa: Pagode do Pirika ");
                    System.out.println("IDH: 0,805");
                } else if (cidade == 2) {
                    System.out.println("População: 348.208 (2020)");
                    System.out.println("Principal festa: Nossa Senhora dos Navegantes ");
                    System.out.println("IDH: 0,815");
                } else {
                    System.out.println("Escolha uma cidade válida.");
                }

            }default -> {
                System.out.println("Escolha um estado válido.");
            }
        }
    }
}
