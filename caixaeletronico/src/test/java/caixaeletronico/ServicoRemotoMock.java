package caixaeletronico;

public class ServicoRemotoMock implements ServicoRemoto {

	ContaCorrente contaCorrente;
	
	private boolean chamouRecuperarConta = false;
	
	private boolean chamouPersistirConta = false;
	
	public boolean chamouRecuperarConta() {
		return this.chamouRecuperarConta;
	}

	public boolean chamouPersistirConta() {
		return this.chamouPersistirConta;
	}

	public ContaCorrente recuperarConta(String nroConta) {
		this.chamouRecuperarConta = true;
		return contaCorrente;
	}

	public void persistirConta(ContaCorrente cc) {
		this.chamouPersistirConta = true;		
	}
	
	public void setContaCorrente(ContaCorrente contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

}
