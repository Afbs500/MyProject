package controle;

import java.util.List;

import modelo.Funcionario;

public interface IFuncionarioRepository extends RepositoryGeneric<Funcionario> {

	List<Funcionario>FindAllByName(String nome) ;
	
	
}
