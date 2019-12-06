package ttps.spring.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.model.dto.UsuarioDTO;
import ttps.spring.model.dto.UsuarioLoginDTO;
import ttps.spring.services.AutenticacionService;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
				produces = MediaType.APPLICATION_JSON_VALUE )
public class AutenticacionController {
	
	@Autowired
	AutenticacionService autenticacionService;
	
	@PostMapping("/login")
	public ResponseEntity<Map<String,Object>> autenticar( @RequestBody UsuarioLoginDTO uDTO) {
		
		UsuarioDTO usuario = autenticacionService.autenticar(uDTO.getEmail(), uDTO.getPassword());
		HashMap<String, Object> res = new HashMap<>();
		
		if(usuario == null) {
			res.put("error", "Credenciales incorrectas");
			return new ResponseEntity<Map<String,Object>>(res, HttpStatus.BAD_REQUEST);
		}
		
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("token", "1234");
	    
	    res.put("id", usuario.getId());
	    res.put("nombre", usuario.getNombre());
	    res.put("apellido", usuario.getApellido());
	    res.put("activo", usuario.getActivo());
	    res.put("roles", usuario.getRoles());
		
		return new ResponseEntity<Map<String,Object>>(res, responseHeaders, HttpStatus.OK);
		
	}
	
}
