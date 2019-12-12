package ttps.spring.model.dto;

import java.io.Serializable;
import java.util.List;

import ttps.spring.model.Rol;

public class UsuarioShowDTO extends UsuarioDTO implements Serializable {

	private List<MascotaDTO> mascotas;
	private List<MascotaDTO> mascotas_atendidas;
	private String foto;
	
	public UsuarioShowDTO(Long id, String apellido, String nombre, String email, String fecha_nacimiento,
			String telefono, Boolean activo, List<String> roles) {
		
		super(id, apellido, nombre, email, fecha_nacimiento, telefono, activo, roles);
	}
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<MascotaDTO> getMascotas() {
		return mascotas;
	}

	public void setMascotas(List<MascotaDTO> mascotas) {
		this.mascotas = mascotas;
	}

	public List<MascotaDTO> getMascotas_atendidas() {
		return mascotas_atendidas;
	}

	public void setMascotas_atendidas(List<MascotaDTO> mascotas_atendidas) {
		this.mascotas_atendidas = mascotas_atendidas;
	}
	
}
