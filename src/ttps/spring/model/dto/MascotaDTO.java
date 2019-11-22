package ttps.spring.model.dto;

import java.io.Serializable;

public class MascotaDTO implements Serializable{
	
	private Long id;
	private String nombre;
	private String fecha_nacimiento;
	private String especie;
	private String raza;
	private String sexo;
	private String color;
	private String senias;
	
	private String duenio;
	private String veterinario;
	private String ficha_publica;
	private String eventos;
	
//	CONSTRUCTOR con campos obligatorios
	
	public MascotaDTO () {
		
	}
	
	public MascotaDTO(Long id, String nombre, String fecha_nacimiento, String especie, String raza, String sexo,
			String color, String senias) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha_nacimiento = fecha_nacimiento;
		this.especie = especie;
		this.raza = raza;
		this.sexo = sexo;
		this.color = color;
		this.senias = senias;
	}
	
//	GETTERS Y SETTERS
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(String fecha_nacimiento) {
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
	public String getDuenio() {
		return duenio;
	}
	public void setDuenio(String duenio) {
		this.duenio = duenio;
	}
	public String getVeterinario() {
		return veterinario;
	}
	public void setVeterinario(String veterinario) {
		this.veterinario = veterinario;
	}
	public String getFicha_publica() {
		return ficha_publica;
	}
	public void setFicha_publica(String ficha_publica) {
		this.ficha_publica = ficha_publica;
	}
	public String getEventos() {
		return eventos;
	}
	public void setEventos(String eventos) {
		this.eventos = eventos;
	}
	

}
