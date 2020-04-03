package ttps.spring.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/{id_creador}")
	public ResponseEntity<Map<String, Object>> recuperarTodos(@PathVariable Long id_creador) {
		Map<String, Object> resp = new HashMap<String, Object>();
		List<EventoDTO> eventos = eventoService.recuperarPorCreador(id_creador);
		
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
}
