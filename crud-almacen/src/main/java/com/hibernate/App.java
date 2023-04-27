package com.hibernate;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.UIManager;

public class App {

	private JFrame frameAlmacen;
	private JTable tableProductos;
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtCategoria;
	private JTextField txtPrecio;
	private JTextField txtStock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frameAlmacen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameAlmacen = new JFrame();
		frameAlmacen.getContentPane().setBackground(new Color(102, 204, 153));
		frameAlmacen.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
		frameAlmacen.setBounds(100, 100, 674, 826);
		frameAlmacen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAlmacen.getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Almacenes Ausias");
		lblTitulo.setBackground(new Color(0, 153, 153));
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 25));
		lblTitulo.setBounds(200, 0, 295, 52);
		frameAlmacen.getContentPane().add(lblTitulo);
		
        DefaultTableModel modelTabla = new DefaultTableModel() {
        
        @Override
		public boolean isCellEditable(int filas,int columnas) {
			return false;
		}
		};
		
		modelTabla.addColumn("Id");
		modelTabla.addColumn("Nombre");
		modelTabla.addColumn("Precio");
		modelTabla.addColumn("Existencias");
		modelTabla.addColumn("Categoria");
		
		tableProductos = new JTable(modelTabla);
		tableProductos.setBounds(26, 251, 489, -159);
		frameAlmacen.getContentPane().add(tableProductos);
		
		
		JScrollPane scrollPaneProductos = new JScrollPane(tableProductos);
		scrollPaneProductos.setBounds(32, 76, 606, 220);
		frameAlmacen.getContentPane().add(scrollPaneProductos);
		
		JLabel lblDatos = new JLabel("INTRODUCIR DATOS");
		lblDatos.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDatos.setBounds(42, 318, 284, 31);
		frameAlmacen.getContentPane().add(lblDatos);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Dialog", Font.BOLD, 15));
		lblId.setBounds(42, 369, 117, 15);
		frameAlmacen.getContentPane().add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNombre.setBounds(42, 399, 117, 15);
		frameAlmacen.getContentPane().add(lblNombre);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCategoria.setBounds(42, 426, 117, 15);
		frameAlmacen.getContentPane().add(lblCategoria);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPrecio.setBounds(42, 452, 117, 15);
		frameAlmacen.getContentPane().add(lblPrecio);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Dialog", Font.BOLD, 15));
		lblStock.setBounds(42, 479, 117, 15);
		frameAlmacen.getContentPane().add(lblStock);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setBounds(187, 365, 151, 19);
		frameAlmacen.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(187, 395, 261, 19);
		frameAlmacen.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(187, 422, 261, 19);
		frameAlmacen.getContentPane().add(txtCategoria);
		txtCategoria.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setText("");
		txtPrecio.setBounds(187, 448, 151, 19);
		frameAlmacen.getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setBounds(187, 475, 151, 19);
		frameAlmacen.getContentPane().add(txtStock);
		txtStock.setColumns(10);
		
		JRadioButton rdbtnMostrarTodosLos = new JRadioButton("Mostrar todos los productos");
		rdbtnMostrarTodosLos.setBackground(new Color(102, 204, 153));
		rdbtnMostrarTodosLos.setFont(new Font("Dialog", Font.BOLD, 15));
		rdbtnMostrarTodosLos.setBounds(42, 544, 284, 23);
		frameAlmacen.getContentPane().add(rdbtnMostrarTodosLos);
		
		JComboBox comboBoxSeleccionarCategoria = new JComboBox();
		comboBoxSeleccionarCategoria.setBounds(408, 591, 98, 24);
		frameAlmacen.getContentPane().add(comboBoxSeleccionarCategoria);
		
		JLabel lblSeleccionarCategoria = new JLabel("Seleccionar Categoria");
		lblSeleccionarCategoria.setFont(new Font("Dialog", Font.BOLD, 15));
		lblSeleccionarCategoria.setBounds(157, 596, 188, 19);
		frameAlmacen.getContentPane().add(lblSeleccionarCategoria);
		
		JRadioButton rdbtnMostrarProductosPor = new JRadioButton("Mostrar productos por categoría");
		rdbtnMostrarProductosPor.setBackground(new Color(102, 204, 153));
		rdbtnMostrarProductosPor.setFont(new Font("Dialog", Font.BOLD, 15));
		rdbtnMostrarProductosPor.setBounds(42, 571, 324, 23);
		frameAlmacen.getContentPane().add(rdbtnMostrarProductosPor);
		
		JRadioButton rdbtnMostrarProductosDe = new JRadioButton("Mostrar productos de los que ya no quede unidades");
		rdbtnMostrarProductosDe.setBackground(new Color(102, 204, 153));
		rdbtnMostrarProductosDe.setFont(new Font("Dialog", Font.BOLD, 15));
		rdbtnMostrarProductosDe.setBounds(42, 623, 495, 23);
		frameAlmacen.getContentPane().add(rdbtnMostrarProductosDe);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(32, 676, 117, 25);
		frameAlmacen.getContentPane().add(btnGuardar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(289, 676, 117, 25);
		frameAlmacen.getContentPane().add(btnActualizar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(521, 676, 117, 25);
		frameAlmacen.getContentPane().add(btnBorrar);
		
		JLabel lblMostrarDatos = new JLabel("MOSTRAR DATOS");
		lblMostrarDatos.setFont(new Font("Dialog", Font.BOLD, 20));
		lblMostrarDatos.setBounds(42, 506, 284, 31);
		frameAlmacen.getContentPane().add(lblMostrarDatos);
		
		
		
		
		
	}
}
