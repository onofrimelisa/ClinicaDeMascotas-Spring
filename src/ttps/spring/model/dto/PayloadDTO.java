package ttps.spring.model.dto;

import java.io.Serializable;
import java.util.List;

import ttps.spring.model.Rol;

public class PayloadDTO implements Serializable{
	
	private Long usuario;
	private List<String> roles;
	
	public PayloadDTO() {
		// TODO Auto-generated constructor stub
	}

	public PayloadDTO(Long usuario, List<String> roles) {
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

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	
	
}
