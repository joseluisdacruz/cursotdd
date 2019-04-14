import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CamelCaseSplitter {

	public static List<String> converterCamelCase(String string) {
		List<String> retorno = Arrays.asList(string.split("(?=[A-Z])"));
		retorno = retorno.stream().reduce(
				new ArrayList<String>(),
				CamelCaseSplitter::adicionarString,
				CamelCaseSplitter::listaCombiner);
		return retorno.stream().map(CamelCaseSplitter::toLowerCase).collect(Collectors.toList());
	}
	
	private static String toLowerCase(String str) {
		if (str.matches("[A-Z]+")) {
			return str;
		}
		return str.toLowerCase();
	}

	private static List<String> adicionarString(List<String> lista, String str) {
		if (lista.size() == 0) {
			lista.add(str);
			return lista;
		}
		String ultimo = lista.get(lista.size() - 1);
		if (ultimo.matches("[A-Z]+") && str.matches("[A-Z]")) {
			ultimo += str;
			lista.set(lista.size() - 1, ultimo);
		} else {
			lista.add(str);
		}
		return lista;
	}

	private static List<String> listaCombiner(List<String> lista1, List<String> lista2) {
		lista1.addAll(lista2);
		return lista1;
	}

}
