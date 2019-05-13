package caixaeletronico;

public class CaixaEletronico {
	
	private Hardware hardware;
	
	public CaixaEletronico(Hardware hardware, ServicoRemoto sr) {
		this.hardware = hardware;
	}

	public String logar() {
		if(this.hardware.pegarNumeroDaContaCartao() == 1) {
			return "Usuário Autenticado";
		}
		return null;
	}

}
