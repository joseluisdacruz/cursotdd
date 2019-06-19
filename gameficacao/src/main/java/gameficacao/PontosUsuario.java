package gameficacao;

public class PontosUsuario {

	private String usuario;
	private Pontos pontos;
	
	public PontosUsuario(String usuario, TipoPonto tipoPontuacao, int pontos) {
		super();
		this.usuario = usuario;
		this.pontos = new Pontos(tipoPontuacao, pontos);
	}

	public String getUsuario() {
		return usuario;
	}

	public TipoPonto getTipoPontuacao() {
		return this.pontos.getTipo();
	}

	public int getPontos() {
		return this.pontos.getQuantidade();
	}
	
	public static PontosUsuario parse(String pontuacao) {
		String[] dados =  pontuacao.split("\\|");
		return new PontosUsuario(dados[0], TipoPonto.valueOf(dados[1]), Integer.parseInt(dados[2]));
	}

	@Override
	public String toString() {
		return getUsuario() + "|" + getTipoPontuacao() + "|" + getPontos();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pontos == null) ? 0 : pontos.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PontosUsuario other = (PontosUsuario) obj;
		if (pontos == null) {
			if (other.pontos != null)
				return false;
		} else if (!pontos.equals(other.pontos))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
}
