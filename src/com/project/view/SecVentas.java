package com.project.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import com.project.model.Cliente;
import com.project.model.Producto;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class SecVentas extends JFrame {

	private JPanel contentPane;

	private JTextField txtIdProducto;
	private JTextField txtNombreProducto;
	private JTextField txtPrecio;
	private JTable tableProductos;

	private ArrayList<Producto> list_P;
	private JTextField txtCantidad;
	private JTextField txtDescuento;
	private JTextField txtImporte;
	private JTextField txtPagoFinal;

	public void LimpiarProductos() {

		txtIdProducto.setText("");
		txtNombreProducto.setText("");
		txtPrecio.setText("");

	}

	public void VerDatosProducto() {

		String Pro[][] = new String[list_P.size()][3];
		Producto product;

		for (int i = 0; i < Pro.length; i++) {

			product = list_P.get(i);
			Pro[i][0] = Integer.toString(product.getId_producto());
			Pro[i][1] = product.getNombre_producto();
			Pro[i][2] = Double.toString(product.getPrecio());

		}

		tableProductos.setModel(new DefaultTableModel(Pro, new String[] { "Id Producto", "Nombre", "Precio" }));

	}

	public SecVentas() {

		list_P = new ArrayList<>();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 806);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Sistema Venta");
		lblTitulo.setForeground(SystemColor.text);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 73));
		lblTitulo.setBounds(0, 0, 1206, 85);
		contentPane.add(lblTitulo);

		JPanel panel = new JPanel();
		panel.setBackground(new java.awt.Color(0, 0, 0, 1));
		panel.setBounds(10, 96, 640, 645);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblTitul = new JLabel("Productos");
		lblTitul.setForeground(Color.BLACK);
		lblTitul.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitul.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTitul.setBounds(54, 9, 317, 39);
		panel.add(lblTitul);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPrecio.setBounds(10, 305, 78, 39);
		panel.add(lblPrecio);

		JLabel lblIdProducto = new JLabel("Id Producto");
		lblIdProducto.setForeground(Color.BLACK);
		lblIdProducto.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblIdProducto.setBounds(0, 174, 106, 39);
		panel.add(lblIdProducto);

		JLabel lblNombreProducto = new JLabel("Nombre");
		lblNombreProducto.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNombreProducto.setBounds(10, 236, 93, 39);
		panel.add(lblNombreProducto);

		txtIdProducto = new JTextField();
		txtIdProducto.setBounds(160, 176, 188, 39);
		panel.add(txtIdProducto);
		txtIdProducto.setColumns(10);

		txtNombreProducto = new JTextField();
		txtNombreProducto.setColumns(10);
		txtNombreProducto.setBounds(160, 238, 188, 39);
		panel.add(txtNombreProducto);

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(160, 307, 188, 39);
		panel.add(txtPrecio);

		JButton btnAgregarPro = new JButton("Agregar");
		btnAgregarPro.setBackground(SystemColor.activeCaptionBorder);
		btnAgregarPro.setIcon(new ImageIcon(
				"C:\\Users\\Usuario\\eclipse-workspace\\System_Venta\\src\\com\\project\\img\\add-to-queue-solid-24.png"));
		btnAgregarPro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nombreProducto;
				double precio;
				int id_Producto;

				try {

					id_Producto = Integer.parseInt(txtIdProducto.getText());
					nombreProducto = txtNombreProducto.getText();
					precio = Double.parseDouble(txtPrecio.getText());

					list_P.add(new Producto(id_Producto, nombreProducto, precio));

				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Ingrese correctamente los datos....");
				}

				VerDatosProducto();

			}
		});
		btnAgregarPro.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnAgregarPro.setBounds(418, 172, 177, 39);
		panel.add(btnAgregarPro);

		JButton btnModificarPro = new JButton("Modificar");
		btnModificarPro.setBackground(SystemColor.activeCaptionBorder);
		btnModificarPro.setIcon(new ImageIcon(
				"C:\\Users\\Usuario\\eclipse-workspace\\System_Venta\\src\\com\\project\\img\\edit-regular-24.png"));
		btnModificarPro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Producto producto;
				int fila_determinada;
				String nombre;
				int id_Producto;
				double precio;

				try {

					fila_determinada = tableProductos.getSelectedRow();
					producto = list_P.get(fila_determinada);

					String selecion = JOptionPane
							.showInputDialog("Columna para modificar.. \nId_Producto \nNombre \nPrecio");

					switch (selecion.toLowerCase()) {
					case "id_producto":
						id_Producto = Integer.parseInt(JOptionPane.showInputDialog("Nuevo Id"));
						producto.setId_producto(id_Producto);
						break;
					case "nombre":
						nombre = JOptionPane.showInputDialog("Nuevo nombre");
						producto.setNombre_producto(nombre);
						break;
					case "precio":
						precio = Double.parseDouble(JOptionPane.showInputDialog("Nuevo precio"));
						producto.setPrecio(precio);
						break;
					default:

						JOptionPane.showMessageDialog(null, "No se encuentra la fila....");

						break;
					}

				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Elija fila para modificar.");
				}

				VerDatosProducto();

			}
		});
		btnModificarPro.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnModificarPro.setBounds(418, 234, 177, 39);
		panel.add(btnModificarPro);

		JButton btnEliminarPro = new JButton("Eliminar");
		btnEliminarPro.setBackground(SystemColor.activeCaptionBorder);
		btnEliminarPro.setIcon(new ImageIcon(
				"C:\\Users\\Usuario\\eclipse-workspace\\System_Venta\\src\\com\\project\\img\\message-alt-minus-solid-24.png"));
		btnEliminarPro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Producto producto;
				int eliminar_fila;

				try {

					eliminar_fila = tableProductos.getSelectedRow();
					list_P.remove(eliminar_fila);

				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Elija la fila para eliminar.");
				}

				VerDatosProducto();

			}
		});
		btnEliminarPro.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnEliminarPro.setBounds(418, 307, 177, 39);
		panel.add(btnEliminarPro);

		tableProductos = new JTable();
		tableProductos.setModel(new DefaultTableModel(
				new Object[][] { { "Id Producto", "Nombre", "Precio" }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null }, },
				new String[] { "Id Producto", "Nombre", "Precio" }));
		tableProductos.setBackground(Color.LIGHT_GRAY);
		tableProductos.setBounds(47, 450, 568, 171);
		panel.add(tableProductos);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setIcon(new ImageIcon(
				"C:\\Users\\Usuario\\eclipse-workspace\\System_Venta\\src\\com\\project\\img\\icons8-escoba-64.png"));
		btnLimpiar.setBackground(SystemColor.activeCaptionBorder);
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LimpiarProductos();

			}
		});
		btnLimpiar.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnLimpiar.setBounds(407, 378, 188, 39);
		panel.add(btnLimpiar);

		JPanel panelCalculos = new JPanel();
		panelCalculos.setBackground(new java.awt.Color(0, 0, 0, 1));
		panelCalculos.setBounds(700, 96, 457, 645);
		contentPane.add(panelCalculos);
		panelCalculos.setLayout(null);

		JLabel lblPago = new JLabel("Pago");
		lblPago.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblPago.setHorizontalAlignment(SwingConstants.CENTER);
		lblPago.setBounds(100, 11, 205, 35);
		panelCalculos.add(lblPago);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblCantidad.setBounds(10, 80, 127, 45);
		panelCalculos.add(lblCantidad);

		JSpinner spCantidad = new JSpinner();
		spCantidad.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				txtCantidad.setText(spCantidad.getValue().toString());

			}
		});
		spCantidad.setBounds(169, 86, 89, 45);
		panelCalculos.add(spCantidad);

		txtCantidad = new JTextField();
		txtCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantidad.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txtCantidad.setBounds(169, 142, 86, 45);
		panelCalculos.add(txtCantidad);
		txtCantidad.setColumns(10);

		JLabel lblDescuento = new JLabel("Descuento");
		lblDescuento.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblDescuento.setBounds(10, 494, 147, 45);
		panelCalculos.add(lblDescuento);

		txtDescuento = new JTextField();
		txtDescuento.setHorizontalAlignment(SwingConstants.CENTER);
		txtDescuento.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		txtDescuento.setColumns(10);
		txtDescuento.setBounds(169, 501, 89, 39);
		panelCalculos.add(txtDescuento);

		JButton btnCalculo = new JButton("Calculo");
		btnCalculo.setIcon(new ImageIcon(
				"C:\\Users\\Usuario\\eclipse-workspace\\System_Venta\\src\\com\\project\\img\\icons8-retirada-64.png"));
		btnCalculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double cantidad, precio, importe;

				try {

					cantidad = Double.parseDouble(txtCantidad.getText());
					precio = Double.parseDouble(txtPrecio.getText());

					importe = cantidad * precio;

					txtImporte.setText(String.valueOf(importe));

				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Faltan datos.......");
				}

			}
		});
		btnCalculo.setBackground(SystemColor.activeCaptionBorder);
		btnCalculo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnCalculo.setBounds(289, 434, 168, 60);
		panelCalculos.add(btnCalculo);

		JLabel lblImporte = new JLabel("Importe");
		lblImporte.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblImporte.setBounds(10, 427, 127, 45);
		panelCalculos.add(lblImporte);

		txtImporte = new JTextField();
		txtImporte.setHorizontalAlignment(SwingConstants.CENTER);
		txtImporte.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		txtImporte.setColumns(10);
		txtImporte.setBounds(169, 434, 89, 39);
		panelCalculos.add(txtImporte);

		JButton btnDescuento = new JButton("Descuento");
		btnDescuento.setIcon(new ImageIcon(
				"C:\\Users\\Usuario\\eclipse-workspace\\System_Venta\\src\\com\\project\\img\\icons8-buscador-de-descuento-64.png"));
		btnDescuento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double importe, descuento, cantidad;
				importe = Double.parseDouble(txtImporte.getText());
				cantidad = Integer.parseInt(txtCantidad.getText());

				try {

					if (cantidad > 5 && cantidad < 10) {
						// 5%
						descuento = importe * 0.05;
						txtDescuento.setText(String.valueOf(descuento));
					} else if (cantidad > 10 && cantidad < 15) {
						// 10%
						descuento = importe * 0.1;
						txtDescuento.setText(String.valueOf(descuento));
					} else if (cantidad > 15 && cantidad < 20) {
						// 15%
						descuento = importe * 0.15;
						txtDescuento.setText(String.valueOf(descuento));
					}

				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Informacion fallida...");
				}

			}
		});
		btnDescuento.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnDescuento.setBackground(SystemColor.activeCaptionBorder);
		btnDescuento.setBounds(266, 333, 191, 60);
		panelCalculos.add(btnDescuento);

		JButton btnPagoFinal = new JButton("Pago final");
		btnPagoFinal.setIcon(new ImageIcon(
				"C:\\Users\\Usuario\\eclipse-workspace\\System_Venta\\src\\com\\project\\img\\icons8-dinero-64.png"));
		btnPagoFinal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double pago, descuento, importe;

				importe = Double.parseDouble(txtImporte.getText());
				descuento = Double.parseDouble(txtDescuento.getText());

				try {

					pago = importe - descuento;
					txtPagoFinal.setText(String.valueOf(pago));

				} catch (Exception e2) {
					// TODO: handle exception

					JOptionPane.showMessageDialog(null, "Faltan datos....");
				}

			}
		});
		btnPagoFinal.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnPagoFinal.setBackground(SystemColor.activeCaptionBorder);
		btnPagoFinal.setBounds(10, 333, 184, 60);
		panelCalculos.add(btnPagoFinal);

		JLabel lblPagoFinal = new JLabel("Pago Final");
		lblPagoFinal.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblPagoFinal.setBounds(10, 550, 147, 45);
		panelCalculos.add(lblPagoFinal);

		txtPagoFinal = new JTextField();
		txtPagoFinal.setHorizontalAlignment(SwingConstants.CENTER);
		txtPagoFinal.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		txtPagoFinal.setColumns(10);
		txtPagoFinal.setBounds(169, 550, 89, 39);
		panelCalculos.add(txtPagoFinal);

		JLabel lblNewLabel_3 = new JLabel("Soles");
		lblNewLabel_3.setIcon(new ImageIcon(
				"C:\\Users\\Usuario\\eclipse-workspace\\System_Venta\\src\\com\\project\\img\\icons8-dinero-64.png"));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(297, 542, 150, 60);
		panelCalculos.add(lblNewLabel_3);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 1093, 767);
		contentPane.add(lblNewLabel_2);
	}
}
