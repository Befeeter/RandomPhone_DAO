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

public class FacturaDAO {
	public static Factura loadFacturaByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return loadFacturaByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Factura getFacturaByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return getFacturaByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Factura loadFacturaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return loadFacturaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Factura getFacturaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return getFacturaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Factura loadFacturaByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Factura) session.load(Factura.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Factura getFacturaByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Factura) session.get(Factura.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Factura loadFacturaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Factura) session.load(Factura.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Factura getFacturaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Factura) session.get(Factura.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFactura(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return queryFactura(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFactura(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return queryFactura(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Factura[] listFacturaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return listFacturaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Factura[] listFacturaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return listFacturaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFactura(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Factura as Factura");
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
	
	public static List queryFactura(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Factura as Factura");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Factura", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Factura[] listFacturaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryFactura(session, condition, orderBy);
			return (Factura[]) list.toArray(new Factura[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Factura[] listFacturaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryFactura(session, condition, orderBy, lockMode);
			return (Factura[]) list.toArray(new Factura[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Factura loadFacturaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return loadFacturaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Factura loadFacturaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return loadFacturaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Factura loadFacturaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Factura[] facturas = listFacturaByQuery(session, condition, orderBy);
		if (facturas != null && facturas.length > 0)
			return facturas[0];
		else
			return null;
	}
	
	public static Factura loadFacturaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Factura[] facturas = listFacturaByQuery(session, condition, orderBy, lockMode);
		if (facturas != null && facturas.length > 0)
			return facturas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateFacturaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return iterateFacturaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateFacturaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = DB.ProyectoFinalPersistentManager.instance().getSession();
			return iterateFacturaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateFacturaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Factura as Factura");
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
	
	public static java.util.Iterator iterateFacturaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Factura as Factura");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Factura", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Factura createFactura() {
		return new Factura();
	}
	
	public static boolean save(Factura factura) throws PersistentException {
		try {
			DB.ProyectoFinalPersistentManager.instance().saveObject(factura);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Factura factura) throws PersistentException {
		try {
			DB.ProyectoFinalPersistentManager.instance().deleteObject(factura);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Factura factura)throws PersistentException {
		try {
			if (factura.getCliente() != null) {
				factura.getCliente().factura.remove(factura);
			}
			
			DB.Servicio[] lServicios = factura.servicio.toArray();
			for(int i = 0; i < lServicios.length; i++) {
				lServicios[i].factura.remove(factura);
			}
			DB.Terminal[] lTerminals = factura.terminal.toArray();
			for(int i = 0; i < lTerminals.length; i++) {
				lTerminals[i].setFactura(null);
			}
			return delete(factura);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Factura factura, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (factura.getCliente() != null) {
				factura.getCliente().factura.remove(factura);
			}
			
			DB.Servicio[] lServicios = factura.servicio.toArray();
			for(int i = 0; i < lServicios.length; i++) {
				lServicios[i].factura.remove(factura);
			}
			DB.Terminal[] lTerminals = factura.terminal.toArray();
			for(int i = 0; i < lTerminals.length; i++) {
				lTerminals[i].setFactura(null);
			}
			try {
				session.delete(factura);
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
	
	public static boolean refresh(Factura factura) throws PersistentException {
		try {
			DB.ProyectoFinalPersistentManager.instance().getSession().refresh(factura);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Factura factura) throws PersistentException {
		try {
			DB.ProyectoFinalPersistentManager.instance().getSession().evict(factura);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Factura loadFacturaByCriteria(FacturaCriteria facturaCriteria) {
		Factura[] facturas = listFacturaByCriteria(facturaCriteria);
		if(facturas == null || facturas.length == 0) {
			return null;
		}
		return facturas[0];
	}
	
	public static Factura[] listFacturaByCriteria(FacturaCriteria facturaCriteria) {
		return facturaCriteria.listFactura();
	}
}
