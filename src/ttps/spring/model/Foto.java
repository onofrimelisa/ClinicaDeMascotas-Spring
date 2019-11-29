package ttps.spring.model;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@Entity
public class Foto{
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

	public String getContenido() {
		try {			
			String str = new String(contenido.getBytes(1l, (int)contenido.length()));
			return str;
		}
		catch(Exception e) {
			return null;
		}
	}

	public void setContenido(Blob contenido) {
		this.contenido = contenido;
	}

	public Long getId() {
		return id;
	}

	public Long getMascota() {
		return mascota.getId();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return ((Foto) obj).getId() == this.getId();
	}
	
	
}
