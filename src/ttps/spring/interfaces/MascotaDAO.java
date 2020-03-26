package ttps.spring.interfaces;

import java.util.List;

import ttps.spring.model.Mascota;
import ttps.spring.model.Usuario;

public interface MascotaDAO extends GenericDAO<Mascota> {
	
	public List<Mascota> getSinVeterinario();
}
