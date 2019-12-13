package ttps.spring.services;

import java.sql.Date;
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
import ttps.spring.model.dto.UsuarioNuevoDTO;
import ttps.spring.model.dto.UsuarioShowDTO;
import ttps.spring.model.dto.UsuarioUpdateDTO;

@Service("usuarioService")
public class UsuarioService {
	
	private UsuarioDAOHibernateJPA usuarioDAO;
	private RolDAOHibernateJPA rolDAO;
	
	@Autowired
	private MascotaService mascotaService;
	
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
		
		for (Usuario u : usuarios) {
			usuariosDTO.add(this.procesarUsuario(u));
		}
		
		return usuariosDTO;
	}
	
	
	
	@Transactional
	public List<UsuarioDTO> recuperarPorRol(String rol){
		
		Rol r = rolDAO.recuperarPorNombre(rol);
		
		List<Usuario> usuarios = this.usuarioDAO.recuperarPorRol(r, "apellido");
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		
		for (Usuario u : usuarios) {
			usuariosDTO.add(this.procesarUsuario(u));
		}
		
		return usuariosDTO;
		
	}
	
	@Transactional 
	public boolean existe( String email) {
		if ( this.usuarioDAO.recuperarPorEmail(email) == null) {
			return false;
		}
		
		return true;
	}
	
	
	@Transactional
	public UsuarioDTO recuperar(Long id) {
		Usuario u = this.usuarioDAO.recuperar(id);
		if (u != null) {
			return this.procesarUsuarioShow( u );			
		}
		return null;
	}
	
	@Transactional
	public UsuarioDTO agregar( UsuarioNuevoDTO uDTO ) {
		
		Usuario usuarioNuevo = new Usuario( uDTO.getEmail(), 
											uDTO.getPassword(), 
											uDTO.getNombre(), 
											uDTO.getApellido(), 
											Date.valueOf( uDTO.getFecha_nacimiento() ),
											uDTO.getTelefono(), 
											uDTO.getActivo(), 
											uDTO.getFoto() );
		
		// me quedo con el rol
		Rol rol = this.rolDAO.recuperarPorNombre( uDTO.getRol() );
		
//		si el rol es veterinario, seteo activo en 0
		if ( rol.getNombre().equals( "veterinario" ) ) {
			usuarioNuevo.setActivo(false);
		}
		
		usuarioNuevo = this.usuarioDAO.persistir( usuarioNuevo );
		
		usuarioNuevo.agregarRol(rol);
		usuarioNuevo = this.usuarioDAO.actualizar( usuarioNuevo );
		
		return this.procesarUsuario( usuarioNuevo );
		
	}
	
	@Transactional
	public UsuarioUpdateDTO actualizar( UsuarioUpdateDTO uDTO) {
		
		Usuario usuario = this.usuarioDAO.recuperar(uDTO.getId());
		
//		además hay que chequear que el email que se quiere actualizar no exista en la bd
		if ( (uDTO.getEmail() != usuario.getEmail()) && (this.usuarioDAO.recuperarPorEmail(uDTO.getEmail()) != null) ) {
			return null;
		}
				
		UsuarioUpdateDTO usuarioActualizadoDTO = new UsuarioUpdateDTO(  uDTO.getId(), 
																		uDTO.getFoto(), 
																		uDTO.getApellido(), 
																		uDTO.getNombre(), 
																		uDTO.getEmail(), 
																		uDTO.getFecha_nacimiento(), 
																		uDTO.getTelefono(), 
																		uDTO.getNombre_consultorio(), 
																		uDTO.getDomicilio_consultorio(), 
																		uDTO.getMatricula() );
		
		Usuario usuarioActualizado = this.actualizar( usuario, usuarioActualizadoDTO);		
	    usuarioActualizado = this.usuarioDAO.actualizar(usuarioActualizado);
		
		return usuarioActualizadoDTO;
	}

	
	
	//============================
	//    OPERACIONES PRIVADAS
	//============================
	
	private Usuario actualizar( Usuario u, UsuarioUpdateDTO uActualizado) {
				
		u.setFoto(uActualizado.getFoto());
		u.setApellido(uActualizado.getApellido());
		u.setNombre(uActualizado.getNombre());
		u.setEmail(uActualizado.getEmail());
		u.setFecha_nacimiento(Date.valueOf(uActualizado.getFecha_nacimiento()));
		u.setTelefono(uActualizado.getTelefono());
		u.setMatricula( uActualizado.getMatricula() );
		u.setDomicilio_consultorio( uActualizado.getDomicilio_consultorio() );
		u.setNombre_consultorio( uActualizado.getNombre_consultorio());
		
		return u;
		
	}
	
	
	private UsuarioDTO procesarUsuario( Usuario u ) {
		
		UsuarioDTO uDTO;
		
		uDTO = new UsuarioDTO( u.getId(), 
				   u.getApellido(), 
				   u.getNombre(), 
				   u.getEmail(), 
				   u.getFecha_nacimiento().toString(), 
				   u.getTelefono(), 
				   u.getActivo(),
				   u.getRolesNombres());

		if( u.getMatricula() != null ) {
			uDTO.setMatricula(u.getMatricula());
			uDTO.setDomicilio_consultorio(u.getDomicilio_consultorio());
			uDTO.setNombre_consultorio(u.getNombre_consultorio());
		}
		
		return uDTO;
	}
	
	private UsuarioDTO procesarUsuarioShow( Usuario u ) {
		
		UsuarioShowDTO uDTO;
		
		uDTO = new UsuarioShowDTO( u.getId(), 
				   u.getApellido(), 
				   u.getNombre(), 
				   u.getEmail(), 
				   u.getFecha_nacimiento().toString(), 
				   u.getTelefono(), 
				   u.getActivo(),
				   u.getRolesNombres());

		//setear mascotas
		uDTO.setMascotas( this.mascotaService.recuperarPorDuenio(u.getId()) );
		
		//foto
		uDTO.setFoto(u.getFoto());
		
		if( u.getMatricula() != null ) {
			uDTO.setMatricula(u.getMatricula());
			uDTO.setDomicilio_consultorio(u.getDomicilio_consultorio());
			uDTO.setNombre_consultorio(u.getNombre_consultorio());
			//setear mascotas atendidas
//			uDTO.setMascotas_atendidas(u.getMascotas_atendidas());
		}
		
		return uDTO;
	}
	
	
	
	
}
