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

public class TelevisionDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression nombre;
	public final FloatExpression precio;
	public final BooleanExpression estado;
	public final CollectionExpression factura;
	public final CollectionExpression paquete;
	
	public TelevisionDetachedCriteria() {
		super(DB.Television.class, DB.TelevisionCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		precio = new FloatExpression("precio", this.getDetachedCriteria());
		estado = new BooleanExpression("estado", this.getDetachedCriteria());
		factura = new CollectionExpression("ORM_factura", this.getDetachedCriteria());
		paquete = new CollectionExpression("ORM_paquete", this.getDetachedCriteria());
	}
	
	public TelevisionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, DB.TelevisionCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		precio = new FloatExpression("precio", this.getDetachedCriteria());
		estado = new BooleanExpression("estado", this.getDetachedCriteria());
		factura = new CollectionExpression("ORM_factura", this.getDetachedCriteria());
		paquete = new CollectionExpression("ORM_paquete", this.getDetachedCriteria());
	}
	
	public DB.PaqueteDetachedCriteria createPaqueteCriteria() {
		return new DB.PaqueteDetachedCriteria(createCriteria("ORM_paquete"));
	}
	
	public DB.FacturaDetachedCriteria createFacturaCriteria() {
		return new DB.FacturaDetachedCriteria(createCriteria("ORM_factura"));
	}
	
	public Television uniqueTelevision(PersistentSession session) {
		return (Television) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Television[] listTelevision(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Television[]) list.toArray(new Television[list.size()]);
	}
}

