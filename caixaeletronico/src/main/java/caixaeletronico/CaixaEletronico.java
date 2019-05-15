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
			return "Não foi possível autenticar o usuário";
		}
		return "Usuário Autenticado";
	}

	public Object sacar() {
		// TODO Auto-generated method stub
		return null;
	}

}
