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

public class TerminalCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression facturaId;
	public final AssociationExpression factura;
	public final StringExpression tipo;
	public final BooleanExpression estado;
	
	public TerminalCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		facturaId = new IntegerExpression("factura.ID", this);
		factura = new AssociationExpression("factura", this);
		tipo = new StringExpression("tipo", this);
		estado = new BooleanExpression("estado", this);
	}
	
	public TerminalCriteria(PersistentSession session) {
		this(session.createCriteria(Terminal.class));
	}
	
	public TerminalCriteria() throws PersistentException {
		this(DB.ProyectoFinalPersistentManager.instance().getSession());
	}
	
	public FacturaCriteria createFacturaCriteria() {
		return new FacturaCriteria(createCriteria("factura"));
	}
	
	public Terminal uniqueTerminal() {
		return (Terminal) super.uniqueResult();
	}
	
	public Terminal[] listTerminal() {
		java.util.List list = super.list();
		return (Terminal[]) list.toArray(new Terminal[list.size()]);
	}
}

