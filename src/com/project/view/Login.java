package com.project.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passwordContraseña;

	public void Limpiar() {

		txtUsuario.setText("");
		passwordContraseña.setText("");

	}

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Usuario\\eclipse-workspace\\System_Venta\\src\\com\\project\\img\\Logo-autonoma.png"));
		lblNewLabel_1.setBounds(475, 0, 709, 143);
		contentPane.add(lblNewLabel_1);

		JLabel lblTitulo = new JLabel("Login");
		lblTitulo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 67));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(-483, 0, 1164, 71);
		contentPane.add(lblTitulo);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblUsuario.setBounds(525, 166, 168, 44);
		contentPane.add(lblUsuario);

		JLabel lblContraseña = new JLabel("Contrase\u00F1a");
		lblContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		lblContraseña.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblContraseña.setBounds(525, 229, 175, 44);
		contentPane.add(lblContraseña);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(742, 167, 229, 44);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		passwordContraseña = new JPasswordField();
		passwordContraseña.setBounds(742, 233, 229, 38);
		contentPane.add(passwordContraseña);

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setIcon(new ImageIcon("C:\\Users\\Usuario\\eclipse-workspace\\System_Venta\\src\\com\\project\\img\\hive-regular-24.png"));
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// get llama
				// set imprime
				String usuario = txtUsuario.getText();
				String contraseña = passwordContraseña.getText();

				try {

					if (usuario.isEmpty() || contraseña.isEmpty()) {

						JOptionPane.showMessageDialog(null, "Complete la informacion");

					} else {

						if (usuario.equals("admin") && contraseña.equals("1234")) {
							JOptionPane.showMessageDialog(null, "Bienvenido...");
							Menu P = new Menu();
							P.setVisible(true);
							P.setLocationRelativeTo(null);
							P.setTitle("Registro");
						} else if (usuario.equals("stiven@test.com") && contraseña.equals("12345")) {
							JOptionPane.showMessageDialog(null, "Bienvenido");
							Menu P = new Menu();
							P.setVisible(true);
							P.setLocationRelativeTo(null);
							P.setTitle("Registro");
						}

					}

				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showConfirmDialog(null, "Informacion incorreta");
				}

				Limpiar();
			}
		});
		btnIngresar.setBounds(623, 306, 191, 44);
		contentPane.add(btnIngresar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(
				"C:\\Users\\Usuario\\eclipse-workspace\\Sistema_Venta\\src\\com\\project\\img\\window-close-regular-24.png"));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.exit(0);

			}
		});
		btnSalir.setBounds(878, 306, 191, 44);
		contentPane.add(btnSalir);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\eclipse-workspace\\System_Venta\\src\\com\\project\\img\\pngtree-simple-flat-geometric-atmosphere-hand-close-up-user-landing-background-picture-image_1057406.jpg"));
		lblNewLabel.setBounds(0, 0, 1184, 461);
		contentPane.add(lblNewLabel);

	}

}
