package DB;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import DB.Incidencia;

public class BD_Incidencias implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4664169345268755796L;
	public BD_Principal bD_Principal_incidencias;
	public Incidencia[] incidencia = new Incidencia[0];

	public boolean anadirObservacion(Incidencia incidencia) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			IncidenciaDAO.save(incidencia);
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

	public boolean crearIncidencia(Incidencia incidencia) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		try {
			if (incidencia.getTiene() == null) {
				incidencia.setTiene(ClienteDAO.getClienteByORMID(9999)); // Desconocido
																			// ID=
																			// 9999
			}
			if (incidencia.getComercial() == null) {
				incidencia.setComercial(ComercialDAO.getComercialByORMID(0)); // ID
																				// =
																				// 0
																				// porque
																				// ComercialID
																				// Gestor
																				// =
																				// 0
			}
			incidencia.setFecha_alta(date);
			IncidenciaDAO.save(incidencia);
			t.commit();
		} catch (PersistentException e) {
			System.out.println(e.getMessage());
			t.rollback();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean responderIncidencia(Incidencia incidencia) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			IncidenciaDAO.save(incidencia);
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

	public boolean asginarIncidencia(Incidencia incidencia, Comercial comercial) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			incidencia.setEstado("Asignada");
			incidencia.setComercial(comercial);
			IncidenciaDAO.save(incidencia);
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

	public boolean actualizarIncidencia(Incidencia incidencia) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			IncidenciaDAO.save(incidencia);
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

	public Incidencia[] cargarIncidencias(int id_cliente) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		Incidencia[] incidencias = null;
		try {
			incidencias = IncidenciaDAO.listIncidenciaByQuery("ClientePersonaId=" + id_cliente, null);
			t.commit();
			return incidencias;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
			 t.rollback();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return null;
		}
		return null;
	}

	public boolean editarIncidencia(Incidencia incidencia) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			IncidenciaDAO.save(incidencia);
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

	public boolean editarEstadoIncidencia(Incidencia incidencia) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			IncidenciaDAO.save(incidencia);
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

	public Incidencia[] cargarIncidenciasAsignadas() throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		Incidencia[] incidencias = null;
		try {
			incidencias = IncidenciaDAO.listIncidenciaByQuery("Estado='Asignada'", null);
			t.commit();
			return incidencias;
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

	public Incidencia[] cargarIncidenciasSinAsignarCibernauta() throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		Incidencia[] incidencias = null;
		try {
			incidencias = IncidenciaDAO.listIncidenciaByQuery("Estado='SinAsignar' AND cliente='0'", null);
			t.commit();
			return incidencias;
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

	public Incidencia[] cargarIncidenciasSinAsignarClientes() throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		Incidencia[] incidencias = null;
		try {
			incidencias = IncidenciaDAO.listIncidenciaByQuery("Estado='SinAsignar' AND cliente='1'", null);
			t.commit();
			return incidencias;
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

	public Incidencia[] cargarIncidenciasCompletadas() throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		Incidencia[] incidencias;
		try {
			incidencias = IncidenciaDAO.listIncidenciaByQuery("Estado='Completada'", null);
			t.commit();
			return incidencias;
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

	public boolean eliminarIncidencias(Incidencia[] incidencias) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			for (Incidencia incidencia : incidencias) {
				System.out.println(incidencia.getID());
				IncidenciaDAO.deleteAndDissociate(incidencia);
			}
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

	public boolean crearIncidenciaCliente(Incidencia incidencia) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			IncidenciaDAO.save(incidencia);
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

	public Incidencia[] cargarIncidenciasCm(int id_comercial) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		Incidencia[] incidencias = null;
		try {
			incidencias = IncidenciaDAO.listIncidenciaByQuery("ComercialPersonaId=" + id_comercial, null);
			t.commit();
			return incidencias;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
			t.rollback();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return null;
		}
		return null;
	}
}