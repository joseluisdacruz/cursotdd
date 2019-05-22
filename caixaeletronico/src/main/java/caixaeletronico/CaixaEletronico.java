package caixaeletronico;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

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
			this.cc = servicoRemoto.recuperarConta(this.nroConta);
		} catch (Exception e) {
			return "Não foi possível autenticar o usuário";
		}
		return "Usuário Autenticado";
	}

	public String sacar(double valor) {
		if(cc.getSaldo() <= valor) {
			return "Saldo insuficiente";
		}
		hardware.entregarDinheiro();
		servicoRemoto.persistirConta(cc);
		return "Retire seu dinheiro";
	}

	public String saldo() {
		DecimalFormat df = criarFormatador();
		return "O saldo é R$" + df.format(cc.getSaldo()) ;
	}

	private DecimalFormat criarFormatador() {
		Locale currentLocale = Locale.getDefault();
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(currentLocale);
		otherSymbols.setDecimalSeparator(',');
		otherSymbols.setGroupingSeparator('.'); 
		DecimalFormat df = new DecimalFormat("#,##0.00", otherSymbols);
		return df;
	}
}
