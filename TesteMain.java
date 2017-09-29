import java.util.List;

import javax.swing.JOptionPane;

public class TesteMain {

	public static void main(String[] args) throws ClubeNaoExisteException {
		Gravador grava= new Gravador();
		SistemaList sistema = new SistemaList();
		boolean sair= false;
		while(sair== false) {
			int opcao= Integer.parseInt(JOptionPane.showInputDialog("Digite uma das opções:\n 1 - Cadastrar Jogador: \n1 2 - Remover Jogador: \n 3 - Pesquisar jogador pela data de nascimento: \n 4 - Pesquisar jogador pelo pais: \n 5 - Pesuisar jogador pelo rg: \n 6 - Pesquisar jogador pelo time: \n 7 - Cadastrar clube: \n 8 - Inscreve jogador no clube: \n 9 - Salvar jogador cadastrado: \n 10 - Carregar jogador: \n 11 - Lista de clube \n 12 - Lista de jogadores \n 13 - Sair."));
			switch(opcao) {
			case 1:
				String nomeJogador= JOptionPane.showInputDialog("Digite o nome do jogador: ");
				String numeroDoJogador= JOptionPane.showInputDialog("Digite o a numeração do jogador: ");
				String dataNascimentoDoJogador= JOptionPane.showInputDialog("Digite a data de nascimento do jogador: ");
				String rgJogador= JOptionPane.showInputDialog("Digite o rg do jogador: ");
				String nacionalidade= JOptionPane.showInputDialog("Digite a nacionalidade do jogador: ");
				String pais= JOptionPane.showInputDialog("Digite o pais que o jogador nasceu: ");
				String cidade= JOptionPane.showInputDialog("Digite a cidade do jogador: ");
				String estado= JOptionPane.showInputDialog("Digite o estado do jogador: ");
				DadosJogador dados= new DadosJogador(nacionalidade, pais, cidade, estado);
				Jogador jogador= new Jogador(nomeJogador, numeroDoJogador, dataNascimentoDoJogador, rgJogador, dados);
				try {
					sistema.cadastraJogador(jogador);
					JOptionPane.showMessageDialog(null, "Cadastrado");
				}catch(JogadorJaExisteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				break;
			case 2:
				String rg= JOptionPane.showInputDialog("Digite o rg do jogador que queira remover: ");
				try {
					sistema.removeJogador(rg);
					JOptionPane.showMessageDialog(null, "Jogador removido!");
				}catch(JogadorNaoExisteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					
				}break;
			
			case 3:
				String dataNascimento= JOptionPane.showInputDialog("Digite a data de nascimento para pesquisar os jogador(s)");
				List<Jogador> lista= sistema.pesquisaJogadorPeleDataNascimento(dataNascimento);
				for(Jogador j: lista) {
					JOptionPane.showMessageDialog(null, j.toString());
				}break;
			
			case 4:
				String pais2= JOptionPane.showInputDialog("Digite o país que queira pesquisar os jogadores: ");
				List<Jogador> lista2= sistema.pesquisaJogadorPeloPais(pais2);
				for(Jogador j: lista2) {
					JOptionPane.showMessageDialog(null, j.toString());
				}break;
			
			case 5:
				String rg1 = JOptionPane.showInputDialog("Digite o rg do jogador para pesquisar: ");
				try {
					Jogador jogadorParaPesquisar=(Jogador)sistema.pesquisaJogador(rg1);
					JOptionPane.showMessageDialog(null, jogadorParaPesquisar);
				}catch (JogadorNaoExisteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}break;
			
			case 6:
				String nomeTime= JOptionPane.showInputDialog("Digite o nome do time para pesquisar: ");
				List<Jogador> lista3= sistema.pesquisaClube(nomeTime);
				for(Jogador j: lista3) {
					JOptionPane.showMessageDialog(null, j.toString());
				}break;
				
			case 7:
				String nomeTimeParaCadastrar= JOptionPane.showInputDialog("Digite o nome do clube para cadastrar: ");
				int numeroMaximoDeJogadores= Integer.parseInt(JOptionPane.showInputDialog("Digite o número total de jogadores que o clube pode ter: "));
				ClubeFutebol clubecadastra= new ClubeFutebol(nomeTimeParaCadastrar, numeroMaximoDeJogadores);
				try {
					sistema.cadastraClube(clubecadastra);
				}catch(ClubeJaExisteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}break;
			
			case 8:
				String rgJogador2 = JOptionPane.showInputDialog("Digite o rg do jogador para cadastrar: ");
				String nomeTime2 = JOptionPane.showInputDialog("Digite o nome do clube para cadastrar o jogador ");
				try {
					sistema.increveJogadorNoClube(rgJogador2, nomeTime2);
				}catch(JogadorNaoExisteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());	
				}catch(ClubeNaoExisteException m) {
					JOptionPane.showMessageDialog(null, m.getMessage());
				}
				break;
			case 9:
				grava.GravadorJogador(sistema.getListaTotalDeJogadores());
				break;
			case 10:
				List<Jogador> lista4= grava.RecuperaParticipante();
				for(Jogador j:lista4) {
					try {
						sistema.cadastraJogador(j);
					}catch (JogadorJaExisteException e) {
						
					}
				}
			break;
			case 11:
				String nomeClube = JOptionPane.showInputDialog("Digite o nome do clube: ");
				try {
					JOptionPane.showMessageDialog(null, sistema.getJogadoresDoClube(nomeClube));
				}catch (ClubeNaoExisteException c) {
					JOptionPane.showMessageDialog(null, c.getMessage());
				}
				break;
	
			case 12:
				JOptionPane.showMessageDialog(null, sistema.getListaTotalDeJogadores());
				break;
			case 13:
				sair= true;
				JOptionPane.showMessageDialog(null, "O programa será finalizado");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida");
				break;
			}
		
		}
		

	}

}
