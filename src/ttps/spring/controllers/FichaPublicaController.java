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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.model.dto.FichaPublicaDTO;
import ttps.spring.services.FichaPublicaService;

@RestController
@RequestMapping(value = "/ficha_publica", produces = MediaType.APPLICATION_JSON_VALUE)
public class FichaPublicaController {
	
	@Autowired
	FichaPublicaService fichaPublicaService;
	
	@GetMapping()
	public ResponseEntity<Map<String,Object>> recuperarTodos() {
		
		List<FichaPublicaDTO> fichas_publicas = fichaPublicaService.recuperarTodas()
;		
		HashMap<String, Object> res = new HashMap<>();
		
		if (fichas_publicas.isEmpty()) {
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
		}
		
		res.put("total", fichas_publicas.size());
		res.put("fichas_publicas", fichas_publicas);
		return new ResponseEntity<Map<String,Object>>(res, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Map<String,Object>> recuperarPorID( @PathVariable("id") Long id) {
		
		FichaPublicaDTO ficha_publica = fichaPublicaService.recuperarPorID(id);
		
		HashMap<String, Object> res = new HashMap<>();
		
		if (ficha_publica == null ) {
			
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
		}
		
		res.put("ficha_publica", ficha_publica);
		return new ResponseEntity<Map<String,Object>>(res, HttpStatus.OK);
		
	}
	
//	EL POST MAPPING PARA CREAR UNA FICHA PUBLICA DEBE CHEQUEAR QUE ESTÉ LOGGEADO?

}
