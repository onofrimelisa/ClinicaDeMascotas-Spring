package ttps.spring.model.dto;

public class EventoDTO {
	
	private Long id;
	private String tipo;
	
	private String fecha;
	private Double peso;
	private String descripcion;
	private String observaciones;
	private String diagnostico;
	private String droga;
	private String indicaciones;
	private Long usuario_creador;
	private String nombre_mascota;
	private Long id_mascota;
	private boolean recordar;
	
	public EventoDTO() {
		// TODO Auto-generated constructor stub
	}

	
	public EventoDTO(Long id, String tipo, String fecha, Double peso, String descripcion, String observaciones,
			String diagnostico, String droga, String indicaciones, Long usuario_creador, String nombre_mascota,
			Long id_mascota, boolean recordar) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.fecha = fecha;
		this.peso = peso;
		this.descripcion = descripcion;
		this.observaciones = observaciones;
		this.diagnostico = diagnostico;
		this.droga = droga;
		this.indicaciones = indicaciones;
		this.usuario_creador = usuario_creador;
		this.nombre_mascota = nombre_mascota;
		this.id_mascota = id_mascota;
		this.recordar = recordar;
	}

	public EventoDTO(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getDroga() {
		return droga;
	}

	public void setDroga(String droga) {
		this.droga = droga;
	}

	public String getIndicaciones() {
		return indicaciones;
	}

	public void setIndicaciones(String indicaciones) {
		this.indicaciones = indicaciones;
	}

	public Long getUsuario_creador() {
		return usuario_creador;
	}

	public void setUsuario_creador(Long usuario_creador) {
		this.usuario_creador = usuario_creador;
	}

	public String getNombre_mascota() {
		return nombre_mascota;
	}

	public void setNombre_mascota(String nombre_mascota) {
		this.nombre_mascota = nombre_mascota;
	}

	public Long getId_mascota() {
		return id_mascota;
	}

	public void setId_mascota(Long id_mascota) {
		this.id_mascota = id_mascota;
	}


	public boolean isRecordar() {
		return recordar;
	}


	public void setRecordar(boolean recordar) {
		this.recordar = recordar;
	}
	
	
}
