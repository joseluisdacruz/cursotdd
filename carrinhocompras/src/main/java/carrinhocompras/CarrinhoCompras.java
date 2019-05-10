package carrinhocompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {

	private List<Produto> itens = new ArrayList<>();
	private ObservadorCarrinho observador;
	
	public void adicionarProduto(Produto produto) {
		itens.add(produto);
		if(observador != null) {
			observador.produtoAdicionado(produto.getNome(), produto.getValor());
		}
	}

	public int total() {
		return itens.stream().reduce(0, (val, p) -> val + p.getValor() , (acc1, acc2) -> acc1 + acc2);
	}

	public void adicionarObservador(ObservadorCarrinho observador) {
		this.observador = observador;
		
	}

}
