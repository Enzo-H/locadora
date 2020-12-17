package view;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Cliente;
import model.dao.ClienteDAO;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class JFAtualizarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	
	private static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAtualizarCliente frame = new JFAtualizarCliente(id);
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
	public JFAtualizarCliente(int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAlterarClientes = new JLabel("Altera\u00E7\u00E3o de Clientes");
		lblAlterarClientes.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAlterarClientes.setBounds(107, 11, 215, 30);
		contentPane.add(lblAlterarClientes);
		
		ClienteDAO cdao = new ClienteDAO();
		Cliente c = cdao.read(id);
		
		JLabel lblIdCliente = new JLabel("ID do Cliente:");
		lblIdCliente.setBounds(10, 47, 83, 14);
		contentPane.add(lblIdCliente);
		
		JLabel lblId = new JLabel("New label");
		lblId.setBounds(84, 47, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(20, 72, 87, 30);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(74, 77, 287, 24);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(21, 113, 46, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(74, 110, 287, 24);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Sexo:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(21, 156, 36, 14);
		contentPane.add(lblNewLabel_4);
		
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnFeminino.setBounds(74, 152, 79, 23);
		contentPane.add(rdbtnFeminino);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnMasculino.setBounds(155, 152, 87, 23);
		contentPane.add(rdbtnMasculino);
		
		ButtonGroup sexo = new ButtonGroup();
		sexo.add(rdbtnFeminino);
		sexo.add(rdbtnMasculino);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(244, 210, 89, 30);
		contentPane.add(btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(143, 210, 89, 30);
		contentPane.add(btnCancelar);
		
		lblId.setText(String.valueOf(c.getIdCliente()));
		txtNome.setText(c.getNome());
		txtEmail.setText(c.getEmail());
		if(rdbtnFeminino.isSelected()) {
			c.setSexo(false);
		}else if (rdbtnMasculino.isSelected()) {
			c.setSexo(true);
		}
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Cliente c = new Cliente();
				ClienteDAO dao = new ClienteDAO();
				
				c.setIdCliente(Integer.parseInt(lblId.getText()));
				c.setNome(txtNome.getText());
				c.setEmail(txtEmail.getText());
				if(rdbtnFeminino.isSelected()) {
					c.setSexo(false);
				}else if (rdbtnMasculino.isSelected()) {
					c.setSexo(true);
				}
				
				dao.update(c);
			}
		});
		
		btnAlterar.setBounds(10, 211, 109, 30);
		contentPane.add(btnAlterar);
	   
	}
}