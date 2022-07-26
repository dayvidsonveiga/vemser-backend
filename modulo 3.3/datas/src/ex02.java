import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ex02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe a 1° data: ");
        LocalDate data1 = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Informe a 2° data: ");
        LocalDate data2 = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Period period = Period.between(data1, data2);

        System.out.println("A diferença entre é " + period.getDays() + " dias, " + period.getMonths() + " meses e "  + period.getYears() + " anos.");
    }
}
