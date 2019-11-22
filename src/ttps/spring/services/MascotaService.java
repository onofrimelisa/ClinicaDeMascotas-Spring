package ttps.spring.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.jpa.MascotaDAOHibernateJPA;
import ttps.spring.jpa.UsuarioDAOHibernateJPA;
import ttps.spring.model.Mascota;
import ttps.spring.model.Usuario;
import ttps.spring.model.dto.MascotaDTO;

@Service("mascotaService")
public class MascotaService {

	private MascotaDAOHibernateJPA mascotaDAO;	
	private UsuarioDAOHibernateJPA usuarioDAO;	
	
	@Autowired
	public MascotaService(MascotaDAOHibernateJPA mascotaDAO, UsuarioDAOHibernateJPA usuarioDAO) {
		super();
		this.mascotaDAO = mascotaDAO;
		this.usuarioDAO = usuarioDAO;
	}
	
	public MascotaService() {
		
	}
	
	// METODOS
	
	@Transactional
	public List<MascotaDTO> recuperarPorDuenio(Long u){
		
		
		List<MascotaDTO> mascotasDTO = new ArrayList<MascotaDTO>();
		
		Usuario duenio = usuarioDAO.recuperar(u);
		if(duenio == null) {
			return null;
		}

		List<Mascota> mascotas = duenio.getMascotas();
		
		MascotaDTO mDTO;
		
		for (Mascota m : mascotas) {
			mDTO = new MascotaDTO(m.getNombre(), m.getFecha_nacimiento().toString(), m.getEspecie(), m.getRaza(), m.getSexo(), m.getColor(), m.getSenias());
			mDTO.setId(m.getId());
			//seteo el link a su veterinario
			if( m.getVeterinario() != null) {
				mDTO.setVeterinario("ttps-spring/usuario/" + m.getVeterinario().getId());				
			}
			
			//agrego a la lista a devolver
			mascotasDTO.add(mDTO);
		}
		
		return mascotasDTO;
	}
	
	@Transactional
	public MascotaDTO agregarMascota(MascotaDTO mascota) {
		System.out.print(Long.valueOf(mascota.getDuenio()));
//		chequeo si existe el usuario
		
		Usuario duenio = this.usuarioDAO.recuperar(Long.valueOf(mascota.getDuenio()));
		if (duenio == null) {
			return null;
		}
		
		Mascota nuevaMascota = new Mascota(mascota.getNombre(), 
										   Date.valueOf(mascota.getFecha_nacimiento()), 
										   mascota.getEspecie(), 
										   mascota.getRaza(), 
										   mascota.getSexo(), 
										   mascota.getColor(), 
										   mascota.getSenias(), 
										   duenio);
		
		nuevaMascota = this.mascotaDAO.persistir( nuevaMascota );
		duenio.agregarMascota(nuevaMascota);
		duenio = this.usuarioDAO.actualizar(duenio);
			
//		seteo el nuevo id
		mascota.setId(nuevaMascota.getId());
		return mascota;
	}

}
