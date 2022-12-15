package view;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import dominio.Musica;
import conexaoBD.BancoDeDados;

public class TelaPesquisar {

	protected JFrame frame;
	protected JTextField txtPesquisa;
	protected JLabel lblPesquisar;
	protected JButton btnPesquisar;
	protected JButton btnVoltar;
	protected JButton btnListar;
	
	
	public TelaPesquisar() {
		initialize();
	}


	protected void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 255, 128));
		frame.getContentPane().setLayout(null);
		
		JLabel lblPesquisar = new JLabel("Digite o nome da música que você deseja pesquisar:");
		lblPesquisar.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		lblPesquisar.setBounds(58, 107, 322, 28);
		frame.getContentPane().add(lblPesquisar);
		
		txtPesquisa = new JTextField();
		txtPesquisa.setBounds(58, 135, 322, 20);
		frame.getContentPane().add(txtPesquisa);
		txtPesquisa.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtPesquisa.getText().equals("")) 
					JOptionPane.showMessageDialog(null, "O campo está em branco!", "Campo sem texto", JOptionPane.ERROR_MESSAGE);
				
				else {
					String titulo = txtPesquisa.getText();
					BancoDeDados bd = new BancoDeDados();
					Musica musica = new Musica(bd);					
					musica.pesquisar(titulo);
				}
				
			}
		});
		btnPesquisar.setBounds(301, 207, 99, 23);
		frame.getContentPane().add(btnPesquisar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal t = new TelaPrincipal();
				frame.setVisible(false);
			}
		});
		
		btnVoltar.setBounds(41, 207, 99, 23);
		frame.getContentPane().add(btnVoltar);
		
		JButton btnListar = new JButton("Listar tudo");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BancoDeDados bd = new BancoDeDados();
				Musica musica = new Musica(bd);		
				musica.listar();
			}
		});
		btnListar.setBounds(162, 207, 119, 23);
		frame.getContentPane().add(btnListar);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setTitle("Pesquisar Música");
		frame.setLocationRelativeTo(null);
		
		frame.setVisible(true);
		
	}
}
