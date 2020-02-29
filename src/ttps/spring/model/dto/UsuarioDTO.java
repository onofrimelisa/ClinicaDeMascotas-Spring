package ttps.spring.model.dto;

import java.io.Serializable;
import java.util.List;

import ttps.spring.model.Rol;


public class UsuarioDTO implements Serializable {

	private Long id;
	private String apellido;
	private String nombre;
	private String email;
	private String fecha_nacimiento;
	private String telefono;
	private Boolean activo;	
	private List<String> roles;	
	
//	veterinario
	private String nombre_consultorio;
	private String domicilio_consultorio;
	private String matricula;

	
	
//	Constructor para el show
	public UsuarioDTO(Long id, String apellido, String nombre, String email, String fecha_nacimiento, String telefono,
			Boolean activo, List<String> roles) {
		super();
		this.id = id;
		this.apellido = apellido;
		this.nombre = nombre;
		this.email = email;
		this.fecha_nacimiento = fecha_nacimiento;
		this.telefono = telefono;
		this.activo = activo;
		this.roles = roles;
	}
	
	public UsuarioDTO(String apellido, String nombre, String email, String fecha_nacimiento, String telefono,
			Boolean activo, List<String> roles) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.email = email;
		this.fecha_nacimiento = fecha_nacimiento;
		this.telefono = telefono;
		this.activo = activo;
		this.roles = roles;
	}

	public UsuarioDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}


	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public Boolean getActivo() {
		return activo;
	}


	public void setActivo(Boolean activo) {
		this.activo = activo;
	}


	public List<String> getRoles() {
		return roles;
	}


	public void setRoles(List<String> roles) {
		this.roles = roles;
	}


	public String getNombre_consultorio() {
		return nombre_consultorio;
	}


	public void setNombre_consultorio(String nombre_consultorio) {
		this.nombre_consultorio = nombre_consultorio;
	}


	public String getDomicilio_consultorio() {
		return domicilio_consultorio;
	}


	public void setDomicilio_consultorio(String domicilio_consultorio) {
		this.domicilio_consultorio = domicilio_consultorio;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	
}
