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

public class CanalDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression nombre;
	public final FloatExpression precio;
	public final DateExpression fecha_alta;
	public final BooleanExpression estado;
	public final CollectionExpression paquete;
	
	public CanalDetachedCriteria() {
		super(DB.Canal.class, DB.CanalCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		precio = new FloatExpression("precio", this.getDetachedCriteria());
		fecha_alta = new DateExpression("fecha_alta", this.getDetachedCriteria());
		estado = new BooleanExpression("estado", this.getDetachedCriteria());
		paquete = new CollectionExpression("ORM_paquete", this.getDetachedCriteria());
	}
	
	public CanalDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, DB.CanalCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		precio = new FloatExpression("precio", this.getDetachedCriteria());
		fecha_alta = new DateExpression("fecha_alta", this.getDetachedCriteria());
		estado = new BooleanExpression("estado", this.getDetachedCriteria());
		paquete = new CollectionExpression("ORM_paquete", this.getDetachedCriteria());
	}
	
	public DB.PaqueteDetachedCriteria createPaqueteCriteria() {
		return new DB.PaqueteDetachedCriteria(createCriteria("ORM_paquete"));
	}
	
	public Canal uniqueCanal(PersistentSession session) {
		return (Canal) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Canal[] listCanal(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Canal[]) list.toArray(new Canal[list.size()]);
	}
}

