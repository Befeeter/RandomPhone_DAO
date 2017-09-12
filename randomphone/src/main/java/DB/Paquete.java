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
@Table(name="Paquete")
public class Paquete implements Serializable {
	public Paquete() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == DB.ORMConstants.KEY_PAQUETE_CANAL) {
			return ORM_canal;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == DB.ORMConstants.KEY_PAQUETE_TELEVISION) {
			this.television = (DB.Television) owner;
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
	@GeneratedValue(generator="DB_PAQUETE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="DB_PAQUETE_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity=DB.Television.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="TelevisionServicioID", referencedColumnName="ServicioID", nullable=true) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private DB.Television television;
	
	@Column(name="Nombre", nullable=true, length=255)	
	private String nombre;
	
	@Column(name="Precio", nullable=false)	
	private float precio;
	
	@Column(name="Fecha_alta", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date fecha_alta;
	
	@Column(name="Estado", nullable=false, length=1)	
	private boolean estado;
	
	@ManyToMany(mappedBy="ORM_paquete", targetEntity=DB.Canal.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_canal = new java.util.HashSet();
	
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
	
	public void setFecha_alta(java.util.Date value) {
		this.fecha_alta = value;
	}
	
	public java.util.Date getFecha_alta() {
		return fecha_alta;
	}
	
	public void setEstado(boolean value) {
		this.estado = value;
	}
	
	public boolean getEstado() {
		return estado;
	}
	
	private void setORM_Canal(java.util.Set value) {
		this.ORM_canal = value;
	}
	
	private java.util.Set getORM_Canal() {
		return ORM_canal;
	}
	
	@Transient	
	public final DB.CanalSetCollection canal = new DB.CanalSetCollection(this, _ormAdapter, DB.ORMConstants.KEY_PAQUETE_CANAL, DB.ORMConstants.KEY_CANAL_PAQUETE, DB.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void setTelevision(DB.Television value) {
		if (television != null) {
			television.paquete.remove(this);
		}
		if (value != null) {
			value.paquete.add(this);
		}
	}
	
	public DB.Television getTelevision() {
		return television;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Television(DB.Television value) {
		this.television = value;
	}
	
	private DB.Television getORM_Television() {
		return television;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
