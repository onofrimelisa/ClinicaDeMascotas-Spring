package ttps.spring.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ttps.spring.interfaces.GenericDAO;

@Repository
public class GenericDAOHibernateJPA<T> implements GenericDAO<T> {
	
	private EntityManager entityManager;
	protected Class<T> persistentClass;
	
	public GenericDAOHibernateJPA() {
		// TODO Auto-generated constructor stub
	}
	
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.entityManager = em;
	}
	
	 
	public GenericDAOHibernateJPA(Class<T> clase) {
		persistentClass = clase;
	}
	
	public Class<T> getPersistentClass() {
		return persistentClass;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	
	@Override
	public T persistir(T entity) {
		this.getEntityManager().persist(entity);
		return entity;
	}
	
	@Override
	public T actualizar(T entity) {
		this.getEntityManager().merge(entity);
		return entity;
	}
	
	@Override
	public void borrar(T entity) {
		this.getEntityManager().remove(entity);
	}
	
	@Override
	public T borrar(Long id) {
	 
		T entity = this.getEntityManager().find(this.getPersistentClass(), id);
		
		if (entity != null) {
			this.borrar(entity);
		}	
		return entity;
	}
	
	@Override
	public boolean existe(Long id) {
		
		T entity = this.getEntityManager().find(this.getPersistentClass(), id);
		
		if (entity != null) {
			return false;
		}	
		return true;	
	}
	
	@Override
	public T recuperar(Long id) {	
		T entity = this.getEntityManager().find(this.getPersistentClass(), id);
		return entity;	
	}
	
	@Override
	public List<T> recuperarTodos(String columnOrder) {
		
		Query consulta = this.getEntityManager()
							.createQuery(" FROM " + getPersistentClass().getSimpleName()
										+" ORDER BY " + columnOrder);
		
		List<T> resultado = (List<T>)consulta.getResultList();
		
		return resultado;
	}	
	
}
