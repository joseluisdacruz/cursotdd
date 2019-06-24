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

	public RankItem[] rank(TipoPonto tipoPonto) {
		return armazenamento.recuperarUsuarios()
				.stream()
				.map(usuario -> new RankItem(usuario, armazenamento.recuperarPontos(usuario, tipoPonto)))
				.filter(ri -> ri.getPontos() > 0)
				.sorted((u1, u2) -> u2.getPontos().compareTo(u1.getPontos()))
				.collect(Collectors.toList()).toArray(new RankItem[0]);
	}

}
