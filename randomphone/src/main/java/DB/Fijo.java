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
@Table(name="Fijo")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="ServicioID", referencedColumnName="ID")
public class Fijo extends DB.Servicio implements Serializable {
	public Fijo() {
	}
	
	@Column(name="Minutos", nullable=false, length=10)	
	private int minutos;
	
	public void setMinutos(int value) {
		this.minutos = value;
	}
	
	public int getMinutos() {
		return minutos;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
