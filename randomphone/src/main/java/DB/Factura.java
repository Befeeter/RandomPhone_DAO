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

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Factura")
public class Factura implements Serializable {
	public Factura() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == DB.ORMConstants.KEY_FACTURA_SERVICIO) {
			return ORM_servicio;
		}
		else if (key == DB.ORMConstants.KEY_FACTURA_TERMINAL) {
			return ORM_terminal;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == DB.ORMConstants.KEY_FACTURA_CLIENTE) {
			this.cliente = (DB.Cliente) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="DB_FACTURA_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="DB_FACTURA_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity=DB.Cliente.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="ClientePersonaID", referencedColumnName="PersonaID", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private DB.Cliente cliente;
	
	@Column(name="Fecha_ini", nullable=true)	
	private Date fecha_ini;
	
	@Column(name="Fecha_fin", nullable=true)	
	private Date fecha_fin;
	
	@Column(name="Total", nullable=false)	
	private float total;
	
	@ManyToMany(targetEntity=DB.Servicio.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Servicio_Factura", joinColumns={ @JoinColumn(name="FacturaID") }, inverseJoinColumns={ @JoinColumn(name="ServicioID") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_servicio = new java.util.HashSet();
	
	@OneToMany(mappedBy="factura", targetEntity=DB.Terminal.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_terminal = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setFecha_ini(Date value) {
		this.fecha_ini = value;
	}
	
	public Date getFecha_ini() {
		return fecha_ini;
	}
	
	public void setFecha_fin(Date value) {
		this.fecha_fin = value;
	}
	
	public Date getFecha_fin() {
		return fecha_fin;
	}
	
	public void setTotal(float value) {
		this.total = value;
	}
	
	public float getTotal() {
		return total;
	}
	
	private void setORM_Servicio(java.util.Set value) {
		this.ORM_servicio = value;
	}
	
	private java.util.Set getORM_Servicio() {
		return ORM_servicio;
	}
	
	@Transient	
	public final DB.ServicioSetCollection servicio = new DB.ServicioSetCollection(this, _ormAdapter, DB.ORMConstants.KEY_FACTURA_SERVICIO, DB.ORMConstants.KEY_SERVICIO_FACTURA, DB.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void setCliente(DB.Cliente value) {
		if (cliente != null) {
			cliente.factura.remove(this);
		}
		if (value != null) {
			value.factura.add(this);
		}
	}
	
	public DB.Cliente getCliente() {
		return cliente;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Cliente(DB.Cliente value) {
		this.cliente = value;
	}
	
	private DB.Cliente getORM_Cliente() {
		return cliente;
	}
	
	private void setORM_Terminal(java.util.Set value) {
		this.ORM_terminal = value;
	}
	
	private java.util.Set getORM_Terminal() {
		return ORM_terminal;
	}
	
	@Transient	
	public final DB.TerminalSetCollection terminal = new DB.TerminalSetCollection(this, _ormAdapter, DB.ORMConstants.KEY_FACTURA_TERMINAL, DB.ORMConstants.KEY_TERMINAL_FACTURA, DB.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
