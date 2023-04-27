package com.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idproducto")
	private int idProducto;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "precio")
	private int precio;

	@Column(name = "existencias")
	private int existencias;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	public Producto() {

	}

	public Producto(String nombre, int precio, int existencias, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.existencias = existencias;
		this.categoria = categoria;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getExistencias() {
		return existencias;
	}

	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}

@Entity
@Table(name = "categoria")
class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idCategoria")
	private int idCategoria;

	@Column(name = "nombre")
	private String nombre;

	public Categoria() {

	}

	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}

