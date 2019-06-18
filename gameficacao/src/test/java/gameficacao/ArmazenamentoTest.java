package gameficacao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArmazenamentoTest {

	@Test
	public void armazenarPontos() {
		Armazenamento armazenamento = new Armazenamento();
		armazenamento.limparArquivo();
		Pontuacao pontuacao = new Pontuacao("Zé", TipoPontuacao.MOEDA, 10);
		armazenamento.adicionarPontuacao(pontuacao);
		int pontos = armazenamento.recuperarPontuacao("Zé", TipoPontuacao.MOEDA);
		assertEquals(pontos, 10);;		
	}
	
	@Test
	public void recuperarPontuacao() {
		Armazenamento armazenamento = new Armazenamento();
		armazenamento.limparArquivo();
		Pontuacao pontuacao1 = new Pontuacao("Zé", TipoPontuacao.MOEDA, 10);
		armazenamento.adicionarPontuacao(pontuacao1);
		Pontuacao pontuacao2 = new Pontuacao("Zé", TipoPontuacao.ESTRELA, 20);
		armazenamento.adicionarPontuacao(pontuacao2);
		int pontuacao = armazenamento.recuperarPontuacao("Zé", TipoPontuacao.ESTRELA);
		assertEquals(pontuacao, 20);
	}
}
