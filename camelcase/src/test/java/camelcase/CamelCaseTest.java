package camelcase;

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
}
