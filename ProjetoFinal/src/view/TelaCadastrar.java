package view;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import dominio.Musica;
import conexaoBD.BancoDeDados;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastrar {

	protected JFrame frame;
	protected JTextField nomeMusica;
	protected JTextField duracao;
	protected JTextField curtidas;
	protected JTextField visualizacoes;
	protected JLabel lblDuracao;
	protected JLabel lblExplicit;
	protected JLabel lblMusica;
	protected JLabel lblCurtidas;
	protected JLabel lblVisualizacoes;
	protected JRadioButton radioSim;
	protected JRadioButton radioNao;
	protected JButton btnSalvar;
	protected JButton btnCancelar;

	
	public TelaCadastrar() {
		initialize();
	}

	
	protected void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 255, 128));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setTitle("Cadastrar Música");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDuracao = new JLabel("Duração em segundos:");
		lblDuracao.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblDuracao.setBounds(10, 48, 123, 15);
		frame.getContentPane().add(lblDuracao);
		
		nomeMusica = new JTextField();
		nomeMusica.setBounds(102, 9, 322, 20);
		frame.getContentPane().add(nomeMusica);
		nomeMusica.setColumns(10);
		
		lblMusica = new JLabel("Nome da música:");
		lblMusica.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblMusica.setBounds(10, 11, 93, 15);
		frame.getContentPane().add(lblMusica);
		
		duracao = new JTextField();
		duracao.setBounds(129, 46, 70, 20);
		frame.getContentPane().add(duracao);
		duracao.setColumns(10);
		
		lblExplicit = new JLabel("Explicit?");
		lblExplicit.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblExplicit.setBounds(209, 49, 48, 15);
		frame.getContentPane().add(lblExplicit);
		
		JRadioButton radioSim = new JRadioButton("Sim");
		radioSim.setBounds(263, 45, 48, 23);
		frame.getContentPane().add(radioSim);
		
		JRadioButton radioNao = new JRadioButton("Não");
		radioNao.setBounds(314, 45, 48, 23);
		frame.getContentPane().add(radioNao);
		
		radioSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioNao.isSelected() == true) {
					radioNao.setSelected(false);
					radioSim.setSelected(true);
				}
			}
		});
		
		radioNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioSim.isSelected() == true) {
					radioSim.setSelected(false); 
					radioNao.setSelected(true);
				}
			}
		});
		
		
		JLabel lblCurtidas = new JLabel("Curtidas:");
		lblCurtidas.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblCurtidas.setBounds(10, 87, 48, 15);
		frame.getContentPane().add(lblCurtidas);
		
		curtidas = new JTextField();
		curtidas.setBounds(57, 85, 142, 20);
		frame.getContentPane().add(curtidas);
		curtidas.setColumns(10);
		
		JLabel lblVisualizacoes = new JLabel("Visualizações:");
		lblVisualizacoes.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblVisualizacoes.setBounds(209, 89, 76, 15);
		frame.getContentPane().add(lblVisualizacoes);
		
		visualizacoes = new JTextField();
		visualizacoes.setColumns(10);
		visualizacoes.setBounds(282, 87, 142, 20);
		frame.getContentPane().add(visualizacoes);	
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nomeMusica.getText().equals("") || duracao.getText().equals("") || curtidas.getText().equals("") || visualizacoes.getText().equals("") || radioSim.isSelected() == false && radioNao.isSelected() == false ) {
					JOptionPane.showMessageDialog(null, "Erro - Preencha todos os campos!", "Erro ao cadastrar Música", JOptionPane.ERROR_MESSAGE);
				}else {
					String musicName = nomeMusica.getText();
					int duration = Integer.parseInt(duracao.getText());
					long likes = Long.parseLong(curtidas.getText());
					long views = Long.parseLong(visualizacoes.getText());
					boolean explicit;
					
					if(radioSim.isSelected())
						explicit = true;
					else 
						explicit = false;
					
					BancoDeDados bd = new BancoDeDados();
					Musica musica = new Musica(musicName, duration, likes, views, explicit, bd);
					musica.cadastrar();
					
					TelaPrincipal tela = new TelaPrincipal();
					frame.setVisible(false);
								
				}
			}
		});
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nomeMusica.getText().equals("") || duracao.getText().equals("") || curtidas.getText().equals("") || visualizacoes.getText().equals("") || radioSim.isSelected() == false && radioNao.isSelected() == false ) {
					TelaPrincipal tela = new TelaPrincipal();
					frame.setVisible(false);
					
				}else {
					int confirm = JOptionPane.showConfirmDialog(null, "Deseja cancelar? Se fizer isso, \nas alterações não serão salvas.", "Confirmação de saída", 1);
					if(confirm == 0) {
						TelaPrincipal tela = new TelaPrincipal();
						frame.setVisible(false);
					
					}
				}
			
			}
		
		});
		
		btnCancelar.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnCancelar);
		
		frame.setVisible(true);
		
	}
}
