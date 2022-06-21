import java.util.Scanner;

public class Exercicio06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        boolean teste = false;

        System.out.println("Digite um numero a ser procurado no vetor");
        int numeroInformado = scanner.nextInt();

        for ( int numero : numeros ) {
            if (numero == numeroInformado) {
                teste = true;
            }
        }

        if (teste == true) {
            System.out.println("O valor está contido no array");
        } else {
            System.out.println("O valor não está contido no array");
        }

    }
}
