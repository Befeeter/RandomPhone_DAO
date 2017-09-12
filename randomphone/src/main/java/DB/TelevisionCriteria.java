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

public class TelevisionCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression nombre;
	public final FloatExpression precio;
	public final BooleanExpression estado;
	public final CollectionExpression factura;
	public final CollectionExpression paquete;
	
	public TelevisionCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		nombre = new StringExpression("nombre", this);
		precio = new FloatExpression("precio", this);
		estado = new BooleanExpression("estado", this);
		factura = new CollectionExpression("ORM_factura", this);
		paquete = new CollectionExpression("ORM_paquete", this);
	}
	
	public TelevisionCriteria(PersistentSession session) {
		this(session.createCriteria(Television.class));
	}
	
	public TelevisionCriteria() throws PersistentException {
		this(DB.ProyectoFinalPersistentManager.instance().getSession());
	}
	
	public DB.PaqueteCriteria createPaqueteCriteria() {
		return new DB.PaqueteCriteria(createCriteria("ORM_paquete"));
	}
	
	public DB.FacturaCriteria createFacturaCriteria() {
		return new DB.FacturaCriteria(createCriteria("ORM_factura"));
	}
	
	public Television uniqueTelevision() {
		return (Television) super.uniqueResult();
	}
	
	public Television[] listTelevision() {
		java.util.List list = super.list();
		return (Television[]) list.toArray(new Television[list.size()]);
	}
}

