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

public class IncidenciaCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression comercialId;
	public final AssociationExpression comercial;
	public final IntegerExpression tieneId;
	public final AssociationExpression tiene;
	public final StringExpression ausnto;
	public final StringExpression tipo;
	public final IntegerExpression telefono;
	public final StringExpression texto;
	public final StringExpression estado;
	public final DateExpression fecha_alta;
	public final StringExpression respuesta;
	public final BooleanExpression cliente;
	public final StringExpression observaciones;
	
	public IncidenciaCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		comercialId = new IntegerExpression("comercial.", this);
		comercial = new AssociationExpression("comercial", this);
		tieneId = new IntegerExpression("tiene.", this);
		tiene = new AssociationExpression("tiene", this);
		ausnto = new StringExpression("ausnto", this);
		tipo = new StringExpression("tipo", this);
		telefono = new IntegerExpression("telefono", this);
		texto = new StringExpression("texto", this);
		estado = new StringExpression("estado", this);
		fecha_alta = new DateExpression("fecha_alta", this);
		respuesta = new StringExpression("respuesta", this);
		cliente = new BooleanExpression("cliente", this);
		observaciones = new StringExpression("observaciones", this);
	}
	
	public IncidenciaCriteria(PersistentSession session) {
		this(session.createCriteria(Incidencia.class));
	}
	
	public IncidenciaCriteria() throws PersistentException {
		this(DB.ProyectoFinalPersistentManager.instance().getSession());
	}
	
	public ComercialCriteria createComercialCriteria() {
		return new ComercialCriteria(createCriteria("comercial"));
	}
	
	public ClienteCriteria createTieneCriteria() {
		return new ClienteCriteria(createCriteria("tiene"));
	}
	
	public Incidencia uniqueIncidencia() {
		return (Incidencia) super.uniqueResult();
	}
	
	public Incidencia[] listIncidencia() {
		java.util.List list = super.list();
		return (Incidencia[]) list.toArray(new Incidencia[list.size()]);
	}
}

