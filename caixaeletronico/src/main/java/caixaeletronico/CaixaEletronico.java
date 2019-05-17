package caixaeletronico;

public class CaixaEletronico {
	
	private String nroConta;
	
	private Hardware hardware;
	
	private ServicoRemoto servicoRemoto;
	
	private ContaCorrente cc;
	
	public CaixaEletronico(Hardware hardware, ServicoRemoto sr) {
		this.hardware = hardware;
		this.servicoRemoto = sr;
	}

	public String logar() {
		try {
			this.nroConta = hardware.pegarNumeroDaContaCartao();
		} catch (Exception e) {
			return "Não foi possível autenticar o usuário";
		}
		return "Usuário Autenticado";
	}

	public String sacar(double valor) {
		this.cc = servicoRemoto.recuperarConta(this.nroConta);
		if(cc.getSaldo() <= valor) {
			return "Saldo insuficiente";
		}
		hardware.entregarDinheiro();
		servicoRemoto.persistirConta(cc);
		return "Retire seu dinheiro";
	}
}
