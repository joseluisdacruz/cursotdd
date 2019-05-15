package caixaeletronico;

public class CaixaEletronico {
	
	private Hardware hardware;
	
	private ServicoRemoto sr;
	
	public CaixaEletronico(Hardware hardware, ServicoRemoto sr) {
		this.hardware = hardware;
		this.sr = sr;
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
		sr.recuperarConta();
		hardware.entragarDinheiro();
		sr.persistirConta();
		return "Retire seu dinheiro";
	}

}
