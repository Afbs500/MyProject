package controle;

import java.sql.SQLException;
import java.util.List;

import modelo.Funcionario;

public interface RegrasDeNegocioFuncionario {
	
	public void InserirFuncionario(Funcionario funcionario)throws SQLException;
	public void AlterarFuncionario(Funcionario funcionario,int idFuncionario)throws SQLException;
	public void ExcluirFuncionario(int idFuncionario)throws SQLException;
	public List<Funcionario> ExibirTodos()throws SQLException;
	public Funcionario ExibirTodosPorId(int idFuncioario)throws SQLException;
	public List<Funcionario> ExibirTodosPorNome(String nome)throws SQLException;
	
}
