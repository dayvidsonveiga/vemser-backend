import java.time.LocalDateTime;

public class Ex03 {
    public static void main(String[] args) {

        LocalDateTime dataAtual = LocalDateTime.now();
        LocalDateTime dataProxima = dataAtual.plusDays(15).plusHours(10);

        System.out.println("Dia da semana daqui 15 dias: " + dataProxima.getDayOfWeek());
        System.out.println("Dia do ano: " + dataProxima.getDayOfYear());

    }
}
