import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[3];
        int posMenor = 0, con = 999999999;

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Informe o " + (i + 1) + "° numero: ");
            numeros[i] = scanner.nextInt();
            scanner.nextLine();
            if (numeros[i] < con) {
                posMenor = i;
                con = numeros[i];
            }
        }
        scanner.close();
        System.out.println("A posição do menor número é: " + posMenor + "\n referente ao número: " + numeros[posMenor]);
    }
}
