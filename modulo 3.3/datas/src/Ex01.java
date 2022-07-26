import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDate dataAtual = LocalDate.now();

        System.out.println("Informe a sua data de aniversário, conforme modelo (DD/MM/YYYY)");
        String dataAniversario = scanner.nextLine();
        LocalDate dataFormatada = LocalDate.parse(dataAniversario, DateTimeFormatter.ofPattern("dd/MM/yyyy")).withYear(LocalDate.now().getYear());

        Period period = Period.between(dataAtual, dataFormatada.plusYears(1));

        System.out.println("Restam " + period.getMonths() + " meses e " + period.getDays() + " dias para seu aniversário");

    }
}
