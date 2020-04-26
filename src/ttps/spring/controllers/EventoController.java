package ttps.spring.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.model.dto.EventoDTO;
import ttps.spring.services.EventoService;

@RestController
@RequestMapping(value = "/api/evento", produces = MediaType.APPLICATION_JSON_VALUE)
public class EventoController {
	
	@Autowired
	EventoService eventoService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> recuperar(@PathVariable Long id) {
		Map<String, Object> resp = new HashMap<String, Object>();
		EventoDTO evento = eventoService.recuperar(id);
		
		if(evento == null) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);
		}
		
		resp.put("evento", evento);
		
		return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.OK);
	}
	
	
	@GetMapping("/listado_creador/{id_creador}")
	public ResponseEntity<Map<String, Object>> recuperarCreador(@PathVariable Long id_creador) {
		Map<String, Object> resp = new HashMap<String, Object>();
		List<EventoDTO> eventos = eventoService.recuperarPorCreador(id_creador);
		
		if(eventos.isEmpty()) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);
		}
		
		resp.put("eventos", eventos);
		resp.put("total", eventos.size());
		
		return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.OK);
	}
	
	
	@GetMapping("/duenio/{id_duenio}")
	public ResponseEntity<Map<String, Object>> recuperarDuenio(@PathVariable Long id_duenio) {
		Map<String, Object> resp = new HashMap<String, Object>();
		List<EventoDTO> eventos = eventoService.recuperarPorDuenio(id_duenio);
		
		if(eventos.isEmpty()) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);
		}
		
		resp.put("eventos", eventos);
		resp.put("total", eventos.size());
		
		return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.OK);
	}
	
	@GetMapping("/veterinario/{id_veterinario}")
	public ResponseEntity<Map<String, Object>> recuperarVeterinario(@PathVariable Long id_veterinario) {
		Map<String, Object> resp = new HashMap<String, Object>();
		List<EventoDTO> eventos = eventoService.recuperarPorVeterinario(id_veterinario);
		
		if(eventos.isEmpty()) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);
		}
		
		resp.put("eventos", eventos);
		resp.put("total", eventos.size());
		
		return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<Map<String, Object>> agregarEvento(@RequestBody EventoDTO evento) {
		HashMap<String, Object> res = new HashMap<String, Object>();
		
		EventoDTO nuevo_evento = eventoService.agregar(evento);
		
		if (nuevo_evento == null) {
			return new ResponseEntity<Map<String, Object>>(res, HttpStatus.BAD_REQUEST);
		}
		
		res.put("evento", nuevo_evento);
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Map<String, Object>> actualizarEvento(@PathVariable Long id, @RequestBody EventoDTO evento) {
		HashMap<String, Object> resp = new HashMap<String, Object>();
		
		if( !eventoService.existe(id) ) {
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
		}
		
		evento = eventoService.actualizar(evento);
		
		if (evento == null ) {
			return new ResponseEntity<Map<String,Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
				
		resp.put("evento", evento);
		return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.OK);		
	}
	
	
	
	@PutMapping("/actualizarRecordar/{id_usuario}/{id_evento}")
	public ResponseEntity<Map<String, Object>> actualizarRecordar(@PathVariable Long id_usuario, @PathVariable Long id_evento, @RequestBody EventoDTO evento) {
		HashMap<String, Object> resp = new HashMap<String, Object>();
		
		if( !eventoService.existe(id_evento) ) {
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
		}
		
		evento = eventoService.actualizarRecordar(evento, id_usuario);
		
		if (evento == null ) {
			return new ResponseEntity<Map<String,Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
				
		resp.put("evento", evento);
		return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.OK);		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Object>> eliminarEvento(@PathVariable Long id) {
		HashMap<String, Object> resp = new HashMap<String, Object>();
		if( !eventoService.existe(id) ) {
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
		}
		
		EventoDTO eventoEliminado = this.eventoService.eliminar(id);
		if( eventoEliminado == null ) {
			return new ResponseEntity<Map<String,Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		resp.put("evento", eventoEliminado);
		return new ResponseEntity<Map<String, Object>>(resp, HttpStatus.OK);		
	}
	
	
	
	
	
}
