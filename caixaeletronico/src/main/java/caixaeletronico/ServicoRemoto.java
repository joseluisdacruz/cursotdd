package caixaeletronico;

public interface ServicoRemoto {

	ContaCorrente recuperarConta(String nroConta);

	void persistirConta(ContaCorrente cc);

}
