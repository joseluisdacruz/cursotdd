import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CamelCaseSplitter {

	public static List<String> converterCamelCase(String string) {
		List<String> retorno = Arrays.asList(string.split("(?=[A-Z])"));
		return retorno.stream()
				.map(str -> str.toLowerCase()).collect(Collectors.toList());
	}

}
