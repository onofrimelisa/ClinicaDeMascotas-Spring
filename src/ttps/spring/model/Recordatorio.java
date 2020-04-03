package ttps.spring.model;



import javax.persistence.*;

import java.sql.Date;
import java.util.ArrayList;

@Entity
public class Recordatorio {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Evento evento;
	
	@ManyToOne()
	private Usuario creador;
	
	private Date fecha;
	private String descripcion;
	
	//Constructor
	public Recordatorio() {
		super();
	}

	
	
	public Recordatorio(Usuario creador, Date fecha, String descripcion, Evento evento) {
		super();
		this.creador = creador;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.evento = evento;
	}



	//Getters y setters
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}



	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	

	public Usuario getCreador() {
		return creador;
	}
	public void setCreador(Usuario creador) {
		this.creador = creador;
	}
	
	
	
	
}
