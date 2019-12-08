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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.model.dto.UsuarioDTO;
import ttps.spring.model.dto.UsuarioUpdateDTO;
import ttps.spring.model.dto.UsuarioUpdatePersonalesDTO;
import ttps.spring.model.dto.UsuarioUpdateProfesionalesDTO;
import ttps.spring.services.UsuarioService;

@RestController
@RequestMapping(value = "/api/usuario", produces = MediaType.APPLICATION_JSON_VALUE )
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<Map<String,Object>> recuperarTodos() {
		List<UsuarioDTO> usuarios = usuarioService.recuperarTodos();
		HashMap<String, Object> res = new HashMap<>();
		
		if(usuarios.isEmpty()) {
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
		}
		
		res.put("total", usuarios.size());
		res.put("usuarios", usuarios);
		
		return new ResponseEntity<Map<String,Object>>(res, HttpStatus.OK);

	}
	
	
	@GetMapping("/rol/{rol}")
	public ResponseEntity<Map<String,Object>> recuperarPorRol( @PathVariable("rol") String rol){
		
		List<UsuarioDTO> usuarios = usuarioService.recuperarPorRol(rol);
		HashMap<String, Object> res = new HashMap<>();
		
		if(usuarios.isEmpty()) {
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
		}
		
		res.put("total", usuarios.size());
		res.put("usuarios", usuarios);
		
		return new ResponseEntity<Map<String,Object>>(res, HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> recuperar( @PathVariable("id") Long id){
		
		UsuarioDTO usuario = usuarioService.recuperar(id);
		HashMap<String, Object> res = new HashMap<>();
		
		if(usuario == null) {
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
		}
		res.put("usuario", usuario);
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
	
	}
	
	@PutMapping("/personales/{id}")
	public ResponseEntity<Map<String, Object>> modificarDatosPersonales ( @PathVariable("id") Long id, @RequestBody UsuarioUpdatePersonalesDTO uDTO){
		
		UsuarioDTO usuario = usuarioService.recuperar(id);
		HashMap<String, Object> res = new HashMap<>();
		
		if(usuario == null || usuario.getId() != uDTO.getId()) {
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
		}
		
		UsuarioUpdateDTO usuarioActualizado = this.usuarioService.actualizarPersonales(uDTO);
		
		if(usuarioActualizado == null) {
			res.put("error", "El email seleccionado ya existe");
			return new ResponseEntity<Map<String,Object>>(res, HttpStatus.BAD_REQUEST);
		}
		
		res.put("usuario", usuarioActualizado);
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
		
	}
	
	
	@PutMapping("/profesionales/{id}")
	public ResponseEntity<Map<String, Object>> modificarDatosProfesionales ( @PathVariable("id") Long id, @RequestBody UsuarioUpdateProfesionalesDTO uDTO){
		UsuarioDTO usuario = usuarioService.recuperar(id);
		HashMap<String, Object> res = new HashMap<>();
		
		if(usuario == null || usuario.getId() != uDTO.getId()) {
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
		}
		
		UsuarioUpdateDTO usuarioActualizado = this.usuarioService.actualizarProfesionales(uDTO);
		
		res.put("usuario", usuarioActualizado);
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
		
	}
	
	
}
