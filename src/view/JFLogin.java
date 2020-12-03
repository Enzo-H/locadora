package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class JFLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordSenha;
	private JTextField textNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFLogin frame = new JFLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEntrar = new JButton("Entrar\r\n");
		btnEntrar.setBounds(121, 201, 86, 33);
		btnEntrar.setBackground(Color.WHITE);
		btnEntrar.setForeground(Color.BLACK);
		contentPane.add(btnEntrar);
		
		passwordSenha = new JPasswordField();
		passwordSenha.setBounds(101, 137, 240, 28);
		contentPane.add(passwordSenha);
		
		textNome = new JTextField();
		textNome.setBounds(101, 82, 240, 28);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar dados");
		btnLimpar.setBounds(227, 201, 103, 33);
		contentPane.add(btnLimpar);
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsuario.setToolTipText("");
		lblUsuario.setBounds(54, 89, 47, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSenha.setBounds(54, 144, 47, 14);
		contentPane.add(lblSenha);
		
		JLabel lblBV = new JLabel("Informe seus dados para fazer login no sistema ");
		lblBV.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBV.setBounds(54, 28, 336, 32);
		contentPane.add(lblBV);
	}
}
