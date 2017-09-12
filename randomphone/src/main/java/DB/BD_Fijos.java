package DB;


import java.io.Serializable;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import DB.Fijo;

public class BD_Fijos implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8234242049524889061L;
	public BD_Principal bD_Principal_fijos;
	public Fijo[] fijo = new Fijo[0];

	public Servicio[] cargarOfertas() {
		throw new UnsupportedOperationException();
	}

	public Fijo[] cargarTarifasFijo() throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		Fijo[] tarifasFijo = null;

		try {
			tarifasFijo = FijoDAO.listFijoByQuery(null, null);
			t.commit();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			t.rollback();
		}

		return tarifasFijo;
	}

	public boolean eliminarTarifaFijo(Fijo fijo, int mesesAdaptacion) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			FijoDAO.delete(fijo);
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

	public boolean crearTarifaFijo(Fijo fijo) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			FijoDAO.save(fijo);
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

	public boolean editarTarifaFijo(Fijo fijo) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			FijoDAO.save(fijo);
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