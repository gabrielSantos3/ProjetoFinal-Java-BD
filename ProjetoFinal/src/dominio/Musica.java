package dominio;

import conexaoBD.BancoDeDados;
import javax.swing.JOptionPane;

public class Musica {
	public int idMusica;
	public String titulo;
	public int duracao;
	public long curtidas;
	public long visualizacoes;
	public boolean explicit;
	public BancoDeDados dataBase;
	
	public Musica(String titulo, int duracao, long curtidas, long visualizacoes, boolean explicit, BancoDeDados dataBase) {
		this.titulo = titulo;
		this.duracao = duracao;
		this.curtidas = curtidas;
		this.visualizacoes = visualizacoes;
		this.explicit = explicit;
		this.dataBase = dataBase;
	}
	
	
	
	public Musica(BancoDeDados dataBase) {
		super();
		this.dataBase = dataBase;
	}


	public BancoDeDados getDataBase() {
		return dataBase;
	}


	public void setDataBase(BancoDeDados dataBase) {
		this.dataBase = dataBase;
	}


	public Musica () {}
	
    public int getIdMusica() {
        return idMusica;
    }
    
    public void setIdMusica(int idMusica) {
        this.idMusica = idMusica;
    }
    
    
	public String getTitulo() {
        return titulo;
    }
	
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    
    public long getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(long curtidas) {
        this.curtidas = curtidas;
    }
    
    
    public long getVisualizacoes() {
        return visualizacoes;
    }

    public void setVisualizacoes(long visualizacoes) {
        this.visualizacoes = visualizacoes;
    }
    
    
    public boolean getExplicit() {
        return explicit;
    }

    public void setExplicit(boolean explicit) {
        this.explicit = explicit;
    }
    
    
    public void listar() {
    	dataBase.conectar();
    	
    	if(dataBase.estaConectado()) {
    		dataBase.listarMusicas();
    		dataBase.desconectar();
    		
    	}else {
			JOptionPane.showMessageDialog(null, "Não foi possível conectar ao Banco de Dados.\nVerifique o terminal para mais informações.", "A operação falhou", JOptionPane.ERROR_MESSAGE);
		}
    }
    
    public void pesquisar(String titulo) {
    	dataBase.conectar();
    	
    	if(dataBase.estaConectado()) {
    		dataBase.pesquisarMusica(titulo);
    		dataBase.desconectar();
    		
    	}else {
			JOptionPane.showMessageDialog(null, "Não foi possível conectar ao Banco de Dados.\nVerifique o terminal para mais informações.", "A operação falhou", JOptionPane.ERROR_MESSAGE);
		}
    	
    }
    
    public void cadastrar() {
    	dataBase.conectar();
		
		if(dataBase.estaConectado()) {
			dataBase.inserirMusica(this.getTitulo(), this.getDuracao(), this.getCurtidas(), this.getVisualizacoes(), this.getExplicit());
			dataBase.desconectar();
			
			JOptionPane.showMessageDialog(null, "A música foi salva no Banco de Dados com sucesso.", "Operação realizada com êxito", 1);
			
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível conectar ao Banco de Dados.\nVerifique o terminal para mais informações.", "A operação falhou", JOptionPane.ERROR_MESSAGE);
		}
    }
    
    public void apagar(String titulo) {
    	dataBase.conectar();
    	
    	if(dataBase.estaConectado()) {
        	dataBase.apagarMusica(titulo);
        	dataBase.desconectar();
        	
        	
    	}else {
			JOptionPane.showMessageDialog(null, "Não foi possível conectar ao Banco de Dados.\nVerifique o terminal para mais informações.", "A operação falhou", JOptionPane.ERROR_MESSAGE);
		}
    	

    }

}
