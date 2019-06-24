package gameficacao;

public class RankItem {
	
	private String usuario;
	
	private Integer pontos;
	
	public RankItem(String usuario, int pontos) {
		this.usuario = usuario;
		this.pontos = pontos;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public Integer getPontos() {
		return pontos;
	}

	@Override
	public String toString() {
		return "RankItem [usuario=" + usuario + ", pontos=" + pontos + "]";
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
		RankItem other = (RankItem) obj;
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
