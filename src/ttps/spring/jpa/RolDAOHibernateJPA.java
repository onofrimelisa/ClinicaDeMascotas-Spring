package ttps.spring.jpa;

import ttps.spring.interfaces.RolDAO;
import ttps.spring.model.Rol;

public class RolDAOHibernateJPA extends GenericDAOHibernateJPA<Rol> implements RolDAO {

	public RolDAOHibernateJPA() {
		 super(Rol.class);
	}

}
