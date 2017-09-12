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

public class PaqueteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression televisionId;
	public final AssociationExpression television;
	public final StringExpression nombre;
	public final FloatExpression precio;
	public final DateExpression fecha_alta;
	public final BooleanExpression estado;
	public final CollectionExpression canal;
	
	public PaqueteDetachedCriteria() {
		super(DB.Paquete.class, DB.PaqueteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		televisionId = new IntegerExpression("television.", this.getDetachedCriteria());
		television = new AssociationExpression("television", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		precio = new FloatExpression("precio", this.getDetachedCriteria());
		fecha_alta = new DateExpression("fecha_alta", this.getDetachedCriteria());
		estado = new BooleanExpression("estado", this.getDetachedCriteria());
		canal = new CollectionExpression("ORM_canal", this.getDetachedCriteria());
	}
	
	public PaqueteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, DB.PaqueteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		televisionId = new IntegerExpression("television.", this.getDetachedCriteria());
		television = new AssociationExpression("television", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		precio = new FloatExpression("precio", this.getDetachedCriteria());
		fecha_alta = new DateExpression("fecha_alta", this.getDetachedCriteria());
		estado = new BooleanExpression("estado", this.getDetachedCriteria());
		canal = new CollectionExpression("ORM_canal", this.getDetachedCriteria());
	}
	
	public TelevisionDetachedCriteria createTelevisionCriteria() {
		return new TelevisionDetachedCriteria(createCriteria("television"));
	}
	
	public DB.CanalDetachedCriteria createCanalCriteria() {
		return new DB.CanalDetachedCriteria(createCriteria("ORM_canal"));
	}
	
	public Paquete uniquePaquete(PersistentSession session) {
		return (Paquete) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Paquete[] listPaquete(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Paquete[]) list.toArray(new Paquete[list.size()]);
	}
}

