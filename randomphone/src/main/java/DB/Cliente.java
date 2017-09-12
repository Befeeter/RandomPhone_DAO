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
@Table(name="Cliente")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="PersonaID", referencedColumnName="ID")
public class Cliente extends DB.Persona implements Serializable {
	public Cliente() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == DB.ORMConstants.KEY_CLIENTE_FACTURA) {
			return ORM_factura;
		}
		else if (key == DB.ORMConstants.KEY_CLIENTE_INCIDENCIA) {
			return ORM_incidencia;
		}
		
		return null;
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	@Column(name="Fecha_altta", nullable=true)	
	private Date fecha_altta;
	
	@Column(name="Estado", nullable=false, length=1)	
	private boolean estado;
	
	@Column(name="Telefono", nullable=true, length=10)	
	private int telefono;
	
	@OneToMany(mappedBy="cliente", targetEntity=DB.Factura.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_factura = new java.util.HashSet();
	
	@OneToMany(mappedBy="tiene", targetEntity=DB.Incidencia.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_incidencia = new java.util.HashSet();
	
	public void setFecha_altta(Date value) {
		this.fecha_altta = value;
	}
	
	public Date getFecha_altta() {
		return fecha_altta;
	}
	
	public void setEstado(boolean value) {
		this.estado = value;
	}
	
	public boolean getEstado() {
		return estado;
	}
	
	public void setTelefono(int value) {
		this.telefono = value;
	}
	
	public int getTelefono() {
		return telefono;
	}
	
	private void setORM_Factura(java.util.Set value) {
		this.ORM_factura = value;
	}
	
	private java.util.Set getORM_Factura() {
		return ORM_factura;
	}
	
	@Transient	
	public final DB.FacturaSetCollection factura = new DB.FacturaSetCollection(this, _ormAdapter, DB.ORMConstants.KEY_CLIENTE_FACTURA, DB.ORMConstants.KEY_FACTURA_CLIENTE, DB.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Incidencia(java.util.Set value) {
		this.ORM_incidencia = value;
	}
	
	private java.util.Set getORM_Incidencia() {
		return ORM_incidencia;
	}
	
	@Transient	
	public final DB.IncidenciaSetCollection incidencia = new DB.IncidenciaSetCollection(this, _ormAdapter, DB.ORMConstants.KEY_CLIENTE_INCIDENCIA, DB.ORMConstants.KEY_INCIDENCIA_TIENE, DB.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return super.toString();
	}
	
	public int getNumIncidencias () {
		iCliente iC = new BD_Principal();
		Incidencia[] incidencias = iC.cargarIncidencias(this.getORMID());
		if (incidencias != null)
			return incidencias.length;
		else
			return 0;
	}
}
