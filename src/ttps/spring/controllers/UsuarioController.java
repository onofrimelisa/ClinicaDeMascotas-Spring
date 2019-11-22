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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.model.Usuario;
import ttps.spring.model.dto.UsuarioDTO;
import ttps.spring.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE )
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<Map<String,Object>> recuperarTodos(@RequestHeader(value = "token", required = false)String token) {
		List<UsuarioDTO> usuarios = usuarioService.recuperarTodos();
		HashMap<String, Object> res = new HashMap<>();
		
		if (token == null || !token.equals("1234")) {
			res.put("error", "Token inválido");
			return new ResponseEntity<Map<String, Object>>(res, HttpStatus.BAD_REQUEST);
		}
		
		if(usuarios.isEmpty()) {
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
		}
		
		res.put("total", usuarios.size());
		res.put("usuarios", usuarios);
		
		return new ResponseEntity<Map<String,Object>>(res, HttpStatus.OK);

	}
	
	
	@GetMapping("/rol/{rol}")
	public ResponseEntity<Map<String,Object>> recuperarPorRol( @PathVariable("rol") String rol, @RequestHeader(value = "token", required = false)String token){
		
		List<UsuarioDTO> usuarios = usuarioService.recuperarPorRol(rol);
		HashMap<String, Object> res = new HashMap<>();
		
		if (token == null || !token.equals("1234")) {
			res.put("error", "Token inválido");
			return new ResponseEntity<Map<String, Object>>(res, HttpStatus.BAD_REQUEST);
		}
		
		if(usuarios.isEmpty()) {
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
		}
		
		res.put("total", usuarios.size());
		res.put("usuarios", usuarios);
		
		return new ResponseEntity<Map<String,Object>>(res, HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> recuperar( @PathVariable("id") Long id, @RequestHeader(value = "token", required = false)String token){
		
		UsuarioDTO usuario = usuarioService.recuperar(id);
		HashMap<String, Object> res = new HashMap<>();
		
		if(usuario == null) {
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
		}
		res.put("usuario", usuario);
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
	
	}
	
	
	
	
	
	
}
