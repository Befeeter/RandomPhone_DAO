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

public class FacturaCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression clienteId;
	public final AssociationExpression cliente;
	public final FloatExpression total;
	public final CollectionExpression servicio;
	public final CollectionExpression terminal;
	
	public FacturaCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		clienteId = new IntegerExpression("cliente.", this);
		cliente = new AssociationExpression("cliente", this);
		total = new FloatExpression("total", this);
		servicio = new CollectionExpression("ORM_servicio", this);
		terminal = new CollectionExpression("ORM_terminal", this);
	}
	
	public FacturaCriteria(PersistentSession session) {
		this(session.createCriteria(Factura.class));
	}
	
	public FacturaCriteria() throws PersistentException {
		this(DB.ProyectoFinalPersistentManager.instance().getSession());
	}
	
	public ClienteCriteria createClienteCriteria() {
		return new ClienteCriteria(createCriteria("cliente"));
	}
	
	public DB.ServicioCriteria createServicioCriteria() {
		return new DB.ServicioCriteria(createCriteria("ORM_servicio"));
	}
	
	public DB.TerminalCriteria createTerminalCriteria() {
		return new DB.TerminalCriteria(createCriteria("ORM_terminal"));
	}
	
	public Factura uniqueFactura() {
		return (Factura) super.uniqueResult();
	}
	
	public Factura[] listFactura() {
		java.util.List list = super.list();
		return (Factura[]) list.toArray(new Factura[list.size()]);
	}
}

