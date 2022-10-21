package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class OrdenaHelper {

	public OrdenaHelper() {}
	
	public static List<String> ordenar(Map<Integer, String> map, MapModel mapModel){
		List<String> nomes = new ArrayList<String>();
		// Precisamos para para o TreeMap, uma classe que implamenta comparator
		Map<Integer, String> mapOrdenado = new TreeMap(mapModel);
		mapOrdenado.putAll(map);
		for (Integer numeros : mapOrdenado.keySet()) {
			nomes.add(map.get(numeros));
		}
		return nomes;
	}

}
