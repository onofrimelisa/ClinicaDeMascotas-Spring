package ttps.spring.interfaces;

import ttps.spring.model.Rol;

public interface RolDAO extends GenericDAO<Rol> {

	
	public Rol recuperarPorNombre(String nombre);
}
