
public class Jogador {
	String nome;
	String numero;
	String dataNascimento;
	String rg;
	DadosJogador dadosjogador;
	
	public Jogador() {
		this("", "", "","", new DadosJogador());
	}
	
	public String toString() {
		return "Nome: "+this.nome + "\n Numero: "+ numero + "\n DataNascimento: "+dataNascimento+ "" + "\nDados: "+ this.dadosjogador.toString()+ "\n";
	}
	public Jogador(String nome, String numero, String dataNascimento, String rg, DadosJogador dadosjogador) {
		this.nome = nome;
		this.numero = numero;
		this.dataNascimento = dataNascimento;
		this.rg = rg;
		this.dadosjogador = dadosjogador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public DadosJogador getDadosjogador() {
		return dadosjogador;
	}

	public void setDadosjogador(DadosJogador dadosjogador) {
		this.dadosjogador = dadosjogador;
	}


}
