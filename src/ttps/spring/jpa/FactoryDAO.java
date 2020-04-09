package ttps.spring.jpa;

import org.springframework.stereotype.Repository;

import ttps.spring.interfaces.*;

@Repository
public class FactoryDAO {

	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOHibernateJPA();
	}

	public static RolDAO getRolDAO() {
		return new RolDAOHibernateJPA();
	}
	
	public static MascotaDAO getMascotaDAO() {
		return new MascotaDAOHibernateJPA();
	}
	
	public static TipoEventoDAO getTipoEventoDAO() {
		return new TipoEventoDAOHibernateJPA();
	}
	
	public static EventoDAO getEventoDAO() {
		return new EventoDAOHibernateJPA();
	}
	
}
