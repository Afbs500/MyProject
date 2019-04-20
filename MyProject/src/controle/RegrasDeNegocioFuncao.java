package controle;

import java.sql.SQLException;
import java.util.List;

import modelo.Funcao;

public interface RegrasDeNegocioFuncao {

	public void InserirFuncao(Funcao funcao) throws SQLException;
	public void AlterarFuncao(Funcao funcao,int idFuncao) throws SQLException;
	public void ExcluirFuncao(int idFuncao) throws SQLException;
	public List<Funcao> ExibirTodos() throws SQLException;
	public Funcao ExibirTodosPorId(int idFuncao) throws SQLException;

}
