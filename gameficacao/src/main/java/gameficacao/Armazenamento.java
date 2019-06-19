package gameficacao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Armazenamento {

	private static final String NOME_ARQUIVO = "./pontuacao.txt";

	public void limparArquivo() {
		try {
			Files.delete(Paths.get(NOME_ARQUIVO));
		} catch (IOException e) {
			System.err.println("Não foi possível deletar o arquivo.");
		}
	}

	public void adicionarPontos(Pontos pontos) {
		byte[] dados = pontos.toString().getBytes();
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

	public int recuperarPontos(String usuario, TipoPonto tipo) {
		try (Stream<String> stream = Files.lines(Paths.get(NOME_ARQUIVO))) {
			return stream.map(Pontos::parse)
					.filter(p -> p.getTipoPontuacao().equals(tipo) && p.getUsuario().equals(usuario))
					.mapToInt(Pontos::getPontos).sum();
		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo");
		}
		return 0;
	}

	public Set<String> recuperarUsuarios() {
		try (Stream<String> stream = Files.lines(Paths.get(NOME_ARQUIVO))) {
			return stream.map(Pontos::parse)
					.map(Pontos::getUsuario)
					.distinct()
					.collect(Collectors.toSet());
		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo");
		}
		return new HashSet<>();
	}

	public Set<TipoPonto> recuperarTiposPontos(String usuario) {
		try (Stream<String> stream = Files.lines(Paths.get(NOME_ARQUIVO))) {
			return stream.map(Pontos::parse)
					.filter(p -> p.getUsuario().equals(usuario))
					.map(Pontos::getTipoPontuacao)
					.collect(Collectors.toSet());
		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo");
		}
		return new HashSet<>();
	}

}