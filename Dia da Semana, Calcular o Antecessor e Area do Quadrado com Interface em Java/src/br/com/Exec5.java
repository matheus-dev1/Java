package br.com;

public class Exec5 {
	public String dia;

	public String Verificar() {
		String retorno = "";
		switch(dia) {
			case "1": 
				retorno = "Domingo";
				break;
			case "2":
				retorno = "Segunda-Feira";
				break;
			case "3":
				retorno = "Terca-Feira";
			  	break;
			case "4":
				retorno = "Quarta-Feira";
			  	break;
			case "5":
				retorno = "Quinta-Feira";
			  	break;
			case "6":
				retorno = "Sexta-Feira";
			  	break;
			case "7":
				retorno = "Sabado";
			  	break;
		    default:
		    	retorno = "0";
		}		
		return retorno;
	}
}