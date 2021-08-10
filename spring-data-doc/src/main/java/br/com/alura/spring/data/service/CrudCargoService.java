package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;

// Os arquivos dentro do pacote package br.com.alura.spring.data.service, serao para classes que farao
// insercao no banco de dados.

// Service, vai receber os valores do frontend ou de onde o usuario inputar dados, 
// e vai fazer as transacoes no banco de dados.
@Service
public class CrudCargoService {
	
	private Boolean system = true;
	
	private final CargoRepository cargoRepository;
	
	public CrudCargoService(CargoRepository cargoRepository) {
		this. cargoRepository = cargoRepository;
	}
	
	public void inicial(Scanner scanner) {
		while(system) {
			System.out.println("Qual acao de cargo voce quer executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar Descricao");
			System.out.println("2 - Atualizar Descricao");
			System.out.println("3 - Visualizar Descricao");
			System.out.println("4 - Deletar Descricao");
			
			Integer acao = scanner.nextInt();
			
			switch (acao) {
			case 1:
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				deletar(scanner);
				break;
			default:
				system = false;
				break;
			}
		}
	}
	
	private void salvar(Scanner scanner) {
		System.out.print("Descricao do Cargo: ");
		String descricao = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setDescricaoCargo(descricao);
		cargoRepository.save(cargo);
		System.out.println("A descricao '" + descricao + "' foi salva com sucesso!");
	}
	
	private void atualizar(Scanner scanner) {
		System.out.print("Id: ");
		Integer id = scanner.nextInt();
		System.out.print("Atualiza descricao do cargo: ");
		String novaDescricao = scanner.next();
		
		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricaoCargo(novaDescricao);
		
		cargoRepository.save(cargo);
		System.out.println("Arquivo atualizado!");
	}
	
	private void visualizar() {
		Iterable<Cargo> cargos = cargoRepository.findAll();
		cargos.forEach(cargo -> System.out.println(cargo));
	}
	
	private void deletar(Scanner scanner) {
		System.out.print("Id: ");
		Integer id = scanner.nextInt();
		
		cargoRepository.deleteById(id);
		System.out.println("Deletado");
	}
}
