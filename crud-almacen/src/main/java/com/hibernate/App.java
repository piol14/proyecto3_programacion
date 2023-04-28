package com.hibernate;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.hibernate.dao.CategoriaDAO;
import com.hibernate.dao.ProductoDAO;
import com.hibernate.model.Categoria;
import com.hibernate.model.Producto;


import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class App {
	
	static final int LONGITUD_BTN_GUARDAR =20;
	static final int ALTURA_BTN_GUARDAR =20;
	
	static final int LONGITUD_BTN_ACTUALIZAR=20;
	static final int ALTURA_BTN_ACTUALIZAR =20;
	
	static final int LONGITUD_BTN_BORRAR =25;
	static final int ALTURA_BTN_BORRAR =25;
	

	private JFrame frameAlmacen;
	private JTable tableProductos;
	private JTextField txtId;
	private JTextField txtNombre;
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
		
		ProductoDAO productoDAO = new ProductoDAO ();
		CategoriaDAO categoriaDAO = new CategoriaDAO ();
		
		frameAlmacen = new JFrame();
		frameAlmacen.getContentPane().setBackground(new Color(102, 204, 153));
		frameAlmacen.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
		frameAlmacen.setBounds(100, 100, 674, 763);
		frameAlmacen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAlmacen.getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("El Rincón de los Sabores");
		lblTitulo.setForeground(new Color(245, 222, 179));
		lblTitulo.setBackground(new Color(0, 153, 153));
		lblTitulo.setFont(new Font("Nimbus Mono PS", Font.BOLD, 25));
		lblTitulo.setBounds(162, 33, 403, 31);
		frameAlmacen.getContentPane().add(lblTitulo);
		
        DefaultTableModel modelTabla = new DefaultTableModel() {
        
        @Override
		public boolean isCellEditable(int filas,int columnas) {
			return false;
		}
		};
		
		modelTabla.addColumn("idproducto");
		modelTabla.addColumn("nombre");
		modelTabla.addColumn("precio");
		modelTabla.addColumn("existencias");
		modelTabla.addColumn("categoria_id");
		
		tableProductos = new JTable(modelTabla);
		
		tableProductos.setBounds(26, 251, 489, -159);
		frameAlmacen.getContentPane().add(tableProductos);
		
		
		List<Producto> selectProducto = productoDAO.selectAllProductos();
		for (Producto pr : selectProducto) {
		    Object[] fila = { pr.getIdProducto(), pr.getNombre() , pr.getPrecio() , pr.getExistencias() , pr.getCategoria().getIdCategoria()};
		    modelTabla.addRow(fila);
		}
		

		
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
		
		
		
		List<Categoria> selectCategoria = categoriaDAO.selectAllCategoria();
		for (Categoria cg : selectCategoria) {
		    Object[] fila = {cg.getNombreCategoria()};
		    comboBoxSeleccionarCategoria.addItem(fila[0]);
		}

				
			
		
		
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
		JComboBox comboBoxCategoria = new JComboBox();
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    try {
				String nombre = txtNombre.getText();
			    
			    int indice = comboBoxCategoria.getSelectedIndex()+1;
			    Categoria categoria =categoriaDAO.selectCategoriaById(indice);
			    int precio = Integer.parseInt(txtPrecio.getText());
			    int existencias = Integer.parseInt(txtStock.getText());
			    Producto producto1 = new Producto(nombre, precio, existencias, categoria);
			    productoDAO.insertProducto(producto1);
			    modelTabla.setRowCount(0);
			    List<Producto> productoSelect = productoDAO.selectAllProductos();
			    for (Producto pr : productoSelect) {
			        Object[] fila = { pr.getIdProducto(), pr.getNombre(), pr.getPrecio(), pr.getExistencias(), pr.getCategoria().getIdCategoria() };
			        modelTabla.addRow(fila);
			    }
			    JOptionPane.showMessageDialog(null, "Producto añadido");
			}catch(NumberFormatException e1) {
				   JOptionPane.showMessageDialog(null,  "¡Error hay casillas vacías o datos mal introducidos!");
			}
			}
		});
		btnGuardar.setBackground(new Color(245, 222, 179));
		btnGuardar.setBounds(32, 676, 121, 25);

		ImageIcon imagenGuardar = new ImageIcon(App.class.getResource("/imagenes/guardar.png"));
		Image imagenRedimensionada = imagenGuardar.getImage().getScaledInstance(LONGITUD_BTN_GUARDAR, ALTURA_BTN_GUARDAR, java.awt.Image.SCALE_SMOOTH);
		btnGuardar.setIcon(new ImageIcon(imagenRedimensionada));
		frameAlmacen.getContentPane().add(btnGuardar);
		
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBackground(new Color(245, 222, 179));
		btnActualizar.setBounds(256, 676, 151, 25);
		
		ImageIcon imagenActualizar = new ImageIcon(App.class.getResource("/imagenes/actualizar.png"));
		Image imagenRedimensionada2 = imagenActualizar.getImage().getScaledInstance(LONGITUD_BTN_ACTUALIZAR, ALTURA_BTN_ACTUALIZAR, java.awt.Image.SCALE_SMOOTH);
		btnActualizar.setIcon(new ImageIcon(imagenRedimensionada2));
		frameAlmacen.getContentPane().add(btnActualizar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBackground(new Color(245, 222, 179));
		btnBorrar.setBounds(517, 676, 121, 25);
		
		ImageIcon imagenBorrar = new ImageIcon(App.class.getResource("/imagenes/borrar.png"));
		Image imagenRedimensionada3 = imagenBorrar.getImage().getScaledInstance(LONGITUD_BTN_BORRAR, ALTURA_BTN_BORRAR, java.awt.Image.SCALE_SMOOTH);
		btnBorrar.setIcon(new ImageIcon(imagenRedimensionada3));
		frameAlmacen.getContentPane().add(btnBorrar);
		
		JLabel lblMostrarDatos = new JLabel("MOSTRAR DATOS");
		lblMostrarDatos.setFont(new Font("Dialog", Font.BOLD, 20));
		lblMostrarDatos.setBounds(42, 506, 284, 31);
		frameAlmacen.getContentPane().add(lblMostrarDatos);
		
		
		
			List<Categoria> Categoria = categoriaDAO.selectAllCategoria();
			for (Categoria cg : Categoria) {
			    Object[] fila = {cg.getNombreCategoria()};
			    comboBoxCategoria.addItem(fila[0]);
			}
		comboBoxCategoria.setBounds(187, 422, 261, 19);
		frameAlmacen.getContentPane().add(comboBoxCategoria);
		
		tableProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    int índice = tableProductos.getSelectedRow();
			    TableModel model = tableProductos.getModel();
			    txtId.setText(model.getValueAt(índice, 0).toString());
			    txtNombre.setText(model.getValueAt(índice, 1).toString());
			    txtPrecio.setText(model.getValueAt(índice, 2).toString());
			    txtStock.setText(model.getValueAt(índice, 3).toString());
			    Object valorSeleccionado = model.getValueAt(índice, 4); // obtiene el valor de la columna de la categoría
			    comboBoxCategoria.setSelectedIndex((int) valorSeleccionado-1);
			}
	});
	
}

}
