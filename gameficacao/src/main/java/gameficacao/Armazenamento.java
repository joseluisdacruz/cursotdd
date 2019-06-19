package gameficacao;

import java.util.Set;

public interface Armazenamento {
	public void limparArquivo();
	public void adicionarPontos(PontosUsuario pontos);
	public int recuperarPontos(String usuario, TipoPonto tipo);
	public Set<String> recuperarUsuarios();
	public Set<TipoPonto> recuperarTiposPontos(String usuario);
}
