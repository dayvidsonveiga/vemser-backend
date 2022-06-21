import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome do produto: ");
        String nomeProduto = scanner.nextLine();

        System.out.println("Informe o valor do produto: ");
        double valorProduto = scanner.nextDouble();

        System.out.println("Produto:  " + nomeProduto +
                "\nPreço R$:  " + valorProduto +
                "\nPromoção: " + nomeProduto +
                "\n---------------------------------------------------");

        for (int i = 1; i <= 10; i++) {
            double desconto = valorProduto * (i * 0.05);
            double valorComDesconto = valorProduto - desconto;
            double valorTotalComDesconto = valorComDesconto * i;
            System.out.printf(i + " x R$ %.2f = R$ %.2f \n", valorComDesconto, valorTotalComDesconto);
        }

    }
}
