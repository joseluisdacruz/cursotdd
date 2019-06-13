package gameficacao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class ArmazenamentoTest {

	@Test
	public void armazenarPontos() {
		Armazenamento armazenamento = new Armazenamento();
		armazenamento.limparArquivo();
		Pontuacao pontuacao = new Pontuacao("Zé", TipoPontuacao.MOEDA, 10);
		armazenamento.adicionarPontuacao(pontuacao);
		List<Pontuacao> listaPontuacao = armazenamento.recuperarPontuacao("Zé", TipoPontuacao.MOEDA);
		int pontos = listaPontuacao.stream().mapToInt(Pontuacao::getPontos).sum();
		assertEquals(pontos, 10);;		
	}
}
