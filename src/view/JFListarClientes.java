package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.Cliente;
import model.bean.Filme;
import model.dao.ClienteDAO;
import model.dao.FilmeDAO;

import javax.swing.JButton;
import java.awt.Font;

public class JFListarClientes extends JFrame {

	private JPanel contentPane;
	private JTable tblClientes;
	private JButton btnAlterar;
	private JButton btnExcluir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarClientes frame = new JFListarClientes();
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
	public JFListarClientes() {
		setTitle("Listar Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 634, 300);
		contentPane.add(scrollPane);
		
		tblClientes = new JTable();
		tblClientes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idCliente", "Nome", "Email", "Sexo"
			}
		));
		scrollPane.setViewportView(tblClientes);
		
		JButton btnCadastrar = new JButton("Cadastrar Cliente");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrar.setBounds(10, 343, 150, 31);
		contentPane.add(btnCadastrar);
		
		btnAlterar = new JButton("Alterar Cliente");
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlterar.setBounds(181, 343, 123, 31);
		contentPane.add(btnAlterar);
		
		btnExcluir = new JButton("Excluir Cliente");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluir.setBounds(321, 343, 123, 31);
		contentPane.add(btnExcluir);
		
		readJTable();
	}
	
	
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
		modelo.setNumRows(0);
		ClienteDAO fdao = new ClienteDAO();
		for(Cliente f : fdao.read()) {
			modelo.addRow(new Object[] {
					f.getIdCliente(),
					f.getNome(),
					f.getEmail(),
					f.isSexo(),
			});
		}
		
	}
}