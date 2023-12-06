package com.project.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;

public class Menu extends JFrame {

	private JPanel contentPane;

	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 806);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Cliente");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 63));
		mnNewMenu.setIcon(new ImageIcon(
				"C:\\Users\\Usuario\\eclipse-workspace\\Sistema_Venta\\System_Hospital\\src\\main\\java\\com\\project\\img\\add-to-queue-solid-24.png"));
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Clientes");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SecClien S = new SecClien();
				S.setVisible(true);
				S.setLocationRelativeTo(null);
				S.setTitle("INGRESO DE CLIENTES");

			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_1 = new JMenu("Venta");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("Ventas");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SecVentas V = new SecVentas();
				V.setVisible(true);
				V.setLocationRelativeTo(null);
				V.setTitle("SECTOR VENTA");
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\Usuario\\eclipse-workspace\\Sistema_Venta\\System_Hospital\\src\\main\\java\\com\\project\\img\\12620.jpg"));
		lblNewLabel.setBounds(0, 0, 1184, 737);
		contentPane.add(lblNewLabel);
	}
}
