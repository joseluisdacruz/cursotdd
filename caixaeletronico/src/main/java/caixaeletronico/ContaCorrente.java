package caixaeletronico;

public class ContaCorrente {
	private Double saldo;
	
	public ContaCorrente(Double saldo) {
		this.saldo = saldo;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
}
