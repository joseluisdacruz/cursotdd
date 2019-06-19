package gameficacao;

import static gameficacao.TipoPonto.ESTRELA;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class PlacarTest {
	
	private Placar placar;
	
	private ArmazenamentoMock armazenamentoMock;
	
	private class ArmazenamentoMock implements Armazenamento {

		private boolean chamouAdicionarPontos = false;

		@Override
		public void limparArquivo() {
		}

		@Override
		public void adicionarPontos(Pontos pontos) {
			this.chamouAdicionarPontos = true;
			
		}

		@Override
		public int recuperarPontos(String usuario, TipoPonto tipo) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Set<String> recuperarUsuarios() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Set<TipoPonto> recuperarTiposPontos(String usuario) {
			// TODO Auto-generated method stub
			return null;
		}

		public boolean isChamouAdicionarPontos() {
			return chamouAdicionarPontos;
		}
		
	}
	
	@Before
	public void init() {
		this.armazenamentoMock = new ArmazenamentoMock();
		this.placar = new Placar(this.armazenamentoMock);
	}
	
	@Test
	public void registrarPonto() {
		this.placar.registrar(new Pontos("guerra", ESTRELA, 10));
		assertTrue(this.armazenamentoMock.isChamouAdicionarPontos());
	}

}
