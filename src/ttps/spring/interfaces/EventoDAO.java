package ttps.spring.interfaces;

import java.util.List;

import ttps.spring.model.Evento;
import ttps.spring.model.Usuario;

public interface EventoDAO extends GenericDAO<Evento> {

	public List<Evento> recuperarPorCreador( Usuario creador, String columnOrder );
}
