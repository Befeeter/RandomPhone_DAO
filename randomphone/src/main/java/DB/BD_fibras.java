package DB;


import java.io.Serializable;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import DB.Fibra;

public class BD_fibras implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2418114805257006408L;
	public BD_Principal bD_Principal_fibras;
	public Fibra[] fibra = new Fibra[0];

	public Fibra[] cargarTarifasFibra() throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		Fibra[] tarifasFibra = null;

		try {
			tarifasFibra = FibraDAO.listFibraByQuery(null, null);
			t.commit();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			t.rollback();
		}

		return tarifasFibra;
	}

	public boolean eliminarTarifaFibra(Fibra fibra, int mesesAdaptacion) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			FibraDAO.delete(fibra);
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

	public boolean crearTarifaFibra(Fibra fibra) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			FibraDAO.save(fibra);
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

	public boolean editarTarifaFibra(Fibra fibra) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			FibraDAO.save(fibra);
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