package br.com.prog2.trabalhoFinal.view;

import javax.swing.table.DefaultTableModel;

import br.com.prog2.trabalhoFinal.controller.ChaleController;
import br.com.prog2.trabalhoFinal.negocio.Chale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class FrmChale extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblConsulta;
	private JTextField txtCodChale;
	private JTextField txtLocalizacao;
	private JTextField txtCapacidade;
	private JTextField txtValorAltaEstacao;
	private JTextField txtValorBaixaEstacao;

	private JLabel lblMensagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmChale frame = new FrmChale();
					frame.setTitle("Cadastro de chale");
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
	public FrmChale() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();

		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE).addGap(3))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(3)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))));
		gl_contentPane
				.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_contentPane.createSequentialGroup()
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING).addComponent(scrollPane,
				Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE));
		gl_panel_2.setVerticalGroup(
				gl_panel_2.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_2.createSequentialGroup()
						.addContainerGap().addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)));

		tblConsulta = new JTable();
		tblConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer linha = tblConsulta.getSelectedRow();
				String CodChale = tblConsulta.getValueAt(linha, 0).toString();
				String Localizacao = tblConsulta.getValueAt(linha, 1).toString();
				String Capacidade = tblConsulta.getValueAt(linha, 2).toString();
				String ValorAltaEstacao = tblConsulta.getValueAt(linha, 3).toString();
				String ValorBaixaEstacao = tblConsulta.getValueAt(linha, 4).toString();
				txtCodChale.setText(CodChale);
				txtLocalizacao.setText(Localizacao);
				txtCapacidade.setText(Capacidade);
				txtValorAltaEstacao.setText(ValorAltaEstacao);
				txtValorBaixaEstacao.setText(ValorBaixaEstacao);
			}
		});
		tblConsulta.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "CodChale", "Localizacao", "Capacidade", "ValorAltaEstacao", "ValorBaixaEstacao" }) {
			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;
			Class <?>[] columnTypes = new Class[] { String.class, String.class, Integer.class, Double.class, Double.class };

			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblConsulta.getColumnModel().getColumn(0).setResizable(false);
		tblConsulta.getColumnModel().getColumn(1).setResizable(false);
		tblConsulta.getColumnModel().getColumn(2).setResizable(false);
		tblConsulta.getColumnModel().getColumn(3).setResizable(false);
		tblConsulta.getColumnModel().getColumn(4).setResizable(false);
		scrollPane.setViewportView(tblConsulta);
		panel_2.setLayout(gl_panel_2);

		JButton btnInserir = new JButton("Inserir");
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChaleController co = new ChaleController();
				Chale ch = new Chale();
				ch.setCodChale(txtCodChale.getText());
				ch.setLocalizacao(txtLocalizacao.getText());
				ch.setCapacidade(Integer.parseInt(txtCapacidade.getText()));
				ch.setValorAltaEstacao(Double.parseDouble(txtValorAltaEstacao.getText()));
				ch.setValorBaixaEstacao(Double.parseDouble(txtValorBaixaEstacao.getText()));

				lblMensagem.setText(co.inserir(ch));
			}
		});

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChaleController co = new ChaleController();
				Chale ch = new Chale();
				ch.setCodChale(txtCodChale.getText());
				ch.setLocalizacao(txtLocalizacao.getText());
				ch.setCapacidade(Integer.parseInt(txtCapacidade.getText()));
				ch.setValorAltaEstacao(Double.parseDouble(txtValorAltaEstacao.getText()));
				ch.setValorBaixaEstacao(Double.parseDouble(txtValorBaixaEstacao.getText()));

				lblMensagem.setText(co.alterar(ch));
			}
		});

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Chale> listach = new ArrayList<>();
				ChaleController ec = new ChaleController();
				listach = ec.listarTodos();
				DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
				for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
					tbm.removeRow(i);
				}
				int i = 0;
				for (Chale ep : listach) {
					tbm.addRow(new String[1]);

					tblConsulta.setValueAt(ep.getCodChale(), i, 0);
					tblConsulta.setValueAt(ep.getLocalizacao(), i, 1);
					tblConsulta.setValueAt(ep.getCapacidade(), i, 2);
					tblConsulta.setValueAt(ep.getValorAltaEstacao(), i, 3);
					tblConsulta.setValueAt(ep.getValorBaixaEstacao(), i, 4);
					i++;
				}
			}
		});

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chale ch = new Chale();
				ChaleController ec = new ChaleController();
				ch.setCodChale(txtCodChale.getText());
				Object[] opcoes = { "Sim", "Não" };
				int i = JOptionPane.showOptionDialog(null,"Deseja excluir esse chale: "+txtCodChale.getText()+"?","Exclusão",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,opcoes, opcoes[0]);
				if(JOptionPane.YES_OPTION == i){
					lblMensagem.setText(ec.excluir(ch));
					}
			}
		});

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCodChale.setText("");
				txtLocalizacao.setText("");
				txtCapacidade.setText("");
				txtValorAltaEstacao.setText("");
				txtValorBaixaEstacao.setText("");
				DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
				for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
					tbm.removeRow(i);
				}
			}
		});

		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmChale.this.dispose();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(6).addComponent(btnInserir)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnAlterar)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnPesquisar)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnExcluir)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnLimpar)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnSair)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(btnAlterar)
								.addComponent(btnPesquisar).addComponent(btnExcluir).addComponent(btnLimpar)
								.addComponent(btnSair).addComponent(btnInserir))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		JLabel lblCodChale = new JLabel("Codigo chale");

		txtCodChale = new JTextField();
		txtCodChale.setColumns(10);

		JLabel lblLocalizaccao = new JLabel("Localizacao");

		JLabel lblCapacidade = new JLabel("Capacidade");

		JLabel lblValoraltaestacao = new JLabel("ValorAltaEstacao");

		JLabel lblValorbaixaestacao = new JLabel("ValorBaixaEstacao");

		txtLocalizacao = new JTextField();
		txtLocalizacao.setColumns(10);

		txtCapacidade = new JTextField();
		txtCapacidade.setText("");
		txtCapacidade.setColumns(10);

		txtValorAltaEstacao = new JTextField();
		txtValorAltaEstacao.setText("");
		txtValorAltaEstacao.setColumns(10);

		txtValorBaixaEstacao = new JTextField();
		txtValorBaixaEstacao.setText("");
		txtValorBaixaEstacao.setColumns(10);

		lblMensagem = new JLabel("Mensagem");
		lblMensagem.setForeground(Color.MAGENTA);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblValorbaixaestacao)
								.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblCodChale).addComponent(lblLocalizaccao)
												.addComponent(lblCapacidade).addComponent(lblValoraltaestacao))
										.addGap(43)
										.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
												.addComponent(txtCodChale, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtValorBaixaEstacao, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtLocalizacao, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtCapacidade, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtValorAltaEstacao, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblMensagem))
						.addContainerGap(256, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup()
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblCodChale).addComponent(
						txtCodChale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblLocalizaccao).addComponent(
						txtLocalizacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel
						.createParallelGroup(Alignment.BASELINE).addComponent(lblCapacidade).addComponent(txtCapacidade,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblValoraltaestacao)
						.addComponent(txtValorAltaEstacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblValorbaixaestacao)
						.addComponent(txtValorBaixaEstacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(lblMensagem).addContainerGap(18, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
