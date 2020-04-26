package ttps.spring.jpa;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.spring.interfaces.EventoDAO;
import ttps.spring.model.Evento;
import ttps.spring.model.Usuario;

@Repository("eventoDAO")
public class EventoDAOHibernateJPA extends GenericDAOHibernateJPA<Evento> implements EventoDAO {

	public EventoDAOHibernateJPA() {
		super(Evento.class);
	}
	
	@Override
	public List<Evento> recuperarPorCreador(Usuario creador, String columnOrder) {
		Query consulta = this.getEntityManager()
							.createQuery("SELECT e FROM Evento AS e"
									    +" INNER JOIN e.usuario_creador AS u"
										+" WHERE u.id = " + creador.getId()
										+" ORDER BY " + columnOrder);
		
		List<Evento> resultado = (List<Evento>)consulta.getResultList();
		return resultado;
	}

}
