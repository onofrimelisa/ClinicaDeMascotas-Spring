package ttps.spring.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import ttps.spring.interfaces.FichaPublicaDAO;
import ttps.spring.model.FichaPublica;


@Repository("fichaPublicaDAO")
public class FichaPublicaDAOHibernateJPA extends GenericDAOHibernateJPA<FichaPublica> implements FichaPublicaDAO {

	public FichaPublicaDAOHibernateJPA() {
		super(FichaPublica.class);
	}

}
