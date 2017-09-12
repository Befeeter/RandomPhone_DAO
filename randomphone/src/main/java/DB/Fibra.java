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
@Table(name="Fibra")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="ServicioID", referencedColumnName="ID")
public class Fibra extends DB.Servicio implements Serializable {
	public Fibra() {
	}
	
	@Column(name="Vsub", nullable=false, length=10)	
	private int vsub;
	
	@Column(name="Vbaj", nullable=false, length=10)	
	private int vbaj;
	
	public void setVsub(int value) {
		this.vsub = value;
	}
	
	public int getVsub() {
		return vsub;
	}
	
	public void setVbaj(int value) {
		this.vbaj = value;
	}
	
	public int getVbaj() {
		return vbaj;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
