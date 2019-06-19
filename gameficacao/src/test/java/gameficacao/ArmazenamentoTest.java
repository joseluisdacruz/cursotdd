package gameficacao;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

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
		assertEquals(pontos, 10);
		;
	}

	@Test
	public void recuperarPontos() {
		int pontuacao = armazenamento.recuperarPontos("Zé", ESTRELA);
		assertEquals(pontuacao, 20);
	}

	@Test
	public void recuperarUsuarios() {
		assertEquals(armazenamento.recuperarUsuarios(), Arrays.asList("Zé", "João", "Pedro"));
	}

	@Test
	public void recuperarTiposPontos() {
		assertEquals(armazenamento.recuperarTiposPontos("Zé"), Arrays.asList(MOEDA, ESTRELA));
		assertEquals(armazenamento.recuperarTiposPontos("João"), Arrays.asList(TOPICO));
		assertEquals(armazenamento.recuperarTiposPontos("Pedro"), Arrays.asList(CURTIDA, TOPICO));
	}
}
