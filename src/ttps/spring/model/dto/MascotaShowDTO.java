package ttps.spring.model.dto;

import java.io.Serializable;
import java.util.List;

public class MascotaShowDTO  implements Serializable{
	
	private Long id;
	private String nombre;
	private String fecha_nacimiento;
	private String especie;
	private String raza;
	private String sexo;
	private String color;
	private String senias;
	private String foto;
	
	private UsuarioDTO duenio;
	private UsuarioDTO veterinario;
	
	private List<EventoDTO> eventos;
	
	public MascotaShowDTO() {
		// TODO Auto-generated constructor stub
	}

	public MascotaShowDTO(Long id, String nombre, String fecha_nacimiento, String especie, String raza, String sexo,
			String color, String senias, String foto, UsuarioDTO duenio, UsuarioDTO veterinario,
			List<EventoDTO> eventos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha_nacimiento = fecha_nacimiento;
		this.especie = especie;
		this.raza = raza;
		this.sexo = sexo;
		this.color = color;
		this.senias = senias;
		this.foto = foto;
		this.duenio = duenio;
		this.veterinario = veterinario;
		this.eventos = eventos;
	}

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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public UsuarioDTO getDuenio() {
		return duenio;
	}

	public void setDuenio(UsuarioDTO duenio) {
		this.duenio = duenio;
	}

	public UsuarioDTO getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(UsuarioDTO veterinario) {
		this.veterinario = veterinario;
	}

	public List<EventoDTO> getEventos() {
		return eventos;
	}

	public void setEventos(List<EventoDTO> eventos) {
		this.eventos = eventos;
	}
	
	
	
}
