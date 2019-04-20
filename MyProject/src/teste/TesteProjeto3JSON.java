package teste;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;

import modelo.Funcao;
import modelo.Funcionario;
import repository.FuncaoRepository;

public class TesteProjeto3JSON {

	public static void main(String[] args) throws SQLException {
//		Funcionario funcionario = new Funcionario();
//		Gson gson = new Gson();
//		
//		String json = gson.toJson(funcionario);
//		

		Funcao funcao = new Funcao();
		FuncaoRepository funcaoRep = new FuncaoRepository();

//		funcao.setDescricao("CPD");
//		funcaoRep.AlterarFuncao(funcao,1);
//		
		//funcaoRep.ExcluirFuncao(1);
//		try {
//			List<Funcao> lista = funcaoRep.ExibirTodos();
//			
//			for (Funcao funcao2 : lista) {
//				System.out.println(funcao2.getId());
//				System.out.println(funcao2.getDescricao());
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

		funcao = funcaoRep.ExibirTodosPorId(1);
		System.out.println(funcao.getId());
		System.out.println(funcao.getDescricao());
		
	}	
		public void converterJson() throws IOException {
			Funcionario funcionario = new Funcionario();
			Gson json = new Gson();
			
			
			funcionario.setId(1);
			funcionario.setNome("Flavia");
			
			String gravarPessoa = json.toJson(funcionario);
			
			FileWriter arquivo = new FileWriter("c://TEMP/teste.json");
			arquivo.write(gravarPessoa);
			arquivo.close();
			
			System.out.println(gravarPessoa);
		}
		
		
		

	
	
	
}
