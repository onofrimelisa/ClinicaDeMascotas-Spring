package ttps.spring.jpa;

import java.util.List;

import javax.persistence.Query;

import ttps.spring.interfaces.UsuarioDAO;
import ttps.spring.model.Rol;
import ttps.spring.model.Usuario;

public class UsuarioDAOHibernateJPA extends GenericDAOHibernateJPA<Usuario> implements UsuarioDAO {

	public UsuarioDAOHibernateJPA() {
		 super(Usuario.class);
	}
	
	@Override
	public List<Usuario> recuperarPorRol(Rol rol, String columnOrder) {
		
		Query consulta = this.getEntityManager()
							.createQuery("FROM Usuario AS u"
										+" INNER JOIN u.roles AS r"
										+" WHERE r.id = " + rol.getId()
										+" ORDER BY " + columnOrder);

		List<Usuario> resultado = (List<Usuario>)consulta.getResultList();

		return resultado;
	}

	
	@Override
	public Usuario recuperarPorEmail(String email) {
		
		Query consulta = this.getEntityManager()
							.createQuery("FROM Usuario u"
										+" WHERE u.email = :email");
		
		consulta.setParameter("email", email);
		
		Usuario resultado = (Usuario)consulta.getSingleResult();
		
		return resultado;
	}
}
