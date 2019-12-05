package ttps.spring.model;
import java.sql.Blob;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.sql.rowset.serial.SerialBlob;

@Entity
public class Mascota {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Date fecha_nacimiento;
	private String especie;
	private String raza;
	private String sexo;
	private String color;
	private String senias;
	
	@Column(nullable=true)
	private Blob foto;
	
	@ManyToOne(optional=false)
	private Usuario duenio;
	
	@ManyToOne(optional=true)
	private Usuario veterinario;
	
	@OneToOne(optional=true)
	private FichaPublica ficha_publica;
	
	
	@OneToMany(mappedBy="mascota")
	List<Evento> eventos;

	//Constructor
	public Mascota() {
		super();
		this.eventos = new ArrayList<Evento>();
	}

	
	
	//Constructor con datos
	public Mascota(String nombre, Date fecha_nacimiento, String especie, String raza, String sexo, String color,
			String senias, Usuario duenio) {
		super();
		this.nombre = nombre;
		this.fecha_nacimiento = fecha_nacimiento;
		this.especie = especie;
		this.raza = raza;
		this.sexo = sexo;
		this.color = color;
		this.senias = senias;
		this.duenio = duenio;
		this.eventos = new ArrayList<Evento>();
	}



	

	public Long getId() {
		return id;
	}



	public void setFicha_publica(FichaPublica ficha_publica) {
		this.ficha_publica = ficha_publica;
	}


	//Getters y setters
	public FichaPublica getFicha_publica() {
		return ficha_publica;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
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

	public Usuario getDuenio() {
		return duenio;
	}

	public void setDuenio(Usuario duenio) {
		this.duenio = duenio;
	}

	public Usuario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Usuario veterinario) {
		this.veterinario = veterinario;
	}



	public List<Evento> getEventos() {
		return eventos;
	}
	
	public void agregarEvento(Evento evento) {
		this.eventos.add(evento);
	}
	
	
	public void eliminarEvento(Evento evento) {
		this.eventos.remove(evento);	
	}



	public String getFoto() {
		try {			
			String str = new String(foto.getBytes(1l, (int)foto.length()));
			return str;
		}
		catch(Exception e) {
			return null;
		}
	}


	public void setFoto(String foto) {
		try {
			byte[] byteData = foto.getBytes("UTF-8");
			Blob blobData = new SerialBlob(byteData);
			this.foto = blobData;
		}
		catch(Exception e) {
			this.foto = null;
		}
		
	}
	
	
	
}
