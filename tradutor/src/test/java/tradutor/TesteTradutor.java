package tradutor;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TesteTradutor {
	
	@Test
	public void tradutorSemPalavras() {
		Tradutor tradutor = new Tradutor();
		assertTrue(tradutor.estaVazio());
	}
}
