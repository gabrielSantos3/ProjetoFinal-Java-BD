package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaLogin{

	public JFrame frame;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	protected JLabel lblLogin;
	protected JLabel lblSenha;
	protected JButton btnEntrar;

	
	public TelaLogin() {
		initialize();
	}

	
	protected void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 255, 128));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setTitle("Verificação");
		frame.setLocationRelativeTo(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblLogin.setBounds(93, 76, 45, 31);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblSenha.setBounds(93, 121, 56, 31);
		frame.getContentPane().add(lblSenha);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(145, 84, 190, 20);
		frame.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(145, 129, 190, 20);
		frame.getContentPane().add(txtSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkLogin(txtLogin.getText(), new String(txtSenha.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Seja bem-vindo ao sistema!", "Autenticação realizada com sucesso", 1);
					frame.setVisible(false);
					
					TelaPrincipal tela = new TelaPrincipal();
					
				}else if(txtLogin.getText().equals("") || new String(txtSenha.getPassword()).equals("")) {
					JOptionPane.showMessageDialog(null, "Erro - Usuário ou senha em branco!", "Acesso negado", JOptionPane.ERROR_MESSAGE);
					txtLogin.setText(null);
					txtSenha.setText(null);
				}else{
					JOptionPane.showMessageDialog(null, "Erro - Usuário ou senha incorretas!", "Acesso negado", JOptionPane.ERROR_MESSAGE);
					txtLogin.setText(null);
					txtSenha.setText(null);
				}
			}
		});
		
		btnEntrar.setBounds(182, 197, 89, 31);
		frame.getContentPane().add(btnEntrar);
	}
	
	protected boolean checkLogin(String login, String senha) {
		return login.equals("usuario") && senha.equals("senha");
	}

}
