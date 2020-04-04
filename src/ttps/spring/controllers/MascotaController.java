package ttps.spring.controllers;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.model.dto.MascotaDTO;
import ttps.spring.services.MascotaService;

@RestController
@RequestMapping(value = "/api/mascota", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class MascotaController {

	@Autowired
	MascotaService mascotaService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> recuperarMascota( @PathVariable("id") Long id){
		
		HashMap<String, Object> res = new HashMap();
		
		
		MascotaDTO mascota = mascotaService.recuperar(id);
		
		if (mascota == null) {
			res.put("mascota", null);
			return new ResponseEntity<Map<String, Object>>(res, HttpStatus.NO_CONTENT);
		}
		
		res.put("mascota", mascota);
		
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
		
	}
	
	@GetMapping("/{rol}/{usuario}")
	public ResponseEntity<Map<String, Object>> recuperarPorDuenio( @PathVariable("usuario") Long usuario, @PathVariable("rol") String rol){
		
		HashMap<String, Object> res = new HashMap();
		
		
		List<MascotaDTO> mascotas = mascotaService.recuperarPorUsuario(usuario, rol);
		
		if (mascotas == null || mascotas.isEmpty()) {
			res.put("mascotas", null);
			return new ResponseEntity<Map<String, Object>>(res, HttpStatus.NO_CONTENT);
		}
		
		res.put("total", mascotas.size());
		res.put("mascotas", mascotas);
		
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
		
	}
	

	@GetMapping("/sinveterinario")
	public ResponseEntity<Map<String, Object>> recuperarSinVeterinario(){
//		
		HashMap<String, Object> res = new HashMap();
		
		
		List<MascotaDTO> mascotas = mascotaService.recuperarSinVeterinario();
		
		if (mascotas == null || mascotas.isEmpty()) {
			res.put("mascotas", null);
			return new ResponseEntity<Map<String, Object>>(res, HttpStatus.NO_CONTENT);
		}
		
		res.put("total", mascotas.size());
		res.put("mascotas", mascotas);
		
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Map<String, Object>> agregarMascota(@RequestBody MascotaDTO mascota){
		HashMap<String, Object> res = new HashMap();
				
		MascotaDTO mascotaNueva = this.mascotaService.agregarMascota(mascota);
		
		if (mascotaNueva == null) {
			return new ResponseEntity<Map<String, Object>>(res, HttpStatus.BAD_REQUEST);
		}
		
		res.put("mascota", mascotaNueva);
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/{mascota}/duenio/{duenio}")
	public ResponseEntity<Map<String, Object>> borrarMascotaDuenio( @PathVariable("mascota") Long id, @PathVariable("duenio") Long duenio){
		HashMap<String, Object> res = new HashMap();
		
		boolean elimino = this.mascotaService.eliminarMascotaDuenio(id, duenio);
		
		if (!elimino) {
			return new ResponseEntity<Map<String, Object>>(res, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{mascota}/veterinario/{veterinario}")
	public ResponseEntity<Map<String, Object>> borrarMascotaVeterinario( @PathVariable("mascota") Long id, @PathVariable("veterinario") Long veterinario){
		HashMap<String, Object> res = new HashMap();
		
		boolean elimino = this.mascotaService.eliminarMascotaVeterinario(id, veterinario);
		
		if (!elimino) {
			return new ResponseEntity<Map<String, Object>>(res, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
		
	}
}
