package caixaeletronico;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CaixaEletronicoTest {
	
	private CaixaEletronico ce;
	
	private HardwareMock hardwareMock;
	
	private ServicoRemotoMock servicoRemotoMock;
	
	@Before
	public void init() {
		hardwareMock = new HardwareMock();
		servicoRemotoMock = new ServicoRemotoMock();
		this.ce = new CaixaEletronico(hardwareMock, servicoRemotoMock);
	}
	
	
	@Test
	public void loginOk() {
		assertTrue(hardwareMock.chamouPegarNroConta());
		assertEquals("Usu�rio Autenticado", ce.logar());
	}
}
