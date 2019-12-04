package ttps.spring.interfaces;

import java.util.List;

import ttps.spring.model.FichaPublica;

public interface FichaPublicaDAO extends GenericDAO<FichaPublica> {
	public List<FichaPublica> recuperarCantidad( String cantidad );
	public Integer getCantidadFichasConFoto();

}
