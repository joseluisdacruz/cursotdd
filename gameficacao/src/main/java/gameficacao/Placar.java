package gameficacao;

public class Placar {

	Armazenamento armazenamento;
	
	public Placar(Armazenamento armazenamento) {
		this.armazenamento = armazenamento;
	}

	public void registrar(Pontos pontos) {
		armazenamento.adicionarPontos(pontos);
	}

}
