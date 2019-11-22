package ttps.spring.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
		
		Usuario duenio = usuarioDAO.recuperarPorId(u);

		List<Mascota> mascotas = duenio.getMascotas();
		
		MascotaDTO mDTO;
		
		for (Mascota m : mascotas) {
			mDTO = new MascotaDTO(m.getNombre(), m.getFecha_nacimiento().toString(), m.getEspecie(), m.getRaza(), m.getSexo(), m.getColor(), m.getSenias());
			mDTO.setId(m.getId());
			//seteo el link a su duenio
			mDTO.setDuenio("ttps-spring/usuario/" + m.getDuenio().getId());
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
		System.out.print(mascota.getDuenio());
//		chequeo si existe el usuario
//		agrego la mascota para ese usuario agregarMascotaDuenio(duenio)
//		la devuelvo
		return mascota;
	}

}
