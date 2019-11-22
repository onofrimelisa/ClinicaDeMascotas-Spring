package ttps.spring.interfaces;

import ttps.spring.model.Usuario;
import ttps.spring.model.Rol;
import java.util.List;

public interface UsuarioDAO extends GenericDAO<Usuario> {

	public List<Usuario> recuperarPorRol(Rol rol, String columnOrder);	
	
	public Usuario recuperarPorEmail(String email);
	
	public Usuario recuperarPorId(Long id);
	
	public Usuario autenticar(String email, String password);
}
