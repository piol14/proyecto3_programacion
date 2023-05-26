package com.hibernate.dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.model.Categoria;

import com.hibernate.model.Producto;
import com.hibernate.util.HibernateUtil;

public class ProductoDAO {

	
	/**
	 * Funcion publica de la clase producto que con la devuelve el objeto producto
	 * 
	 * @param id la id que le pasa el usuario 
	 * @return devuelve el objeto producto de esa id 
	 */
		public Producto selectProductoById(int id) {
			Transaction transaction = null;
			Producto pr = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				transaction = session.beginTransaction();
				pr = session.get(Producto.class, id);
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
			}
			return pr;
		}

		/**
		 * Metodo publico de la clase producto que inserta un producto en la base
		 * de datos 
		 * @param pr el objeto producto pasado por el programa principal con los atributos
		 * introducidos por el usuario
		 * No devuelve nada porque es void 
		 */
		
		public void insertProducto(Producto pr) {
			Transaction transaction = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				transaction = session.beginTransaction();
				session.persist(pr);
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
			}
		}
		/**
		 * Metodo publico de la clase producto que actualiza  un producto en la base
		 * de datos 
		 * @param pr el objeto producto pasado por el programa principal con los atributos
		 * introducidos por el usuario
		 * No devuelve nada porque es void 
		 */
		
		public void updateProducto(Producto pr) {
			Transaction transaction = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				transaction = session.beginTransaction();
				session.merge(pr);
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
			}
		}

		/**
		 * Metodo publico de la clase producto que borra  un producto en la base
		 * de datos 
		 * @param id la id del producto que queremos eliminar 
		 * No devuelve nada porque es void 
		 */
		public void deleteProducto(int id) {
			Transaction transaction = null;
			Producto pr = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				transaction = session.beginTransaction();
				pr = session.get(Producto.class, id);
				session.remove(pr);
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
			}
		}
		
		/**
		 * Funcion publica de tipo Lista producto que selecciona todos los productos
		 * @return devuelve una lista con todos los productos 
		 */
		public List<Producto> selectAllProductos() {
			Transaction transaction = null;
			List<Producto> productos = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				transaction = session.beginTransaction();
				productos = session.createQuery("FROM Producto", Producto.class).getResultList();
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
			}
			return productos;
		}
		/**
		 * Funcion publica de la clase objeto que pasandole un objeto de tipo categoria selecciona los 
		 * objeto con esa categoria 
		 * @param categoria la categoria seleccionada por el usuario 
		 * @return devuelve los productos con esa categoria 
		 */
		public List<Producto> selectProductoByCategoria (Categoria categoria) {
			Transaction transaction = null;
			List<Producto> productos= null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				transaction = session.beginTransaction();
				Query<Producto> query=session.createQuery("FROM Producto  WHERE categoria = :categoriaParam",Producto.class);
				query.setParameter("categoriaParam", categoria);
				 productos=query.getResultList();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
			}
			return productos;
		}
/** 
 * Funcion publica de la clase producto que selecciona los productos sin stock
 * @return devuelve la lista de producto de los objetos sin stock 
 */
		public List<Producto> selectProductosSinStock() {
		    Transaction transaction = null;
		    List<Producto> productos = null;
		    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		        transaction = session.beginTransaction();
		        productos = session.createQuery("FROM Producto WHERE  existencias = 0", Producto.class).getResultList();
		        transaction.commit();
		    } catch (Exception e) {
		        if (transaction != null) {
		            transaction.rollback();
		        }
		    }
		    return productos;
		}
		
		
		
		
}
