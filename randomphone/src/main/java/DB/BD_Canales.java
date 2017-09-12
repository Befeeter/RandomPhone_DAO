package DB;

import DB.Canal;
import DB.Paquete;
import java.io.Serializable;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class BD_Canales implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6374697791669005570L;
	public BD_Principal bD_Principal_canales;
	public Canal[] canal = new Canal[0];

	public Canal[] cargarCanalesPaquete(Paquete paquete) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			Canal[] canales = paquete.canal.toArray();
			PaqueteDAO.refresh(paquete);
			t.commit();
			return canales;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			t.rollback();
		}
		return paquete.canal.toArray();
	}

	public Canal[] cargarCanalesDisp() throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			Canal[] canales = CanalDAO.listCanalByQuery("Estado=1", null);
			t.commit();
			return canales;
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			t.rollback();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public boolean crearCanal(Canal canal) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			CanalDAO.save(canal);
			t.commit();
			return true;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			t.rollback();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public boolean EditarCanal(Canal canal) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			CanalDAO.save(canal);
			t.commit();
			return true;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			t.rollback();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public boolean eliminarCanal(Canal canal) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			CanalDAO.delete(canal);
			t.commit();
			return true;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			t.rollback();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public Canal[] cargarCanalesTv() throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			Canal[] canales = CanalDAO.listCanalByQuery(null, null);
			t.commit();
			return canales;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			t.rollback();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

}