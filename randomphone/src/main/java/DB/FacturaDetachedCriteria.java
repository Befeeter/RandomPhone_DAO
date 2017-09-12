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

public class FacturaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression clienteId;
	public final AssociationExpression cliente;
	public final FloatExpression total;
	public final CollectionExpression servicio;
	public final CollectionExpression terminal;
	
	public FacturaDetachedCriteria() {
		super(DB.Factura.class, DB.FacturaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		clienteId = new IntegerExpression("cliente.", this.getDetachedCriteria());
		cliente = new AssociationExpression("cliente", this.getDetachedCriteria());
		total = new FloatExpression("total", this.getDetachedCriteria());
		servicio = new CollectionExpression("ORM_servicio", this.getDetachedCriteria());
		terminal = new CollectionExpression("ORM_terminal", this.getDetachedCriteria());
	}
	
	public FacturaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, DB.FacturaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		clienteId = new IntegerExpression("cliente.", this.getDetachedCriteria());
		cliente = new AssociationExpression("cliente", this.getDetachedCriteria());
		total = new FloatExpression("total", this.getDetachedCriteria());
		servicio = new CollectionExpression("ORM_servicio", this.getDetachedCriteria());
		terminal = new CollectionExpression("ORM_terminal", this.getDetachedCriteria());
	}
	
	public ClienteDetachedCriteria createClienteCriteria() {
		return new ClienteDetachedCriteria(createCriteria("cliente"));
	}
	
	public DB.ServicioDetachedCriteria createServicioCriteria() {
		return new DB.ServicioDetachedCriteria(createCriteria("ORM_servicio"));
	}
	
	public DB.TerminalDetachedCriteria createTerminalCriteria() {
		return new DB.TerminalDetachedCriteria(createCriteria("ORM_terminal"));
	}
	
	public Factura uniqueFactura(PersistentSession session) {
		return (Factura) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Factura[] listFactura(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Factura[]) list.toArray(new Factura[list.size()]);
	}
}

