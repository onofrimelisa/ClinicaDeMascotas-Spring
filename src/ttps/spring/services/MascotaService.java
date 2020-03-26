package ttps.spring.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.jpa.MascotaDAOHibernateJPA;
import ttps.spring.jpa.RolDAOHibernateJPA;
import ttps.spring.jpa.UsuarioDAOHibernateJPA;
import ttps.spring.model.Mascota;
import ttps.spring.model.Rol;
import ttps.spring.model.Usuario;
import ttps.spring.model.dto.MascotaDTO;
import ttps.spring.model.dto.UsuarioDTO;

@Service("mascotaService")
public class MascotaService {

	private MascotaDAOHibernateJPA mascotaDAO;	
	private UsuarioDAOHibernateJPA usuarioDAO;
	private RolDAOHibernateJPA rolDAO;	
	
	@Autowired
	public MascotaService(MascotaDAOHibernateJPA mascotaDAO, UsuarioDAOHibernateJPA usuarioDAO, RolDAOHibernateJPA rolDAO) {
		super();
		this.mascotaDAO = mascotaDAO;
		this.usuarioDAO = usuarioDAO;
		this.rolDAO = rolDAO;
	}
	
	public MascotaService() {
		
	}
	
	// METODOS
	
	@Transactional
	public MascotaDTO recuperar(Long id) {
		Mascota m = this.mascotaDAO.recuperar(id);
		if (m != null) {
			return this.procesarMascota(m);			
		}
		return null;
	}
	
	
	@Transactional
	public List<MascotaDTO> recuperarPorUsuario(Long u, String r){
				
		List<MascotaDTO> mascotasDTO = new ArrayList<MascotaDTO>();
		List<Mascota> mascotas;
		
		Usuario usuario = usuarioDAO.recuperar(u);
		if(usuario == null) {
			return null;
		}
		
		Rol rol = rolDAO.recuperarPorNombre(r);
		
		if( rol == null || (!rol.getNombre().equals("veterinario") && !rol.getNombre().equals("duenio"))) {
			
			return null;
		}
		System.out.println(rol.getNombre());
		if(rol.getNombre().equals("veterinario")) {
			System.out.println("es vete");
			mascotas = usuario.getMascotas_atendidas();
		}else {
			mascotas = usuario.getMascotas();
		}		
		
		for (Mascota m : mascotas) {
			mascotasDTO.add(this.procesarMascota(m));
		}
		
		return mascotasDTO;
	}
	

	@Transactional
	public List<MascotaDTO> recuperarSinVeterinario(){
				
		List<MascotaDTO> mascotasDTO = new ArrayList<MascotaDTO>();
		List<Mascota> mascotas;
		
		mascotas = this.mascotaDAO.getSinVeterinario();
		
		
		for (Mascota m : mascotas) {
			mascotasDTO.add(this.procesarMascota(m));
		}
		
		return mascotasDTO;
	}
	
	
	@Transactional
	public MascotaDTO agregarMascota(MascotaDTO mascota) {
		System.out.print(Long.valueOf(mascota.getDuenio()));
//		chequeo si existe el usuario
		
		Usuario duenio = this.usuarioDAO.recuperar(Long.valueOf(mascota.getDuenio()));
		if (duenio == null ) {
			return null;
		}
		Usuario veterinario = null;
		
		if (mascota.getVeterinario() != null && mascota.getVeterinario() != "") {
			veterinario = this.usuarioDAO.recuperar(Long.valueOf(mascota.getVeterinario()));
			if (veterinario == null ) {
				return null;
			}
		}
			
		
		Mascota nuevaMascota = new Mascota(mascota.getNombre(), 
										   Date.valueOf(mascota.getFecha_nacimiento()), 
										   mascota.getEspecie(), 
										   mascota.getRaza(), 
										   mascota.getSexo(), 
										   mascota.getColor(), 
										   mascota.getSenias(), 
										   duenio,
										   mascota.getFoto());
		nuevaMascota.setVeterinario(veterinario);
		
		nuevaMascota = this.mascotaDAO.persistir( nuevaMascota );
		duenio.agregarMascota(nuevaMascota);
		
//		si la linea de abajo se descomenta, la mascota se agrega dos veces
//		duenio = this.usuarioDAO.actualizar(duenio);
			
//		seteo el nuevo id
		mascota.setId(nuevaMascota.getId());
		return mascota;
	}
	
	@Transactional
	public boolean eliminarMascotaDuenio(Long id, Long duenio) {
		
		Usuario user = this.usuarioDAO.recuperar(duenio);
		Mascota mascotaABorrar = this.mascotaDAO.recuperar(id);
		
		if((user == null) || (mascotaABorrar == null)) {
			return false;
		}
		
//		chequeo que solo el mismo duenio pueda borrar a su mascota
		if(mascotaABorrar.getDuenio().getId() != duenio) {
			return false;
		}
		
		mascotaDAO.borrar(id);
		user = this.usuarioDAO.actualizar(user);
		return true;
		
	}
	
	@Transactional
	public boolean eliminarMascotaVeterinario(Long id, Long veterinario) {
		
		Usuario user = this.usuarioDAO.recuperar(veterinario);
		Mascota mascotaABorrar = this.mascotaDAO.recuperar(id);
		
		if((user == null) || (mascotaABorrar == null)) {
			return false;
		}
		
//		chequeo que solo el veterinario que la atiende puede borrar la mascota
		if(mascotaABorrar.getVeterinario().getId() != veterinario) {
			return false;
		}
		
		mascotaABorrar.setVeterinario(null);
		mascotaABorrar = this.mascotaDAO.actualizar(mascotaABorrar);
		
		user.getMascotas_atendidas().remove(mascotaABorrar);
		user = this.usuarioDAO.actualizar(user);
		return true;
		
	}
	
	
	//============================
	//    OPERACIONES PRIVADAS
	//============================
	
	private MascotaDTO procesarMascota(Mascota m) {
		MascotaDTO mDTO;
		
		mDTO = new MascotaDTO(m.getNombre(), 
							  m.getFecha_nacimiento().toString(), 
							  m.getEspecie(), 
							  m.getRaza(), 
							  m.getSexo(), 
							  m.getColor(), 
							  m.getSenias()
							  );
		mDTO.setId(m.getId());
		
		if(m.getFoto() != null) {
			mDTO.setFoto(m.getFoto());
		}
		
		//seteo el link a su veterinario
		if( m.getVeterinario() != null) {
			mDTO.setVeterinario("ttps-spring/api/usuario/" + m.getVeterinario().getId());				
		}
		
		return mDTO;
	}

}
