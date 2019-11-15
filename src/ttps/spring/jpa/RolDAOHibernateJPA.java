package ttps.spring.jpa;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.spring.interfaces.RolDAO;
import ttps.spring.model.Rol;


@Repository("rolDAO")
public class RolDAOHibernateJPA extends GenericDAOHibernateJPA<Rol> implements RolDAO {

	public RolDAOHibernateJPA() {
		 super(Rol.class);
	}
	
	@Override
	public Rol recuperarPorNombre(String nombre) {
		
		Query consulta = this.getEntityManager()
							.createQuery("FROM Rol"
										+" WHERE nombre = '" + nombre + "'");

		Rol resultado = (Rol)consulta.getSingleResult();

		return resultado;
	}

}
