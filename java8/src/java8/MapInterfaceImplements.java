package java8;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapInterfaceImplements {

	public MapInterfaceImplements() { }

	public static void main(String[] args) {
		// Interface Map<K,V>
		// Só consegue instanciar a classe que implementa a interface.
		Map<Integer, String> map1 = new HashMap<Integer, String>();
		
		for (Integer i = 1; i <= 7; i++) {
			map1.put(i, "Number: " + i.toString());
			// Pega o valor a partir do indice.
			System.out.println(map1.get(i));
		}
		System.out.println("--------------------------------------------------");
		// Retorna um conjunto de Maps contido no mapa configurado, podendo ser possível acessar suas chaves e valores.
		Set<Entry<Integer, String>> setEntryMap1 = map1.entrySet();
		setEntryMap1.forEach((number) -> {
			System.out.println("Chave: " + number.getKey() + " | " + "Valor: '" + number.getValue() + "'");
		});
		
		// Retorna um Set com as chaves do mapa especificado. Um objeto do tipo Set, tipo uma lista.
		Set<Integer> setMap1 = map1.keySet();
		System.out.println(setMap1);
		
		Map<Integer, String> mapaNomes = new HashMap<Integer, String>();
	    mapaNomes.put(1, "João Delfino");
	    mapaNomes.put(2, "Maria do Carmo");
	    mapaNomes.put(3, "Claudinei Silva");
	    mapaNomes.put(4, "Amélia Mourão");
	    
	    // Ordenação de String(nomes)
	    System.out.println(OrdenaHelper.ordenar(mapaNomes, new MapModel(mapaNomes)));
	    
	    Cliente c1 = new Cliente("754.856.869-88", "Valdinei Santos");
	    Cliente c2 = new Cliente("828.929.222.12", "Claire Moura");
	    Cliente c3 = new Cliente("156.565.556-88", "José Seller");
	    
	    // Um Mapa de Objetos
	    Hashtable<Integer, Cliente> MapComObjetos = new Hashtable<Integer, Cliente>();
	    MapComObjetos.put(1, c1);
	    MapComObjetos.put(2, c2);
	    MapComObjetos.put(3, c3);
	    
	    for(Integer index: MapComObjetos.keySet()) {
	    	System.out.println(MapComObjetos.get(index));
	    }
	    
	    // Declaração de arrays no Java
	    String[] Pontos = {
	    		"Localizacao",
	    		"Setores",
	    		"Funcionarios",
	    		"Projetos",
	    		"Segmentos"
	    	};
	    
	    String[] Localizacao = {
	    		"Endereço",
	    		"CNPJ",
	    		"Cidade",
	    		"Estado"
	    	};
	    String[] Setores = {
	    		"Vendas",
	    		"Comercial",
	    		"Suporte"
	    	};
	    String[] Funcionarios = {
	    		"Alberto",
	    		"Henrique",
	    		"Ana"
	    	};
	    String[] Projetos = {
	    		"Projeto Abn1",
	    		"Projeto Xny99",
	    		"Projeto Xanax"
	    	};
	    String[] Segmentos = {
	    		"Varejo",
	    		"Atacado",
	    };
	    
	    // Aqui eu crio um array de objeto e cada index vai me retornar todos os valores de cada array.
	    // Exemplo, se eu colcoar Informacoes[0], vou retoranr todos os dados do objeto Localizacao por exemplo.
	    // System.out.println(Informacoes[0]);
	    Object[] Informacoes = {Localizacao, Setores, Funcionarios, Projetos, Segmentos};
	    
	    // Crio um outro array dentro desse arary.
	    //Map<Integer, Object[]> map2;
	    
	    for(Integer index = 0; index < Pontos.length; index++) {
	    	System.out.println(Pontos[index] + ": ");
	    	// Casting
	    	for(String nome: (String[]) Informacoes[index]) {
	    		System.out.println(nome);
	    	}
	    	System.out.println();
	    }
	}

}
