package teste;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.Funcionario;

public class Collections3 {

	public static void main(String[] args) {
		
		Funcionario f1 = new Funcionario();
		Funcionario f2 = new Funcionario();
		Funcionario f3 = new Funcionario();
		
		List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
		
		f1.setId(1);
		f1.setNome("Flavia");
		f1.setDataAdmissao(LocalDate.of(2001, 01, 01));
		
		f2.setId(2);
		f2.setNome("Julia");
		f2.setDataAdmissao(LocalDate.of(2013, 01, 01));
		
		f3.setId(3);
		f3.setNome("Davi");
		f3.setDataAdmissao(LocalDate.of(2017, 01, 01));
		
		listaFuncionarios.add(f1);
		listaFuncionarios.add(f2);
		listaFuncionarios.add(f3);
		
		
		for (Funcionario funcionario : listaFuncionarios) {
			
			System.out.println(funcionario.getId());
			System.out.println(funcionario.getNome());
			System.out.println(funcionario.getDataAdmissao());
			System.out.println("---------------------");
			
			
			
		}
		
		
	}
	
	
}
