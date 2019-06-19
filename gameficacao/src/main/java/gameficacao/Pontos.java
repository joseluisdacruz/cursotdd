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
}
