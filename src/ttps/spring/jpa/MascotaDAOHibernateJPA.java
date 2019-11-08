package ttps.spring.jpa;

import ttps.spring.interfaces.MascotaDAO;
import ttps.spring.model.Mascota;


public class MascotaDAOHibernateJPA extends GenericDAOHibernateJPA<Mascota> implements MascotaDAO {

	public MascotaDAOHibernateJPA() {
		 super(Mascota.class);
	}

}
