package anotacoes;

import java.time.LocalDate;
import java.time.Month;

public class Teste {
	public static void main(String[] args) {
		Usuario usuario = new Usuario("Mário", "42198284863", LocalDate.of(1995, Month.MARCH, 14));
		System.out.println(IdadeMinimaImpl.validador(usuario));
	}
	
}
