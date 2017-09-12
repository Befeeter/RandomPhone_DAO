/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: University of Almeria
 * License Type: Academic
 */
package DB;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ComercialCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression documento;
	public final StringExpression nombre;
	public final StringExpression apellidos;
	public final StringExpression contrasena;
	public final StringExpression email;
	public final BooleanExpression estado;
	public final CollectionExpression incidencia;
	
	public ComercialCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		documento = new StringExpression("documento", this);
		nombre = new StringExpression("nombre", this);
		apellidos = new StringExpression("apellidos", this);
		contrasena = new StringExpression("contrasena", this);
		email = new StringExpression("email", this);
		estado = new BooleanExpression("estado", this);
		incidencia = new CollectionExpression("ORM_incidencia", this);
	}
	
	public ComercialCriteria(PersistentSession session) {
		this(session.createCriteria(Comercial.class));
	}
	
	public ComercialCriteria() throws PersistentException {
		this(DB.ProyectoFinalPersistentManager.instance().getSession());
	}
	
	public DB.IncidenciaCriteria createIncidenciaCriteria() {
		return new DB.IncidenciaCriteria(createCriteria("ORM_incidencia"));
	}
	
	public Comercial uniqueComercial() {
		return (Comercial) super.uniqueResult();
	}
	
	public Comercial[] listComercial() {
		java.util.List list = super.list();
		return (Comercial[]) list.toArray(new Comercial[list.size()]);
	}
}

