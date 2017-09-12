package DB;

import java.io.Serializable;


import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import DB.Television;

public class BD_Televisiones implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2297552449003689367L;
	public BD_Principal bD_Principal_televisiones;
	public Television[] television = new Television[0];


	public Television[] cargarTarifasTelevision() throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		Television[] serviciosDisp = null;
		try {
			serviciosDisp = TelevisionDAO.listTelevisionByQuery(null, null);
			t.commit();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			t.rollback();
		}
		return serviciosDisp;
	}
}