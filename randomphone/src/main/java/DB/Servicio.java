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
@Table(name="Servicio")
@Inheritance(strategy=InheritanceType.JOINED)
public class Servicio implements Serializable {
	public Servicio() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == DB.ORMConstants.KEY_SERVICIO_FACTURA) {
			return ORM_factura;
		}
		
		return null;
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	@Column(name="ID", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="DB_SERVICIO_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="DB_SERVICIO_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="Nombre", nullable=true, length=255)	
	private String nombre;
	
	@Column(name="Precio", nullable=false)	
	private float precio;
	
	@Column(name="Estado", nullable=false, length=1)	
	private boolean estado;
	
	@ManyToMany(mappedBy="ORM_servicio", targetEntity=DB.Factura.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_factura = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setPrecio(float value) {
		this.precio = value;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	public void setEstado(boolean value) {
		this.estado = value;
	}
	
	public boolean getEstado() {
		return estado;
	}
	
	private void setORM_Factura(java.util.Set value) {
		this.ORM_factura = value;
	}
	
	private java.util.Set getORM_Factura() {
		return ORM_factura;
	}
	
	@Transient	
	public final DB.FacturaSetCollection factura = new DB.FacturaSetCollection(this, _ormAdapter, DB.ORMConstants.KEY_SERVICIO_FACTURA, DB.ORMConstants.KEY_FACTURA_SERVICIO, DB.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
