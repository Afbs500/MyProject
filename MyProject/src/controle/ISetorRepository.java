package controle;

import java.util.List;

import modelo.Setor;

public interface ISetorRepository extends RepositoryGeneric<Setor> {

	List<Setor>FindAllByName(String nome) ;
	
	
}
