package modelo;

import java.time.LocalDate;
import java.time.Period;

public class Funcionario extends Pessoa {
	private LocalDate dataAdmissao;
	private double salario;
	
	//dados de classes geradas no proprio projeto
	private Setor setor;
	private Funcao funcao;
	
	public Funcionario() {
		
	}
	
	public Funcionario(LocalDate dataAdmissao,double salario,Setor setor, Funcao funcao) {
		this.dataAdmissao = dataAdmissao;
		this.salario = salario;
		this.setor = setor;
		this.funcao = funcao;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	@Override
	public int calcularIdade(LocalDate nasc) {
		LocalDate hoje = LocalDate.now();
		Period idade = Period.between(nasc, hoje);
		
		return idade.getYears();
	}

	
	
		
	
}
