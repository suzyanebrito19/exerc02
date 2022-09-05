package entidades;

import Exececao.NegociosExce ;

public class Conta {
	private Integer numero;
	private String titular;
	private Double saldo;
	private Double retirarLimite;
	
	public Conta() {
	}

	public Conta(Integer numero, String titular, Double saldo, Double retirarLimite) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.retirarLimite = retirarLimite;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo=saldo;
	}

	public Double getretirarLimite() {
		return retirarLimite;
	}

	public void setretirarLimitet(Double retirarLimite) {
		this.retirarLimite = retirarLimite;
	}
	
	public void deposit(double quantia) {
		saldo += quantia;
	}
	
	public void retirar(double quantia) {
		validarRetirada(quantia);
		saldo -= quantia;
	}
	
	private void validarRetirada(double quantia) {
		if (quantia > getretirarLimite()) {
			throw new NegociosExce("Erro de saque: A quantia excede o limite de saque");
		} 
		if (quantia > getSaldo()) {
			throw new NegociosExce("Erro de saque: Saldo insuficiente");
		}
	}
}
