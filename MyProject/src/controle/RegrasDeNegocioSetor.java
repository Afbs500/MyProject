package controle;

import java.sql.SQLException;
import java.util.List;

import modelo.Setor;

public interface RegrasDeNegocioSetor {
	
	public void InserirSetor(Setor setor) throws SQLException;
	public void AlterarSetor(Setor setor ,int idSetor)throws SQLException;
	public void ExcluirSetor(int idSetor)throws SQLException;
	public List<Setor> ExibirTodos()throws SQLException;
	public Setor ExibirTodosPorID(int idSetor)throws SQLException;

}
