import java.util.ArrayList;
import java.util.List;

public class ClubeFutebol {
	List<Jogador> jogadores= new ArrayList<Jogador>();
	int totalDeJogadores;
	String nomeClube;
	
	public ClubeFutebol() {
		this.totalDeJogadores=0;
		this.nomeClube="";
		jogadores=new ArrayList<Jogador>();
	}
	

	public ClubeFutebol( String nomeClube, int totalDeJogadores) {
		this.totalDeJogadores = totalDeJogadores;
		this.nomeClube = nomeClube;
	}
	
	public List<Jogador> getJogadores() {
		return jogadores;
	}
	
	public void adiciona(Jogador jog) {
		this.jogadores.add(jog);
	}
	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	
	public int getTotalDeJogadores() {
		return totalDeJogadores;
	}
	public void adicionaJogador(Jogador j) {
		this.jogadores.add(j);
	}
	
	public void setTotalDeJogadores(int totalDeJogadores) {
		this.totalDeJogadores = totalDeJogadores;
	}
	
	public String getNomeClube() {
		return nomeClube;
	}
	
	public void setNomeClube(String nomeClube) {
		this.nomeClube = nomeClube;
	}
	

}
