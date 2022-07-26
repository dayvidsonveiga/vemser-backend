import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Ex04 {
    public static void main(String[] args) {

        LocalDateTime show = LocalDateTime.of(2024, 9, 14, 18, 30);
        ZoneId londres = ZoneId.of("Europe/London");
        ZonedDateTime zoned = ZonedDateTime.of(show, londres);

        LocalDateTime date = LocalDateTime.now();

        long anos = date.until(zoned, ChronoUnit.YEARS);
        date = date.plusYears(anos);

        long meses = date.until(zoned, ChronoUnit.MONTHS);
        date = date.plusMonths(meses);

        long dias = date.until(zoned, ChronoUnit.DAYS);
        date = date.plusDays(dias);

        long horas = date.until(zoned, ChronoUnit.HOURS);
        date = date.plusHours(horas);

        long minutos = date.until(zoned, ChronoUnit.MINUTES);
        date = date.plusMinutes(minutos);

        long segundos = date.until(zoned, ChronoUnit.SECONDS);

        System.out.println("Faltam " + anos + " anos, " + meses + " meses, " + dias + " dias, " + horas + " horas, "
                + minutos + " minutos e "
                + segundos + " segundos para o show do wesley safadãooooo");
        
    }
}

