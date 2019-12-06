package ttps.spring.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.sql.rowset.serial.SerialBlob;

import java.util.ArrayList;

@Entity
public class FichaPublica {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private Date fecha_nacimiento;
	private String especie;
	private String raza;
	private String sexo;
	private String color;
	private String senias;
	private String foto;
	private String email_duenio;
	private String nombre_duenio;
	private String apellido_duenio;
	private String telefono_duenio;
	
	//Constructor
	public FichaPublica() {
		super();
	}

	
	//Getters y setters
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}


	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}


	public String getEspecie() {
		return especie;
	}


	public void setEspecie(String especie) {
		this.especie = especie;
	}


	public String getRaza() {
		return raza;
	}


	public void setRaza(String raza) {
		this.raza = raza;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getSenias() {
		return senias;
	}


	public void setSenias(String senias) {
		this.senias = senias;
	}


	public String getEmail_duenio() {
		return email_duenio;
	}


	public void setEmail_duenio(String email_duenio) {
		this.email_duenio = email_duenio;
	}


	public String getNombre_duenio() {
		return nombre_duenio;
	}


	public void setNombre_duenio(String nombre_duenio) {
		this.nombre_duenio = nombre_duenio;
	}


	public String getApellido_duenio() {
		return apellido_duenio;
	}


	public void setApellido_duenio(String apellido_duenio) {
		this.apellido_duenio = apellido_duenio;
	}


	public String getTelefono_duenio() {
		return telefono_duenio;
	}


	public void setTelefono_duenio(String telefono_duenio) {
		this.telefono_duenio = telefono_duenio;
	}



	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	public Long getId() {
		return id;
	}
	
	
	 
	 
}
