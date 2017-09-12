/**
 * Licensee: University of Almeria
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateProyectoFinalData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = DB.ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			DB.Persona dBPersona = DB.PersonaDAO.loadPersonaByQuery(null, null);
			// Update the properties of the persistent object
			DB.PersonaDAO.save(dBPersona);
			DB.Cliente dBCliente = DB.ClienteDAO.loadClienteByQuery(null, null);
			// Update the properties of the persistent object
			DB.ClienteDAO.save(dBCliente);
			DB.Comercial dBComercial = DB.ComercialDAO.loadComercialByQuery(null, null);
			// Update the properties of the persistent object
			DB.ComercialDAO.save(dBComercial);
			DB.Servicio dBServicio = DB.ServicioDAO.loadServicioByQuery(null, null);
			// Update the properties of the persistent object
			DB.ServicioDAO.save(dBServicio);
			DB.Movil dBMovil = DB.MovilDAO.loadMovilByQuery(null, null);
			// Update the properties of the persistent object
			DB.MovilDAO.save(dBMovil);
			DB.Fijo dBFijo = DB.FijoDAO.loadFijoByQuery(null, null);
			// Update the properties of the persistent object
			DB.FijoDAO.save(dBFijo);
			DB.Fibra dBFibra = DB.FibraDAO.loadFibraByQuery(null, null);
			// Update the properties of the persistent object
			DB.FibraDAO.save(dBFibra);
			DB.Television dBTelevision = DB.TelevisionDAO.loadTelevisionByQuery(null, null);
			// Update the properties of the persistent object
			DB.TelevisionDAO.save(dBTelevision);
			DB.Paquete dBPaquete = DB.PaqueteDAO.loadPaqueteByQuery(null, null);
			// Update the properties of the persistent object
			DB.PaqueteDAO.save(dBPaquete);
			DB.Canal dBCanal = DB.CanalDAO.loadCanalByQuery(null, null);
			// Update the properties of the persistent object
			DB.CanalDAO.save(dBCanal);
			DB.Incidencia dBIncidencia = DB.IncidenciaDAO.loadIncidenciaByQuery(null, null);
			// Update the properties of the persistent object
			DB.IncidenciaDAO.save(dBIncidencia);
			DB.Factura dBFactura = DB.FacturaDAO.loadFacturaByQuery(null, null);
			// Update the properties of the persistent object
			DB.FacturaDAO.save(dBFactura);
			DB.Administrador dBAdministrador = DB.AdministradorDAO.loadAdministradorByQuery(null, null);
			// Update the properties of the persistent object
			DB.AdministradorDAO.save(dBAdministrador);
			DB.Terminal dBTerminal = DB.TerminalDAO.loadTerminalByQuery(null, null);
			// Update the properties of the persistent object
			DB.TerminalDAO.save(dBTerminal);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Persona by PersonaCriteria");
		DB.PersonaCriteria dBPersonaCriteria = new DB.PersonaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//dBPersonaCriteria.ID.eq();
		System.out.println(dBPersonaCriteria.uniquePersona());
		
		System.out.println("Retrieving Cliente by ClienteCriteria");
		DB.ClienteCriteria dBClienteCriteria = new DB.ClienteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//dBClienteCriteria.ID.eq();
		System.out.println(dBClienteCriteria.uniqueCliente());
		
		System.out.println("Retrieving Comercial by ComercialCriteria");
		DB.ComercialCriteria dBComercialCriteria = new DB.ComercialCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//dBComercialCriteria.ID.eq();
		System.out.println(dBComercialCriteria.uniqueComercial());
		
		System.out.println("Retrieving Servicio by ServicioCriteria");
		DB.ServicioCriteria dBServicioCriteria = new DB.ServicioCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//dBServicioCriteria.ID.eq();
		System.out.println(dBServicioCriteria.uniqueServicio());
		
		System.out.println("Retrieving Movil by MovilCriteria");
		DB.MovilCriteria dBMovilCriteria = new DB.MovilCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//dBMovilCriteria.ID.eq();
		System.out.println(dBMovilCriteria.uniqueMovil());
		
		System.out.println("Retrieving Fijo by FijoCriteria");
		DB.FijoCriteria dBFijoCriteria = new DB.FijoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//dBFijoCriteria.ID.eq();
		System.out.println(dBFijoCriteria.uniqueFijo());
		
		System.out.println("Retrieving Fibra by FibraCriteria");
		DB.FibraCriteria dBFibraCriteria = new DB.FibraCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//dBFibraCriteria.ID.eq();
		System.out.println(dBFibraCriteria.uniqueFibra());
		
		System.out.println("Retrieving Television by TelevisionCriteria");
		DB.TelevisionCriteria dBTelevisionCriteria = new DB.TelevisionCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//dBTelevisionCriteria.ID.eq();
		System.out.println(dBTelevisionCriteria.uniqueTelevision());
		
		System.out.println("Retrieving Paquete by PaqueteCriteria");
		DB.PaqueteCriteria dBPaqueteCriteria = new DB.PaqueteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//dBPaqueteCriteria.ID.eq();
		System.out.println(dBPaqueteCriteria.uniquePaquete());
		
		System.out.println("Retrieving Canal by CanalCriteria");
		DB.CanalCriteria dBCanalCriteria = new DB.CanalCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//dBCanalCriteria.ID.eq();
		System.out.println(dBCanalCriteria.uniqueCanal());
		
		System.out.println("Retrieving Incidencia by IncidenciaCriteria");
		DB.IncidenciaCriteria dBIncidenciaCriteria = new DB.IncidenciaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//dBIncidenciaCriteria.ID.eq();
		System.out.println(dBIncidenciaCriteria.uniqueIncidencia());
		
		System.out.println("Retrieving Factura by FacturaCriteria");
		DB.FacturaCriteria dBFacturaCriteria = new DB.FacturaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//dBFacturaCriteria.ID.eq();
		System.out.println(dBFacturaCriteria.uniqueFactura());
		
		System.out.println("Retrieving Administrador by AdministradorCriteria");
		DB.AdministradorCriteria dBAdministradorCriteria = new DB.AdministradorCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//dBAdministradorCriteria.ID.eq();
		System.out.println(dBAdministradorCriteria.uniqueAdministrador());
		
		System.out.println("Retrieving Terminal by TerminalCriteria");
		DB.TerminalCriteria dBTerminalCriteria = new DB.TerminalCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//dBTerminalCriteria.ID.eq();
		System.out.println(dBTerminalCriteria.uniqueTerminal());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateProyectoFinalData retrieveAndUpdateProyectoFinalData = new RetrieveAndUpdateProyectoFinalData();
			try {
				retrieveAndUpdateProyectoFinalData.retrieveAndUpdateTestData();
				//retrieveAndUpdateProyectoFinalData.retrieveByCriteria();
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
