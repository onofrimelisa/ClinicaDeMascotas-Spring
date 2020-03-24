package ttps.spring.jpa;

import org.springframework.stereotype.Repository;

import ttps.spring.interfaces.EventoDAO;
import ttps.spring.model.Evento;

@Repository("eventoDAO")
public class EventoDAOHibernateJPA extends GenericDAOHibernateJPA<Evento> implements EventoDAO {

	public EventoDAOHibernateJPA() {
		super(Evento.class);
	}
	
}
