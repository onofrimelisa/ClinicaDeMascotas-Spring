package ttps.spring.controllers;

import java.util.Calendar;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.model.dto.MascotaDTO;
import ttps.spring.model.dto.UsuarioDTO;
import ttps.spring.model.dto.UsuarioUpdateDTO;
import ttps.spring.services.MascotaService;
import ttps.spring.services.UsuarioService;

@RestController
@RequestMapping(value = "/api/usuario", produces = MediaType.APPLICATION_JSON_VALUE )
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	@Autowired
	MascotaService mascotaService;
	
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
	
	@PutMapping("/agregar_atendidas/{id_mascota}")
	public ResponseEntity<Map<String, Object>> agregarMascotaVeterinario( @PathVariable("id_mascota") Long id, @RequestBody UsuarioUpdateDTO uDTO){
		
		UsuarioDTO usuario = usuarioService.recuperar(uDTO.getId());
		MascotaDTO mascota = mascotaService.recuperar(id);
		
		HashMap<String, Object> res = new HashMap<>();
		
		if(usuario == null || mascota == null) {
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
		}
		
		UsuarioUpdateDTO usuarioActualizado = this.usuarioService.agregarMascota(usuario, mascota);
		
		res.put("usuario", usuarioActualizado);
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Map<String, Object>> actualizar( @PathVariable("id") Long id, @RequestBody UsuarioUpdateDTO uDTO){
		
		UsuarioDTO usuario = usuarioService.recuperar(id);
		HashMap<String, Object> res = new HashMap<>();
		
		if(usuario == null || usuario.getId() != uDTO.getId()) {
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
		}
		
		if (!this.edadValida(uDTO.getFecha_nacimiento())) {
			res.put("error", "Debe ser mayor a 18 años.");
			return new ResponseEntity<Map<String, Object>>(res, HttpStatus.BAD_REQUEST);
		}
		

		UsuarioUpdateDTO usuarioActualizado = this.usuarioService.actualizar(uDTO);
		
		if(usuarioActualizado == null) {
			res.put("error", "El email seleccionado ya existe");
			return new ResponseEntity<Map<String,Object>>(res, HttpStatus.BAD_REQUEST);
		}
		
		res.put("usuario", usuarioActualizado);
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
		
	}
	

	@DeleteMapping("/{rol}/{id}")
	public ResponseEntity<Map<String,Object>> eliminarPorRol( @PathVariable("rol") String rol, @PathVariable("id") Long id){
		
		UsuarioDTO usuario = usuarioService.recuperar(id);
		HashMap<String, Object> res = new HashMap<>();
		
		if(usuario == null) {
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
		}

		UsuarioDTO usuarioBorrado = usuarioService.eliminarPorRol(usuario, rol);
		
		if(usuarioBorrado == null) {
			return new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}

		res.put("usuario", usuarioBorrado);			
		return new ResponseEntity<Map<String,Object>>(res, HttpStatus.OK);
	}
	
	@PutMapping("/{id_usuario}/{rol}")
	public ResponseEntity<Map<String, Object>> agregarRol( @PathVariable("id_usuario") Long id,@PathVariable("rol") String rol, @RequestBody UsuarioUpdateDTO uDTO){
		HashMap<String, Object> res = new HashMap<>();
		UsuarioDTO usuario = usuarioService.recuperar(id);
		
		if(usuario == null) {
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);
		}
		
		UsuarioDTO usuarioActualizado = this.usuarioService.agregarRol(uDTO, rol);
		
		
		res.put("usuario", usuarioActualizado);			
		return new ResponseEntity<Map<String,Object>>(res, HttpStatus.OK);
		
	}
	
	
	// ==================
	// VALIDACIONES
	// ==================
	
	
	private boolean edadValida(String fecha_nacimiento) {
		String[] fechaNac = fecha_nacimiento.split("-");
		Calendar fechaActual = Calendar.getInstance();
		 
        // Cálculo de las diferencias.
        int years = fechaActual.get(Calendar.YEAR) - Integer.valueOf(fechaNac[0]);
        int months = fechaActual.get(Calendar.MONTH) + 1 - Integer.valueOf(fechaNac[1]);
        int days = fechaActual.get(Calendar.DAY_OF_MONTH) - Integer.valueOf(fechaNac[2]);
        
        if ( ( years > 18 ) || ( years == 18 && months  >= 0 && days >= 0 ) ){
        	return true;
        }
        
        return false;
	}
	
	
}
