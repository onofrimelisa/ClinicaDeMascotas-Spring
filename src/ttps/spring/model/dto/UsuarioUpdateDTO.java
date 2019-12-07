package ttps.spring.model.dto;

import java.io.Serializable;

public class UsuarioUpdateDTO implements Serializable{
	
	private String password;
	private String foto;
	private String apellido;
	private String nombre;
	private String email;
	private String fecha_nacimiento;
	private String telefono;
	
//	veterinario
	private String nombre_consultorio;
	private String domicilio_consultorio;
	private String matricula;
	
	public UsuarioUpdateDTO() {
		
	}

	public UsuarioUpdateDTO(String password, String foto, String apellido, String nombre, String email,
			String fecha_nacimiento, String telefono, String nombre_consultorio, String domicilio_consultorio,
			String matricula) {
		super();
		this.password = password;
		this.foto = foto;
		this.apellido = apellido;
		this.nombre = nombre;
		this.email = email;
		this.fecha_nacimiento = fecha_nacimiento;
		this.telefono = telefono;
		this.nombre_consultorio = nombre_consultorio;
		this.domicilio_consultorio = domicilio_consultorio;
		this.matricula = matricula;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
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
