package teste;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.Funcionario;

public class Collections {
	
	public static void main(String[] args) {
		
		Funcionario f1 = new Funcionario();
		Funcionario f2 = new Funcionario();
		Funcionario f3 = new Funcionario();
		
		List listaFuncionarios = new ArrayList();
		
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
		listaFuncionarios.add(f2);
		listaFuncionarios.add(f3);
		listaFuncionarios.add(f1);
		
		
		for (int i = 0; i < listaFuncionarios.size(); i++) {
			Funcionario fTemp = (Funcionario) listaFuncionarios.get(i) ;
			System.out.println(fTemp.getNome());
			System.out.println(fTemp.getDataAdmissao());
		}
		
		
	}
	
	
	

}
