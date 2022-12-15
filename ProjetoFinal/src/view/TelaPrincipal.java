package view;

import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal {

	protected JFrame frame;
	protected JLabel hello;
	protected JLabel lblSpotify;
	protected JLabel lblFrase;
	protected JButton btnCadastrar;
	protected JButton btnPesquisar;
	protected JButton btnApagar;
	

	
	public TelaPrincipal() {
		initialize();
	}

	
	protected void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 255, 128));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setTitle("Página Principal");
		frame.setLocationRelativeTo(null);

		
		JLabel hello = new JLabel("Olá!");
		hello.setFont(new Font("Ink Free", Font.BOLD, 18));
		hello.setBounds(10, 11, 326, 22);
		frame.getContentPane().add(hello);
		
		JLabel lblFrase = new JLabel("A maior biblioteca de música do planeta.");
		lblFrase.setFont(new Font("Ink Free", Font.BOLD, 18));
		lblFrase.setBounds(50, 95, 338, 72);
		frame.getContentPane().add(lblFrase);
		
		JLabel lblSpotify = new JLabel("Spotify.");
		lblSpotify.setFont(new Font("Ink Free", Font.BOLD, 18));
		lblSpotify.setBounds(173, 75, 72, 38);
		frame.getContentPane().add(lblSpotify);
		
		JButton btnCadastrar = new JButton("Cadastrar música");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrar c = new TelaCadastrar();
				frame.setVisible(false);
				
			}
		});
		
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCadastrar.setBounds(155, 205, 126, 31);
		frame.getContentPane().add(btnCadastrar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPesquisar p = new TelaPesquisar();
				frame.setVisible(false);
			}
		});
		
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPesquisar.setBounds(19, 205, 126, 31);
		frame.getContentPane().add(btnPesquisar);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaApagar a = new TelaApagar();
				frame.setVisible(false);
			}
		});
		
		btnApagar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnApagar.setBounds(291, 205, 126, 31);
		frame.getContentPane().add(btnApagar);
		
		Calendar data = Calendar.getInstance();
        int hora = data.get(Calendar.HOUR_OF_DAY);
        
        if(hora >= 0 && hora < 12) {
        	hello.setText("Bom dia!");
        }else if(hora >= 12 && hora < 18) {
        	hello.setText("Boa tarde!");
        }else {
        	hello.setText("Boa noite!");
        }
        
        frame.setVisible(true);
        
	}
}
