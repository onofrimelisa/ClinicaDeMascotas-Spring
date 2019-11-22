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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.model.dto.MascotaDTO;
import ttps.spring.services.MascotaService;

@RestController
@RequestMapping(value = "/mascota", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class MascotaController {

	@Autowired
	MascotaService mascotaService;
	
	@GetMapping("/duenio/{duenio}")
	public ResponseEntity<Map<String, Object>> recuperarPorDuenio( @PathVariable("duenio") Long duenio, @RequestHeader(value = "token", required = false)String token){
//		CHEQUEO SI ESTÁ LOGGEADO
		System.out.print(token);
		HashMap<String, Object> res = new HashMap();
		
		if (token == null || !token.equals("1234")) {
			res.put("error", "Token inválido");
			return new ResponseEntity<Map<String, Object>>(res, HttpStatus.BAD_REQUEST);
		}
		
		List<MascotaDTO> mascotas = mascotaService.recuperarPorDuenio(duenio);
		
		if (mascotas.isEmpty()) {
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);
		}
		
		res.put("total", mascotas.size());
		res.put("mascotas", mascotas);
		
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Map<String, Object>> agregarMascota(@RequestBody MascotaDTO mascota, @RequestHeader(value = "token", required = false)String token){
//		CHEQUEO SI ESTÁ LOGGEADO
		HashMap<String, Object> res = new HashMap();
		
		if (token == null || !token.equals("1234")) {
			res.put("error", "Token inválido");
			return new ResponseEntity<Map<String, Object>>(res, HttpStatus.BAD_REQUEST);
		}
		
		MascotaDTO mascotaNueva = this.mascotaService.agregarMascota(mascota);
		
		if (mascotaNueva != null) {
			res.put("mascota", mascotaNueva);
			return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
		}
		
		//no la pudo agregar
		
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.BAD_REQUEST);
		
	}
}
