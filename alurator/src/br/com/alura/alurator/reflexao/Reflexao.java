package br.com.alura.alurator.reflexao;

public class Reflexao {

	public ManipuladorClasse refleteClasse(String fqn) {
		try {
			Class<?> classFQN = Class.forName(fqn);
			return new ManipuladorClasse(classFQN);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public Class<?> getClasse(String FQN) {
		try {
			Class<?> classFQN = Class.forName(FQN);
			return classFQN;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
