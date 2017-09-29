import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Gravador {
	public List<String> recuperaTextoDeArquivo(String nomeArquivo)
			throws IOException {    
		BufferedReader leitor = null;
        List<String> textoLido = new ArrayList<String>();
		try {
			leitor = new BufferedReader(new FileReader(nomeArquivo));
			String texto = null;
			do {
				texto = leitor.readLine(); // lê a próxima linha do arquivo
				if (texto != null){
                       textoLido.add(texto);
                }
			} while(texto != null); //vai ser null quando chegar no fim do arquivo
		} finally {
			if (leitor!=null){
				leitor.close(); //fecha o stream(fluxo) de leitura
			}
		}
		return textoLido;
	}
	
	public void gravaTextoEmArquivo(List<String> texto, String nomeArquivo)
			throws IOException {
		BufferedWriter gravador = null;
		try {
			gravador = new BufferedWriter(new FileWriter(nomeArquivo));
                        for (String s: texto){
                              gravador.write(s+"\n");
                        }
		} finally {
			if (gravador!=null){
				gravador.close(); //fecha o stream(fluxo) de escrita
			}
		}
	}	public void GravadorJogador(List<Jogador> lista){
		List<String> lista2= new ArrayList<String>();
		for(Jogador p: lista){
			lista2.add(p.getNome());
			lista2.add(p.getNumero());
			lista2.add(p.getDataNascimento());
			lista2.add(p.getRg());
			lista2.add(p.getDadosjogador().getNacionalidade());
			lista2.add(p.getDadosjogador().getPais());
			lista2.add(p.getDadosjogador().getCidade());
			lista2.add(p.getDadosjogador().getEstado());
		}
		try {
			gravaTextoEmArquivo(lista2,"Jogador.txt");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao gravar arquivo");
		}
	}
	public List<Jogador> RecuperaParticipante(){
		try {
			List<Jogador> jog= new ArrayList<Jogador>();
			List<String> lista= recuperaTextoDeArquivo("Jogador.txt");
			if(lista!=null){
				for(int k=0; k < lista.size();k++){
					String nome= lista.get(k);
					k++;
					String numero=lista.get(k);
					k++;
					String dataNascimento= lista.get(k);
					k++;
					String rg= lista.get(k);
					k++;
					String nacionalidade= lista.get(k);
					k++;
					String pais= lista.get(k);
					k++;
					String cidade= lista.get(k);
					k++;
					String estado= lista.get(k);
					DadosJogador dados= new DadosJogador(nacionalidade, pais, cidade, estado);
					Jogador joga= new Jogador(nome, numero, dataNascimento, rg, dados);
					jog.add(joga);
				}
			}
			return jog;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao recuperar arquivo");
		
		}
		return null;
		
	}


}
