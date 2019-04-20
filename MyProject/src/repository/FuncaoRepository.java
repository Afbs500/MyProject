package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controle.RegrasDeNegocioFuncao;
import modelo.Funcao;

public class FuncaoRepository implements RegrasDeNegocioFuncao {

	Connection conn;

	public FuncaoRepository() {
		this.conn = new ConnectionFactory().getConectar();
	}

	@Override
	public void InserirFuncao(Funcao funcao) throws SQLException {

		String sql = "insert into funcao (descricao) values (?)";
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, funcao.getDescricao());
		stmt.execute();
		stmt.close();
		conn.close();
	}

	@Override
	public void AlterarFuncao(Funcao funcao, int idFuncao) throws SQLException {

		String sql = "update funcao set descricao = ? where idFuncao = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, funcao.getDescricao());
		stmt.setInt(2, idFuncao);
		stmt.execute();
		stmt.close();
		conn.close();
	}

	@Override
	public void ExcluirFuncao(int idFuncao) throws SQLException {
		String sql = "delete from funcao where idFuncao = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, idFuncao);
		stmt.execute();
		stmt.close();
		conn.close();

	}

	@Override
	public List<Funcao> ExibirTodos() throws SQLException {

		String sql = "select * from funcao";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		List<Funcao> listaFuncao = new ArrayList<Funcao>();
		while (rs.next()) {
			Funcao funcao = new Funcao();
			funcao.setId(rs.getInt("idFuncao"));
			funcao.setDescricao(rs.getString("descricao"));

			listaFuncao.add(funcao);
		}

		rs.close();
		stmt.close();
		conn.close();

		return listaFuncao;
	}

	@Override
	public Funcao ExibirTodosPorId(int idFuncao) {

		String sql = "select * from funcao where idFuncao = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idFuncao);
			ResultSet rs = stmt.executeQuery();
			if (rs.first()) {
				Funcao funcao = new Funcao();
				funcao.setId(rs.getInt("idFuncao"));
				funcao.setDescricao(rs.getString("descricao"));
				return funcao;
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
