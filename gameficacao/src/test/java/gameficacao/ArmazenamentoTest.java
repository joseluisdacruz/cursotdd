package gameficacao;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class ArmazenamentoTest {

	private Armazenamento armazenamento;
	
	@Before
	public void init() {
		armazenamento = new Armazenamento();
		armazenamento.limparArquivo();
	}
	
	@Test
	public void armazenarPontos() {
		Pontuacao pontuacao = new Pontuacao("Zé", TipoPontuacao.MOEDA, 10);
		armazenamento.adicionarPontuacao(pontuacao);
		int pontos = armazenamento.recuperarPontuacao("Zé", TipoPontuacao.MOEDA);
		assertEquals(pontos, 10);;		
	}
	
	@Test
	public void recuperarPontuacao() {
		Pontuacao pontuacao1 = new Pontuacao("Zé", TipoPontuacao.MOEDA, 10);
		armazenamento.adicionarPontuacao(pontuacao1);
		Pontuacao pontuacao2 = new Pontuacao("Zé", TipoPontuacao.ESTRELA, 20);
		armazenamento.adicionarPontuacao(pontuacao2);
		int pontuacao = armazenamento.recuperarPontuacao("Zé", TipoPontuacao.ESTRELA);
		assertEquals(pontuacao, 20);
	}
	
	@Test
	public void recuperarUsuarios() {
		Pontuacao pontuacao1 = new Pontuacao("Zé", TipoPontuacao.MOEDA, 10);
		Pontuacao pontuacao2 = new Pontuacao("Zé", TipoPontuacao.ESTRELA, 20);
		Pontuacao pontuacao3 = new Pontuacao("João", TipoPontuacao.TOPICO, 30);
		Pontuacao pontuacao4 = new Pontuacao("Pedro", TipoPontuacao.CURTIDA, 40);
		armazenamento.adicionarPontuacao(pontuacao1);
		armazenamento.adicionarPontuacao(pontuacao2);
		armazenamento.adicionarPontuacao(pontuacao3);
		armazenamento.adicionarPontuacao(pontuacao4);
		assertEquals(armazenamento.recuperarUsuarios(), Arrays.asList("Zé", "João", "Pedro"));
	}
}
