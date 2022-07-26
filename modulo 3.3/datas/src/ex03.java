import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ex03 {
    public static void main(String[] args) {

        LocalDateTime dataAtual = LocalDateTime.now();
        LocalDateTime dataProxima = dataAtual.plusDays(15).plusHours(10);

        System.out.println("Dia da semana daqui 15 dias: " + dataProxima.getDayOfWeek());
        System.out.println("Dia do ano: " + dataProxima.getDayOfYear());

    }
}
