import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CamelCaseTest {
	
	@Test
	public void testStringSemMaiuscula() {
		List<String> strList = Arrays.asList("fulano");
		assertEquals(strList, CamelCaseSplitter.converterCamelCase("fulano")); 		
	}
	
	@Test
	public void testStringComMaiuscula() {
		List<String> strList = Arrays.asList("nome");
		assertEquals(strList, CamelCaseSplitter.converterCamelCase("Nome"));
	}
	
	@Test
	public void testSepararStringCamelCase() {
		List<String> strList = Arrays.asList("nome", "completo");
		assertEquals(strList, CamelCaseSplitter.converterCamelCase("nomeCompleto"));
	}
 }
