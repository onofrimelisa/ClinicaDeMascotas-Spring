package ttps.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.jpa.UsuarioDAOHibernateJPA;
import ttps.spring.model.Usuario;

@Service("usuarioService")
public class UsuarioService {
	
	private UsuarioDAOHibernateJPA usuarioDAO;
	
	@Autowired
	public UsuarioService(UsuarioDAOHibernateJPA usuarioDAO) {
		super();
		this.usuarioDAO = usuarioDAO;
	}
	
	public UsuarioService() {
		// TODO Auto-generated constructor stub
	}
	
	
//	METODOS
	public List<Usuario> recuperarTodos() {
		
		return this.usuarioDAO.recuperarTodos("apellido");
	}
	
	
	
}
