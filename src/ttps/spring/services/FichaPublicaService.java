package ttps.spring.services;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.jpa.FichaPublicaDAOHibernateJPA;
import ttps.spring.model.FichaPublica;
import ttps.spring.model.dto.FichaPublicaDTO;

@Service("fichaPublicaService")
public class FichaPublicaService {
	
	private FichaPublicaDAOHibernateJPA fichaPublicaDAO;
	
	@Autowired
	public FichaPublicaService(FichaPublicaDAOHibernateJPA fichaPublicaDAO) {
		this.fichaPublicaDAO = fichaPublicaDAO;
	}
	
	public FichaPublicaService() {
		
	}
	
//	METODOS
	
//	TODO HACER METODOS PRIVADOS PARA PASAR DE FICHApUBLICA A FICHAPUBLICADTO, POR AHORA SOLO SE SETEA EL APELLIDO DEL DUENIO PARA VER SI ANDA
	
	@Transactional
	public List<FichaPublicaDTO> recuperarTodas(){
		
		List<FichaPublicaDTO> fichasDTO= new ArrayList<FichaPublicaDTO>();
		
		List<FichaPublica> fichas = fichaPublicaDAO.recuperarTodos("id");
		
		for (FichaPublica f: fichas) {
			FichaPublicaDTO ficha = new FichaPublicaDTO(f.getId());
			
			ficha = this.procesarFichaPublica(f);
			
			fichasDTO.add(ficha);
		}
		
		return fichasDTO;
		
	}
	
	@Transactional
	public FichaPublicaDTO recuperarPorID( Long id) {
		
		FichaPublica ficha = fichaPublicaDAO.recuperar(id);
		
		if (ficha != null) {
			
			return this.procesarFichaPublica(ficha);
		}
		return null;
		
	}
	
//	OPERACIONES PRIVADAS
	private FichaPublicaDTO procesarFichaPublica(FichaPublica ficha) {
		
		FichaPublicaDTO f = new FichaPublicaDTO( ficha.getId());
		
		f.setApellido_duenio(ficha.getApellido_duenio());
		f.setColor(ficha.getColor());
		f.setDomicilio_duenio(ficha.getDomicilio_duenio());
		f.setEmail_duenio(ficha.getEmail_duenio());
		f.setEspecie(ficha.getEspecie());	
		f.setFoto(ficha.getFoto());
		
		if (ficha.getFecha_nacimiento() != null) {
			f.setFecha_nacimiento(ficha.getFecha_nacimiento().toString());
		}else {
			f.setFecha_nacimiento(null);
		}
		
		f.setSexo(ficha.getSexo());
		f.setNombre(ficha.getNombre());
		f.setNombre_duenio(ficha.getNombre_duenio());
		f.setRaza(ficha.getRaza());
		f.setSenias(ficha.getSenias());
		f.setTelefono_duenio(ficha.getTelefono_duenio());
		
		return f;
	}

}
