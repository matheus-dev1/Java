package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Bd {
	
	public static List<Empresa> listaEmpresas = new ArrayList<Empresa>();
	
	// bloco de comandos static, ou seja, quando a Maquina Virtual for carregada, ele executa 
	// este bloco.
	static {
		Empresa empresa = new Empresa();
		empresa.setNome("Google");
		listaEmpresas.add(empresa);
		
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Itau");
		listaEmpresas.add(empresa2);
	}

	public void add(Empresa empresa) {
		Bd.listaEmpresas.add(empresa);
		System.out.println(empresa);
	}
	
	// Aqui ele esta apenas guardando na sessao.
	public List<Empresa> getEmpresas() {
		return Bd.listaEmpresas;
	}
}
