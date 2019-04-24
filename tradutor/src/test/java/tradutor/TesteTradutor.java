package tradutor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TesteTradutor {
	
	@Test
	public void tradutorSemPalavras() {
		Tradutor tradutor = new Tradutor();
		assertTrue(tradutor.estaVazio());
	}
	
	@Test
	public void contemUmaTraducao() {
		Tradutor tradutor = new Tradutor();
		tradutor.adicionarTraducao("bom", "good");
		assertFalse(tradutor.estaVazio());
		assertEquals("good", tradutor.traduzir("bom"));
	}
	
 }
