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

public class FijoDAO {
	public static Fijo loadFijoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return loadFijoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fijo getFijoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return getFijoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fijo loadFijoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return loadFijoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fijo getFijoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return getFijoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fijo loadFijoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Fijo) session.load(Fijo.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fijo getFijoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Fijo) session.get(Fijo.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fijo loadFijoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Fijo) session.load(Fijo.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fijo getFijoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Fijo) session.get(Fijo.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFijo(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return queryFijo(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFijo(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return queryFijo(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fijo[] listFijoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return listFijoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fijo[] listFijoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return listFijoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFijo(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Fijo as Fijo");
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
	
	public static List queryFijo(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Fijo as Fijo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Fijo", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fijo[] listFijoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryFijo(session, condition, orderBy);
			return (Fijo[]) list.toArray(new Fijo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fijo[] listFijoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryFijo(session, condition, orderBy, lockMode);
			return (Fijo[]) list.toArray(new Fijo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fijo loadFijoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return loadFijoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fijo loadFijoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return loadFijoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fijo loadFijoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Fijo[] fijos = listFijoByQuery(session, condition, orderBy);
		if (fijos != null && fijos.length > 0)
			return fijos[0];
		else
			return null;
	}
	
	public static Fijo loadFijoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Fijo[] fijos = listFijoByQuery(session, condition, orderBy, lockMode);
		if (fijos != null && fijos.length > 0)
			return fijos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateFijoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return iterateFijoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateFijoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return iterateFijoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateFijoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Fijo as Fijo");
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
	
	public static java.util.Iterator iterateFijoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Fijo as Fijo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Fijo", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fijo createFijo() {
		return new Fijo();
	}
	
	public static boolean save(Fijo fijo) throws PersistentException {
		try {
			DB.ProyectoFinalPersistentManager.instance().saveObject(fijo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Fijo fijo) throws PersistentException {
		try {
			DB.ProyectoFinalPersistentManager.instance().deleteObject(fijo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Fijo fijo)throws PersistentException {
		try {
			DB.Factura[] lFacturas = fijo.factura.toArray();
			for(int i = 0; i < lFacturas.length; i++) {
				lFacturas[i].servicio.remove(fijo);
			}
			return delete(fijo);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Fijo fijo, org.orm.PersistentSession session)throws PersistentException {
		try {
			DB.Factura[] lFacturas = fijo.factura.toArray();
			for(int i = 0; i < lFacturas.length; i++) {
				lFacturas[i].servicio.remove(fijo);
			}
			try {
				session.delete(fijo);
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
	
	public static boolean refresh(Fijo fijo) throws PersistentException {
		try {
			DB.ProyectoFinalPersistentManager.instance().getSession().refresh(fijo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Fijo fijo) throws PersistentException {
		try {
			DB.ProyectoFinalPersistentManager.instance().getSession().evict(fijo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Fijo loadFijoByCriteria(FijoCriteria fijoCriteria) {
		Fijo[] fijos = listFijoByCriteria(fijoCriteria);
		if(fijos == null || fijos.length == 0) {
			return null;
		}
		return fijos[0];
	}
	
	public static Fijo[] listFijoByCriteria(FijoCriteria fijoCriteria) {
		return fijoCriteria.listFijo();
	}
}
