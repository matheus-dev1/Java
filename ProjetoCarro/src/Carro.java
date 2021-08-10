public class Carro{
    private int ano;
    private String modelo;
    private double preco;

    public Carro(int ano, String modelo, double preco){
    	System.out.println("Logica Principal...");
        if (ano >= 1891) {
            this.ano = ano;
        } else {
            System.out.println("O ano informado est� inv�lido. Por isso usaremos 2017!");
            this.ano = 2017;
        }

        if (modelo != null) {
            this.modelo = modelo;
        } else {
            System.out.println("O modelo n�o foi informado. Por isso usaremos Gol!");
            this.modelo = "Gol";
        }

        if (preco > 0) {
            this.preco = preco;
        } else {
            System.out.println("O pre�o n�o � v�lido. Por isso usaremos 40000.0!");
            this.preco = 40000.0;
        }        
    }

    public Carro(String modelo, double preco){
    	// Uma maneira pra voce ver onde esta este this() eh clicando com o CTRL e botao direito.
    	
    	// No Java podemos chamar a implementa��o de um construtor atrav�s de outro usando simplesmente
    	// this( ) com os par�metros exigidos pelo construtor.
    	
    	// No Java � poss�vel fazer a chamada de um construtor dentro de outro e faz-se isso para 
    	// evitar duplica��es de c�digos e regras.
    	
    	// Basicamente eu estou chamando outro construtor dentro destre construtor, e fazendo isso eu estou
    	// reaproveitando a logica e passando os valores referente a esta chamada, entao se eu passar 
    	// dois parametros sera este construtor que sera executado pegando valores diferentes.
    	
        this(2017, modelo, preco);
        // Eu posso usar um codigo que nao sera daquele construtor so depois deste this()
        System.out.println("Reaproveitando logica...");
    }

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}