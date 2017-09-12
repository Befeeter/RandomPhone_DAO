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

public class PaqueteDAO {
	public static Paquete loadPaqueteByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return loadPaqueteByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paquete getPaqueteByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return getPaqueteByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paquete loadPaqueteByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return loadPaqueteByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paquete getPaqueteByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return getPaqueteByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paquete loadPaqueteByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Paquete) session.load(Paquete.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paquete getPaqueteByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Paquete) session.get(Paquete.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paquete loadPaqueteByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Paquete) session.load(Paquete.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paquete getPaqueteByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Paquete) session.get(Paquete.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPaquete(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return queryPaquete(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPaquete(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return queryPaquete(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paquete[] listPaqueteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return listPaqueteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paquete[] listPaqueteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return listPaqueteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPaquete(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Paquete as Paquete");
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
	
	public static List queryPaquete(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Paquete as Paquete");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Paquete", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paquete[] listPaqueteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryPaquete(session, condition, orderBy);
			return (Paquete[]) list.toArray(new Paquete[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paquete[] listPaqueteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryPaquete(session, condition, orderBy, lockMode);
			return (Paquete[]) list.toArray(new Paquete[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paquete loadPaqueteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return loadPaqueteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paquete loadPaqueteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return loadPaqueteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paquete loadPaqueteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Paquete[] paquetes = listPaqueteByQuery(session, condition, orderBy);
		if (paquetes != null && paquetes.length > 0)
			return paquetes[0];
		else
			return null;
	}
	
	public static Paquete loadPaqueteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Paquete[] paquetes = listPaqueteByQuery(session, condition, orderBy, lockMode);
		if (paquetes != null && paquetes.length > 0)
			return paquetes[0];
		else
			return null;
	}
	
	public static java.util.Iterator iteratePaqueteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return iteratePaqueteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePaqueteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return iteratePaqueteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePaqueteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Paquete as Paquete");
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
	
	public static java.util.Iterator iteratePaqueteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Paquete as Paquete");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Paquete", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paquete createPaquete() {
		return new Paquete();
	}
	
	public static boolean save(Paquete paquete) throws PersistentException {
		try {
			DB.ProyectoFinalPersistentManager.instance().saveObject(paquete);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Paquete paquete) throws PersistentException {
		try {
			DB.ProyectoFinalPersistentManager.instance().deleteObject(paquete);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Paquete paquete)throws PersistentException {
		try {
			if (paquete.getTelevision() != null) {
				paquete.getTelevision().paquete.remove(paquete);
			}
			
			DB.Canal[] lCanals = paquete.canal.toArray();
			for(int i = 0; i < lCanals.length; i++) {
				lCanals[i].paquete.remove(paquete);
			}
			return delete(paquete);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Paquete paquete, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (paquete.getTelevision() != null) {
				paquete.getTelevision().paquete.remove(paquete);
			}
			
			DB.Canal[] lCanals = paquete.canal.toArray();
			for(int i = 0; i < lCanals.length; i++) {
				lCanals[i].paquete.remove(paquete);
			}
			try {
				session.delete(paquete);
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
	
	public static boolean refresh(Paquete paquete) throws PersistentException {
		try {
			DB.ProyectoFinalPersistentManager.instance().getSession().refresh(paquete);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Paquete paquete) throws PersistentException {
		try {
			DB.ProyectoFinalPersistentManager.instance().getSession().evict(paquete);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paquete loadPaqueteByCriteria(PaqueteCriteria paqueteCriteria) {
		Paquete[] paquetes = listPaqueteByCriteria(paqueteCriteria);
		if(paquetes == null || paquetes.length == 0) {
			return null;
		}
		return paquetes[0];
	}
	
	public static Paquete[] listPaqueteByCriteria(PaqueteCriteria paqueteCriteria) {
		return paqueteCriteria.listPaquete();
	}
}
