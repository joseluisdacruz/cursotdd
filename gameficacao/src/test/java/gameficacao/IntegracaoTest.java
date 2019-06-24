package gameficacao;

import static gameficacao.TipoPonto.ESTRELA;
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
}
