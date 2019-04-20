package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import controle.IFuncionarioRepository;
import modelo.Funcao;
import modelo.Funcionario;
import modelo.Setor;

public class FuncionarioRepository implements IFuncionarioRepository {

	Connection conn;

	public FuncionarioRepository() {
		this.conn = new ConnectionFactory().getConectar();
	}

	@Override
	public void Insert(Funcionario funcionario) {
		String sql = "Insert into funcionario (nome, dataNascimento, dataAdmissao, salario, idSetor, idFuncao) values(?,?,?,?,?,?)";

		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			Date dataNasc = java.sql.Date.valueOf(funcionario.getDataNascimento());
			stmt.setDate(2, (java.sql.Date) dataNasc);
			Date dataAdm = java.sql.Date.valueOf(funcionario.getDataAdmissao());
			stmt.setDate(3, (java.sql.Date) dataAdm);

			stmt.setDouble(4, funcionario.getSalario());
			stmt.setInt(5, funcionario.getSetor().getId());
			stmt.setInt(6, funcionario.getFuncao().getId());

			stmt.execute();

			stmt.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void Update(Funcionario funcionario, int id) {
		String sql = "update funcionario set nome = ?, dataNascimento = ?, dataAdmissao = ?, salario = ?, idSetor = ?, idFuncao = ? where idFuncionario = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			Date dataNasc = java.sql.Date.valueOf(funcionario.getDataNascimento());
			stmt.setDate(2, (java.sql.Date) dataNasc);
			Date dataAdm = java.sql.Date.valueOf(funcionario.getDataAdmissao());
			stmt.setDate(3, (java.sql.Date) dataAdm);

			stmt.setDouble(4, funcionario.getSalario());
			stmt.setInt(5, funcionario.getSetor().getId());
			stmt.setInt(6, funcionario.getFuncao().getId());
                        stmt.setInt(7, id);
                        

			int col = stmt.executeUpdate();
			if (col > 0)
				System.out.println(col + " funcion�rio(s) atualizado(s) com sucesso!");

			stmt.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void Delete(int Id) {
		try {

			String sql = "delete from funcionario where idFuncionario = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, Id);

			int col = stmt.executeUpdate();
			if (col > 0)
				System.out.println(col + " funcion�rio(s) excluido(s) com sucesso!");

			stmt.close();
			conn.close();

		} catch (SQLException e) {
			new RuntimeException().getMessage();
		}
	}

	@Override
	public List<Funcionario> FindAll() {
		try {
			String sql = "select * from funcionario inner join setor on setor.idSetor = funcionario.idSetor"
					+ " inner join funcao on funcao.idFuncao = funcionario.idFuncao ";
			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			List<Funcionario> lista = new ArrayList<Funcionario>();
			Setor setor = new Setor();
			Funcao funcao = new Funcao();

			while (rs.next()) {
				Funcionario func = new Funcionario();

				func.setId(rs.getInt("idFuncionario"));
				func.setNome(rs.getString("nome"));
				func.setDataNascimento(LocalDate.parse(rs.getString("dataNascimento")));
				func.setDataAdmissao(LocalDate.parse(rs.getString("dataAdmissao")));
				func.setSalario(rs.getDouble("salario"));

				setor.setSigla(rs.getString("sigla"));
				setor.setNomeSetor(rs.getString("nomeSetor"));
				func.setSetor(setor);

				funcao.setDescricao(rs.getString("descricao"));
				func.setFuncao(funcao);

				lista.add(func);
			}
			rs.close();
			stmt.close();
			conn.close();

			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Funcionario FindById(int Id) {

		try {
			String sql = "select * from funcionario where idFuncionario= ? ";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, Id);

			ResultSet rs = stmt.executeQuery();
			Setor setor = new Setor();
			Funcao funcao = new Funcao();

			if (rs.first()) {
				Funcionario func = new Funcionario();

				func.setId(rs.getInt("idFuncionario"));
				func.setNome(rs.getString("nome"));
				func.setDataNascimento(LocalDate.parse(rs.getString("dataNascimento")));
				func.setDataAdmissao(LocalDate.parse(rs.getString("dataAdmissao")));
				func.setSalario(rs.getDouble("salario"));

				rs.close();
				stmt.close();
				conn.close();

				return func;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Funcionario> FindAllByName(String nome) {

		try {
			String sql = "select * from funcionario where nome like ? ";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, "%" + nome + "%");

			ResultSet rs = stmt.executeQuery();
			List<Funcionario> lista = new ArrayList<Funcionario>();
			Setor setor = new Setor();
			Funcao funcao = new Funcao();

			while (rs.next()) {
				Funcionario func = new Funcionario();

				func.setId(rs.getInt("idFuncionario"));
				func.setNome(rs.getString("nome"));
				func.setDataNascimento(LocalDate.parse(rs.getString("dataNascimento")));
				func.setDataAdmissao(LocalDate.parse(rs.getString("dataAdmissao")));
				func.setSalario(rs.getDouble("salario"));

				lista.add(func);
			}
			rs.close();
			stmt.close();
			conn.close();

			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
