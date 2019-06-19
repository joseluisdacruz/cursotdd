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

		@Override
		public void limparArquivo() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void adicionarPontos(Pontos pontos) {
			// TODO Auto-generated method stub
			
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
			// TODO Auto-generated method stub
			return false;
		}
		
	}
	
	@Before
	private void init() {
		this.armazenamentoMock = new ArmazenamentoMock();
		this.placar = new Placar(this.armazenamentoMock);
	}
	
	@Test
	public void registrarPonto() {
		this.placar.registrar(new Pontos("guerra", ESTRELA, 10));
		assertTrue(this.armazenamentoMock.isChamouAdicionarPontos());
	}

}
