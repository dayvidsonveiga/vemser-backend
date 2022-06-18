import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("informe o valor da hora em R$ ");
        double valorHora = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Informe o numero de hroas normais trabalhadas: ");
        double horasNormaisTrabalhadas = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Informe o numero de horas extras 50%: ");
        double horasExtraCinquenta = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Informe o numero de horas extras 100%");
        double horasExtrasCem = scanner.nextDouble();
        scanner.nextLine();

        double salario = (horasNormaisTrabalhadas * valorHora) + (horasExtraCinquenta * valorHora * 1.5) +
                (horasExtrasCem * valorHora *2);

        System.out.println("O salario bruto foi R$ " + salario);
    }
}
