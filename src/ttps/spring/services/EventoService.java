package ttps.spring.services;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.jpa.EventoDAOHibernateJPA;
import ttps.spring.jpa.MascotaDAOHibernateJPA;
import ttps.spring.jpa.TipoEventoDAOHibernateJPA;
import ttps.spring.jpa.UsuarioDAOHibernateJPA;
import ttps.spring.model.Evento;
import ttps.spring.model.Mascota;
import ttps.spring.model.TipoEvento;
import ttps.spring.model.Usuario;
import ttps.spring.model.dto.EventoDTO;

@Service("eventoService")
public class EventoService {
	
	private EventoDAOHibernateJPA eventoDAO;	
	private MascotaDAOHibernateJPA mascotaDAO;
	private UsuarioDAOHibernateJPA usuarioDAO;
	private TipoEventoDAOHibernateJPA tipoEventoDAO;
	
	@Autowired
	public EventoService(EventoDAOHibernateJPA eventoDAO, MascotaDAOHibernateJPA mascotaDAO,
			UsuarioDAOHibernateJPA usuarioDAO, TipoEventoDAOHibernateJPA tipoEventoDAO) {
		super();
		this.eventoDAO = eventoDAO;
		this.mascotaDAO = mascotaDAO;
		this.usuarioDAO = usuarioDAO;
		this.tipoEventoDAO = tipoEventoDAO;
	}

	public EventoService() { }
	
	
	
	@Transactional
	public EventoDTO agregar( EventoDTO evento ) {
		
//		chequeo si existe la mascota y usuario
		Mascota mascota = mascotaDAO.recuperar(evento.getId_mascota());
		Usuario usuario = usuarioDAO.recuperar(evento.getUsuario_creador());
		TipoEvento tipo = tipoEventoDAO.recuperarPorNombre(evento.getTipo());
		
		if( mascota == null || usuario == null || tipo == null) {
			return null;
		}
		
		
		Evento nuevo_evento = new Evento( tipo, 
										  Date.valueOf(evento.getFecha()),
										  evento.getPeso(),
										  evento.getDescripcion(),
										  evento.getObservaciones(),
										  evento.getDiagnostico(),
										  evento.getDroga(),
										  evento.getIndicaciones(),
										  usuario,
										  mascota);
		
//		Persisto
		nuevo_evento = eventoDAO.persistir(nuevo_evento);
		
		usuario.agregarEvento(nuevo_evento);
		mascota.agregarEvento(nuevo_evento);
		
		usuarioDAO.actualizar(usuario);
		mascotaDAO.actualizar(mascota);
		
		evento.setId(nuevo_evento.getId());
		evento.setNombre_mascota(mascota.getNombre());
		return evento;
	}
	
	
}
