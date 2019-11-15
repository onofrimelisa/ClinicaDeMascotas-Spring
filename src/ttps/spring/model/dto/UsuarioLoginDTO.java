package ttps.spring.model.dto;

public class UsuarioLoginDTO {
	
	private String email;
	private String password;
	
	public UsuarioLoginDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public UsuarioLoginDTO(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	
}
