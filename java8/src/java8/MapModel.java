package java8;

import java.util.Comparator;
import java.util.Map;

public class MapModel implements Comparator<Integer> {

	private Map<Integer, String> map;
	
	public MapModel(Map<Integer, String> map) {
		this.map = map;
	}

	// Compara se um objeto é igual ao outro objeto.
	@Override
	public int compare(Integer number1, Integer number2) {
		return this.map.get(number1).compareTo(this.map.get(number2));
	}

}
