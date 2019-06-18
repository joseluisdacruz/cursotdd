package gameficacao;

public class Pontuacao {

	private String usuario;
	private TipoPontuacao tipoPontuacao;
	private int pontos;
	
	public Pontuacao(String usuario, TipoPontuacao tipoPontuacao, int pontos) {
		super();
		this.usuario = usuario;
		this.tipoPontuacao = tipoPontuacao;
		this.pontos = pontos;
	}

	public String getUsuario() {
		return usuario;
	}

	public TipoPontuacao getTipoPontuacao() {
		return tipoPontuacao;
	}

	public int getPontos() {
		return pontos;
	}
}
