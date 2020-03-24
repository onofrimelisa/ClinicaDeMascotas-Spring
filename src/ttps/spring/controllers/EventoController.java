package ttps.spring.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.model.dto.EventoDTO;
import ttps.spring.services.EventoService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class EventoController {
	
	@Autowired
	EventoService eventoService;
	
	
	@PostMapping("/api/evento")
	public ResponseEntity<Map<String, Object>> agregarEvento(@RequestBody EventoDTO evento) {
		HashMap<String, Object> res = new HashMap();
		
		EventoDTO nuevo_evento = eventoService.agregar(evento);
		
		if (nuevo_evento == null) {
			return new ResponseEntity<Map<String, Object>>(res, HttpStatus.BAD_REQUEST);
		}
		
		res.put("evento", nuevo_evento);
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
	}
}
