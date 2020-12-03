package view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.Filme;
import model.dao.FilmeDAO;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFListarFilmes extends JFrame {

	private JPanel contentPane;
	private JTable tblFilmes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarFilmes frame = new JFListarFilmes();
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
	
	public JFListarFilmes() {
		setTitle("Listar Filmes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 655, 284);
		contentPane.add(scrollPane);
		
		tblFilmes = new JTable();
		tblFilmes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idFilme", "T\u00EDtulo", "Categoria", "Tempo"
			}
		));
		scrollPane.setViewportView(tblFilmes);
		
		JButton btnCadastrar = new JButton("Cadastrar Filme");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrar.setBounds(10, 330, 139, 30);
		contentPane.add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar Filme");
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlterar.setBounds(175, 330, 111, 30);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir Filme");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluir.setBounds(296, 330, 111, 30);
		contentPane.add(btnExcluir);
		
		readJTable();
	}
	
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) tblFilmes.getModel();
		modelo.setNumRows(0);
		FilmeDAO fdao = new FilmeDAO();
		for(Filme f : fdao.read()) {
			modelo.addRow(new Object[] {
					f.getIdFilme(),
					f.getTitulo(),
					f.getCategoria(),
					f.getTempo()
			});
		}
		
	}
}