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

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class MovilDAO {
	public static Movil loadMovilByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return loadMovilByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movil getMovilByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return getMovilByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movil loadMovilByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return loadMovilByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movil getMovilByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return getMovilByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movil loadMovilByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Movil) session.load(Movil.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movil getMovilByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Movil) session.get(Movil.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movil loadMovilByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Movil) session.load(Movil.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movil getMovilByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Movil) session.get(Movil.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMovil(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return queryMovil(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMovil(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return queryMovil(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movil[] listMovilByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return listMovilByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movil[] listMovilByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return listMovilByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMovil(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Movil as Movil");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMovil(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Movil as Movil");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Movil", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movil[] listMovilByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryMovil(session, condition, orderBy);
			return (Movil[]) list.toArray(new Movil[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movil[] listMovilByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryMovil(session, condition, orderBy, lockMode);
			return (Movil[]) list.toArray(new Movil[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movil loadMovilByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return loadMovilByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movil loadMovilByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return loadMovilByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movil loadMovilByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Movil[] movils = listMovilByQuery(session, condition, orderBy);
		if (movils != null && movils.length > 0)
			return movils[0];
		else
			return null;
	}
	
	public static Movil loadMovilByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Movil[] movils = listMovilByQuery(session, condition, orderBy, lockMode);
		if (movils != null && movils.length > 0)
			return movils[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateMovilByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return iterateMovilByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateMovilByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return iterateMovilByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateMovilByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Movil as Movil");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateMovilByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Movil as Movil");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Movil", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movil createMovil() {
		return new Movil();
	}
	
	public static boolean save(Movil movil) throws PersistentException {
		try {
			DB.ProyectoFinalPersistentManager.instance().saveObject(movil);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Movil movil) throws PersistentException {
		try {
			DB.ProyectoFinalPersistentManager.instance().deleteObject(movil);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Movil movil)throws PersistentException {
		try {
			DB.Factura[] lFacturas = movil.factura.toArray();
			for(int i = 0; i < lFacturas.length; i++) {
				lFacturas[i].servicio.remove(movil);
			}
			return delete(movil);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Movil movil, org.orm.PersistentSession session)throws PersistentException {
		try {
			DB.Factura[] lFacturas = movil.factura.toArray();
			for(int i = 0; i < lFacturas.length; i++) {
				lFacturas[i].servicio.remove(movil);
			}
			try {
				session.delete(movil);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(Movil movil) throws PersistentException {
		try {
			DB.ProyectoFinalPersistentManager.instance().getSession().refresh(movil);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Movil movil) throws PersistentException {
		try {
			DB.ProyectoFinalPersistentManager.instance().getSession().evict(movil);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movil loadMovilByCriteria(MovilCriteria movilCriteria) {
		Movil[] movils = listMovilByCriteria(movilCriteria);
		if(movils == null || movils.length == 0) {
			return null;
		}
		return movils[0];
	}
	
	public static Movil[] listMovilByCriteria(MovilCriteria movilCriteria) {
		return movilCriteria.listMovil();
	}
}
