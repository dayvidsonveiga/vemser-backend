import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("################################");

        System.out.println("Escolha o estado: RJ | SP | RS ");
        String estado = scanner.nextLine().toUpperCase();

        switch (estado) {
            case "RJ" -> {
                System.out.println("Escolha a cidade: RIO DE JANEIRO | CAMPOS DOS GOYTACAZES");
                String cidade = scanner.nextLine().toUpperCase();

                if (cidade.equalsIgnoreCase("RIO DE JANEIRO")) {
                    System.out.println("População: 6,748 milhões (2020)");
                    System.out.println("Principal festa: Carnaval ");
                    System.out.println("IDH: 0,799");
                } else if (cidade.equalsIgnoreCase("CAMPOS DOS GOYTACAZES")) {
                    System.out.println("População: 511.168 (2020)");
                    System.out.println("Principal festa: Festa do Santíssimo Salvador ");
                    System.out.println("IDH: 0,716");
                } else {
                    System.out.println("Escolha uma cidade válida.");
                }
            }
            case "SP" -> {
                System.out.println("Escolha a cidade: SÃO PAULO | CAMPINAS");
                String cidade = scanner.nextLine().toUpperCase();

                if (cidade.equalsIgnoreCase("SÃO PAULO")) {
                    System.out.println("População: 12,33 milhões (2020)");
                    System.out.println("Principal festa: Festival Gastronômico Sabor ");
                    System.out.println("IDH: 0,783");
                } else if (cidade.equalsIgnoreCase("CAMPINAS")) {
                    System.out.println("População: 1.213.792 (2020)");
                    System.out.println("Principal festa: BENDITA FEIJUCA ");
                    System.out.println("IDH: 0,816");
                } else {
                    System.out.println("Escolha uma cidade válida.");
                }

            }
            case "RS" -> {
                System.out.println("Escolha a cidade: PORTO ALEGRE | CANOAS");
                String cidade = scanner.nextLine().toUpperCase();

                if (cidade.equalsIgnoreCase("PORTO ALEGRE")) {
                    System.out.println("População: 1.483.771 (2020)");
                    System.out.println("Principal festa: Pagode do Pirika ");
                    System.out.println("IDH: 0,805");
                } else if (cidade.equalsIgnoreCase("CANOAS")) {
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
