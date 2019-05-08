package carrinhocompras;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TesteCarrinhoCompras {

	@Test
	public void totalCarrinho() {
		CarrinhoCompras c = new CarrinhoCompras();
		c.adicionarProduto(new Produto("tenis", 100));
		c.adicionarProduto(new Produto("camiseta", 50));
		c.adicionarProduto(new Produto("bermuda", 70));
		assertEquals(220, c.total());
	}
	
	public void escutaAdicaoDeProduto() {
		CarrinhoCompras c = new CarrinhoCompras();
		MockObservadorCarrinho mock = MockObservadorCarrinho();
		c.adicionarObservador(mock);
		c.adicionarProduto(new Produto("tenis", 100));
		mock.verificaRecebimentoProduto("tenis", 100);
	}
}
