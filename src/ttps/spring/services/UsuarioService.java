package ttps.spring.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.jpa.MascotaDAOHibernateJPA;
import ttps.spring.jpa.RolDAOHibernateJPA;
import ttps.spring.jpa.UsuarioDAOHibernateJPA;
import ttps.spring.model.Mascota;
import ttps.spring.model.Rol;
import ttps.spring.model.Usuario;
import ttps.spring.model.dto.MascotaDTO;
import ttps.spring.model.dto.UsuarioDTO;
import ttps.spring.model.dto.UsuarioNuevoDTO;
import ttps.spring.model.dto.UsuarioShowDTO;
import ttps.spring.model.dto.UsuarioUpdateDTO;

@Service("usuarioService")
public class UsuarioService {
	
	private UsuarioDAOHibernateJPA usuarioDAO;
	private RolDAOHibernateJPA rolDAO;
	private MascotaDAOHibernateJPA mascotaDAO;
	
	@Autowired
	private MascotaService mascotaService;
	
	@Autowired
	public UsuarioService(UsuarioDAOHibernateJPA usuarioDAO, RolDAOHibernateJPA rolDAO, MascotaDAOHibernateJPA mascotaDAO) {
		super();
		this.usuarioDAO = usuarioDAO;
		this.rolDAO = rolDAO;
		this.mascotaDAO = mascotaDAO;
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
			usuariosDTO.add(this.procesarUsuarioShow(u));
		}
		System.out.println(usuariosDTO.size());
		
		return usuariosDTO;	
	}
	
	@Transactional
	public List<MascotaDTO> recuperarMascotasAsociadas( Long id_usuario ) {
		Usuario usuario = this.usuarioDAO.recuperar(id_usuario);
		
		if( usuario == null) {
			return null;
		}
		
		List<Mascota> mascotas = usuario.getMascotas();
		mascotas.addAll(usuario.getMascotas_atendidas());
		
		Set<Mascota> mascotasSet = new HashSet<Mascota>(mascotas);
		
		List<MascotaDTO> mascotasDTO = new ArrayList<MascotaDTO>();
		
		for(Mascota m: mascotasSet) {
			mascotasDTO.add(this.mascotaService.procesarMascota(m));
		}
		
		return mascotasDTO;
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
			usuarioNuevo.setMatricula(uDTO.getMatricula());
			usuarioNuevo.setNombre_consultorio(uDTO.getNombre_consultorio());
			usuarioNuevo.setDomicilio_consultorio(uDTO.getDomicilio_consultorio());
		}
		
		usuarioNuevo = this.usuarioDAO.persistir( usuarioNuevo );
		
		usuarioNuevo.agregarRol(rol);
		usuarioNuevo = this.usuarioDAO.actualizar( usuarioNuevo );
		
		return this.procesarUsuario( usuarioNuevo );
		
	}
	
	@Transactional
	public UsuarioDTO actualizar( UsuarioUpdateDTO uDTO) {
		
		Usuario usuario = this.usuarioDAO.recuperar(uDTO.getId());
		
//		además hay que chequear que el email que se quiere actualizar no exista en la bd
		if ( !uDTO.getEmail().equals(usuario.getEmail())) {
			if( this.usuarioDAO.recuperarPorEmail(uDTO.getEmail()) != null) {
				return null;		
			}
		}
		
		Usuario usuarioActualizado = this.actualizar( usuario, uDTO);		
	    usuarioActualizado = this.usuarioDAO.actualizar(usuarioActualizado);
	    
		return this.procesarUsuario(usuarioActualizado);
	}
	
	@Transactional
	public UsuarioDTO agregarRol(UsuarioUpdateDTO uDTO,String rol){
		
		Rol r = rolDAO.recuperarPorNombre(rol);
		Usuario usuario = this.usuarioDAO.recuperar(uDTO.getId());
		
		usuario.getRoles().add(r);
		usuario = this.usuarioDAO.actualizar(usuario);
		
		UsuarioDTO u = this.procesarUsuarioShow(usuario);
		
		return u;
		
	}
	
	@Transactional
	public UsuarioUpdateDTO agregarMascota( UsuarioDTO u, MascotaDTO m) {
		
		Mascota mascota = this.mascotaDAO.recuperar(m.getId());
		Usuario veterinario = this.usuarioDAO.recuperar(u.getId());
		
		mascota.setVeterinario(veterinario);
		mascota = this.mascotaDAO.actualizar(mascota);
		
		veterinario.agregarMascotaAtendida(mascota);
		veterinario = this.usuarioDAO.actualizar(veterinario);
		
		return new UsuarioUpdateDTO( veterinario.getId(), 
										veterinario.getFoto(), 
										veterinario.getApellido(), 
										veterinario.getNombre(), 
										veterinario.getEmail(), 
										String.valueOf(veterinario.getFecha_nacimiento()), 
										veterinario.getTelefono(), 
										veterinario.getNombre_consultorio(), 
										veterinario.getDomicilio_consultorio(), 
										veterinario.getMatricula(), 
										veterinario.getActivo());
	}
	
	@Transactional
	public UsuarioDTO eliminarPorRol( UsuarioDTO uDTO, String rol ) {
		
//		si tiene un solo rol, lo elimino directamente de la tabla Usuario.
//		Si tiene solo mas de un rol, no elimino el usuario en si, sino solo la relacion user-rol del rol que me pasan como parametro
		Usuario usuario = this.usuarioDAO.recuperar(uDTO.getId());
		UsuarioDTO usuarioDTO = null;
		
		if (usuario.getRoles().size() > 1) {
//			tiene mas de un rol, elimino solo el rol que llega como parametro
			Rol _rol = rolDAO.recuperarPorNombre(rol);
			
			if ( usuarioDAO.tieneRol(usuario, _rol)) {
				usuario = usuarioDAO.eliminarRol(usuario, _rol);
				usuario = usuarioDAO.actualizar(usuario);
				usuarioDTO = this.procesarUsuario(usuario);
			}			
			
		}else {
			
			Usuario usuarioBorrado = this.usuarioDAO.borrar( uDTO.getId() );
			usuarioDTO =  this.procesarUsuario(usuarioBorrado);
		}
		
		return usuarioDTO;
		
		
		
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
		u.setActivo(uActualizado.getActivo());
		
		return u;
		
	}
	
	
	public UsuarioDTO procesarUsuario( Usuario u ) {
		
		UsuarioDTO uDTO;
		
		if (u == null) {
			return new UsuarioDTO();
		}
		
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
		uDTO.setMascotas( this.mascotaService.recuperarPorUsuario(u.getId(), "duenio") );
		
		//foto
		uDTO.setFoto(u.getFoto());
		
		if( u.getMatricula() != null ) {
			uDTO.setMatricula(u.getMatricula());
			uDTO.setDomicilio_consultorio(u.getDomicilio_consultorio());
			uDTO.setNombre_consultorio(u.getNombre_consultorio());
			//setear mascotas atendidas
			uDTO.setMascotas_atendidas(this.mascotaService.recuperarPorUsuario(u.getId(), "veterinario"));
		}
		
		return uDTO;
	}
	
	
	
	
}
