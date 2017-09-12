/**
 * Licensee: University of Almeria
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteProyectoFinalData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = DB.ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			DB.Persona dBPersona = DB.PersonaDAO.loadPersonaByQuery(null, null);
			// Delete the persistent object
			DB.PersonaDAO.delete(dBPersona);
			DB.Cliente dBCliente = DB.ClienteDAO.loadClienteByQuery(null, null);
			// Delete the persistent object
			DB.ClienteDAO.delete(dBCliente);
			DB.Comercial dBComercial = DB.ComercialDAO.loadComercialByQuery(null, null);
			// Delete the persistent object
			DB.ComercialDAO.delete(dBComercial);
			DB.Servicio dBServicio = DB.ServicioDAO.loadServicioByQuery(null, null);
			// Delete the persistent object
			DB.ServicioDAO.delete(dBServicio);
			DB.Movil dBMovil = DB.MovilDAO.loadMovilByQuery(null, null);
			// Delete the persistent object
			DB.MovilDAO.delete(dBMovil);
			DB.Fijo dBFijo = DB.FijoDAO.loadFijoByQuery(null, null);
			// Delete the persistent object
			DB.FijoDAO.delete(dBFijo);
			DB.Fibra dBFibra = DB.FibraDAO.loadFibraByQuery(null, null);
			// Delete the persistent object
			DB.FibraDAO.delete(dBFibra);
			DB.Television dBTelevision = DB.TelevisionDAO.loadTelevisionByQuery(null, null);
			// Delete the persistent object
			DB.TelevisionDAO.delete(dBTelevision);
			DB.Paquete dBPaquete = DB.PaqueteDAO.loadPaqueteByQuery(null, null);
			// Delete the persistent object
			DB.PaqueteDAO.delete(dBPaquete);
			DB.Canal dBCanal = DB.CanalDAO.loadCanalByQuery(null, null);
			// Delete the persistent object
			DB.CanalDAO.delete(dBCanal);
			DB.Incidencia dBIncidencia = DB.IncidenciaDAO.loadIncidenciaByQuery(null, null);
			// Delete the persistent object
			DB.IncidenciaDAO.delete(dBIncidencia);
			DB.Factura dBFactura = DB.FacturaDAO.loadFacturaByQuery(null, null);
			// Delete the persistent object
			DB.FacturaDAO.delete(dBFactura);
			DB.Administrador dBAdministrador = DB.AdministradorDAO.loadAdministradorByQuery(null, null);
			// Delete the persistent object
			DB.AdministradorDAO.delete(dBAdministrador);
			DB.Terminal dBTerminal = DB.TerminalDAO.loadTerminalByQuery(null, null);
			// Delete the persistent object
			DB.TerminalDAO.delete(dBTerminal);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteProyectoFinalData deleteProyectoFinalData = new DeleteProyectoFinalData();
			try {
				deleteProyectoFinalData.deleteTestData();
			}
			finally {
				DB.ProyectoFinalPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
