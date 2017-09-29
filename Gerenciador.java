import java.util.List;

public interface Gerenciador {
	
	public void SistemaList();
	public void cadastraJogador(Jogador jog) throws JogadorJaExisteException;
	public void removeJogador(String rg) throws JogadorNaoExisteException;
	public List<Jogador> pesquisaJogadorPeleDataNascimento(String dataNascimento);
	public List<Jogador> pesquisaJogadorPeloPais(String pais);
	public Jogador pesquisaJogador(String rg) throws JogadorNaoExisteException;
	public void increveJogadorNoClube(String rg, String nomeTime)throws JogadorNaoExisteException, ClubeNaoExisteException;
	public List<Jogador> getListaTotalDeJogadores();
	public List<Jogador> getJogadoresDoClube(String nomeClube) throws ClubeNaoExisteException;
	public void cadastraClube(ClubeFutebol c) throws ClubeJaExisteException;
	public List<Jogador> pesquisaClube(String nomeTime) throws ClubeNaoExisteException;
	
}
