package gameficacao;

import static gameficacao.TipoPonto.ESTRELA;
import static gameficacao.TipoPonto.CURTIDA;
import static gameficacao.TipoPonto.TOPICO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
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

		public boolean isChamouRecuperarTiposPontos() {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean isChamouRecuperarPontos() {
			// TODO Auto-generated method stub
			return false;
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
	
	@Test
	public void retornarPontosUsuario() {
		Pontos pontos1 = new Pontos("jose", ESTRELA, 15);
		Pontos pontos2 = new Pontos("jose", CURTIDA, 10);
		Pontos pontos3 = new Pontos("jose", TOPICO, 10);
		assertEquals(
				new HashSet<Pontos>(Arrays.asList(pontos1, pontos2, pontos3)),
				this.placar.retornarPontosUsuario("jose"));
		assertTrue(armazenamentoMock.isChamouRecuperarTiposPontos());
		assertTrue(armazenamentoMock.isChamouRecuperarPontos());
	}

}
