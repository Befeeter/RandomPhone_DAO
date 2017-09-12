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
@Table(name="Comercial")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="PersonaID", referencedColumnName="ID")
public class Comercial extends DB.Persona implements Serializable {
	public Comercial() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == DB.ORMConstants.KEY_COMERCIAL_INCIDENCIA) {
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
	
	@Column(name="Fecha_alta", nullable=true)	
	private Date fecha_alta;
	
	@Column(name="Fecha_baja", nullable=true)	
	private Date fecha_baja;
	
	@Column(name="Estado", nullable=false, length=1)	
	private boolean estado;
	
	@OneToMany(mappedBy="comercial", targetEntity=DB.Incidencia.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_incidencia = new java.util.HashSet();
	
	public void setFecha_alta(Date value) {
		this.fecha_alta = value;
	}
	
	public Date getFecha_alta() {
		return fecha_alta;
	}
	
	public void setFecha_baja(Date value) {
		this.fecha_baja = value;
	}
	
	public Date getFecha_baja() {
		return fecha_baja;
	}
	
	public void setEstado(boolean value) {
		this.estado = value;
	}
	
	public boolean getEstado() {
		return estado;
	}
	
	private void setORM_Incidencia(java.util.Set value) {
		this.ORM_incidencia = value;
	}
	
	private java.util.Set getORM_Incidencia() {
		return ORM_incidencia;
	}
	
	@Transient	
	public final DB.IncidenciaSetCollection incidencia = new DB.IncidenciaSetCollection(this, _ormAdapter, DB.ORMConstants.KEY_COMERCIAL_INCIDENCIA, DB.ORMConstants.KEY_INCIDENCIA_COMERCIAL, DB.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return super.toString();
	}
	
	public int getNumincidenciasActivas () {
		iComercial ic = new BD_Principal();
		Incidencia[] incidencias = ic.cargarIncidenciasCm(this.getORMID());
		int i=0;
		for (Incidencia incidencia : incidencias) {
			if (incidencia.getEstado().equals("Asignada")) {
				i++;
			}
		}
		if (incidencias != null)
			return i;
		else
			return 0;
	}
}
