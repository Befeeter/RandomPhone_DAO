package DB;

import java.io.Serializable;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import DB.Comercial;

public class BD_Comerciales implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8175316813185622178L;
	public BD_Principal bD_Principal_comerciales;
	public Comercial[] comercial = new Comercial[0];

	public boolean eliminarComercial(Comercial comercial) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			ComercialDAO.delete(comercial);
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

	public boolean editarComercial(Comercial comercial) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {			
			ComercialDAO.save(comercial);
			PersonaDAO.save(comercial);
			t.commit();
			return true;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			t.rollback();
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public boolean altaComercial(Comercial comercial) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			ComercialDAO.save(comercial);
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

	public Comercial[] cargarComerciales() throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			Comercial[] comerciales = ComercialDAO.listComercialByQuery("Estado=1", null);
			t.commit();
			return comerciales;
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