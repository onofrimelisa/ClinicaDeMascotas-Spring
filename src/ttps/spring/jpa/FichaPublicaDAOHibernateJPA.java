package ttps.spring.jpa;

import java.util.List;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.spring.interfaces.FichaPublicaDAO;
import ttps.spring.model.FichaPublica;


@Repository("fichaPublicaDAO")
public class FichaPublicaDAOHibernateJPA extends GenericDAOHibernateJPA<FichaPublica> implements FichaPublicaDAO {

	public FichaPublicaDAOHibernateJPA() {
		super(FichaPublica.class);
	}
	
	@Override
	public List<FichaPublica> recuperarCantidad( String cantidad ){
		 Query consulta = this.getEntityManager().createQuery( "FROM FichaPublica f WHERE f.foto IS NOT NULL ORDER BY RAND()");
		 consulta.setMaxResults( Integer.valueOf(cantidad) );
		 
		 List<FichaPublica> resultado = ( List<FichaPublica> )consulta.getResultList();
		 
		 return resultado;
	}
	
	@Override
	public Integer getCantidadFichasConFoto() {
		Query consulta = this.getEntityManager().createQuery( "FROM FichaPublica WHERE foto IS NOT NULL ");
		 
		Integer resultado = consulta.getResultList().size();
		System.out.println(resultado);
	 
		return resultado;
	}

}
