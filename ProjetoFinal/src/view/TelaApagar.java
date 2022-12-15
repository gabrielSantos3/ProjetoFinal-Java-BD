package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import dominio.Musica;
import conexaoBD.BancoDeDados;

public class TelaApagar {

	protected JFrame frame;
	protected JTextField txtApagar;
	protected JLabel lblApagar;
	protected JButton btnApagar;
	protected JButton btnCancelar;
	
	
	public TelaApagar() {
		initialize();
	}

	
	protected void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 255, 128));
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		
		frame.setTitle("Apagar Música");
		frame.setLocationRelativeTo(null);
		
		JLabel lblApagar = new JLabel("Digite o nome da música que você deseja apagar:");
		lblApagar.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		lblApagar.setBounds(62, 118, 307, 18);
		frame.getContentPane().add(lblApagar);
		
		txtApagar = new JTextField();
		txtApagar.setBounds(62, 147, 307, 20);
		frame.getContentPane().add(txtApagar);
		txtApagar.setColumns(10);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtApagar.getText().equals(""))
					JOptionPane.showMessageDialog(null, "O campo está em branco!", "Campo sem texto", JOptionPane.ERROR_MESSAGE);
				
				else {
					String titulo = txtApagar.getText();
					BancoDeDados bd = new BancoDeDados();
					Musica musica = new Musica(bd);
					musica.apagar(titulo);
					txtApagar.setText(null);
				}
				
			}
		});
		btnApagar.setBounds(280, 206, 89, 23);
		frame.getContentPane().add(btnApagar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtApagar.getText().equals("")) {
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
		
		btnCancelar.setBounds(62, 206, 89, 23);
		frame.getContentPane().add(btnCancelar);
		
		
		frame.setVisible(true);
		
	}

}
