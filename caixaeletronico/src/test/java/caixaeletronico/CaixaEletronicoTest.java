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
		assertEquals("Usuário Autenticado", ce.logar());
		assertTrue(hardwareMock.chamouPegarNroConta());
	}
	
	@Test
	public void loginFail() {
		hardwareMock.falharPegarNroConta();
		assertEquals("Não foi possível autenticar o usuário", ce.logar());
		assertTrue(hardwareMock.chamouPegarNroConta());
	}
	
	@Test
	public void sacarComSaldo() {
		ce.logar();
		assertEquals("Retire seu dinheiro", ce.sacar());
		assertTrue(servicoRemotoMock.chamouRecuperarConta());
		assertTrue(hardwareMock.chamouEntregarDinheiro());
		assertTrue(servicoRemotoMock.chamouPersistirConta());
	}
}
