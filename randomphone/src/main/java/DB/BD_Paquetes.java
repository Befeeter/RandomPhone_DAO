package DB;



import java.io.Serializable;

import org.orm.PersistentException;

import DB.Paquete;

public class BD_Paquetes implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -919776534341468878L;
	public BD_Principal bD_Principal_paquetes;
	public Paquete[] paquete = new Paquete[0];

	public Paquete[] cargarPaquetesCliente(int idCliente) {
		Paquete[] paquetes = null;

		try {
			Servicio[] serviciosCliente = bD_Principal_paquetes.cargarServiciosCliente(idCliente);

			for (Servicio servicio : serviciosCliente) {
				if (TelevisionDAO.getTelevisionByORMID(servicio.getID()) != null)
					paquetes = PaqueteDAO.listPaqueteByQuery("TelevisionServicioId=" + servicio.getID(), null);
			}

			// ProyectoFinalPersistentManager.instance().getSession().close();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return paquetes;
	}

	public Paquete[] cargarPaquetesDisp() {
		try {
			return PaqueteDAO.listPaqueteByQuery("Estado=1", null);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public Paquete[] cargarPaquetesTV() {
		try {
			return PaqueteDAO.listPaqueteByQuery(null, null);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}


	public boolean crearPaquete(Paquete paquete) {
		try {
			PaqueteDAO.save(paquete);
			ProyectoFinalPersistentManager.instance().getSession().beginTransaction().commit();
			return true;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public boolean anadirCanalesAPaquete(Paquete paquete, Canal[] canales) {
		try {
			PaqueteDAO.refresh(paquete);
			for (Canal canal : canales){
				if(!paquete.canal.contains(canal))
				paquete.canal.add(canal);
			}
			PaqueteDAO.save(paquete);
			ProyectoFinalPersistentManager.instance().getSession().beginTransaction().commit();
			return true;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean eliminarCanalesAPaquete(Paquete paquete, Canal[] canales){
		try{
			for (Canal canal : canales){
				paquete.canal.remove(canal);
			}
		PaqueteDAO.save(paquete);
		ProyectoFinalPersistentManager.instance().getSession().beginTransaction().commit();
		return true;
		}catch (PersistentException e){
			e.printStackTrace();
		}catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public boolean eliminarPaquete(Paquete paquete) {
		try {
			PaqueteDAO.deleteAndDissociate(paquete);
			ProyectoFinalPersistentManager.instance().getSession().beginTransaction().commit();
			return true;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	public boolean eidtarEstadoPaquete(Paquete paquete, boolean estado){
		try {
			PaqueteDAO.refresh(paquete);
			paquete.setEstado(estado);
			PaqueteDAO.save(paquete);
			ProyectoFinalPersistentManager.instance().getSession().beginTransaction().commit();
			return true;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}
}