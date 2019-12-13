package ttps.spring.model.dto;

import java.io.Serializable;
import java.util.List;

import ttps.spring.model.Rol;

public class PayloadDTO implements Serializable{
	
	private Long usuario;
	private List<String> roles;
	private boolean activo;
	
	public PayloadDTO() {
		// TODO Auto-generated constructor stub
	}

	public PayloadDTO(Long usuario, List<String> roles, boolean activo) {
		super();
		this.usuario = usuario;
		this.roles = roles;
		this.activo = activo;
	}

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
	
	
}
