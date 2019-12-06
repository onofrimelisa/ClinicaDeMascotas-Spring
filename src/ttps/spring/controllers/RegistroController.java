package ttps.spring.controllers;

import java.sql.Date;
import java.util.Calendar;
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

import ttps.spring.model.dto.UsuarioDTO;
import ttps.spring.model.dto.UsuarioNuevoDTO;
import ttps.spring.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE )
public class RegistroController {

	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<Map<String, Object>> agregarUsuario( @RequestBody UsuarioNuevoDTO uDTO){
		HashMap<String, Object> res = new HashMap();
		
		if (!this.rolValido(uDTO.getRol())) {
			res.put("error", "No se pueden crear usuarios con ese rol.");
			return new ResponseEntity<Map<String, Object>>(res, HttpStatus.BAD_REQUEST);
		}
		
		if (!this.edadValida(uDTO.getFecha_nacimiento())) {
			res.put("error", "Debe ser mayor a 18 años.");
			return new ResponseEntity<Map<String, Object>>(res, HttpStatus.BAD_REQUEST);
		}
		
		if (this.usuarioService.existe( uDTO.getEmail() )) {
			res.put("error", "El email ya existe en el sistema.");
			return new ResponseEntity<Map<String, Object>>(res, HttpStatus.BAD_REQUEST);
		}
		
		UsuarioDTO usuarioNuevo = this.usuarioService.agregar(uDTO);
		
		if (usuarioNuevo == null) {
			return new ResponseEntity<Map<String, Object>>(res, HttpStatus.BAD_REQUEST);
		}
		
		res.put("usuario", usuarioNuevo);
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);	
	}
	
	// ==================
	// VALIDACIONES
	// ==================
	
	private boolean rolValido(String rol) {
		if(rol.equals("admin")) {
			return false;
		}
		return true;
	}
	
	
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
