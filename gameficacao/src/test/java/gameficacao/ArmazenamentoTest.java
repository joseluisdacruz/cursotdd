package gameficacao;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import static gameficacao.TipoPonto.*;

public class ArmazenamentoTest {

	private Armazenamento armazenamento;

	@Before
	public void init() {
		armazenamento = new Armazenamento();
		armazenamento.limparArquivo();
		armazenamento.adicionarPontos(new Pontos("Zé", MOEDA, 10));
		armazenamento.adicionarPontos(new Pontos("Zé", ESTRELA, 20));
		armazenamento.adicionarPontos(new Pontos("João", TOPICO, 30));
		armazenamento.adicionarPontos(new Pontos("Pedro", CURTIDA, 40));
		armazenamento.adicionarPontos(new Pontos("Pedro", TOPICO, 30));
	}

	@Test
	public void armazenarPontos() {
		int pontos = armazenamento.recuperarPontos("Zé", MOEDA);
		assertEquals(10, pontos);
		;
	}

	@Test
	public void recuperarPontos() {
		int pontuacao = armazenamento.recuperarPontos("Zé", ESTRELA);
		assertEquals(20, pontuacao);
	}

	@Test
	public void recuperarUsuarios() {
		assertEquals(new HashSet<String>(Arrays.asList("Zé", "João", "Pedro")), armazenamento.recuperarUsuarios());
	}

	@Test
	public void recuperarTiposPontos() {
		assertEquals(new HashSet<TipoPonto>(Arrays.asList(MOEDA, ESTRELA)), armazenamento.recuperarTiposPontos("Zé"));
		assertEquals(new HashSet<TipoPonto>(Arrays.asList(TOPICO)), armazenamento.recuperarTiposPontos("João"));
		assertEquals(new HashSet<TipoPonto>(Arrays.asList(TOPICO, CURTIDA)), armazenamento.recuperarTiposPontos("Pedro"));
	}
}
