package repository;

import controle.ISetorRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Setor;

public class SetorRepository implements ISetorRepository {

	Connection conn;
	public SetorRepository() {
		// conectar banco
		 conn = new ConnectionFactory().getConectar();
	}

	@Override
	public void Insert(Setor setor) {
		String sql = "Insert into setor (sigla,nomeSetor) values(?,?)";
try{
		// abre caminho pra instru��o chegar ao BD
		PreparedStatement stmt = conn.prepareStatement(sql);

		// conecta o sql com os campos da tabela BD
		stmt.setString(1, setor.getSigla());
		stmt.setString(2, setor.getNomeSetor());

		stmt.execute();

		stmt.close();
		conn.close();

	}catch(SQLException e){
            e.printStackTrace();
        }
        }
	@Override
	public void Update(Setor setor, int id){

		String sql = "update setor set sigla=?, nomeSetor=? where idSetor = ? ";
                try{
		// abre caminho pra instrucao chegar ao BD
		PreparedStatement stmt = conn.prepareStatement(sql);

		// conecta o sql com os campos da tabela BD
		stmt.setString(1, setor.getSigla());
		stmt.setString(2, setor.getNomeSetor());
		stmt.setInt(3, id);

		stmt.execute();

		stmt.close();
		conn.close();
	}catch(SQLException e ){
            e.printStackTrace();
        }
        }  

	@Override
	public void Delete(int idSetor) {

		String sql = "delete from setor where idSetor = ?";
        try{
		// abre caminho pra instru��o chegar ao BD
		PreparedStatement stmt = conn.prepareStatement(sql);

		// conecta o sql com os campos da tabela BD
		stmt.setInt(1, idSetor);

		stmt.execute();
		stmt.close();
		conn.close();
	}catch(SQLException e){
          e.printStackTrace();
        }
        }

	@Override
	public List<Setor> FindAll(){

		String sql = "select * from setor";
	try{
                PreparedStatement stmt = conn.prepareStatement(sql);
		// executa sql e retorna com os dados do banco
		ResultSet rs = stmt.executeQuery();
		List<Setor> lista = new ArrayList<Setor>();
		// enqto houver registro ele executa
		while (rs.next()) {
			Setor setor = new Setor();
			// joga os dados retornados do banco em suas respectivas variaveis
			setor.setId(rs.getInt("idSetor"));
			setor.setSigla(rs.getString("sigla"));
			setor.setNomeSetor(rs.getString("nomeSetor"));
			lista.add(setor);
		}
		rs.close();
		stmt.close();
		conn.close();

		return lista;
	
        }catch(SQLException e){
          e.printStackTrace();
        }
            return null;
        }
	@Override
	public Setor FindById(int idSetor) {

		String sql = "select * from setor where idSetor = ?";
	try{	
                PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, idSetor);

		// executa sql e retorna com os dados do banco
		ResultSet rs = stmt.executeQuery();

		if (rs.first()) {
			Setor setor = new Setor();
			setor.setId(rs.getInt("idSetor"));
			setor.setSigla(rs.getString("sigla"));
			setor.setNomeSetor(rs.getString("nomeSetor"));

			rs.close();
			stmt.close();
			conn.close();

			return setor;
                }
		}catch(SQLException e){
          e.printStackTrace();
        }
                
              
			return null;
	}

    @Override
    public List<Setor> FindAllByName(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
