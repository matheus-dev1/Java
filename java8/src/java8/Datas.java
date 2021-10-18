package java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {
	public static void main(String[] args) {
		System.out.println();
		
		System.out.println(LocalDate.now());
		
		LocalDate olimpiadas = LocalDate.of(2028, Month.AUGUST, 3);
		
		Period tempoAteAsOlimpiadasPeriod = Period.between(LocalDate.now(), olimpiadas);
		
		String periodFormatado =  String.format("Dias: %d Meses: %d Anos: %d", 
				tempoAteAsOlimpiadasPeriod.getDays(), 
				tempoAteAsOlimpiadasPeriod.getMonths(), 
				tempoAteAsOlimpiadasPeriod.getYears());
		
		// Minus é subtração de data e Plus e adição de data.
		System.out.println(periodFormatado);
		
		LocalDate proximaOlimpiada = olimpiadas.plusYears(4);
		
		System.out.println(proximaOlimpiada);
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		String valorFormatado = proximaOlimpiada.format(formatador);
		
		System.out.println(valorFormatado);
		
		DateTimeFormatter formatadorHorasMinutos = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora.format(formatadorHorasMinutos));
		
		System.out.println(agora.toLocalDate().format(formatador));
		
		LocalTime horario = LocalTime.of(1, 15);
		System.out.println(horario);
	}
}
