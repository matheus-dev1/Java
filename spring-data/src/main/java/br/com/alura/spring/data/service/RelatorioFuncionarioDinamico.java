package br.com.alura.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.specification.SpecificationFuncionario;

@Service
public class RelatorioFuncionarioDinamico {
	
	private final FuncionarioRepository funcionarioRepository;
	
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public RelatorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void inicial(Scanner scanner) {
		System.out.println("Digite um nome: ");
		String nome = scanner.next();
		if(nome.equalsIgnoreCase("NULL")) {
			nome = null;
		}
		
		System.out.println("Digite um cpf: ");
		String cpf = scanner.next();
		if(cpf.equalsIgnoreCase("NULL")) {
			cpf = null;
		}
		
		System.out.println("Digite um salario: ");
		Double salario = scanner.nextDouble();
		if(salario == 0) {
			salario = null;
		}
		
		System.out.println("Qual Data deseja pesquisar?");
		String data = scanner.next();
		LocalDate localDate;
		if(data.equalsIgnoreCase("NULL")) {
			localDate = null;
		} else {
			localDate = LocalDate.parse(data, formatter);
		}
		
		List<Funcionario> listaDeFuncionarios = funcionarioRepository.findAll(Specification.where(
				SpecificationFuncionario.nome(nome)
				.or(SpecificationFuncionario.cpf(cpf)
				.or(SpecificationFuncionario.salario(salario)
				.or(SpecificationFuncionario.dataContratacao(localDate)
			)))));
		
		listaDeFuncionarios.forEach(System.out::println);
	}
}
