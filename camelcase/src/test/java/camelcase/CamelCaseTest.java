package camelcase;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CamelCaseTest {

	private CamelCaseSplitter ccs;
	
	@Before
	public void init() {
		ccs = new CamelCaseSplitter();
	}
	
	@Test
	public void testStringSemMaiuscula() {
		List<String> strList = Arrays.asList("fulano");
		assertEquals(strList, ccs.converterCamelCase("fulano")); 		
	}
}
