package br.com.prog2.trabalhoFinal.view;

import java.awt.EventQueue;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.prog2.trabalhoFinal.controller.HospedagemController;
import br.com.prog2.trabalhoFinal.negocio.Hospedagem;
import br.com.prog2.trabalhoFinal.util.Util;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmHospedagem extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblConsulta;
	private JTextField txtCodHospedagem;
	private JTextField txtCodChale;
	private JTextField txtEstado;
	private JFormattedTextField txtDataInicio;
	private JFormattedTextField txtDataFim;
	private JTextField txtQtdPessoas;
	private JTextField txtDesconto;
	private JTextField txtValorFinal;

	private MaskFormatter mascaraData = null;
	private JLabel lblMensagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmHospedagem frame = new FrmHospedagem();
					frame.setTitle("Cadastro de hospedagens");
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
	public FrmHospedagem() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();

		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 637, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 639, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 184, Short.MAX_VALUE)));

		JLabel lblCodhospedagem = new JLabel("CodHospedagem");

		txtCodHospedagem = new JTextField();
		txtCodHospedagem.setColumns(10);

		JLabel lblCodchale = new JLabel("CodChale");

		txtCodChale = new JTextField();
		txtCodChale.setColumns(10);

		JLabel lblEstado = new JLabel("Estado");

		txtEstado = new JTextField();
		txtEstado.setColumns(10);

		JLabel lblDatainicio = new JLabel("DataInicio");

		JLabel lblDatafim = new JLabel("DataFim");

		JLabel lblQtdpessoas = new JLabel("QtdPessoas");

		txtQtdPessoas = new JTextField();
		txtQtdPessoas.setColumns(10);

		JLabel lblDesconto = new JLabel("Desconto");

		txtDesconto = new JTextField();
		txtDesconto.setColumns(10);

		JLabel lblValorfinal = new JLabel("ValorFinal");

		txtValorFinal = new JTextField();
		txtValorFinal.setColumns(10);

		lblMensagem = new JLabel("Mensagem");
		lblMensagem.setForeground(Color.BLUE);
		try {
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			System.err.println(e.getMessage());
		}
		txtDataInicio = new JFormattedTextField(mascaraData);

		txtDataFim = new JFormattedTextField(mascaraData);

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblCodhospedagem)
								.addComponent(lblCodchale).addComponent(lblEstado).addComponent(lblDatainicio)
								.addComponent(lblDatafim).addComponent(lblQtdpessoas).addComponent(lblDesconto)
								.addComponent(lblValorfinal))
						.addGap(67)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtDataFim, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDataInicio, GroupLayout.PREFERRED_SIZE, 129,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtValorFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDesconto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtQtdPessoas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCodChale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCodHospedagem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblMensagem))
				.addContainerGap(326, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup()
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblCodhospedagem).addComponent(
						txtCodHospedagem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblCodchale).addComponent(
						txtCodChale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblEstado).addComponent(
						txtEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel
						.createParallelGroup(Alignment.BASELINE).addComponent(lblDatainicio).addComponent(txtDataInicio,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblDatafim).addComponent(
						txtDataFim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel
						.createParallelGroup(Alignment.BASELINE).addComponent(lblQtdpessoas).addComponent(txtQtdPessoas,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblDesconto).addComponent(
						txtDesconto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtValorFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblValorfinal, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblMensagem)
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JButton btnInserir = new JButton("Inserir");
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hospedagem hosp = new Hospedagem();
				HospedagemController hc = new HospedagemController();
				hosp.setCodHospedagem(txtCodHospedagem.getText());
				hosp.setCodChale(txtCodChale.getText());
				hosp.setEstado(txtEstado.getText());
				int[] dataFormatada = Util.formatarDataDeGuiParaLocalDate(txtDataInicio.getText());
				hosp.setDataInicio(LocalDate.of(dataFormatada[2], dataFormatada[1],dataFormatada[0]));
				dataFormatada = Util.formatarDataDeGuiParaLocalDate(txtDataFim.getText());
				hosp.setDataFim(LocalDate.of(dataFormatada[2], dataFormatada[1],dataFormatada[0]));
				hosp.setQtdPessoas(Integer.parseInt(txtQtdPessoas.getText()));
				hosp.setDesconto(Double.parseDouble(txtDesconto.getText()));
				hosp.setValorFinal(Double.parseDouble(txtValorFinal.getText()));
				lblMensagem.setText(hc.inserir(hosp));
			}
		});

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hospedagem hosp = new Hospedagem();
				HospedagemController hc = new HospedagemController();
				hosp.setCodHospedagem(txtCodHospedagem.getText());
				hosp.setCodChale(txtCodChale.getText());
				hosp.setEstado(txtEstado.getText());
				int[] dataFormatada = Util.formatarDataDeGuiParaLocalDate(txtDataInicio.getText());
				hosp.setDataInicio(LocalDate.of(dataFormatada[2], dataFormatada[1],dataFormatada[0]));
				dataFormatada = Util.formatarDataDeGuiParaLocalDate(txtDataFim.getText());
				hosp.setDataFim(LocalDate.of(dataFormatada[2], dataFormatada[1],dataFormatada[0]));
				hosp.setQtdPessoas(Integer.parseInt(txtQtdPessoas.getText()));
				hosp.setDesconto(Double.parseDouble(txtDesconto.getText()));
				hosp.setValorFinal(Double.parseDouble(txtValorFinal.getText()));
				lblMensagem.setText(hc.alterar(hosp));
			}
		});

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Hospedagem> listahosp = new ArrayList<>();
				HospedagemController hc = new HospedagemController();
				listahosp = hc.listarTodos();
				DefaultTableModel tbm = (DefaultTableModel)tblConsulta.getModel();
				for(int i = tbm.getRowCount()-1; i >= 0; i--){
					tbm.removeRow(i);
					}
					int i = 0;
					for(Hospedagem ep : listahosp){
						tbm.addRow(new String[1]);
						tblConsulta.setValueAt(ep.getCodHospedagem(), i, 0);
						tblConsulta.setValueAt(ep.getCodChale(), i, 1);
						tblConsulta.setValueAt(ep.getEstado(), i, 2);
						tblConsulta.setValueAt(ep.getDataInicio(), i, 3);
						tblConsulta.setValueAt(ep.getDataFim(), i, 4);
						tblConsulta.setValueAt(ep.getQtdPessoas(), i, 5);
						tblConsulta.setValueAt(ep.getDesconto(), i, 6);
						tblConsulta.setValueAt(ep.getValorFinal(), i, 7);
						i++;
					}
			}
		});

		JButton btnExlcuir = new JButton("Exlcuir");
		btnExlcuir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hospedagem hosp = new Hospedagem();
				HospedagemController hc = new HospedagemController();
				hosp.setCodHospedagem(txtCodHospedagem.getText());
				Object[] opcoes = { "Sim", "Não" };
				int i = JOptionPane.showOptionDialog(null,
				"Deseja excluir essa hospedagem: "+txtCodHospedagem.getText()+"?","Exclusão",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,opcoes, opcoes[0]);
				if(JOptionPane.YES_OPTION == i){
					lblMensagem.setText(hc.excluir(hosp));
					}
			}
		});

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCodHospedagem.setText("");
				txtCodChale.setText("");
				txtEstado.setText("");
				txtDataInicio.setText("");
				txtDataFim.setText("");
				txtQtdPessoas.setText("");
				txtDesconto.setText("");
				txtValorFinal.setText("");
				DefaultTableModel tbm =
				(DefaultTableModel)tblConsulta.getModel();
				for(int i = tbm.getRowCount()-1; i >= 0; i--){
				tbm.removeRow(i);
				}
			}
		});

		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmHospedagem.this.dispose();
				
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_1.createSequentialGroup().addContainerGap().addComponent(btnInserir).addGap(29)
						.addComponent(btnAlterar).addGap(35).addComponent(btnPesquisar)
						.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE).addComponent(btnExlcuir)
						.addGap(21).addComponent(btnLimpar).addGap(18).addComponent(btnSair).addContainerGap()));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_1.createSequentialGroup().addContainerGap(13, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(btnSair)
								.addComponent(btnInserir).addComponent(btnAlterar).addComponent(btnPesquisar)
								.addComponent(btnExlcuir).addComponent(btnLimpar))
						.addContainerGap()));
		panel_1.setLayout(gl_panel_1);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE).addContainerGap()));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap(23, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
						.addGap(1)));

		tblConsulta = new JTable();
		tblConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer linha = tblConsulta.getSelectedRow();
				String codHospedagem = tblConsulta.getValueAt(linha, 0).toString();
				String codChale = tblConsulta.getValueAt(linha, 0).toString();
				String estado = tblConsulta.getValueAt(linha, 0).toString();
				String dataInicio = tblConsulta.getValueAt(linha, 0).toString();
				String dataFim = tblConsulta.getValueAt(linha, 0).toString();
				String qtdPessoas = tblConsulta.getValueAt(linha, 0).toString();
				String desconto = tblConsulta.getValueAt(linha, 0).toString();
				String valorFinal = tblConsulta.getValueAt(linha, 0).toString();
				
				txtCodHospedagem.setText(codHospedagem);
				txtCodChale.setText(codChale);
				txtEstado.setText(estado);
				txtDataInicio.setText(dataInicio);
				txtDataFim.setText(dataFim);
				txtQtdPessoas.setText(qtdPessoas);
				txtDesconto.setText(desconto);
				txtValorFinal.setText(valorFinal);

			}
		});
		tblConsulta.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "CodHospedagem", "CodChale", "Estado",
				"DataInicio", "DataFim", "QntPessoas", "Desconto", "ValorFinal" }) {
			/**
					 * 
					 */
					private static final long serialVersionUID = 1L;
			Class<?>[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					Integer.class, Double.class, Double.class };

			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblConsulta.getColumnModel().getColumn(0).setResizable(false);
		tblConsulta.getColumnModel().getColumn(1).setResizable(false);
		tblConsulta.getColumnModel().getColumn(2).setResizable(false);
		tblConsulta.getColumnModel().getColumn(3).setResizable(false);
		tblConsulta.getColumnModel().getColumn(4).setResizable(false);
		tblConsulta.getColumnModel().getColumn(5).setResizable(false);
		tblConsulta.getColumnModel().getColumn(6).setResizable(false);
		tblConsulta.getColumnModel().getColumn(7).setResizable(false);
		scrollPane.setViewportView(tblConsulta);
		panel_2.setLayout(gl_panel_2);
		contentPane.setLayout(gl_contentPane);
	}
}
