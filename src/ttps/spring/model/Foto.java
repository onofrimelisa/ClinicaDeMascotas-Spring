package ttps.spring.model;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Foto {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Blob contenido;
	
	@ManyToOne(optional=false)
	private Mascota mascota;

	
	public Foto() {	}
	
	public Foto(Blob contenido, Mascota mascota) {
		super();
		this.contenido = contenido;
		this.mascota = mascota;
	}

	public Blob getContenido() {
		return contenido;
	}

	public void setContenido(Blob contenido) {
		this.contenido = contenido;
	}

	public Long getId() {
		return id;
	}

	public Mascota getMascota() {
		return mascota;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return ((Foto) obj).getId() == this.getId();
	}
	
	
}
