public class Conta {
	/* A principal ideia de colocar um throws dentro de um metodo � que voc� nunca o deixa ele sem tratamento
	sempre tem que fazer alguma coisa referente a essa exce��o deste metodo. */
	public void dep() throws MinhaExcecaoApenasException {
		System.out.println("Conta.dep() exception lan�ada!");
	}
}
