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

public class CanalCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression nombre;
	public final FloatExpression precio;
	public final DateExpression fecha_alta;
	public final BooleanExpression estado;
	public final CollectionExpression paquete;
	
	public CanalCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		nombre = new StringExpression("nombre", this);
		precio = new FloatExpression("precio", this);
		fecha_alta = new DateExpression("fecha_alta", this);
		estado = new BooleanExpression("estado", this);
		paquete = new CollectionExpression("ORM_paquete", this);
	}
	
	public CanalCriteria(PersistentSession session) {
		this(session.createCriteria(Canal.class));
	}
	
	public CanalCriteria() throws PersistentException {
		this(DB.ProyectoFinalPersistentManager.instance().getSession());
	}
	
	public DB.PaqueteCriteria createPaqueteCriteria() {
		return new DB.PaqueteCriteria(createCriteria("ORM_paquete"));
	}
	
	public Canal uniqueCanal() {
		return (Canal) super.uniqueResult();
	}
	
	public Canal[] listCanal() {
		java.util.List list = super.list();
		return (Canal[]) list.toArray(new Canal[list.size()]);
	}
}

