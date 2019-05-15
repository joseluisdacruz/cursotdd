package caixaeletronico;

public class CaixaEletronico {
	
	private Hardware hardware;
	
	public CaixaEletronico(Hardware hardware, ServicoRemoto sr) {
		this.hardware = hardware;
	}

	public String logar() {
		try {
			this.hardware.pegarNumeroDaContaCartao();
		} catch (Exception e) {
			return "N�o foi poss�vel autenticar o usu�rio";
		}
		return "Usu�rio Autenticado";
	}

	public Object sacar() {
		// TODO Auto-generated method stub
		return null;
	}

}
