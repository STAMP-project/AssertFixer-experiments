package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

// implelemtacion del DAO de usuarios, la anotacion @Repository indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.dao
// para encontrar esta clase.
@Repository("usuarioDao")
public class UsuarioDaoImpl extends AbstractDao implements UsuarioDao {

	// Como todo dao maneja acciones de persistencia, normalmente estará inyectado el session factory de hibernate
	// el mismo está difinido en el archivo hibernateContext.xml
	@Override
	public Usuario consultarUsuario(Usuario usuario) {
		return (Usuario) getSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("email", usuario.getEmail()))
				.add(Restrictions.eq("password", usuario.getPassword()))
				.uniqueResult();
	}
	
	@Override
	public Usuario getUsuarioById(Long id) {
		return (Usuario) getSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}
	
	@Override
	public Integer consultarExistencia(Usuario usuario) {
		return getSession().createCriteria(Usuario.class)
			    .add( Restrictions.disjunction()
			    	    .add( Restrictions.eq("email", usuario.getEmail()))
			            .add( Restrictions.eq("username", usuario.getUsername()) )
			        ) 
			    .list()
			    .size();
	}
	
	@Override
	public void guardarUsuario(Usuario usuario) {
		getSession().saveOrUpdate(usuario);
	}
}
