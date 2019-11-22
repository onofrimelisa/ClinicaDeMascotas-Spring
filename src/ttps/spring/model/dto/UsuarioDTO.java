package ttps.spring.model.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import ttps.spring.model.Rol;


public class UsuarioDTO implements Serializable {

	private Long id;
	private String apellido;
	private String nombre;
	private String email;
	private Date fecha_nacimiento;
	private String telefono;
	private Boolean activo;	
	private List<Rol> roles;	
	private String eventos;
	private String recordatorios;
	
//	veterinario
	private String nombre_consultorio;
	private String domicilio_consultorio;
	private String matricula;

	
//	mascotas
	private String mascotas;
	private String mascotas_atendidas;
	
	
//	Constructor campos obligatorios
	public UsuarioDTO(Long id, String apellido, String nombre, String email, Date fecha_nacimiento, String telefono,
			Boolean activo, List<Rol> roles) {
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

	

	public String getEventos() {
		return eventos;
	}


	public void setEventos(String eventos) {
		this.eventos = eventos;
	}


	public String getRecordatorios() {
		return recordatorios;
	}


	public void setRecordatorios(String recordatorios) {
		this.recordatorios = recordatorios;
	}


	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}


	public void setFecha_nacimiento(Date fecha_nacimiento) {
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


	public List<Rol> getRoles() {
		return roles;
	}


	public void setRoles(List<Rol> roles) {
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


	public String getMascotas() {
		return mascotas;
	}


	public void setMascotas(String mascotas) {
		this.mascotas = mascotas;
	}


	public String getMascotas_atendidas() {
		return mascotas_atendidas;
	}


	public void setMascotas_atendidas(String mascotas_atendidas) {
		this.mascotas_atendidas = mascotas_atendidas;
	}
	
	
	
	
	
	
}
