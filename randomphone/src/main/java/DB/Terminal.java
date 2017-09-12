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
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Terminal")
public class Terminal implements Serializable {
	public Terminal() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == DB.ORMConstants.KEY_TERMINAL_FACTURA) {
			this.factura = (DB.Factura) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="DB_TERMINAL_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="DB_TERMINAL_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity=DB.Factura.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="FacturaID", referencedColumnName="ID", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private DB.Factura factura;
	
	@Column(name="Tipo", nullable=true, length=255)	
	private String tipo;
	
	@Column(name="Estado", nullable=false, length=1)	
	private boolean estado;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setTipo(String value) {
		this.tipo = value;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setEstado(boolean value) {
		this.estado = value;
	}
	
	public boolean getEstado() {
		return estado;
	}
	
	public void setFactura(DB.Factura value) {
		if (factura != null) {
			factura.terminal.remove(this);
		}
		if (value != null) {
			value.terminal.add(this);
		}
	}
	
	public DB.Factura getFactura() {
		return factura;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Factura(DB.Factura value) {
		this.factura = value;
	}
	
	private DB.Factura getORM_Factura() {
		return factura;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
