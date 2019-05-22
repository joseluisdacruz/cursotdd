package caixaeletronico;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
		servicoRemotoMock.setContaCorrente(new ContaCorrente(20.00));
		ce.logar();
		assertEquals("Retire seu dinheiro", ce.sacar(10.00));
		assertTrue(servicoRemotoMock.chamouRecuperarConta());
		assertTrue(hardwareMock.chamouEntregarDinheiro());
		assertTrue(servicoRemotoMock.chamouPersistirConta());
	}
	
	@Test
	public void sacarSemSaldo() {
		servicoRemotoMock.setContaCorrente(new ContaCorrente(0.00));
		ce.logar();
		assertEquals("Saldo insuficiente", ce.sacar(10.00));
		assertTrue(servicoRemotoMock.chamouRecuperarConta());
		assertFalse(hardwareMock.chamouEntregarDinheiro());
		assertFalse(servicoRemotoMock.chamouPersistirConta());
	}
	
	@Test
	public void verificarSaldo() {
		servicoRemotoMock.setContaCorrente(new ContaCorrente(10.00));
		ce.logar();
		assertEquals("O saldo é R$10,00", ce.saldo());
		assertTrue(servicoRemotoMock.chamouRecuperarConta());
	}
}
