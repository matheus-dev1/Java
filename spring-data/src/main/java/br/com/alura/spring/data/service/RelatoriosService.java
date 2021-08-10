package br.com.alura.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.FuncionarioProjecao;
import br.com.alura.spring.data.repository.FuncionarioRepository;

@Service
public class RelatoriosService {
	
	private Boolean system = true;
	
	// Um formatador/conversor de data e como a data de ver criada.
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private final FuncionarioRepository funcionarioRepository;
	
	public RelatoriosService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void inicial(Scanner scanner) {
		
		while(system) {
			System.out.println("Qual acao de cargo deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Buscar Funcionario pelo Nome");
			System.out.println("2 - Buscar Funcionario pelo Nome, maior Salario e Data de Contracao");
			System.out.println("3 - Buscar Funcionario pela Data de Contracao");
			System.out.println("4 - Buscar Funcionario com campos id, nome e salario");
			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				buscaFuncionarioPeloNome(scanner);
				break;
			case 2:
				findNomeSalarioMaiorQueDataContratacao(scanner);
				break;
			case 3:
				findDataContratacaoMaior(scanner);
				break;
			case 4:
				findFuncionarioSalario();
				break;
			default:
				system = false;
				break;
			}
		}
	}
	
	private void buscaFuncionarioPeloNome(Scanner scanner) {
		System.out.println("Qual nome deseja pesquisar?");
		String nome = scanner.next();
		List<Funcionario> list = funcionarioRepository.findByNome(nome);
		list.forEach(System.out::println);
	}
	
	private void findNomeSalarioMaiorQueDataContratacao(Scanner scanner) {
		System.out.println("Qual Nome deseja pesquisar?");
		String nome = scanner.next();
		
		System.out.println("Qual Salario deseja pesquisar?");
		Double salario = scanner.nextDouble();
		
		
		System.out.println("Qual Data deseja pesquisar?");
		String data = scanner.next();
		// O valor da data e o objeto formatador para verificar se o que foi digitado esta de acordo.
		LocalDate localDate = LocalDate.parse(data, formatter);
		
		List<Funcionario> listaDeFuncionarios = funcionarioRepository.findNomeSalarioMaiorQueDataContratacao(nome, salario, localDate);
	
		listaDeFuncionarios.forEach(System.out::println);
	}
	
	private void findDataContratacaoMaior(Scanner scanner) {
		System.out.println("Qual Data deseja pesquisar?");
		String data = scanner.next();
		LocalDate localDate = LocalDate.parse(data, formatter);
		
		List<Funcionario> listaDeFuncionarios = funcionarioRepository.findDataContratacaoMaior(localDate);
		
		listaDeFuncionarios.forEach(System.out::println);
	}
	
	private void findFuncionarioSalario() {
		List<FuncionarioProjecao> listaDaProjecaoDeFuncionarios = funcionarioRepository.findFuncionarioSalario();
		
		listaDaProjecaoDeFuncionarios.forEach(funcionario -> {
			System.out.println("Nome: " + funcionario.getNome()
			+ " | ID: " + funcionario.getId()
			+ " | Salario: " + funcionario.getSalario());
		});
	}
}
