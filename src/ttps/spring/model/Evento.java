package ttps.spring.model;

import java.sql.Date;

import javax.persistence.*;

import java.util.ArrayList;

@Entity
public class Evento {
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
	
	
	
}
