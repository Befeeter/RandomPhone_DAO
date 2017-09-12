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
@Table(name="Incidencia")
public class Incidencia implements Serializable {
	public Incidencia() {
		this.setEstado("SinAsignar");
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == DB.ORMConstants.KEY_INCIDENCIA_TIENE) {
			this.tiene = (DB.Cliente) owner;
		}
		
		else if (key == DB.ORMConstants.KEY_INCIDENCIA_COMERCIAL) {
			this.comercial = (DB.Comercial) owner;
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
	@GeneratedValue(generator="DB_INCIDENCIA_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="DB_INCIDENCIA_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity=DB.Comercial.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="ComercialPersonaID", referencedColumnName="PersonaID", nullable=true) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private DB.Comercial comercial;
	
	@ManyToOne(targetEntity=DB.Cliente.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="ClientePersonaID", referencedColumnName="PersonaID", nullable=true) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private DB.Cliente tiene;
	
	@Column(name="Ausnto", nullable=true, length=255)	
	private String ausnto;
	
	@Column(name="Tipo", nullable=true, length=255)	
	private String tipo;
	
	@Column(name="Telefono", nullable=false, length=10)	
	private int telefono;
	
	@Column(name="Texto", nullable=true, length=255)	
	private String texto;
	
	@Column(name="Estado", nullable=true, length=255)	
	private String estado;
	
	@Column(name="Fecha_alta", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date fecha_alta;
	
	@Column(name="Respuesta", nullable=true, length=255)	
	private String respuesta;
	
	@Column(name="Cliente", nullable=false, length=1)	
	private boolean cliente;
	
	@Column(name="Observaciones", nullable=true, length=255)	
	private String observaciones;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setAusnto(String value) {
		this.ausnto = value;
	}
	
	public String getAusnto() {
		return ausnto;
	}
	
	public void setTipo(String value) {
		this.tipo = value;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTelefono(int value) {
		this.telefono = value;
	}
	
	public int getTelefono() {
		return telefono;
	}
	
	public void setTexto(String value) {
		this.texto = value;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setEstado(String value) {
		this.estado = value;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setFecha_alta(java.util.Date value) {
		this.fecha_alta = value;
	}
	
	public java.util.Date getFecha_alta() {
		return fecha_alta;
	}
	
	public void setRespuesta(String value) {
		this.respuesta = value;
	}
	
	public String getRespuesta() {
		return respuesta;
	}
	
	public void setCliente(boolean value) {
		this.cliente = value;
	}
	
	public boolean getCliente() {
		return cliente;
	}
	
	public void setObservaciones(String value) {
		this.observaciones = value;
	}
	
	public String getObservaciones() {
		return observaciones;
	}
	
	public void setTiene(DB.Cliente value) {
		if (tiene != null) {
			tiene.incidencia.remove(this);
		}
		if (value != null) {
			value.incidencia.add(this);
		}
	}
	
	public DB.Cliente getTiene() {
		return tiene;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Tiene(DB.Cliente value) {
		this.tiene = value;
	}
	
	private DB.Cliente getORM_Tiene() {
		return tiene;
	}
	
	public void setComercial(DB.Comercial value) {
		if (comercial != null) {
			comercial.incidencia.remove(this);
		}
		if (value != null) {
			value.incidencia.add(this);
		}
	}
	
	public DB.Comercial getComercial() {
		return comercial;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Comercial(DB.Comercial value) {
		this.comercial = value;
	}
	
	private DB.Comercial getORM_Comercial() {
		return comercial;
	}
	
	public int getIDComercial (){
		return getComercial().getORMID();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
