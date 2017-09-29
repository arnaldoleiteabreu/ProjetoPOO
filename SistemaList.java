import java.util.ArrayList;
import java.util.List;

public class SistemaList {
	List<Jogador> jogadores;
	List<ClubeFutebol> clubes;
	
	public SistemaList() {
		this.jogadores= new ArrayList<Jogador>();
		this.clubes= new ArrayList<ClubeFutebol>();
	}
	public void cadastraJogador(Jogador jog) throws JogadorJaExisteException{
		for(Jogador j: this.jogadores) {
			if(j.getRg().equals(jog.getRg())) {
				throw new JogadorJaExisteException("Já existe jogador com rg"+jog.getRg());
				
			}
		}
		this.jogadores.add(jog);
	}
	
	public void removeJogador(String rg) throws JogadorNaoExisteException{
		boolean opcao = true;
		for(int k=0; k<jogadores.size(); k++) {
			if(jogadores.get(k).getRg().equals(rg)) {
				this.jogadores.remove(jogadores.get(k));
				opcao= false;
			}
			if(opcao==true) {
				throw new JogadorNaoExisteException("Jogador não existe com o rg pesquisado ");
			}
		}
	}
	
	public List<Jogador> pesquisaJogadorPeleDataNascimento(String dataNascimento){
		ArrayList<Jogador> lista= new ArrayList<Jogador>();
		for(Jogador j: this.jogadores) {
			if(j.getDataNascimento().equals(dataNascimento)) {
				lista.add(j);
			}
		}
		return lista;
	}
	
	public List<Jogador> pesquisaJogadorPeloPais(String pais){
		ArrayList<Jogador> lista= new ArrayList<Jogador>();
		for(Jogador j: this.jogadores) {
			if(j.getDadosjogador().getPais().equals(pais)) {
				lista.add(j);
			}
		}
		return lista;
	}
	 
	public Jogador pesquisaJogador(String rg) throws JogadorNaoExisteException{
		for(Jogador j: this.jogadores) {
			if(j.getRg().equals(rg)){
				return j;
			}
		}
		throw new JogadorNaoExisteException("Não existe jogador com esse rg");
		
	}
	public void increveJogadorNoClube(String rg, String nomeTime)throws JogadorNaoExisteException, ClubeNaoExisteException{
		boolean opcao= true;
		boolean opcao2= true;
		for(Jogador j: this.jogadores) {
			if(j.getRg().equals(rg)) {
				opcao= false;
				for(ClubeFutebol c: this.clubes) {
					if(c.getNomeClube().equals(nomeTime)) {
						c.adiciona(j);
						opcao2= false;
					}
				}
			}
		}
		if(opcao==true) {
			throw new JogadorNaoExisteException("Não existe jogador com esse rg");
		}
		if(opcao2==true) {
			throw new ClubeNaoExisteException("Não existe clube com esse nome");
		}
	}
	
	public List<Jogador> getListaTotalDeJogadores(){
		return this.jogadores;
	}
	
	public List<Jogador> getJogadoresDoClube(String nomeClube) throws ClubeNaoExisteException{
		for(ClubeFutebol c: this.clubes) {
			if(c.getNomeClube().equals(nomeClube)) {
				return c.getJogadores();
			}
			throw new ClubeNaoExisteException("Não existe clube com esse nome");
		}
		return null;
	}
	
	public void cadastraClube(ClubeFutebol c) throws ClubeJaExisteException{
		for(ClubeFutebol f: this.clubes) {
			if(f.equals(c)) {
				throw new ClubeJaExisteException("Já existe esse clube: ");
			}
			
		}
		this.clubes.add(c);
	}
	public List<Jogador> pesquisaClube(String nomeTime) throws ClubeNaoExisteException{
		for(ClubeFutebol c: this.clubes) {
			if(c.getNomeClube().equals(nomeTime)) {
				return c.jogadores;
			}
		}
		throw new ClubeNaoExisteException("Não existe clube com esse nome");
	}

}
