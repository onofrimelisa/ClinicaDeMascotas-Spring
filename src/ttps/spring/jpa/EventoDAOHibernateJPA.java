package ttps.spring.jpa;

import ttps.spring.interfaces.EventoDAO;
import ttps.spring.model.Evento;

public class EventoDAOHibernateJPA extends GenericDAOHibernateJPA<Evento> implements EventoDAO {

	public EventoDAOHibernateJPA() {
		super(Evento.class);
	}
	
}
