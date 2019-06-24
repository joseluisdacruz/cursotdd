package gameficacao;

import static gameficacao.TipoPonto.CURTIDA;
import static gameficacao.TipoPonto.ESTRELA;
import static gameficacao.TipoPonto.MOEDA;
import static gameficacao.TipoPonto.TOPICO;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class IntegracaoTest {

	private Armazenamento armazenamento;
	private Placar placar;
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
		this.armazenamento = new ArmazenamentoArquivo(NOME_ARQUIVO);
		this.placar = new Placar(armazenamento);
	}

	@Test
	public void registrarPonto() {
		this.placar.registrar(new PontosUsuario("guerra", ESTRELA, 10));
		assertEquals(new HashSet<Pontos>(Arrays.asList(new Pontos(ESTRELA, 10))),
				this.placar.retornarPontosUsuario("guerra"));
	}
	
	@Test
	public void retornarPontosUsuario() {
		Pontos pontos1 = new Pontos(ESTRELA, 15);
		Pontos pontos2 = new Pontos(CURTIDA, 10);
		Pontos pontos3 = new Pontos(TOPICO, 10);
		this.placar.registrar(new PontosUsuario("jose", ESTRELA, 15));
		this.placar.registrar(new PontosUsuario("jose", CURTIDA, 10));
		this.placar.registrar(new PontosUsuario("jose", TOPICO, 10));
		this.placar.registrar(new PontosUsuario("joao", MOEDA, 10));
		assertEquals(
				new HashSet<Pontos>(Arrays.asList(pontos1, pontos2, pontos3)),
				this.placar.retornarPontosUsuario("jose"));
	}
	
	@Test
	public void recuperarRank() {
		RankItem[] rank = {new RankItem("pedro", 20), new RankItem("joao", 15), new RankItem("jose", 10)};
		this.placar.registrar(new PontosUsuario("joao", MOEDA, 15));
		this.placar.registrar(new PontosUsuario("jose", MOEDA, 10));
		this.placar.registrar(new PontosUsuario("pedro", MOEDA, 20));
		this.placar.registrar(new PontosUsuario("fulano", CURTIDA,5));
		this.placar.registrar(new PontosUsuario("maria", ESTRELA, 30));
		assertArrayEquals(rank, this.placar.rank(MOEDA));
	}
}
