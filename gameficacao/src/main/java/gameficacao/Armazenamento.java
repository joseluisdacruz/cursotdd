package gameficacao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class Armazenamento {

	private static final String NOME_ARQUIVO = "./pontuacao.txt";

	public void limparArquivo() {
		File file = new File(NOME_ARQUIVO);
		file.delete();
	}

	public void adicionarPontuacao(Pontuacao pontuacao) {
		byte[] dados = pontuacao.toString().getBytes();
		Path path = Paths.get(NOME_ARQUIVO);
		try {
			if (Files.isWritable(path)) {
				Files.write(path, System.getProperty("line.separator").getBytes(), StandardOpenOption.APPEND);
				Files.write(path, dados, StandardOpenOption.APPEND);
			} else {
				Files.write(path, dados, StandardOpenOption.CREATE);
			}
		} catch (IOException e) {
			System.err.println("Erro ao escrever no arquivo");
		}
	}

	public int recuperarPontuacao(String usuario, TipoPontuacao tipo) {
		try (Stream<String> stream = Files.lines(Paths.get(NOME_ARQUIVO))) {
			return stream.map(Pontuacao::parse)
					.filter(p -> p.getTipoPontuacao().equals(tipo) && p.getUsuario().equals(usuario))
					.mapToInt(Pontuacao::getPontos).sum();
		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo");
		}
		return 0;
	}

}