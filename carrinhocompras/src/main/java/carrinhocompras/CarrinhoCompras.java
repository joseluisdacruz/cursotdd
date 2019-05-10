package carrinhocompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {

	private List<Produto> itens = new ArrayList<>();
	private List<ObservadorCarrinho> observadores = new ArrayList<>();
	
	public void adicionarProduto(Produto produto) {
		itens.add(produto);
		for (ObservadorCarrinho observador: observadores) {
			try {
				observador.produtoAdicionado(produto.getNome(), produto.getValor());
			} catch (Exception e) {
			}
		}
	}

	public int total() {
		return itens.stream().reduce(0, (val, p) -> val + p.getValor() , (acc1, acc2) -> acc1 + acc2);
	}

	public void adicionarObservador(ObservadorCarrinho observador) {
		this.observadores.add(observador);
		
	}

}
