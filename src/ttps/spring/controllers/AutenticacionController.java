package ttps.spring.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.model.Usuario;
import ttps.spring.model.dto.UsuarioLoginDTO;
import ttps.spring.services.AutenticacionService;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
				produces = MediaType.APPLICATION_JSON_VALUE )
public class AutenticacionController {
	
	@Autowired
	AutenticacionService autenticacionService;
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> autenticar( @RequestBody UsuarioLoginDTO uDTO) {
		
		Usuario usuario = autenticacionService.autenticar(uDTO.getEmail(), uDTO.getPassword());
		
		if(usuario == null) {
			return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
		}
		
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("token", "1234");
	    
	    return new ResponseEntity<Usuario>(usuario, responseHeaders ,HttpStatus.OK);
		
	}
	
}
