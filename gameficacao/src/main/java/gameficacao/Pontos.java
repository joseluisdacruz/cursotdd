package gameficacao;

public class Pontos {
	
	private TipoPonto tipo;
	private int quantidade;
	
	public Pontos(TipoPonto tipo, int quantidade) {
		super();
		this.tipo = tipo;
		this.quantidade = quantidade;
	}
	
	public TipoPonto getTipo() {
		return tipo;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	@Override
	public String toString() {
		return tipo + "|" + quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + quantidade;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		if (quantidade != other.quantidade)
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}
}
