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

public class ServicioDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression nombre;
	public final FloatExpression precio;
	public final BooleanExpression estado;
	public final CollectionExpression factura;
	
	public ServicioDetachedCriteria() {
		super(DB.Servicio.class, DB.ServicioCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		precio = new FloatExpression("precio", this.getDetachedCriteria());
		estado = new BooleanExpression("estado", this.getDetachedCriteria());
		factura = new CollectionExpression("ORM_factura", this.getDetachedCriteria());
	}
	
	public ServicioDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, DB.ServicioCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		precio = new FloatExpression("precio", this.getDetachedCriteria());
		estado = new BooleanExpression("estado", this.getDetachedCriteria());
		factura = new CollectionExpression("ORM_factura", this.getDetachedCriteria());
	}
	
	public DB.FacturaDetachedCriteria createFacturaCriteria() {
		return new DB.FacturaDetachedCriteria(createCriteria("ORM_factura"));
	}
	
	public Servicio uniqueServicio(PersistentSession session) {
		return (Servicio) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Servicio[] listServicio(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Servicio[]) list.toArray(new Servicio[list.size()]);
	}
}

