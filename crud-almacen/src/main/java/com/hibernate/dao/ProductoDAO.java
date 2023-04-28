package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.model.Categoria;

import com.hibernate.model.Producto;
import com.hibernate.util.HibernateUtil;

public class ProductoDAO {

	
	// Selección simple
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

		//Insercion
		
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
	//Actualizacion
		
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

		//Eliminar
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
		
		//Seleccion multiple
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

}
