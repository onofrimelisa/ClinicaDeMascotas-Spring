package ttps.spring.model.dto;

import java.io.Serializable;
import java.util.List;

import ttps.spring.model.Rol;

public class PayloadDTO implements Serializable{
	
	private Long usuario;
	private List<Rol> roles;
	
	public PayloadDTO() {
		// TODO Auto-generated constructor stub
	}

	public PayloadDTO(Long usuario, List<Rol> roles) {
		super();
		this.usuario = usuario;
		this.roles = roles;
	}

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	
	
	
}
