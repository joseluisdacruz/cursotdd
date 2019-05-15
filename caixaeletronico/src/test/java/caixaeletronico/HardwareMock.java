package caixaeletronico;

public class HardwareMock implements Hardware {

	private boolean chamouPegarNroConta = false;
	
	private boolean chamouEntregarDinheiro = false;
	
	
	
	private boolean falhar = false;
	
	public String pegarNumeroDaContaCartao() {
		this.chamouPegarNroConta = true;
		if(falhar) {
			throw new RuntimeException();
		}
		return "1";
	}

	public boolean chamouPegarNroConta() {
		return chamouPegarNroConta;
	}

	public void falharPegarNroConta() {
		this.falhar = true;
	}

	public boolean chamouEntregarDinheiro() {
		return this.chamouEntregarDinheiro;
	}

	public void entragarDinheiro() {
		this.chamouEntregarDinheiro = true;
	}

}
