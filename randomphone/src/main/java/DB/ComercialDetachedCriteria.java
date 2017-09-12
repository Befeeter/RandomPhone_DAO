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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ComercialDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression documento;
	public final StringExpression nombre;
	public final StringExpression apellidos;
	public final StringExpression contrasena;
	public final StringExpression email;
	public final BooleanExpression estado;
	public final CollectionExpression incidencia;
	
	public ComercialDetachedCriteria() {
		super(DB.Comercial.class, DB.ComercialCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		documento = new StringExpression("documento", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellidos = new StringExpression("apellidos", this.getDetachedCriteria());
		contrasena = new StringExpression("contrasena", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		estado = new BooleanExpression("estado", this.getDetachedCriteria());
		incidencia = new CollectionExpression("ORM_incidencia", this.getDetachedCriteria());
	}
	
	public ComercialDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, DB.ComercialCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		documento = new StringExpression("documento", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellidos = new StringExpression("apellidos", this.getDetachedCriteria());
		contrasena = new StringExpression("contrasena", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		estado = new BooleanExpression("estado", this.getDetachedCriteria());
		incidencia = new CollectionExpression("ORM_incidencia", this.getDetachedCriteria());
	}
	
	public DB.IncidenciaDetachedCriteria createIncidenciaCriteria() {
		return new DB.IncidenciaDetachedCriteria(createCriteria("ORM_incidencia"));
	}
	
	public Comercial uniqueComercial(PersistentSession session) {
		return (Comercial) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Comercial[] listComercial(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Comercial[]) list.toArray(new Comercial[list.size()]);
	}
}

