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
@Table(name="Canal")
public class Canal implements Serializable {
	public Canal() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == DB.ORMConstants.KEY_CANAL_PAQUETE) {
			return ORM_paquete;
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
	@GeneratedValue(generator="DB_CANAL_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="DB_CANAL_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="Nombre", nullable=true, length=255)	
	private String nombre;
	
	@Column(name="Precio", nullable=false)	
	private float precio;
	
	@Column(name="Fecha_alta", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private Date fecha_alta;
	
	@Column(name="Estado", nullable=false, length=1)	
	private boolean estado;
	
	@ManyToMany(targetEntity=DB.Paquete.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Paquete_Canal", joinColumns={ @JoinColumn(name="CanalID") }, inverseJoinColumns={ @JoinColumn(name="PaqueteID") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_paquete = new java.util.HashSet();
	
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
	
	public void setFecha_alta(Date value) {
		this.fecha_alta = value;
	}
	
	public Date getFecha_alta() {
		return fecha_alta;
	}
	
	public void setEstado(boolean value) {
		this.estado = value;
	}
	
	public boolean getEstado() {
		return estado;
	}
	
	private void setORM_Paquete(java.util.Set value) {
		this.ORM_paquete = value;
	}
	
	private java.util.Set getORM_Paquete() {
		return ORM_paquete;
	}
	
	@Transient	
	public final DB.PaqueteSetCollection paquete = new DB.PaqueteSetCollection(this, _ormAdapter, DB.ORMConstants.KEY_CANAL_PAQUETE, DB.ORMConstants.KEY_PAQUETE_CANAL, DB.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
