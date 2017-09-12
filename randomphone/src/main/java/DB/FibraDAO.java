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

public class FibraDAO {
	public static Fibra loadFibraByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return loadFibraByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fibra getFibraByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return getFibraByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fibra loadFibraByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return loadFibraByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fibra getFibraByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return getFibraByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fibra loadFibraByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Fibra) session.load(Fibra.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fibra getFibraByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Fibra) session.get(Fibra.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fibra loadFibraByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Fibra) session.load(Fibra.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fibra getFibraByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Fibra) session.get(Fibra.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFibra(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return queryFibra(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFibra(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return queryFibra(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fibra[] listFibraByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return listFibraByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fibra[] listFibraByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return listFibraByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFibra(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Fibra as Fibra");
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
	
	public static List queryFibra(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Fibra as Fibra");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Fibra", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fibra[] listFibraByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryFibra(session, condition, orderBy);
			return (Fibra[]) list.toArray(new Fibra[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fibra[] listFibraByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryFibra(session, condition, orderBy, lockMode);
			return (Fibra[]) list.toArray(new Fibra[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fibra loadFibraByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return loadFibraByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fibra loadFibraByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return loadFibraByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fibra loadFibraByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Fibra[] fibras = listFibraByQuery(session, condition, orderBy);
		if (fibras != null && fibras.length > 0)
			return fibras[0];
		else
			return null;
	}
	
	public static Fibra loadFibraByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Fibra[] fibras = listFibraByQuery(session, condition, orderBy, lockMode);
		if (fibras != null && fibras.length > 0)
			return fibras[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateFibraByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return iterateFibraByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateFibraByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return iterateFibraByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateFibraByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Fibra as Fibra");
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
	
	public static java.util.Iterator iterateFibraByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Fibra as Fibra");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Fibra", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fibra createFibra() {
		return new Fibra();
	}
	
	public static boolean save(Fibra fibra) throws PersistentException {
		try {
			DB.ProyectoFinalPersistentManager.instance().saveObject(fibra);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Fibra fibra) throws PersistentException {
		try {
			DB.ProyectoFinalPersistentManager.instance().deleteObject(fibra);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Fibra fibra)throws PersistentException {
		try {
			DB.Factura[] lFacturas = fibra.factura.toArray();
			for(int i = 0; i < lFacturas.length; i++) {
				lFacturas[i].servicio.remove(fibra);
			}
			return delete(fibra);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Fibra fibra, org.orm.PersistentSession session)throws PersistentException {
		try {
			DB.Factura[] lFacturas = fibra.factura.toArray();
			for(int i = 0; i < lFacturas.length; i++) {
				lFacturas[i].servicio.remove(fibra);
			}
			try {
				session.delete(fibra);
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
	
	public static boolean refresh(Fibra fibra) throws PersistentException {
		try {
			DB.ProyectoFinalPersistentManager.instance().getSession().refresh(fibra);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Fibra fibra) throws PersistentException {
		try {
			DB.ProyectoFinalPersistentManager.instance().getSession().evict(fibra);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fibra loadFibraByCriteria(FibraCriteria fibraCriteria) {
		Fibra[] fibras = listFibraByCriteria(fibraCriteria);
		if(fibras == null || fibras.length == 0) {
			return null;
		}
		return fibras[0];
	}
	
	public static Fibra[] listFibraByCriteria(FibraCriteria fibraCriteria) {
		return fibraCriteria.listFibra();
	}
}
