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

public class ClienteCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression documento;
	public final StringExpression nombre;
	public final StringExpression apellidos;
	public final StringExpression contrasena;
	public final StringExpression email;
	public final BooleanExpression estado;
	public final IntegerExpression telefono;
	public final CollectionExpression factura;
	public final CollectionExpression incidencia;
	
	public ClienteCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		documento = new StringExpression("documento", this);
		nombre = new StringExpression("nombre", this);
		apellidos = new StringExpression("apellidos", this);
		contrasena = new StringExpression("contrasena", this);
		email = new StringExpression("email", this);
		estado = new BooleanExpression("estado", this);
		telefono = new IntegerExpression("telefono", this);
		factura = new CollectionExpression("ORM_factura", this);
		incidencia = new CollectionExpression("ORM_incidencia", this);
	}
	
	public ClienteCriteria(PersistentSession session) {
		this(session.createCriteria(Cliente.class));
	}
	
	public ClienteCriteria() throws PersistentException {
		this(DB.ProyectoFinalPersistentManager.instance().getSession());
	}
	
	public DB.FacturaCriteria createFacturaCriteria() {
		return new DB.FacturaCriteria(createCriteria("ORM_factura"));
	}
	
	public DB.IncidenciaCriteria createIncidenciaCriteria() {
		return new DB.IncidenciaCriteria(createCriteria("ORM_incidencia"));
	}
	
	public Cliente uniqueCliente() {
		return (Cliente) super.uniqueResult();
	}
	
	public Cliente[] listCliente() {
		java.util.List list = super.list();
		return (Cliente[]) list.toArray(new Cliente[list.size()]);
	}
}

