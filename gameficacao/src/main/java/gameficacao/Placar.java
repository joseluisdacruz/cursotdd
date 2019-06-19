package gameficacao;

import java.util.Set;
import java.util.stream.Collectors;

public class Placar {

	Armazenamento armazenamento;
	
	public Placar(Armazenamento armazenamento) {
		this.armazenamento = armazenamento;
	}

	public void registrar(PontosUsuario pontos) {
		armazenamento.adicionarPontos(pontos);
	}

	public Set<Pontos> retornarPontosUsuario(String usuario) {
		return armazenamento.recuperarTiposPontos(usuario)
				.stream()
				.map(tp -> new Pontos(tp, armazenamento.recuperarPontos(usuario, tp)))
				.collect(Collectors.toSet());
	}

}
