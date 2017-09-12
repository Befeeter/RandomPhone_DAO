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

public class MovilDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression nombre;
	public final FloatExpression precio;
	public final BooleanExpression estado;
	public final CollectionExpression factura;
	public final IntegerExpression minutos;
	public final IntegerExpression datos;
	
	public MovilDetachedCriteria() {
		super(DB.Movil.class, DB.MovilCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		precio = new FloatExpression("precio", this.getDetachedCriteria());
		estado = new BooleanExpression("estado", this.getDetachedCriteria());
		factura = new CollectionExpression("ORM_factura", this.getDetachedCriteria());
		minutos = new IntegerExpression("minutos", this.getDetachedCriteria());
		datos = new IntegerExpression("datos", this.getDetachedCriteria());
	}
	
	public MovilDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, DB.MovilCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		precio = new FloatExpression("precio", this.getDetachedCriteria());
		estado = new BooleanExpression("estado", this.getDetachedCriteria());
		factura = new CollectionExpression("ORM_factura", this.getDetachedCriteria());
		minutos = new IntegerExpression("minutos", this.getDetachedCriteria());
		datos = new IntegerExpression("datos", this.getDetachedCriteria());
	}
	
	public DB.FacturaDetachedCriteria createFacturaCriteria() {
		return new DB.FacturaDetachedCriteria(createCriteria("ORM_factura"));
	}
	
	public Movil uniqueMovil(PersistentSession session) {
		return (Movil) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Movil[] listMovil(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Movil[]) list.toArray(new Movil[list.size()]);
	}
}

