package gameficacao;

import static gameficacao.TipoPonto.CURTIDA;
import static gameficacao.TipoPonto.ESTRELA;
import static gameficacao.TipoPonto.MOEDA;
import static gameficacao.TipoPonto.TOPICO;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class ArmazenamentoTest {

	private Armazenamento armazenamento;

	private static final String NOME_ARQUIVO = "./pontos.txt";

	private void limparArquivo(String nomeArquivo) {
		Path path = Paths.get(nomeArquivo);
		try {
			if (Files.exists(path)) {
				Files.delete(path);
			}
		} catch (IOException e) {
			System.err.println("Não foi possível deletar o arquivo.");
		}
	}

	@Before
	public void init() {
		limparArquivo(NOME_ARQUIVO);
		armazenamento = new ArmazenamentoArquivo(NOME_ARQUIVO);
		armazenamento.adicionarPontos(new PontosUsuario("Zé", MOEDA, 10));
		armazenamento.adicionarPontos(new PontosUsuario("Zé", ESTRELA, 20));
		armazenamento.adicionarPontos(new PontosUsuario("João", TOPICO, 30));
		armazenamento.adicionarPontos(new PontosUsuario("Pedro", CURTIDA, 40));
		armazenamento.adicionarPontos(new PontosUsuario("Pedro", TOPICO, 30));
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
		assertEquals(new HashSet<TipoPonto>(Arrays.asList(TOPICO, CURTIDA)),
				armazenamento.recuperarTiposPontos("Pedro"));
	}
}
