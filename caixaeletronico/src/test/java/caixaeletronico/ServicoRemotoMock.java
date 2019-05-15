package caixaeletronico;

public class ServicoRemotoMock implements ServicoRemoto {

	private boolean chamouRecuperarConta = false;
	
	private boolean chamouPersistirConta = false;
	
	public boolean chamouRecuperarConta() {
		return this.chamouRecuperarConta;
	}

	public boolean chamouPersistirConta() {
		return this.chamouPersistirConta;
	}

	public void recuperarConta() {
		this.chamouRecuperarConta = true;
	}

	public void persistirConta() {
		this.chamouPersistirConta = true;
		// TODO Auto-generated method stub
		
	}

}
