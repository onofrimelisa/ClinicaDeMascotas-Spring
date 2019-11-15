package ttps.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ttps.spring.jpa.UsuarioDAOHibernateJPA;
import ttps.spring.model.Usuario;

@Service("autenticacionService")
public class AutenticacionService {
	
	@Autowired
	private UsuarioDAOHibernateJPA usuarioDAO;

	public AutenticacionService() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	public Usuario autenticar(String email, String password) {
		
		return this.usuarioDAO.autenticar(email, password);
	}
	
}
