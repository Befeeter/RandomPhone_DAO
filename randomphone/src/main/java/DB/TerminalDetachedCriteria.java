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

public class TerminalDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression facturaId;
	public final AssociationExpression factura;
	public final StringExpression tipo;
	public final BooleanExpression estado;
	
	public TerminalDetachedCriteria() {
		super(DB.Terminal.class, DB.TerminalCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		facturaId = new IntegerExpression("factura.ID", this.getDetachedCriteria());
		factura = new AssociationExpression("factura", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
		estado = new BooleanExpression("estado", this.getDetachedCriteria());
	}
	
	public TerminalDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, DB.TerminalCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		facturaId = new IntegerExpression("factura.ID", this.getDetachedCriteria());
		factura = new AssociationExpression("factura", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
		estado = new BooleanExpression("estado", this.getDetachedCriteria());
	}
	
	public FacturaDetachedCriteria createFacturaCriteria() {
		return new FacturaDetachedCriteria(createCriteria("factura"));
	}
	
	public Terminal uniqueTerminal(PersistentSession session) {
		return (Terminal) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Terminal[] listTerminal(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Terminal[]) list.toArray(new Terminal[list.size()]);
	}
}

