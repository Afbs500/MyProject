package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controle.IFuncaoRepository;
import modelo.Funcao;

public class FuncaoRepository2 implements IFuncaoRepository {

	Connection conn;

	public FuncaoRepository2() {
		conn = new ConnectionFactory().getConectar();
	}

	@Override
	public void Insert(Funcao funcao) {

		String sql = "insert into funcao (descricao) values (?)";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, funcao.getDescricao());
			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void Update(Funcao funcao, int id) {
		String sql = "update funcao set descricao = ? where idFuncao = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, funcao.getDescricao());
                        stmt.setInt(2, id);
			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Override
	public void Delete(int Id) {
		String sql = "delete from funcao where idFuncao = ?";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, Id);
			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	public List<Funcao> FindAll() {
		String sql = "select * from funcao";
		try {
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
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Funcao FindById(int Id) {
		String sql = "select * from funcao where idFuncao = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, Id);
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

	@Override
	public List<Funcao> FindAllByName(String nome) {
		String sql = "select * from funcao where nome like ?";
		try {
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,"%"+nome+"%");
		
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
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
