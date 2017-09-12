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

public class ServicioCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression nombre;
	public final FloatExpression precio;
	public final BooleanExpression estado;
	public final CollectionExpression factura;
	
	public ServicioCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		nombre = new StringExpression("nombre", this);
		precio = new FloatExpression("precio", this);
		estado = new BooleanExpression("estado", this);
		factura = new CollectionExpression("ORM_factura", this);
	}
	
	public ServicioCriteria(PersistentSession session) {
		this(session.createCriteria(Servicio.class));
	}
	
	public ServicioCriteria() throws PersistentException {
		this(DB.ProyectoFinalPersistentManager.instance().getSession());
	}
	
	public DB.FacturaCriteria createFacturaCriteria() {
		return new DB.FacturaCriteria(createCriteria("ORM_factura"));
	}
	
	public Servicio uniqueServicio() {
		return (Servicio) super.uniqueResult();
	}
	
	public Servicio[] listServicio() {
		java.util.List list = super.list();
		return (Servicio[]) list.toArray(new Servicio[list.size()]);
	}
}

