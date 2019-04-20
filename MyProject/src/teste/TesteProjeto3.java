package teste;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.spi.LocaleServiceProvider;

import com.google.gson.Gson;

import modelo.Funcao;
import modelo.Funcionario;
import modelo.Setor;
import modelo.Sexo;

public class TesteProjeto3 {

	public static void main(String[] args) {

		Setor setor = new Setor();
		Funcao funcao = new Funcao();

		List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();

		Gson gson = new Gson();

		Scanner sc = new Scanner(System.in);

		String novaExecucao = "N";

					
			System.out.println("1 - Gravar Setor");
			System.out.println("2 - Gravar Função");
			System.out.println("3 - Gravar e Imprimir Funcionario");
			
			
			System.out.println("Escolha uma opção");
			int opcao = sc.nextInt();
			
			switch (opcao) {
			case 1:
				gravarSetor(setor);
				break;
			case 2:
				gravarFuncao(funcao);
				break;
			case 3:
				gravarFuncionarioLista(setor, funcao, listaFuncionario);
				imprimirFuncionarioJson(listaFuncionario, gson);
				break;
			
			default:
				main(args);
				break;
			}
			
			System.out.println("Deseja continuar S|N" );
			String rec = sc.next();
			
			if (rec.equalsIgnoreCase("S")) {
				
				main(args);
			}else {
				System.out.println("bye!");
			}
	
	}

	public static void gravarFuncionarioLista(Setor setor, Funcao funcao, List<Funcionario> listaFuncionario) {
		String totalFuncionarios;

			Scanner sc = new Scanner(System.in);
			Funcionario funcionario = new Funcionario();
			
			System.out.println("Informe ID");
			funcionario.setId(sc.nextInt());
			System.out.println("Informe o Nome");
			funcionario.setNome(sc.next());
			System.out.println("Informe a Data de Nascimento");
			String nasc = sc.next();
			funcionario.setDataNascimento(LocalDate.parse(nasc));
			System.out.println("Informe Data Admissao");
			String data = sc.next();
			funcionario.setDataAdmissao(LocalDate.parse(data));
			System.out.println("Informe Salario");
			funcionario.setSalario(sc.nextDouble());
			
			// ********************************************
			funcionario.setSetor(setor);
			// ********************************************
			funcionario.setFuncao(funcao);

			listaFuncionario.add(funcionario);
		
			System.out.println("Deseja gravar mais algum funcionario");
			totalFuncionarios = sc.next();
			
			if (totalFuncionarios.equalsIgnoreCase("S")){
				gravarFuncionarioLista(setor, funcao, listaFuncionario);
			}
	}

	public static void imprimirFuncionarioJson(List<Funcionario> listaFuncionario, Gson gson) {
		for (Funcionario funcionario : listaFuncionario) {
			System.out.println("ID Funcionario: ...........\t" + funcionario.getId());
			System.out.println("Nome Funcionario: .........\t" + funcionario.getNome());
			System.out.println("Data Admissao: ............\t" + funcionario.getDataAdmissao());
			System.out.println("Salário R$: ...............\t" + funcionario.getSalario());
		//	System.out.println("Sigla Setor: ..............\t" + funcionario.getSetor().getSigla());
		//	System.out.println("Nome do Setor: ............\t" + funcionario.getSetor().getNomeSetor());
		//	System.out.println("Detalhamento Função: ......\t" + funcionario.getFuncao().getDescricao());
			System.out.println("Idade: ....................\t" + funcionario.calcularIdade(funcionario.getDataNascimento()));
			System.out.println("-------------------------------");

			String json = gson.toJson(funcionario);

			try {

				FileWriter writer = new FileWriter("C:\\TEMP\\file.json", true);
				writer.write(json);
				writer.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println(json);
		}
	}

	public static void gravarFuncao(Funcao funcao) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe o Id");
		funcao.setId(sc.nextInt());
		System.out.println("Informe a Descrição da função");
		funcao.setDescricao(sc.next());
		System.out.println("Gravado com sucesso");
	}

	public static void gravarSetor(Setor setor) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe o Id");
		setor.setId(sc.nextInt());
		System.out.println("Informe a Sigla");
		setor.setSigla(sc.next());
		System.out.println("Informe o Setor");
		setor.setNomeSetor(sc.next());
		System.out.println("Gravado com sucesso");
	}
}
