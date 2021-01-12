package view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
	private JTable jtFilme;
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
		
		jtFilme = new JTable();
		jtFilme.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idFilme", "T\u00EDtulo", "Categoria", "Tempo"
			}
		));
		scrollPane.setViewportView(jtFilme);
		
		JButton btnCadastrar = new JButton("Cadastrar Filme");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrar.setBounds(10, 330, 139, 30);
		contentPane.add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar Filme");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//verificar se há linha selecionada
				if(jtFilme.getSelectedRow() != -1) {
					JFAtualizarFilme af = new JFAtualizarFilme(
							(int)jtFilme.getValueAt(jtFilme.getSelectedRow(), 0));				
					af.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um filme");	
				}
				
				readJTable();
				
			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlterar.setBounds(175, 330, 111, 30);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir Filme");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jtFilme.getSelectedRow() != -1) {	
					
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o filme selecionado?", "Exclusão", JOptionPane.YES_NO_OPTION);		
				if(opcao == 0) {
					FilmeDAO dao = new FilmeDAO();
					Filme f = new Filme();
					f.setIdFilme((int) jtFilme.getValueAt(jtFilme.getSelectedRow(), 0));
					dao.delete(f);
				}else {
					JOptionPane.showMessageDialog(null, "Selecione um filme!");
				}
				readJTable();
				
				}
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluir.setBounds(296, 330, 111, 30);
		contentPane.add(btnExcluir);
		
		readJTable();
	}
	
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) jtFilme.getModel();
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