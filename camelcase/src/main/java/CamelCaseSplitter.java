import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CamelCaseSplitter {

	public static List<String> converterCamelCase(String string) {
		if (isInicioNumerico(string) || hasCaractereInvalido(string)) {
			throw new InvalidStringException("String inválido.");
		}
		List<String> retorno = fatiar(string);
		retorno = retorno.stream().reduce(
				new ArrayList<String>(),
				CamelCaseSplitter::adicionarString,
				CamelCaseSplitter::listaCombiner);
		return retorno.stream().map(CamelCaseSplitter::toLowerCase).collect(Collectors.toList());
	}

	private static List<String> adicionarString(List<String> lista, String str) {
		if (lista.size() == 0) {
			lista.add(str);
			return lista;
		}
		String ultimo = lista.get(lista.size() - 1);
		if (isSigla(ultimo) && isMaiusculo(str) || 
			isNumero(ultimo) && isDigito(str)) {
			ultimo += str;
			lista.set(lista.size() - 1, ultimo);
		} else {
			lista.add(str);
		}
		return lista;
	}
	
	private static List<String> fatiar(String string) {
		return Arrays.asList(string.split("(?=[A-Z0-9])"));
	}

	private static boolean isDigito(String str) {
		return str.matches("[0-9]");
	}

	private static boolean isNumero(String str) {
		return str.matches("[0-9]+");
	}

	private static boolean isMaiusculo(String str) {
		return str.matches("[A-Z]");
	}

	private static List<String> listaCombiner(List<String> lista1, List<String> lista2) {
		lista1.addAll(lista2);
		return lista1;
	}
	
	private static boolean isInicioNumerico(String str) {
		return str.matches("^[0-9]+.*");
	}
	
	private static boolean hasCaractereInvalido(String str) {
		return !str.matches("[a-zA-Z0-9]+");
	}
	
	private static String toLowerCase(String str) {
		return isSigla(str) ? str : str.toLowerCase();
	}

	private static boolean isSigla(String str) {
		return str.matches("[A-Z]+");
	}
}
