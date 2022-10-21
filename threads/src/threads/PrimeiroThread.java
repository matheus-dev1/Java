package threads;

public class PrimeiroThread {

	public PrimeiroThread() {}
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Thread main!!!");
		// Parei a execução da thread e ficou parada por 50 segundos, no estado TIMED_WAITING
	    Thread.sleep(60000);
	}
}
