package ttps.spring.model.dto;

public class FichaPublicaDTO {
	private Long id;	
	private String nombre;
	private String fecha_nacimiento;
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
	private String domicilio_duenio;
	
//	se crea solo con la foto, luego se setean las variables
	public FichaPublicaDTO( Long id ) {
		this.id = id;
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
	public String getDomicilio_duenio() {
		return domicilio_duenio;
	}
	public void setDomicilio_duenio(String domicilio_duenio) {
		this.domicilio_duenio = domicilio_duenio;
	}
}
