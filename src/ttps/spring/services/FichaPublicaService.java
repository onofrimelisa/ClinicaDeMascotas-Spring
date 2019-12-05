package ttps.spring.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.jpa.FichaPublicaDAOHibernateJPA;
import ttps.spring.jpa.MascotaDAOHibernateJPA;
import ttps.spring.model.FichaPublica;
import ttps.spring.model.Mascota;
import ttps.spring.model.dto.FichaPublicaDTO;

@Service("fichaPublicaService")
public class FichaPublicaService {
	
	private FichaPublicaDAOHibernateJPA fichaPublicaDAO;
	private MascotaDAOHibernateJPA mascotaDAO;
	
	@Autowired
	public FichaPublicaService(FichaPublicaDAOHibernateJPA fichaPublicaDAO, MascotaDAOHibernateJPA mascotaDAO) {
		this.fichaPublicaDAO = fichaPublicaDAO;
		this.mascotaDAO = mascotaDAO;
	}
	
	public FichaPublicaService() {
		
	}
	
//	METODOS
	
	
	@Transactional
	public List<FichaPublicaDTO> recuperarTodas(){
		
		List<FichaPublicaDTO> fichasDTO= new ArrayList<FichaPublicaDTO>();
		
		List<FichaPublica> fichas = fichaPublicaDAO.recuperarTodos("id");
		
		for (FichaPublica f: fichas) {
//			devuelve solo las que tengan fotos cargadas
			if (f.getFoto() != null) {
				FichaPublicaDTO ficha = new FichaPublicaDTO(f.getId());
				
				ficha = this.procesarFichaPublica(f);
				
				fichasDTO.add(ficha);
			}
			
		}
		
		return fichasDTO;
		
	}
	
//	RECUPERAR UN NUMERO DETERMINADO DE FICHAS, SE USA PARA MOSTRARLAS EN EL HOME
	@Transactional
	public List<FichaPublicaDTO> recuperarCantidad (String unaCantidad ){
		
		List<FichaPublicaDTO> fichasDTO= new ArrayList<FichaPublicaDTO>();
		
		Integer cantidad = fichaPublicaDAO.getCantidadFichasConFoto();
		
		if (cantidad < Integer.valueOf(unaCantidad)) {
			return null;
		}
		
		List<FichaPublica> fichas = fichaPublicaDAO.recuperarCantidad( unaCantidad );
		
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
//			la devuelve solo si tiene la foto cargada
			if (ficha.getFoto() != null) {
				return this.procesarFichaPublica(ficha);
			}
			
		}
		return null;
		
	}
	
	@Transactional
	public FichaPublicaDTO agregarFichaPublica( FichaPublicaDTO ficha_publica ) {
		
//		chequeo si existe la mascota
		Mascota mascota = mascotaDAO.recuperar(ficha_publica.getMascota());
		if( mascota == null) {
			return null;
		}
		
		FichaPublica nueva_ficha = new FichaPublica();
		
		nueva_ficha.setNombre(ficha_publica.getNombre());
		nueva_ficha.setFecha_nacimiento( Date.valueOf( ficha_publica.getFecha_nacimiento() ) );
		nueva_ficha.setEspecie(ficha_publica.getEspecie());
		nueva_ficha.setRaza(ficha_publica.getRaza());
		nueva_ficha.setSenias(ficha_publica.getSenias());
		nueva_ficha.setSexo(ficha_publica.getSexo());
		nueva_ficha.setColor(ficha_publica.getColor());
		nueva_ficha.setEmail_duenio(ficha_publica.getEmail_duenio());
		nueva_ficha.setApellido_duenio(ficha_publica.getApellido_duenio());
		nueva_ficha.setNombre_duenio(ficha_publica.getNombre_duenio());
		nueva_ficha.setTelefono_duenio(ficha_publica.getTelefono_duenio());
		nueva_ficha.setFoto(ficha_publica.getFoto());
		
//		PERSISTO
		nueva_ficha = this.fichaPublicaDAO.persistir(nueva_ficha);
		mascota.setFicha_publica(nueva_ficha);
		mascota = this.mascotaDAO.actualizar(mascota);
		
		ficha_publica.setId( nueva_ficha.getId() );
		return ficha_publica;
		
	}
	
//	OPERACIONES PRIVADAS
	private FichaPublicaDTO procesarFichaPublica(FichaPublica ficha) {
		
		FichaPublicaDTO f = new FichaPublicaDTO( ficha.getId());
		
		f.setApellido_duenio(ficha.getApellido_duenio());
		f.setColor(ficha.getColor());
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
