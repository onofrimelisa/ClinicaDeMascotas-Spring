package ttps.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.jpa.RolDAOHibernateJPA;
import ttps.spring.jpa.UsuarioDAOHibernateJPA;
import ttps.spring.model.Rol;
import ttps.spring.model.Usuario;
import ttps.spring.model.dto.UsuarioDTO;

@Service("usuarioService")
public class UsuarioService {
	
	private UsuarioDAOHibernateJPA usuarioDAO;
	private RolDAOHibernateJPA rolDAO;
	
	@Autowired
	public UsuarioService(UsuarioDAOHibernateJPA usuarioDAO, RolDAOHibernateJPA rolDAO) {
		super();
		this.usuarioDAO = usuarioDAO;
		this.rolDAO = rolDAO;
	}
	
	public UsuarioService() {
		// TODO Auto-generated constructor stub
	}
	
	
//	METODOS
	
	@Transactional
	public List<UsuarioDTO> recuperarTodos() {
		
		List<Usuario> usuarios = this.usuarioDAO.recuperarTodos("apellido");
		
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		
		UsuarioDTO uDTO;
		
		for (Usuario u : usuarios) {
			uDTO = new UsuarioDTO( u.getId(), 
								   u.getApellido(), 
								   u.getNombre(), 
								   u.getEmail(), 
								   u.getFecha_nacimiento(), 
								   u.getTelefono(), 
								   u.getActivo(),
								   u.getRoles());
			
			if( u.getMatricula() != null ) {
				uDTO.setMatricula(u.getMatricula());
				uDTO.setDomicilio_consultorio(u.getDomicilio_consultorio());
				uDTO.setNombre_consultorio(u.getNombre_consultorio());
			}
			
			uDTO.setMascotas("ttps-spring/mascota/duenio/" + uDTO.getId());
			uDTO.setMascotas_atendidas("ttps-spring/mascota/veterinario/" + uDTO.getId());
			uDTO.setEventos("ttps-spring/usuario/" + uDTO.getId() + "/evento");
			uDTO.setRecordatorios("ttps-spring/usuario/" + uDTO.getId() + "/recordatorio");
			
			usuariosDTO.add(uDTO);
		}
		
		return usuariosDTO;
	}
	
	@Transactional
	public List<Usuario> recuperarPorRol(String rol){
		
		Rol r = rolDAO.recuperarPorNombre(rol);
		
		return this.usuarioDAO.recuperarPorRol(r, "apellido");
		
	}
	
	
	
}
