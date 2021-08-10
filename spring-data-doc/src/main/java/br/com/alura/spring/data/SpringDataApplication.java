package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.service.CrudCargoService;

// O SpringBootApplication nós utilizamos para que ao iniciar o Framework do Spring, ele
// percorra todas as anotações Spring que temos dentro da nossa aplicação para executá-las.
@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner{
	
	// Constante
	// private final CargoRepository cargoRepository;
	
	// Classe para inserir valores.
	private final CrudCargoService crudCargoService;
	
	private boolean system = true;
	
	// Ao criar a SpringDataApplication voce crie com uma instancia do CargoRepository.
	// CargoRepository cargoRepository
	
	// Ao cria a SpringDataApplication voce crie com uma instancia do CrudCargoService.
	public SpringDataApplication(CrudCargoService crudCargoService) {
		// "Instnaciando" Interface CargoRepository.
		// this.cargoRepository = cargoRepository;
		this.crudCargoService = crudCargoService;
	}
	
	public static void main(String[] args) {
		// Basicamente é para que possamos iniciar o Framework do Spring
		SpringApplication.run(SpringDataApplication.class, args);
		
	}
	
	// Apos o start da aplicacao dentro do metodo run implementado pela interface CommandLineRunner
	// ele vai executar algo depois do spring(SpringApplication.run(SpringDataApplication.class, args))
	// ter iniciado.
	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		while(system) {
			System.out.println("Qual acao voce quer executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			
			Integer acao = scanner.nextInt();
			
			if(acao == 1) {
				crudCargoService.inicial(scanner);
			} {
				system = false;
			}
		}
		
		/*
		Cargo cargo = new Cargo();
		cargo.setDescricaoCargo("Desenvolvedor Java");
		
		cargoRepository.save(cargo);
		*/
	}

}
