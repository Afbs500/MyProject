package controle;

import java.util.List;

import modelo.Funcao;

public interface IFuncaoRepository extends RepositoryGeneric<Funcao> {

	List<Funcao>FindAllByName(String nome) ;
	
	
}
