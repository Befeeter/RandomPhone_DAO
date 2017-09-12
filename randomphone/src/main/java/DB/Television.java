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
@Table(name="Television")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="ServicioID", referencedColumnName="ID")
public class Television extends DB.Servicio implements Serializable {
	public Television() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == DB.ORMConstants.KEY_TELEVISION_PAQUETE) {
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
	
	@OneToMany(mappedBy="television", targetEntity=DB.Paquete.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_paquete = new java.util.HashSet();
	
	private void setORM_Paquete(java.util.Set value) {
		this.ORM_paquete = value;
	}
	
	private java.util.Set getORM_Paquete() {
		return ORM_paquete;
	}
	
	@Transient	
	public final DB.PaqueteSetCollection paquete = new DB.PaqueteSetCollection(this, _ormAdapter, DB.ORMConstants.KEY_TELEVISION_PAQUETE, DB.ORMConstants.KEY_PAQUETE_TELEVISION, DB.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return super.toString();
	}
	
}
