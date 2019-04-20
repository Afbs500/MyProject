package modelo;

public class Setor {
	private int id;
	private String sigla;
	private String nomeSetor;
	

	
	public Setor() {

	}

	public Setor(int id, String sigla, String nomeSetor) {

		this.id = id;
		this.sigla = sigla;
		this.nomeSetor = nomeSetor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNomeSetor() {
		return nomeSetor;
	}

	public void setNomeSetor(String nomeSetor) {
		this.nomeSetor = nomeSetor;
	}

}
