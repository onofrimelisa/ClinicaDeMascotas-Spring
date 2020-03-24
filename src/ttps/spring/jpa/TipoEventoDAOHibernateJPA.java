package ttps.spring.jpa;

import ttps.spring.interfaces.TipoEventoDAO;
import ttps.spring.model.TipoEvento;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository("tipoEventoDAO")
public class TipoEventoDAOHibernateJPA extends GenericDAOHibernateJPA<TipoEvento> implements TipoEventoDAO {

	public TipoEventoDAOHibernateJPA() {
		super(TipoEvento.class);
	}
	
	//	RECUPERAR POR NOMBRE DE EVENTO
	
	@Override
	public TipoEvento recuperarPorNombre(String nombre) {
		
		Query consulta = this.getEntityManager()
							.createQuery("FROM TipoEvento"
										+" WHERE nombre = '" + nombre + "'");

		TipoEvento resultado = (TipoEvento)consulta.getSingleResult();

		return resultado;
	}

}
