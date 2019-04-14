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
	
	@Test
	public void testSepararStringCamelCaseSigla() {
		List<String> strList = Arrays.asList("nome", "completo", "ABC");
		assertEquals(strList, CamelCaseSplitter.converterCamelCase("nomeCompletoABC"));
		List<String> strList2 = Arrays.asList("teste", "ABC", "teste");
		assertEquals(strList2, CamelCaseSplitter.converterCamelCase("testeABCTeste"));
	}
	
	@Test
	public void testSepararStringCamelCaseSiglaNumero() {
		List<String> strList = Arrays.asList("nome", "completo", "123");
		assertEquals(strList, CamelCaseSplitter.converterCamelCase("nomeCompleto123"));
		List<String> strList2 = Arrays.asList("teste", "123", "teste");
		assertEquals(strList2, CamelCaseSplitter.converterCamelCase("teste123Teste"));
		List<String> strList3 = Arrays.asList("nome", "completo", "ABC", "123");
		assertEquals(strList3, CamelCaseSplitter.converterCamelCase("nomeCompletoABC123"));
		List<String> strList4 = Arrays.asList("teste", "ABC", "123", "teste");
		assertEquals(strList4, CamelCaseSplitter.converterCamelCase("testeABC123Teste"));
	}
	
	@Test(expected = InvalidStringException.class)
	public void  testStringComNumeroNoComeco() {
		CamelCaseSplitter.converterCamelCase("10Primeiros");
	}
 }
