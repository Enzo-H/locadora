package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Filme;
import model.dao.FilmeDAO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class JFCadastrarFilme extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastrarFilme frame = new JFCadastrarFilme();
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
	public JFCadastrarFilme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Filme");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(198, 11, 121, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EDtulo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 50, 33, 25);
		contentPane.add(lblNewLabel_1);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(10, 76, 497, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Sinopse");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 107, 57, 25);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 132, 497, 153);
		contentPane.add(scrollPane);
		
		JTextArea txtSinopse = new JTextArea();
		scrollPane.setViewportView(txtSinopse);
		
		JLabel lblNewLabel_3 = new JLabel("Categoria");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 296, 79, 25);
		contentPane.add(lblNewLabel_3);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(10, 321, 497, 20);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Tempo");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(53, 352, 46, 25);
		contentPane.add(lblNewLabel_4);
		
		JSpinner spnTempo = new JSpinner();
		spnTempo.setBounds(57, 377, 42, 41);
		contentPane.add(spnTempo);
		
		JLabel lblNewLabel_5 = new JLabel("Imagem");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(188, 352, 57, 25);
		contentPane.add(lblNewLabel_5);
		
		JRadioButton rdbtn2D = new JRadioButton("2D");
		rdbtn2D.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtn2D.setBounds(162, 384, 57, 23);
		contentPane.add(rdbtn2D);
		
		JRadioButton rdbtn3D = new JRadioButton("3D");
		rdbtn3D.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtn3D.setBounds(234, 384, 46, 23);
		contentPane.add(rdbtn3D);
		
		ButtonGroup imagem = new ButtonGroup();
		imagem.add(rdbtn2D);
		imagem.add(rdbtn3D);
		
		JLabel lblNewLabel_6 = new JLabel("Audio");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(380, 357, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JRadioButton rdbtnDublado = new JRadioButton("Dublado");
		rdbtnDublado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnDublado.setBounds(320, 384, 79, 23);
		contentPane.add(rdbtnDublado);
		
		JRadioButton rdbtnLegendado = new JRadioButton("Legendado");
		rdbtnLegendado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnLegendado.setBounds(398, 384, 109, 23);
		contentPane.add(rdbtnLegendado);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Filme f = new Filme();
				FilmeDAO dao = new FilmeDAO();
				f.setTitulo(txtTitulo.getText());
				f.setSinopse(txtSinopse.getText());
				f.setCategoria(txtCategoria.getText());
				f.setTempo(Integer.parseInt(spnTempo.getValue().toString()));
				if (rdbtn2D.isSelected()) {
					f.setImagem3d(false);
				} else if (rdbtn3D.isSelected()) {
					f.setImagem3d(true);
				}
				if (rdbtnDublado.isSelected()) {
					f.setDublado(true);
				} else if (rdbtnLegendado.isSelected()) {
					f.setDublado(false);
				}
				dao.create(f);

			}
		});
		btnCadastrar.setBounds(39, 440, 94, 36);
		contentPane.add(btnCadastrar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(285, 439, 101, 38);
		contentPane.add(btnLimpar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancelar.setBounds(158, 439, 101, 38);
		contentPane.add(btnCancelar);
	}
}
