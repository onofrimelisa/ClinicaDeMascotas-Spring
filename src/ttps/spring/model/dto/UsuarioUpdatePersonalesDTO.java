package ttps.spring.model.dto;

public class UsuarioUpdatePersonalesDTO {
	
//	representa al usuario loggeado, es para chequear que el usuairo con id 1 solo pueda editar al usuario con id 1 y no mandar por la URL otro id
	private Long id;
	private String password;
	private String foto;
	private String apellido;
	private String nombre;
	private String email;
	private String fecha_nacimiento;
	private String telefono;
	
	public UsuarioUpdatePersonalesDTO() {
		
	}

	public UsuarioUpdatePersonalesDTO(String password, String foto, String apellido, String nombre, String email,
			String fecha_nacimiento, String telefono, Long id) {
		super();
		this.password = password;
		this.foto = foto;
		this.apellido = apellido;
		this.nombre = nombre;
		this.email = email;
		this.fecha_nacimiento = fecha_nacimiento;
		this.telefono = telefono;
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	
}
