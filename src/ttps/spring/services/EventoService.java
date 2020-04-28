package ttps.spring.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


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
	public List<EventoDTO> recuperarPorCreador( Long id_creador ) {
		
		Usuario creador = usuarioDAO.recuperar(id_creador);
		
		if( creador == null) {
			return null;
		}
		
		List<Evento> eventos = eventoDAO.recuperarPorCreador(creador, "fecha DESC");
		
		List<Evento> eventosPasados = new ArrayList<Evento>();
		List<Evento> eventosNuevos  = new ArrayList<Evento>(); 
		
		java.util.Date hoy =  new java.util.Date();
		
		for( Evento e: eventos) {
			if( e.getFecha().after(hoy)) {
				eventosNuevos.add(e);
			} else {
				eventosPasados.add(e);
			}	
		}
		
		Collections.sort(eventosNuevos);
		
		List<EventoDTO> eventosDTO = new ArrayList<EventoDTO>();
		
		for( Evento e: eventosNuevos) {
			eventosDTO.add(this.procesarEvento(e));
		}
		for( Evento e: eventosPasados) {
			eventosDTO.add(this.procesarEvento(e));
		}

		
		return eventosDTO;
	}
	
	@Transactional
	public List<EventoDTO> recuperarPorVeterinario( Long id_veterinario ) {
		Usuario veterinario = usuarioDAO.recuperar(id_veterinario);
		
		if( veterinario == null) {
			return null;
		}
		
		List<EventoDTO> eventosDTO = new ArrayList<EventoDTO>();
		
		for( Mascota m: veterinario.getMascotas_atendidas()) {
			for( Evento e: m.getEventos()) {
				eventosDTO.add(this.procesarEvento(e));
			}
		}
		
		return eventosDTO;
	}
	
	@Transactional
	public List<EventoDTO> recuperarPorDuenio( Long id_duenio ) {
		Usuario duenio= usuarioDAO.recuperar(id_duenio);
		
		if( duenio == null) {
			return null;
		}
		
		List<EventoDTO> eventosDTO = new ArrayList<EventoDTO>();
		
		for( Mascota m: duenio.getMascotas()) {
			for( Evento e: m.getEventos()) {
				eventosDTO.add(this.procesarEvento(e));
			}
		}
		
		return eventosDTO;
	}
	
	
	
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
	
	
	@Transactional
	public EventoDTO actualizar( EventoDTO eventoDTO ) {

		Mascota mascota = mascotaDAO.recuperar(eventoDTO.getId_mascota());
		Usuario usuario = usuarioDAO.recuperar(eventoDTO.getUsuario_creador());
		TipoEvento tipo = tipoEventoDAO.recuperarPorNombre(eventoDTO.getTipo());
		Evento evento   = eventoDAO.recuperar(eventoDTO.getId());
		
		if( evento == null || mascota == null || usuario == null || tipo == null) {
			return null;
		}
		
		evento.setTipo(tipo);
		evento.setDescripcion(eventoDTO.getDescripcion());
		evento.setFecha(Date.valueOf(eventoDTO.getFecha()));
		evento.setIndicaciones(eventoDTO.getIndicaciones());
		evento.setDiagnostico(eventoDTO.getDiagnostico());
		evento.setObservaciones(eventoDTO.getObservaciones());
		evento.setDroga(eventoDTO.getDroga());
		evento.setPeso(eventoDTO.getPeso());
		
		evento = eventoDAO.actualizar(evento);
		return eventoDTO;
	}
	
	@Transactional
	public EventoDTO actualizarRecordar( EventoDTO eventoDTO, Long id_usuario ) {

		Mascota mascota = mascotaDAO.recuperar(eventoDTO.getId_mascota());
		Usuario creador = usuarioDAO.recuperar(eventoDTO.getUsuario_creador());
		TipoEvento tipo = tipoEventoDAO.recuperarPorNombre(eventoDTO.getTipo());
		Evento evento   = eventoDAO.recuperar(eventoDTO.getId());
		
		if( evento == null || mascota == null || creador == null || tipo == null) {
			return null;
		}
		
		if( mascota.getDuenio().getId() == id_usuario )
			evento.setRecordar_duenio(!eventoDTO.isRecordar_duenio()); //bug
		else
			evento.setRecordar_veterinario(!eventoDTO.isRecordar_veterinario());
		
		
		evento = eventoDAO.actualizar(evento);
		return eventoDTO;
	}
	
	@Transactional
	public EventoDTO recuperar( Long id ) {
		Evento e = this.eventoDAO.recuperar(id);
		if( e == null) {
			return null;
		}
		return this.procesarEvento(e);
	}
	
	
	@Transactional
	public EventoDTO eliminar( Long id ) {
		Evento e = this.eventoDAO.borrar(id);
		if( e == null) {
			return null;
		}
		return this.procesarEvento(e);
	}
	
	@Transactional
	public boolean existe( Long id ) {
		return eventoDAO.existe(id);
	}
	
	//============================
	//    OPERACIONES PRIVADAS
	//============================
	public EventoDTO procesarEvento( Evento e ) {
		return new EventoDTO(e.getId(),
							 e.getTipo().getNombre(),
							 e.getFecha().toString(),
							 e.getPeso(),
							 e.getDescripcion(),
							 e.getObservaciones(),
							 e.getDiagnostico(),
							 e.getDroga(),
							 e.getIndicaciones(),
							 e.getUsuario_creador().getId(),
							 e.getMascota().getNombre(),
							 e.getMascota().getId(),
							 e.isRecordar_duenio(),
							 e.isRecordar_veterinario());
	
	}
	
	
	
	
	
}
