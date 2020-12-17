package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFListarClientes extends JFrame {

	private JPanel contentPane;
	private JTable jtCliente;
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
		
		jtCliente = new JTable();
		jtCliente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idCliente", "Nome", "Email", "Sexo"
			}
		));
		scrollPane.setViewportView(jtCliente);
		
		JButton btnCadastrar = new JButton("Cadastrar Cliente");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrar.setBounds(10, 343, 150, 31);
		contentPane.add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar Cliente");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//verificar se há linha selecionada
				if(jtCliente.getSelectedRow()!= -1) {
					JFAtualizarCliente af = new JFAtualizarCliente(
							(int)jtCliente.getValueAt(jtCliente.getSelectedRow(), 0));
					af.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Selecione um cliente");
				}
				readJTable();
			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlterar.setBounds(170, 343, 141, 31);
		contentPane.add(btnAlterar);
		
		btnExcluir = new JButton("Excluir Cliente");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluir.setBounds(321, 343, 123, 31);
		contentPane.add(btnExcluir);
		
		readJTable();
	}
	
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) jtCliente.getModel();
		modelo.setNumRows(0);
		ClienteDAO cdao = new ClienteDAO();
		for(Cliente c : cdao.read()) {
			modelo.addRow(new Object[] {
					c.getIdCliente(),
					c.getNome(),
					c.getEmail(),
					c.isSexo(),
			});
		}
		
	}
}