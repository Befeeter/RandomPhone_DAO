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

public class IncidenciaDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public IncidenciaDetachedCriteria() {
		super(DB.Incidencia.class, DB.IncidenciaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		comercialId = new IntegerExpression("comercial.", this.getDetachedCriteria());
		comercial = new AssociationExpression("comercial", this.getDetachedCriteria());
		tieneId = new IntegerExpression("tiene.", this.getDetachedCriteria());
		tiene = new AssociationExpression("tiene", this.getDetachedCriteria());
		ausnto = new StringExpression("ausnto", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
		telefono = new IntegerExpression("telefono", this.getDetachedCriteria());
		texto = new StringExpression("texto", this.getDetachedCriteria());
		estado = new StringExpression("estado", this.getDetachedCriteria());
		fecha_alta = new DateExpression("fecha_alta", this.getDetachedCriteria());
		respuesta = new StringExpression("respuesta", this.getDetachedCriteria());
		cliente = new BooleanExpression("cliente", this.getDetachedCriteria());
		observaciones = new StringExpression("observaciones", this.getDetachedCriteria());
	}
	
	public IncidenciaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, DB.IncidenciaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		comercialId = new IntegerExpression("comercial.", this.getDetachedCriteria());
		comercial = new AssociationExpression("comercial", this.getDetachedCriteria());
		tieneId = new IntegerExpression("tiene.", this.getDetachedCriteria());
		tiene = new AssociationExpression("tiene", this.getDetachedCriteria());
		ausnto = new StringExpression("ausnto", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
		telefono = new IntegerExpression("telefono", this.getDetachedCriteria());
		texto = new StringExpression("texto", this.getDetachedCriteria());
		estado = new StringExpression("estado", this.getDetachedCriteria());
		fecha_alta = new DateExpression("fecha_alta", this.getDetachedCriteria());
		respuesta = new StringExpression("respuesta", this.getDetachedCriteria());
		cliente = new BooleanExpression("cliente", this.getDetachedCriteria());
		observaciones = new StringExpression("observaciones", this.getDetachedCriteria());
	}
	
	public ComercialDetachedCriteria createComercialCriteria() {
		return new ComercialDetachedCriteria(createCriteria("comercial"));
	}
	
	public ClienteDetachedCriteria createTieneCriteria() {
		return new ClienteDetachedCriteria(createCriteria("tiene"));
	}
	
	public Incidencia uniqueIncidencia(PersistentSession session) {
		return (Incidencia) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Incidencia[] listIncidencia(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Incidencia[]) list.toArray(new Incidencia[list.size()]);
	}
}

