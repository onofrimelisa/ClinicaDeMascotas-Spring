package ttps.spring.jpa;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.spring.interfaces.UsuarioDAO;
import ttps.spring.model.Rol;
import ttps.spring.model.Usuario;

@Repository("usuarioDAO")
public class UsuarioDAOHibernateJPA extends GenericDAOHibernateJPA<Usuario> implements UsuarioDAO {

	public UsuarioDAOHibernateJPA() {
		 super(Usuario.class);
	}
	
	@Override
	public List<Usuario> recuperarPorRol(Rol rol, String columnOrder) {
		
		Query consulta = this.getEntityManager()
							.createQuery("SELECT u FROM Usuario AS u"
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
		
		try {
			return (Usuario)consulta.getSingleResult();
		}
		catch(Exception e) {
			return null;
		}
	}
	
	
	@Override
	public Usuario autenticar(String email, String password) {
		Query consulta = this.getEntityManager()
				.createQuery("FROM Usuario u"
							+" WHERE u.email = :email"
							+" AND u.password = :password");

		consulta.setParameter("email", email);
		consulta.setParameter("password", password);
		
		try {
			return (Usuario)consulta.getSingleResult();
		}
		catch(Exception e) {
			return null;
		}
		
	}
	
	public boolean tieneRol (Usuario usuario, Rol rol) {
		Query consulta = this.getEntityManager()
				.createQuery("FROM Usuario_tiene_rol"
							+" WHERE id_usuario = :id_usuario and id_rol = :id_rol");

		consulta.setParameter("id_usuario", usuario.getId());
		consulta.setParameter("id_rol", rol.getId());
		
		try {
			return (Boolean)consulta.getSingleResult();
		}
		catch(Exception e) {
			return false;
		}
	}
	
	
}
