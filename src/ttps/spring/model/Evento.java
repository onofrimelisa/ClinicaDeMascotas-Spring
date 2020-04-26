package ttps.spring.model;

import java.sql.Date;

import javax.persistence.*;


@Entity
public class Evento implements Comparable<Evento> {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(optional=false)
	private TipoEvento tipo;
	
	private Date fecha;
	private Double peso;
	private String descripcion;
	private String observaciones;
	private String diagnostico;
	private String droga;
	private String indicaciones;
	private boolean recordar_duenio;
	private boolean recordar_veterinario;

	@ManyToOne(optional=false)
	private Usuario usuario_creador;
	
	@ManyToOne(optional=false)
	private Mascota mascota;
		
		
	//Constructor
	public Evento() {
		super();
	}
	
	//Constructor con datos
	public Evento(TipoEvento tipo, Date fecha, Double peso, String descripcion, String observaciones,
			String diagnostico, String droga, String indicaciones, Usuario usuario_creador, Mascota mascota) {
		super();
		this.tipo = tipo;
		this.fecha = fecha;
		this.peso = peso;
		this.descripcion = descripcion;
		this.observaciones = observaciones;
		this.diagnostico = diagnostico;
		this.droga = droga;
		this.indicaciones = indicaciones;
		this.usuario_creador = usuario_creador;
		this.mascota = mascota;
		this.recordar_duenio = false;
		this.recordar_veterinario = false;
	}


	//Getters y setters
	
	public Date getFecha() {
		return fecha;
	}
	
	public Long getId() {
		return id;
	}

	public TipoEvento getTipo() {
		return tipo;
	}

	public void setTipo(TipoEvento tipo) {
		this.tipo = tipo;
	}

	public void setFecha(Date fecha) {
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
	public Usuario getUsuario_creador() {
		return usuario_creador;
	}
	public void setUsuario_creador(Usuario usuario_creador) {
		this.usuario_creador = usuario_creador;
	}
	public Mascota getMascota() {
		return mascota;
	}
	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}
	

	public boolean isRecordar_duenio() {
		return recordar_duenio;
	}

	public void setRecordar_duenio(boolean recordar_duenio) {
		this.recordar_duenio = recordar_duenio;
	}

	public boolean isRecordar_veterinario() {
		return recordar_veterinario;
	}

	public void setRecordar_veterinario(boolean recordar_veterinario) {
		this.recordar_veterinario = recordar_veterinario;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return ((Evento) obj).getTipo().equals(this.getTipo());
	}

	@Override
	public int compareTo(Evento o) {
		if( this.getFecha().before(o.getFecha()) ) return -1;
		else if( this.getFecha().after(o.getFecha()) ) return 1;
		else return 0;
	}
	
	
}
