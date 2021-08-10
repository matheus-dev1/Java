package br.com.bytebank.banco.teste;

public class TesteArrayString {

	// O argumento String[] sao os parametro que o meu metodo main tem, ou saja, no momento da execucao do 
	// projeto, na linha de comando ou aqui no eclipse atraves do run configuration -> class que vai rodar -> 
	// ir em argumentos -> no primeiro text area colocar os argumentos, sendo que ele se separam por um espaco
	// -> apply -> run , eu consigo passar argumento, e recuperar os valores destes argumentos 
	// atraves da variavel args.
	public static void main(String[] args) {
		for(int index = 0; index < args.length; index++) {
			System.out.println(args[index]);
		}
	}
}
