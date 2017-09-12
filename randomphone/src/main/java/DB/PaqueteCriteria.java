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

public class PaqueteCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression televisionId;
	public final AssociationExpression television;
	public final StringExpression nombre;
	public final FloatExpression precio;
	public final DateExpression fecha_alta;
	public final BooleanExpression estado;
	public final CollectionExpression canal;
	
	public PaqueteCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		televisionId = new IntegerExpression("television.", this);
		television = new AssociationExpression("television", this);
		nombre = new StringExpression("nombre", this);
		precio = new FloatExpression("precio", this);
		fecha_alta = new DateExpression("fecha_alta", this);
		estado = new BooleanExpression("estado", this);
		canal = new CollectionExpression("ORM_canal", this);
	}
	
	public PaqueteCriteria(PersistentSession session) {
		this(session.createCriteria(Paquete.class));
	}
	
	public PaqueteCriteria() throws PersistentException {
		this(DB.ProyectoFinalPersistentManager.instance().getSession());
	}
	
	public TelevisionCriteria createTelevisionCriteria() {
		return new TelevisionCriteria(createCriteria("television"));
	}
	
	public DB.CanalCriteria createCanalCriteria() {
		return new DB.CanalCriteria(createCriteria("ORM_canal"));
	}
	
	public Paquete uniquePaquete() {
		return (Paquete) super.uniqueResult();
	}
	
	public Paquete[] listPaquete() {
		java.util.List list = super.list();
		return (Paquete[]) list.toArray(new Paquete[list.size()]);
	}
}

