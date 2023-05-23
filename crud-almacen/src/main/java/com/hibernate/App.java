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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.List;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class App {
	
	static final int LONGITUD_BTN_GUARDAR =18;
	static final int ALTURA_BTN_GUARDAR =18;
	
	static final int LONGITUD_BTN_ACTUALIZAR=20;
	static final int ALTURA_BTN_ACTUALIZAR =20;
	
	static final int LONGITUD_BTN_BORRAR =20;
	static final int ALTURA_BTN_BORRAR =20;
	

	  
	
	private JFrame frameAlmacen;
	private JTable tableProductos;
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtExistencias;
	
	ButtonGroup g1 = new ButtonGroup();
	
	

	/**
	 * Launch the application.
	 */
	/**
	 * 
	 * @param args
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
		
		JComboBox comboBoxSeleccionarCategoria = new JComboBox();
		JComboBox comboBoxCategoria = new JComboBox();
		
		frameAlmacen = new JFrame();
		frameAlmacen.getContentPane().setBackground(new Color(51, 204, 204));
		frameAlmacen.setBackground(new Color(50, 204, 204));
		frameAlmacen.setBounds(100, 100, 921, 773);
		frameAlmacen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAlmacen.getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("El Rincón de los Sabores");
		lblTitulo.setForeground(new Color(255, 153, 102));
		lblTitulo.setBackground(new Color(0, 153, 153));
		lblTitulo.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
		lblTitulo.setBounds(259, 12, 403, 31);
		frameAlmacen.getContentPane().add(lblTitulo);
		
        DefaultTableModel modelTabla = new DefaultTableModel() {
        
        @Override
        /**
         * Este metodo sirve para que las celdas de la tabla no sean editables 
         * @param filas: este parametro son las filas de la tabla
         * @param columnas: las columnas de la tabla
         * @return: false, asi no se pueden editar las celdas 
         */
		public boolean isCellEditable(int filas,int columnas) {
			return false;
		}
		};
		
		modelTabla.addColumn("Producto");
		modelTabla.addColumn("Nombre");
		modelTabla.addColumn("Precio");
		modelTabla.addColumn("Existencias");
		modelTabla.addColumn("Categoria");
	
		tableProductos = new JTable(modelTabla);
		
		tableProductos.setBounds(26, 251, 489, -159);
		frameAlmacen.getContentPane().add(tableProductos);
		
		
		List<Producto> selectProducto = productoDAO.selectAllProductos();
		for (Producto pr : selectProducto) {
		    Object[] fila = { pr.getIdProducto(), pr.getNombre() , pr.getPrecio() , pr.getExistencias() , pr.getCategoria().getIdCategoria()};
		    modelTabla.addRow(fila);
		}

  
		
		JScrollPane scrollPaneProductos = new JScrollPane(tableProductos);
		scrollPaneProductos.setBounds(32, 76, 857, 220);
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
		
		txtExistencias = new JTextField();
		txtExistencias.setBounds(187, 475, 151, 19);
		frameAlmacen.getContentPane().add(txtExistencias);
		txtExistencias.setColumns(10);
		
		
		
		
	
		
		JRadioButton rdbtnMostrarTodos = new JRadioButton("Mostrar todos los productos",true);
		rdbtnMostrarTodos.addActionListener(new ActionListener() {
			/**
			 * Esta funcion muestra todos los productos de la tabla cuando le das al radioButton: rdbtnMostrarTodos
			 * @param arg0
			 */
			public void actionPerformed(ActionEvent arg0) {
				
				modelTabla.setRowCount(0);
				List<Producto> selectProducto = productoDAO.selectAllProductos();
				if(selectProducto.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "No hay productos");
				}
				for (Producto pr : selectProducto) {
				    Object[] fila = { pr.getIdProducto(), pr.getNombre() , pr.getPrecio() , pr.getExistencias() , pr.getCategoria().getIdCategoria()};
				    modelTabla.addRow(fila);
				    modelTabla.fireTableDataChanged();
				}
				
			}
		});
		rdbtnMostrarTodos.setBackground(new Color(51, 204, 204));
		rdbtnMostrarTodos.setFont(new Font("Dialog", Font.BOLD, 15));
		rdbtnMostrarTodos.setBounds(42, 544, 284, 23);
		
		frameAlmacen.getContentPane().add(rdbtnMostrarTodos);
		
		

		comboBoxSeleccionarCategoria.addActionListener(new ActionListener() {
			/**
			 * Esta funcion muestra los productos por su categoria cuando selecciona una categoria 
			 * del comboBox comboBoxSeleccionarCategoria
			 * @param arg0
			 */
			public void actionPerformed(ActionEvent arg0) {
				modelTabla.setRowCount(0);
			
            
				if(!comboBoxSeleccionarCategoria.isEnabled()) {
					List<Producto> selectProducto = productoDAO.selectAllProductos();
					
					for (Producto pr : selectProducto) {
					    Object[] fila = { pr.getIdProducto(), pr.getNombre() , pr.getPrecio() , pr.getExistencias() , pr.getCategoria().getIdCategoria()};
					    modelTabla.addRow(fila);
					    modelTabla.fireTableDataChanged();
					}
					
				}else {
				int indice = comboBoxSeleccionarCategoria.getSelectedIndex()+1;
				Categoria categoria = categoriaDAO.selectCategoriaById(indice);
				List<Producto> selectProducto = productoDAO.selectProductoByCategoria(categoria);
				if(selectProducto.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "No hay productos en esa categoria");
				}
				for (Producto pr : selectProducto) {
					Object[] fila = { pr.getIdProducto(), pr.getNombre(), pr.getPrecio(), pr.getExistencias(),
							pr.getCategoria().getIdCategoria() };
					modelTabla.addRow(fila);
					  modelTabla.fireTableDataChanged();
				}
				}

			}
		});

		comboBoxSeleccionarCategoria.setEnabled(false);
		
		List<Categoria> selectCategoria = categoriaDAO.selectAllCategoria();
		for (Categoria cg : selectCategoria) {
		  comboBoxSeleccionarCategoria.addItem(cg.getNombreCategoria());
		}
		
		comboBoxSeleccionarCategoria.setBounds(476, 591, 215, 24);
		frameAlmacen.getContentPane().add(comboBoxSeleccionarCategoria);
		
		JLabel lblSeleccionarCategoria = new JLabel("Seleccionar Categoria");
		lblSeleccionarCategoria.setFont(new Font("Dialog", Font.BOLD, 15));
		lblSeleccionarCategoria.setBounds(157, 596, 188, 19);
		frameAlmacen.getContentPane().add(lblSeleccionarCategoria);
		
		JRadioButton rdbtnMostrarProductosCategoria = new JRadioButton("Mostrar productos por categoría");
		/**
		 * Esta funcion habilita el comboBox comboBoxSeleccionarCategoria para que muestre segun la categoria
		 */
		rdbtnMostrarProductosCategoria.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				if(rdbtnMostrarProductosCategoria.isSelected()) {
					modelTabla.setRowCount(0);
					comboBoxSeleccionarCategoria.setEnabled(true);
					int indice = comboBoxSeleccionarCategoria.getSelectedIndex()+1;
					Categoria categoria = categoriaDAO.selectCategoriaById(indice);
					List<Producto> selectProducto = productoDAO.selectProductoByCategoria(categoria);
					if(selectProducto.isEmpty())
					{
						JOptionPane.showMessageDialog(null, "No hay productos en esa categoria");
					}
					for (Producto pr : selectProducto) {
						Object[] fila = { pr.getIdProducto(), pr.getNombre(), pr.getPrecio(), pr.getExistencias(),
								pr.getCategoria().getIdCategoria()};
						modelTabla.addRow(fila);
					}
				}else {
					comboBoxSeleccionarCategoria.setEnabled(false);
				}
				}
			
		});
		
		rdbtnMostrarProductosCategoria.setBackground(new Color(51, 204, 204));
		rdbtnMostrarProductosCategoria.setFont(new Font("Dialog", Font.BOLD, 15));
		rdbtnMostrarProductosCategoria.setBounds(42, 571, 324, 23);
		frameAlmacen.getContentPane().add(rdbtnMostrarProductosCategoria);
		
		JRadioButton rdbtnMostrarProductosSinUnidades = new JRadioButton("Mostrar productos de los que ya no quede unidades");
		rdbtnMostrarProductosSinUnidades.addActionListener(new ActionListener() {
			/**
			 * Esta funcion muestra los productos sin stock al darle al radioButton rdbtnMostrarProductosSinUnidades 
			 */
		    public void actionPerformed(ActionEvent e) {
		 
		            modelTabla.setRowCount(0);
		            List<Producto> selectProducto = productoDAO.selectProductosSinStock();
		            if(selectProducto.isEmpty())
					{
						JOptionPane.showMessageDialog(null, "No hay productos sin stock.");
					}
		            for (Producto pr : selectProducto) {
		                Object[] fila = { pr.getIdProducto(), pr.getNombre(), pr.getPrecio(), pr.getExistencias(), pr.getCategoria().getIdCategoria()};
		                modelTabla.addRow(fila);
		                modelTabla.fireTableDataChanged();
		                
		            }
		        }
		    
		    
		});
		
		rdbtnMostrarProductosSinUnidades.setBackground(new Color(51, 204, 204));
		rdbtnMostrarProductosSinUnidades.setFont(new Font("Dialog", Font.BOLD, 15));
		rdbtnMostrarProductosSinUnidades.setBounds(42, 623, 495, 23);
		frameAlmacen.getContentPane().add(rdbtnMostrarProductosSinUnidades);
		g1.add(rdbtnMostrarProductosCategoria);
		g1.add(rdbtnMostrarProductosSinUnidades);
		g1.add(rdbtnMostrarTodos);
		
		
	
		
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			/**
			 * Esta funcion inserta un producto cuando los datos estan introducidos correctamente, tras darle al boton guardar
			 * 
			 * @param arg0
			 */
			public void actionPerformed(ActionEvent arg0) {
			    
				
				
				try {
				String nombre = txtNombre.getText();
			    
			    int indice = comboBoxCategoria.getSelectedIndex()+1;
			    Categoria categoria =categoriaDAO.selectCategoriaById(indice);
			  double precio =Double.parseDouble(txtPrecio.getText());
			  int existencias = Integer.parseInt(txtExistencias.getText());
			  
		
		 
			  
			    Producto producto1 = new Producto(nombre, precio, existencias, categoria);
			    productoDAO.insertProducto(producto1);
			    modelTabla.setRowCount(0);
			    List<Producto> productoSelect = productoDAO.selectAllProductos();
			    for (Producto pr : productoSelect) {
			        Object[] fila = { pr.getIdProducto(), pr.getNombre(), pr.getPrecio(), pr.getExistencias(), pr.getCategoria().getIdCategoria()};
			        modelTabla.addRow(fila);
			    }
			    JOptionPane.showMessageDialog(null, "Producto añadido");
			    txtNombre.setText("");
				txtPrecio.setText("");
				txtExistencias.setText("");
				txtId.setText("");
			    
				if(rdbtnMostrarProductosSinUnidades.isSelected()) {
					  modelTabla.setRowCount(0);
			            List<Producto> selectProducto = productoDAO.selectProductosSinStock();
			            if(selectProducto.isEmpty())
						{
							JOptionPane.showMessageDialog(null, "No hay productos sin  stock");
						}
			            for (Producto pr : selectProducto) {
			                Object[] fila = { pr.getIdProducto(), pr.getNombre(), pr.getPrecio(), pr.getExistencias(), pr.getCategoria().getIdCategoria() };
			                modelTabla.addRow(fila);
			                modelTabla.fireTableDataChanged();
			                
			            }
			        
			  
				}else if(rdbtnMostrarProductosCategoria.isSelected()) {
						modelTabla.setRowCount(0);
						comboBoxSeleccionarCategoria.setEnabled(true);
						int indice2 = comboBoxSeleccionarCategoria.getSelectedIndex()+1;
						Categoria categoria2 = categoriaDAO.selectCategoriaById(indice2);
						List<Producto> selectProducto = productoDAO.selectProductoByCategoria(categoria2);
						if(selectProducto.isEmpty())
						{
							JOptionPane.showMessageDialog(null, "No hay productos en esa categoria");
						}
						for (Producto pr : selectProducto) {
							Object[] fila = { pr.getIdProducto(), pr.getNombre(), pr.getPrecio(), pr.getExistencias(),
									pr.getCategoria().getIdCategoria() };
							modelTabla.addRow(fila);
						}
					}else {
						comboBoxSeleccionarCategoria.setEnabled(false);
					}
				
					
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
		btnActualizar.addActionListener(new ActionListener() {
			/**
			 * Esta funcion actualiza un producto tras seleccionarlo, cambiar un valor de un textField o del
			 * comboBox y despues se le da al boton Actualizar, si los datos estan introducidos correctamente
			 * se actualiza, sino, sale un mensaje de error.
			 */
			public void actionPerformed(ActionEvent e) {
				 int selectedRow = tableProductos.getSelectedRow();
			      
		try {
			
			
			        	int id = (int) tableProductos.getValueAt(selectedRow, 0);

			            String nombre = txtNombre.getText();
			            int indice = comboBoxCategoria.getSelectedIndex()+1;
			            Categoria categoria =categoriaDAO.selectCategoriaById(indice);
			            double precio = Double.parseDouble(txtPrecio.getText());
			            
			            int existencias = Integer.parseInt(txtExistencias.getText());
			            Producto producto = productoDAO.selectProductoById(id);
			            if(txtNombre.getText().isEmpty())
			            {
			            	 JOptionPane.showMessageDialog(null,  "¡Error hay casillas vacías o datos mal introducidos!");
			            }
			            else
			            {
			            JOptionPane.showMessageDialog(null,  "Producto actualizado correctamente");
			            producto.setNombre(nombre);
			            producto.setCategoria(categoria);
			            producto.setPrecio(precio);
			            producto.setExistencias(existencias);
			           
			            productoDAO.updateProducto(producto);
			            tableProductos.setValueAt(nombre, selectedRow, 1);
			            tableProductos.setValueAt(precio, selectedRow, 2);
			            tableProductos.setValueAt(existencias, selectedRow, 3);
			            tableProductos.setValueAt(indice, selectedRow, 4);
			           
			            
			            txtNombre.setText("");
						txtPrecio.setText("");
						txtExistencias.setText("");
						txtId.setText("");
			            }
			        }catch(ArrayIndexOutOfBoundsException e1) {
			        	 JOptionPane.showMessageDialog(null,  "No se ha seleccionado ninguna casilla o no hay ningun producto");
			        
			        }
			catch(NumberFormatException e1) {
				   JOptionPane.showMessageDialog(null,  "¡Error hay casillas vacías o datos mal introducidos!");
			}
			        }
			    
			
		});
		btnActualizar.setBackground(new Color(245, 222, 179));
		btnActualizar.setBounds(385, 676, 151, 25);
		
		ImageIcon imagenActualizar = new ImageIcon(App.class.getResource("/imagenes/actualizar.png"));
		Image imagenRedimensionada2 = imagenActualizar.getImage().getScaledInstance(LONGITUD_BTN_ACTUALIZAR, ALTURA_BTN_ACTUALIZAR, java.awt.Image.SCALE_SMOOTH);
		btnActualizar.setIcon(new ImageIcon(imagenRedimensionada2));
		frameAlmacen.getContentPane().add(btnActualizar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			/**
			 * Este evento borra el producto  seleccionando cuando le das al boton de borrar
			 * @param arg0
			 */
			public void actionPerformed(ActionEvent arg0) {
			
				
				try {
					
					int filaSeleccionada = tableProductos.getSelectedRow();
					int idProducto = (int)tableProductos.getValueAt(filaSeleccionada, 0);
					
					
					productoDAO.deleteProducto(idProducto);
					
					modelTabla.removeRow(filaSeleccionada);
					JOptionPane.showMessageDialog(null, "Producto borrado correctamente");
					txtNombre.setText("");
					txtPrecio.setText("");
					txtExistencias.setText("");
					txtId.setText("");
					
					
					}catch(ArrayIndexOutOfBoundsException e1) {
						JOptionPane.showMessageDialog(null, "No hay ningun producto o no se ha seleccionado ninguno");
					}
			}
		});
		btnBorrar.setBackground(new Color(245, 222, 179));
		btnBorrar.setBounds(768, 676, 121, 25);
		
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
				comboBoxCategoria.addItem(cg.getNombreCategoria());
			}
		comboBoxCategoria.setBounds(187, 422, 215, 19);
		frameAlmacen.getContentPane().add(comboBoxCategoria);
		
	
		
		tableProductos.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Este evento sirve para que cuando el usuario le de a una fila de la tabla 
			 * se muestre en los text field 
			 * @param e
			 */
			public void mouseClicked(MouseEvent e) {
			    int índice = tableProductos.getSelectedRow();
			    TableModel model = tableProductos.getModel();
			    txtId.setText(model.getValueAt(índice, 0).toString());
			    txtNombre.setText(model.getValueAt(índice, 1).toString());
			    txtPrecio.setText(model.getValueAt(índice, 2).toString());
			    txtExistencias.setText(model.getValueAt(índice, 3).toString());
			    Object valorSeleccionado = model.getValueAt(índice, 4); // obtiene el valor de la columna de la categoría
			    comboBoxCategoria.setSelectedIndex((int) valorSeleccionado-1);
			}
	});
	
}
}

