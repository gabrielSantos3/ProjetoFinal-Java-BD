package conexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class BancoDeDados {
	
	private Connection  connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	
	
	public void conectar() {
		String servidor = "jdbc:mysql://10.28.0.35:3306/musica"; //  BD remoto do IFBA - Interno
		String usuario = "remoto"; // root 
		String senha = "remoto"; // senha
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();
			
		} catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}		
	}
	
	
	public boolean estaConectado() {
		if(this.connection != null)
			return true;
		else
			return false;
	}
	
	// Listar Musicas
	public void listarMusicas() {
		try {
			String query = "SELECT * FROM musica ORDER BY idMusica ASC";
			this.resultset = this.statement.executeQuery(query);
			while(this.resultset.next()) {
				
			JOptionPane.showMessageDialog(null, "Id: " + this.resultset.getString("idMusica") +
				       "\nTítulo: " + this.resultset.getString("titulo") + 
				       "\nDuração: " + this.resultset.getString("duracao") +
				       "\nCurtidas: " + this.resultset.getString("curtidas") + 
				       "\nVisualizações: " + this.resultset.getString("visualizacoes") +
				       "\nExplicit: " + this.resultset.getString("explicit"), "Listando as músicas", 1);
			}

			
		} catch(Exception e)	{
			System.out.println("Exception: " + e.getMessage());
		}
	}
	
	// Inserir Musica
	public void inserirMusica(String titulo, int duracao, long curtidas, long visualizacoes, boolean explicit) {
		try {
			String query = "INSERT INTO musica (titulo, duracao, curtidas, visualizacoes, explicit) VALUES ('" + titulo + "', " + duracao + ", " + curtidas + ", " + visualizacoes + ", " + explicit + ");";
			this.statement.executeUpdate(query);
		} catch (Exception e){
			System.out.println("Exception: " + e.getMessage());
		}
	}
	
	// Apagar Musica
	public void apagarMusica(String titulo) {
		try {
			String query = "SELECT * FROM musica WHERE titulo = '" + titulo + "';";
			String query2 = "DELETE FROM musica WHERE titulo = '" + titulo + "';";
			this.statement.executeQuery(query);
			this.resultset = this.statement.executeQuery(query);
			
			if(this.resultset.next()) {
				
				this.statement.executeUpdate(query2);
				JOptionPane.showMessageDialog(null, "A música foi deletada do Banco de Dados com sucesso.", "Operação realizada com êxito", 1);
			}else {
				JOptionPane.showMessageDialog(null, "A música não foi encontrada no Banco de Dados.", "Música não encontrada", JOptionPane.ERROR_MESSAGE);
			}

		} catch (Exception e){
			System.out.println("Exception: " + e.getMessage());
		}
	}
	
	// Pesquisar Musica
	public void pesquisarMusica(String titulo) {
		try {
			String query = "SELECT * FROM musica WHERE titulo = '" + titulo + "';";
			this.statement.executeQuery(query);
			this.resultset = this.statement.executeQuery(query);
			
			if(this.resultset.next()) {
				
				JOptionPane.showMessageDialog(null, "Id: " + this.resultset.getString("idMusica") +
					       "\nTítulo: " + this.resultset.getString("titulo") + 
					       "\nDuração: " + this.resultset.getString("duracao") +
					       "\nCurtidas: " + this.resultset.getString("curtidas") + 
					       "\nVisualizações: " + this.resultset.getString("visualizacoes") +
					       "\nExplicit: " + this.resultset.getString("explicit"), "Música encontrada", 1);
				
				
				//JOptionPane.showMessageDialog(null, "A música foi encontrada no Banco de Dados!", "Música encontrada", 1);	

			} else {
				JOptionPane.showMessageDialog(null, "A música não foi encontrada no Banco de Dados.", "Música não encontrada", JOptionPane.ERROR_MESSAGE);
			}
			
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());			
		}
	}
	
	public void desconectar() {
		try {
			this.connection.close();
		} catch(Exception e) {
			System.out.println("erro - em desconectar: " + e.getMessage());
		}
	}
}
