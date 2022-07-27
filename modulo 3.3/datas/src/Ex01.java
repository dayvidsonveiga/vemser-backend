import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe a data do seu aniversário");
        LocalDate dataAniversario = LocalDate.parse(sc.nextLine());
        LocalDate diaAtual = LocalDate.now();
        Period periodo;
        if (dataAniversario.withYear(diaAtual.getYear()).isBefore(diaAtual)){
            //Adiciona um ano para que não seja negativo o valor do retorno
            periodo = Period.between(diaAtual, dataAniversario.withYear(diaAtual.plusYears(1).getYear()));
        } else {
            periodo = Period.between(diaAtual, dataAniversario.withYear(diaAtual.getYear()));
        }
        System.out.println("Faltam " + periodo.getMonths() + " meses e " + periodo.getDays() + " dias para o seu próximo aniversário!");
        sc.close();
    }
}
