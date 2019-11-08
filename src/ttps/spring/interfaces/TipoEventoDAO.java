package ttps.spring.interfaces;

import ttps.spring.model.TipoEvento;


public interface TipoEventoDAO extends GenericDAO<TipoEvento> {
	
	public TipoEvento recuperarPorNombre(String nombre);
	
}
