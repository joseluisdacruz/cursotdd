package gameficacao;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Armazenamento {

	public void limparArquivo() {
		File file = new File("pontuacao.txt");
		file.delete();		
	}

	public void adicionarPontuacao(Pontuacao pontuacao) {
		// TODO Auto-generated method stub
		
	}

	public List<Pontuacao> recuperarPontuacao(String string, TipoPontuacao tipo) {
		// TODO Auto-generated method stub
		return Arrays.asList(new Pontuacao("Zé", TipoPontuacao.MOEDA, 10));
	}

}
