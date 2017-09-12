package DB;



import java.io.Serializable;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import DB.Movil;

public class BD_Moviles implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7729449439111100637L;
	public BD_Principal bD_Principal_moviles;
	public Movil[] movil = new Movil[0];
	

	public Movil[] cargarTarifasMovil() throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		Movil[] tarifasMovil = null;

		try {
			tarifasMovil = MovilDAO.listMovilByQuery(null, null);
			t.commit();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			t.rollback();
		}

		return tarifasMovil;
	}

	public boolean eliminarTarifaMovil(int mesesAdaptacion, Movil movil) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			MovilDAO.delete(movil);
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

	public boolean crearTarifaMovil(Movil movil) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			MovilDAO.save(movil);
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

	public boolean editarTarifaMovil(Movil movil) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			MovilDAO.save(movil);
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
}