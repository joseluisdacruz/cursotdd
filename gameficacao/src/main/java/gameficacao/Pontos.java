package gameficacao;

public class Pontos {

	private String usuario;
	private TipoPonto tipoPontuacao;
	private int pontos;
	
	public Pontos(String usuario, TipoPonto tipoPontuacao, int pontos) {
		super();
		this.usuario = usuario;
		this.tipoPontuacao = tipoPontuacao;
		this.pontos = pontos;
	}

	public String getUsuario() {
		return usuario;
	}

	public TipoPonto getTipoPontuacao() {
		return tipoPontuacao;
	}

	public int getPontos() {
		return pontos;
	}
	
	public static Pontos parse(String pontuacao) {
		String[] dados =  pontuacao.split("\\|");
		return new Pontos(dados[0], TipoPonto.valueOf(dados[1]), Integer.parseInt(dados[2]));
	}

	@Override
	public String toString() {
		return usuario + "|" + tipoPontuacao + "|" + pontos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pontos;
		result = prime * result + ((tipoPontuacao == null) ? 0 : tipoPontuacao.hashCode());
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
		Pontos other = (Pontos) obj;
		if (pontos != other.pontos)
			return false;
		if (tipoPontuacao != other.tipoPontuacao)
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
}
