package ttps.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.jpa.UsuarioDAOHibernateJPA;
import ttps.spring.model.Usuario;
import ttps.spring.model.dto.UsuarioDTO;

@Service("autenticacionService")
public class AutenticacionService {
	
	@Autowired
	private UsuarioDAOHibernateJPA usuarioDAO;
	@Autowired
	UsuarioService usuarioService;

	public AutenticacionService() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	public UsuarioDTO autenticar(String email, String password) {
		
		Usuario u = this.usuarioDAO.autenticar(email, password);
		
		if ( u != null) {
			return usuarioService.recuperar(u.getId());
		}
		return null;
	}
	
}
