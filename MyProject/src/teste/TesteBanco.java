package teste;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.Funcao;
import modelo.Funcionario;
import modelo.Setor;
import repository.FuncionarioRepository;

public class TesteBanco {
	
	public static void main(String[] args) throws SQLException {
		
//		SetorRepository sRep = new SetorRepository(); 
//		
//		
//		setor.setSigla("TDD");
//		setor.setNomeSetor("Dev Testes");
//		
//		sRep.AlterarSetor(setor,2);
		
		FuncionarioRepository fRepo = new FuncionarioRepository();
		Setor setor = new Setor();
		Funcao funcao = new Funcao();
		
//		setor.setId(1);
//		funcao.setId(1);
////		
//		func.setNome("Davi Alexandre");
//		func.setDataNascimento(LocalDate.of(2011, 02, 21));
//		func.setDataAdmissao(LocalDate.of(2017, 10,10));
//		func.setFuncao(funcao);
//		func.setSetor(setor);
//		func.setSalario(500.0);
//		fRepo.Insert(func); fRepo.Update(func);
//		
		
		//fRepo.Delete(3);
		
		//List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
		
		Funcionario funcionario = new Funcionario();
		funcionario = fRepo.FindById(2);
		
		//listaFuncionario = fRepo.FindAll();
		
	//	for (Funcionario funcionario : listaFuncionario) {
			System.out.println("ID Funcionario: ...........\t" + funcionario.getId());
			System.out.println("Nome Funcionario: .........\t" + funcionario.getNome());
			System.out.println("Data Admissao: ............\t" + funcionario.getDataAdmissao());
			System.out.println("Salário R$: ...............\t" + funcionario.getSalario());
			System.out.println("Sigla Setor: ..............\t" + funcionario.getSetor().getSigla());
			System.out.println("Nome do Setor: ............\t" + funcionario.getSetor().getNomeSetor());
			System.out.println("Detalhamento Função: ......\t" + funcionario.getFuncao().getDescricao());
			System.out.println("Idade: ....................\t" + funcionario.calcularIdade(funcionario.getDataNascimento()));
			System.out.println("-------------------------------");

			
		

		
	}
	

}
