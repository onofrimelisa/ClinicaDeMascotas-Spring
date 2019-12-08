package ttps.spring.model.dto;

public class UsuarioUpdateProfesionalesDTO {
	private Long id;
	private String nombre_consultorio;
	private String domicilio_consultorio;
	private String matricula;

	public UsuarioUpdateProfesionalesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioUpdateProfesionalesDTO(Long id, String nombre_consultorio, String domicilio_consultorio,
			String matricula) {
		super();
		this.id = id;
		this.nombre_consultorio = nombre_consultorio;
		this.domicilio_consultorio = domicilio_consultorio;
		this.matricula = matricula;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
