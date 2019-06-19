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

public class ArmazenamentoArquivo implements Armazenamento {

	private String nomeArquivo = "./db.txt";
	
	public ArmazenamentoArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public void adicionarPontos(PontosUsuario pontos) {
		byte[] dados = pontos.toString().getBytes();
		Path path = Paths.get(nomeArquivo);
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
		try (Stream<String> stream = Files.lines(Paths.get(nomeArquivo))) {
			return stream.map(PontosUsuario::parse)
					.filter(p -> p.getTipoPontuacao().equals(tipo) && p.getUsuario().equals(usuario))
					.mapToInt(PontosUsuario::getPontos).sum();
		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo");
		}
		return 0;
	}

	public Set<String> recuperarUsuarios() {
		try (Stream<String> stream = Files.lines(Paths.get(nomeArquivo))) {
			return stream.map(PontosUsuario::parse)
					.map(PontosUsuario::getUsuario)
					.distinct()
					.collect(Collectors.toSet());
		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo");
		}
		return new HashSet<>();
	}

	public Set<TipoPonto> recuperarTiposPontos(String usuario) {
		try (Stream<String> stream = Files.lines(Paths.get(nomeArquivo))) {
			return stream.map(PontosUsuario::parse)
					.filter(p -> p.getUsuario().equals(usuario))
					.map(PontosUsuario::getTipoPontuacao)
					.collect(Collectors.toSet());
		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo");
		}
		return new HashSet<>();
	}

}