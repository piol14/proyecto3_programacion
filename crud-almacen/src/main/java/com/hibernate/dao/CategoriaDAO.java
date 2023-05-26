package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Categoria;
import com.hibernate.model.Producto;
import com.hibernate.util.HibernateUtil;

public class CategoriaDAO {
	
	/**
	 * Metodo selectAllCategoria de tipo publico. Es una seleccion multiple de la 
	 * clase categoria 
	 * @return  devuelve una lista con las id yt el nombre de todas las categorias
	 */
			public List<Categoria> selectAllCategoria() {
				Transaction transaction = null;
				List<Categoria> categorias = null;
				try (Session session = HibernateUtil.getSessionFactory().openSession()) {
					transaction = session.beginTransaction();
					categorias = session.createQuery("FROM Categoria", Categoria.class).getResultList();
					transaction.commit();
				} catch (Exception e) {
					if (transaction != null) {
						transaction.rollback();
					}
				}
				return categorias;
			}
			/**
			 * Funcion publica de la clase categoria  que con la id devuelve el nombre de 
			 * la categoria con esa id
			 * @param id que pasa el usuario 
			 * @return el objeto de la categoria de esa id
			 */
			public Categoria selectCategoriaById(int id) {
				Transaction transaction = null;
			Categoria cg = null;
				try (Session session = HibernateUtil.getSessionFactory().openSession()) {
					transaction = session.beginTransaction();
					cg = session.get(Categoria.class, id);
					transaction.commit();
				} catch (Exception e) {
					if (transaction != null) {
						transaction.rollback();
					}
				}
				return cg;
			}
}
