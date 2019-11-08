package ttps.spring.jpa;

import ttps.spring.interfaces.RecordatorioDAO;
import ttps.spring.model.Recordatorio;

public class RecordatorioDAOHibernateJPA extends GenericDAOHibernateJPA<Recordatorio> implements RecordatorioDAO {

	public RecordatorioDAOHibernateJPA() {
		super(Recordatorio.class);
	}

}
