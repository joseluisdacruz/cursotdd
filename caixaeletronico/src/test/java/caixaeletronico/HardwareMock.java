package caixaeletronico;

public class HardwareMock implements Hardware {

	private boolean chamouPegarNroConta = false;

	public Long pegarNumeroDaContaCartao() {
		this.chamouPegarNroConta = true;
		return 1L;
	}

	public boolean chamouPegarNroConta() {
		return chamouPegarNroConta;
	}

}
