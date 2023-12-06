package com.project.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import com.project.model.Cliente;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class SecClien extends JFrame {

	private JPanel contentPane;
	private JTextField txtEdad;
	private JTextField txtNombre;
	private JTextField txtDni;
	private JTable tableClientes;
	private ArrayList<Cliente> list_C;

	public void LimpiarClientes() {

		txtDni.setText("");
		txtEdad.setText("");
		txtNombre.setText("");

	}

	public void VerDatosCliente() {

		String Mat[][] = new String[list_C.size()][3];
		Cliente client;

		for (int i = 0; i < Mat.length; i++) {

			client = list_C.get(i);
			Mat[i][0] = Integer.toString(client.getId_cliente());
			Mat[i][1] = client.getNombre();
			Mat[i][2] = Integer.toString(client.getEdad());

		}

		tableClientes.setModel(new DefaultTableModel(Mat, new String[] { "Id_Cliente", "Nombre", "Edad" }));

	}

	public SecClien() {
		list_C = new ArrayList<>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 806);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBackground(Color.BLACK);
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNombre.setBounds(40, 204, 100, 40);
		contentPane.add(lblNombre);

		JLabel lblIdcliente = new JLabel("Dni");
		lblIdcliente.setBackground(Color.BLACK);
		lblIdcliente.setForeground(Color.BLACK);
		lblIdcliente.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblIdcliente.setBounds(40, 153, 87, 40);
		contentPane.add(lblIdcliente);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBackground(Color.BLACK);
		lblEdad.setForeground(Color.BLACK);
		lblEdad.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEdad.setBounds(40, 255, 87, 40);
		contentPane.add(lblEdad);

		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(210, 255, 185, 40);
		contentPane.add(txtEdad);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(210, 204, 185, 38);
		contentPane.add(txtNombre);

		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(210, 154, 185, 38);
		contentPane.add(txtDni);

		tableClientes = new JTable();
		tableClientes
				.setModel(new DefaultTableModel(
						new Object[][] { { "Dni", "Nombre", "Edad" }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, },
						new String[] { "Dni", "Nombre", "Edad" }));
		tableClientes.setForeground(Color.BLACK);
		tableClientes.setBackground(Color.LIGHT_GRAY);
		tableClientes.setBounds(438, 168, 471, 156);
		contentPane.add(tableClientes);

		JLabel lblNewLabel = new JLabel("Lista de Clientes");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 38));
		lblNewLabel.setBounds(438, 109, 475, 48);
		contentPane.add(lblNewLabel);

		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBackground(Color.BLACK);
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setForeground(Color.BLACK);
		lblCliente.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblCliente.setBounds(109, 112, 166, 40);
		contentPane.add(lblCliente);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre;
				int Id_Cliente, edad;

				try {

					nombre = txtNombre.getText();
					Id_Cliente = Integer.parseInt(txtDni.getText());
					edad = Integer.parseInt(txtEdad.getText());

					list_C.add(new Cliente(Id_Cliente, nombre, edad));

				} catch (Exception e2) {

					JOptionPane.showMessageDialog(null, "Inserte de forma correcta los datos...");
				}

				LimpiarClientes();
				VerDatosCliente();

			}
		});
		btnAgregar.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnAgregar.setBackground(SystemColor.activeCaptionBorder);
		btnAgregar.setBounds(1008, 186, 166, 40);
		contentPane.add(btnAgregar);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente client;
				int fila_determinada, edad, Id_Cliente;
				String nombre;

				try {

					fila_determinada = tableClientes.getSelectedRow();
					client = list_C.get(fila_determinada);

					String determinado = JOptionPane.showInputDialog("Columna para modificar? \nNombre \nDni \nEdad");
					switch (determinado.toLowerCase()) {
					case "nombre":
						nombre = JOptionPane.showInputDialog("Nuevo nombre");
						client.setNombre(nombre);

						break;

					case "dni":
						Id_Cliente = Integer.parseInt(JOptionPane.showInputDialog("Nuevo Dni"));
						client.setId_cliente(Id_Cliente);
						break;

					case "edad":

						edad = Integer.parseInt(JOptionPane.showInputDialog("Nueva edad"));
						client.setEdad(edad);

						break;
					default:
						JOptionPane.showMessageDialog(null, "No se encuentra la columna para modificar");
						break;
					}

				} catch (Exception e2) {
					// TODO: handle exception

					JOptionPane.showMessageDialog(null, "Selecione fila para modificar");
				}

				VerDatosCliente();

			}
		});
		btnModificar.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnModificar.setBackground(SystemColor.activeCaptionBorder);
		btnModificar.setBounds(1008, 253, 166, 40);
		contentPane.add(btnModificar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SecClien client;
				int eliminar_fila;

				try {

					eliminar_fila = tableClientes.getSelectedRow();
					list_C.remove(eliminar_fila);

				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Seleecione fila para eliminar");

				}

				VerDatosCliente();
			}
		});
		btnEliminar.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnEliminar.setBackground(SystemColor.activeCaptionBorder);
		btnEliminar.setBounds(1008, 297, 166, 40);
		contentPane.add(btnEliminar);
	}
}
