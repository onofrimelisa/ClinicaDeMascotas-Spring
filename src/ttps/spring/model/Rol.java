package ttps.spring.model;
import javax.persistence.*;

@Entity
public class Rol {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	//constructor 
	
	public Rol() {
	}
	
	public Rol(String nombre) {
		this.nombre = nombre;
	}
	
	//Getters y Setters
	
	public Long getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombre=" + nombre + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return ((Rol) obj).getNombre().equals(this.getNombre());
	}
	
	
	
	
	
}
