package br.com.prog2.trabalhoFinal.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
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
	public FrmPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadrastro = new JMenu("Cadrastro");
		menuBar.add(mnCadrastro);
		
		JMenuItem mntmChale = new JMenuItem("Chale");
		mntmChale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmChale ch = new FrmChale();
				ch.setVisible(true);
			}
		});
		mnCadrastro.add(mntmChale);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JMenuItem mntmHospedagem = new JMenuItem("Hospedagem");
		mntmHospedagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmHospedagem fh = new FrmHospedagem();
				fh.setVisible(true);
			}
		});
		mnCadrastro.add(mntmHospedagem);
		mnCadrastro.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 440, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 265, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}

}
