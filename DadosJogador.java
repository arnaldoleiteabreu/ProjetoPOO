
public class DadosJogador {
	String nacionalidade;
	String pais;
	String cidade;
	String estado;
	
	
	public DadosJogador() {
		this("", "", "", "");
	}
	public DadosJogador(String nacionalidade, String pais, String cidade, String estado) {
		this.nacionalidade = nacionalidade;
		this.pais = pais;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public String toString() {
		return this.nacionalidade+" , "+this.pais+" , "+this.cidade+" , "+this.estado;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstados(String estados) {
		this.estado = estados;
	}
	
	

}
