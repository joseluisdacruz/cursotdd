package gameficacao;

import static gameficacao.TipoPonto.CURTIDA;
import static gameficacao.TipoPonto.ESTRELA;
import static gameficacao.TipoPonto.MOEDA;
import static gameficacao.TipoPonto.TOPICO;
import static org.junit.Assert.assertArrayEquals;
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

		private boolean chamouPecuperarPontos = false;
		private boolean chamouAdicionarPontos = false;
		private boolean chamouRecuperarTiposPontos = false;
		private boolean chamouRecuperarUsuarios = false;

		@Override
		public void adicionarPontos(PontosUsuario pontos) {
			this.chamouAdicionarPontos = true;
			
		}

		@Override
		public int recuperarPontos(String usuario, TipoPonto tipo) {
			this.chamouPecuperarPontos = true;
			if(tipo.equals(ESTRELA)) return 15;
			if(tipo.equals(TOPICO)) return 10;
			if(tipo.equals(CURTIDA)) return 10;
			if(tipo.equals(MOEDA) && "jose".equals(usuario)) return 10;
			if(tipo.equals(MOEDA) && "joao".equals(usuario)) return 15;
			if(tipo.equals(MOEDA) && "pedro".equals(usuario)) return 20;
			return 0;			
		}

		@Override
		public Set<String> recuperarUsuarios() {
			this.chamouRecuperarUsuarios = true;
			return new HashSet<>(Arrays.asList("joao", "pedro", "jose"));
		}

		@Override
		public Set<TipoPonto> recuperarTiposPontos() {
			this.chamouRecuperarTiposPontos = true;
			return new HashSet<>(Arrays.asList(ESTRELA, CURTIDA, TOPICO));
		}

		public boolean isChamouAdicionarPontos() {
			return this.chamouAdicionarPontos;
		}

		public boolean isChamouRecuperarTiposPontos() {
			return this.chamouRecuperarTiposPontos;
		}

		public boolean isChamouRecuperarPontos() {
			return this.chamouPecuperarPontos;
		}
		
		public boolean isChamouRecuperarUsuarios() {
			return chamouRecuperarUsuarios;
		}
		
	}
	
	@Before
	public void init() {
		this.armazenamentoMock = new ArmazenamentoMock();
		this.placar = new Placar(this.armazenamentoMock);
	}
	
	@Test
	public void registrarPonto() {
		this.placar.registrar(new PontosUsuario("guerra", ESTRELA, 10));
		assertTrue(this.armazenamentoMock.isChamouAdicionarPontos());
	}
	
	@Test
	public void retornarPontosUsuario() {
		Pontos pontos1 = new Pontos(ESTRELA, 15);
		Pontos pontos2 = new Pontos(CURTIDA, 10);
		Pontos pontos3 = new Pontos(TOPICO, 10);
		assertEquals(
				new HashSet<Pontos>(Arrays.asList(pontos1, pontos2, pontos3)),
				this.placar.retornarPontosUsuario("jose"));
		assertTrue(armazenamentoMock.isChamouRecuperarTiposPontos());
		assertTrue(armazenamentoMock.isChamouRecuperarPontos());
	}
	
	@Test
	public void recuperarRank() {
		RankItem[] rank = {new RankItem("pedro", 20), new RankItem("joao", 15), new RankItem("jose", 10)};
		assertArrayEquals(rank, this.placar.rank(MOEDA));
		assertTrue(armazenamentoMock.isChamouRecuperarUsuarios());
		assertTrue(armazenamentoMock.isChamouRecuperarPontos());
	}

}
