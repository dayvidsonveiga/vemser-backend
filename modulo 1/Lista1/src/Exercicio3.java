import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("##########################");

        System.out.println("Digite o valor total consumido: ");
        double totalConsumido = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Digite o valor pago pelo cliente: ");
        double valorPagoCliente = scanner.nextDouble();
        scanner.nextLine();

        if (valorPagoCliente < totalConsumido) {
            System.out.println("O valor pago deve ser maior ou igual ao valor consumido");
        } else {
            double troco = valorPagoCliente - totalConsumido;
            System.out.println("O troco é de: R$ " + troco);
        }
    }
}
