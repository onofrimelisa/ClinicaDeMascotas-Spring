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

import ttps.spring.model.dto.PayloadDTO;
import ttps.spring.model.dto.UsuarioDTO;
import ttps.spring.model.dto.UsuarioLoginDTO;
import ttps.spring.model.dto.UsuarioShowDTO;
import ttps.spring.services.AutenticacionService;
import ttps.spring.services.TokenService;
import ttps.spring.services.UsuarioService;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
				produces = MediaType.APPLICATION_JSON_VALUE )
public class AutenticacionController {
	
	@Autowired
	AutenticacionService autenticacionService;
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	TokenService tokenService;
	
	// 15 minutos
    private final int EXPIRATION_IN_SEC = 900;
    
	@PostMapping("/login")
	public ResponseEntity<Map<String,Object>> autenticar( @RequestBody UsuarioLoginDTO uDTO) {
		
		UsuarioDTO usuario = autenticacionService.autenticar(uDTO.getEmail(), uDTO.getPassword());
		HashMap<String, Object> res = new HashMap<>();
		
		if(usuario == null) {
			res.put("error", "Credenciales incorrectas");
			return new ResponseEntity<Map<String,Object>>(res, HttpStatus.BAD_REQUEST);
		}new ResponseEntity<Map<String,Object>>(res, HttpStatus.BAD_REQUEST);
				
		
		if (!usuario.getActivo()) {
			res.put("error", "Ese usuario está inactivo, debe esperar activación por parte de nuestro administrador.");
			return new ResponseEntity<Map<String,Object>>(res, HttpStatus.BAD_REQUEST);
		}
		
		//Creo payload
		PayloadDTO payload = new PayloadDTO(usuario.getId(), usuario.getRoles(), usuario.getActivo());
		
		//Genero token
		String token = tokenService.generateToken(payload, EXPIRATION_IN_SEC);		
		res.put("token", token);
		
		//Genero usuario
		UsuarioDTO uShowDTO = usuarioService.recuperar(usuario.getId());
	    res.put("usuario", uShowDTO);
		
		return new ResponseEntity<Map<String,Object>>(res, HttpStatus.OK);
		
	}
	
}
