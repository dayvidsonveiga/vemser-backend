import java.util.Scanner;

public class Exercicio08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int linha = 5;
        int coluna = 4;
        int maiorNota = 0;
        int matricula = 0;
        int soma = 0;
        int[][] alunos = new int[5][4];

        for (int i = 0; i < linha; i++) {
            System.out.printf("Digite as informações do %dº aluno:%n", i + 1);
            for (int j = 0; j < (coluna - 1); j++) {
                alunos[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < linha; i++) {
            alunos[i][3] = (int) (alunos[i][1] * 0.6 + alunos[i][2] * 0.4);
        }

        for (int i = 0; i < linha; i++) {
            if (alunos[i][3] > maiorNota) {
                maiorNota = alunos[i][3];
                matricula = alunos[i][0];
            }
            soma += alunos[i][3];
        }

        System.out.println("Matrícula com a maior nota: " + matricula);
        System.out.printf("Média das notas finais: %.2f", (double) soma / linha);

        scanner.close();
    }
}

