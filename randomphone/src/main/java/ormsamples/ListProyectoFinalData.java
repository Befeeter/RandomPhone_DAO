/**
 * Licensee: University of Almeria
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListProyectoFinalData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Persona...");
		DB.Persona[] dBPersonas = DB.PersonaDAO.listPersonaByQuery(null, null);
		int length = Math.min(dBPersonas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(dBPersonas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Cliente...");
		DB.Cliente[] dBClientes = DB.ClienteDAO.listClienteByQuery(null, null);
		length = Math.min(dBClientes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(dBClientes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Comercial...");
		DB.Comercial[] dBComercials = DB.ComercialDAO.listComercialByQuery(null, null);
		length = Math.min(dBComercials.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(dBComercials[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Servicio...");
		DB.Servicio[] dBServicios = DB.ServicioDAO.listServicioByQuery(null, null);
		length = Math.min(dBServicios.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(dBServicios[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Movil...");
		DB.Movil[] dBMovils = DB.MovilDAO.listMovilByQuery(null, null);
		length = Math.min(dBMovils.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(dBMovils[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Fijo...");
		DB.Fijo[] dBFijos = DB.FijoDAO.listFijoByQuery(null, null);
		length = Math.min(dBFijos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(dBFijos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Fibra...");
		DB.Fibra[] dBFibras = DB.FibraDAO.listFibraByQuery(null, null);
		length = Math.min(dBFibras.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(dBFibras[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Television...");
		DB.Television[] dBTelevisions = DB.TelevisionDAO.listTelevisionByQuery(null, null);
		length = Math.min(dBTelevisions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(dBTelevisions[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Paquete...");
		DB.Paquete[] dBPaquetes = DB.PaqueteDAO.listPaqueteByQuery(null, null);
		length = Math.min(dBPaquetes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(dBPaquetes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Canal...");
		DB.Canal[] dBCanals = DB.CanalDAO.listCanalByQuery(null, null);
		length = Math.min(dBCanals.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(dBCanals[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Incidencia...");
		DB.Incidencia[] dBIncidencias = DB.IncidenciaDAO.listIncidenciaByQuery(null, null);
		length = Math.min(dBIncidencias.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(dBIncidencias[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Factura...");
		DB.Factura[] dBFacturas = DB.FacturaDAO.listFacturaByQuery(null, null);
		length = Math.min(dBFacturas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(dBFacturas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Administrador...");
		DB.Administrador[] dBAdministradors = DB.AdministradorDAO.listAdministradorByQuery(null, null);
		length = Math.min(dBAdministradors.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(dBAdministradors[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Terminal...");
		DB.Terminal[] dBTerminals = DB.TerminalDAO.listTerminalByQuery(null, null);
		length = Math.min(dBTerminals.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(dBTerminals[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Persona by Criteria...");
		DB.PersonaCriteria dBPersonaCriteria = new DB.PersonaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//dBPersonaCriteria.ID.eq();
		dBPersonaCriteria.setMaxResults(ROW_COUNT);
		DB.Persona[] dBPersonas = dBPersonaCriteria.listPersona();
		int length =dBPersonas== null ? 0 : Math.min(dBPersonas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(dBPersonas[i]);
		}
		System.out.println(length + " Persona record(s) retrieved."); 
		
		System.out.println("Listing Cliente by Criteria...");
		DB.ClienteCriteria dBClienteCriteria = new DB.ClienteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//dBClienteCriteria.ID.eq();
		dBClienteCriteria.setMaxResults(ROW_COUNT);
		DB.Cliente[] dBClientes = dBClienteCriteria.listCliente();
		length =dBClientes== null ? 0 : Math.min(dBClientes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(dBClientes[i]);
		}
		System.out.println(length + " Cliente record(s) retrieved."); 
		
		System.out.println("Listing Comercial by Criteria...");
		DB.ComercialCriteria dBComercialCriteria = new DB.ComercialCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//dBComercialCriteria.ID.eq();
		dBComercialCriteria.setMaxResults(ROW_COUNT);
		DB.Comercial[] dBComercials = dBComercialCriteria.listComercial();
		length =dBComercials== null ? 0 : Math.min(dBComercials.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(dBComercials[i]);
		}
		System.out.println(length + " Comercial record(s) retrieved."); 
		
		System.out.println("Listing Servicio by Criteria...");
		DB.ServicioCriteria dBServicioCriteria = new DB.ServicioCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//dBServicioCriteria.ID.eq();
		dBServicioCriteria.setMaxResults(ROW_COUNT);
		DB.Servicio[] dBServicios = dBServicioCriteria.listServicio();
		length =dBServicios== null ? 0 : Math.min(dBServicios.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(dBServicios[i]);
		}
		System.out.println(length + " Servicio record(s) retrieved."); 
		
		System.out.println("Listing Movil by Criteria...");
		DB.MovilCriteria dBMovilCriteria = new DB.MovilCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//dBMovilCriteria.ID.eq();
		dBMovilCriteria.setMaxResults(ROW_COUNT);
		DB.Movil[] dBMovils = dBMovilCriteria.listMovil();
		length =dBMovils== null ? 0 : Math.min(dBMovils.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(dBMovils[i]);
		}
		System.out.println(length + " Movil record(s) retrieved."); 
		
		System.out.println("Listing Fijo by Criteria...");
		DB.FijoCriteria dBFijoCriteria = new DB.FijoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//dBFijoCriteria.ID.eq();
		dBFijoCriteria.setMaxResults(ROW_COUNT);
		DB.Fijo[] dBFijos = dBFijoCriteria.listFijo();
		length =dBFijos== null ? 0 : Math.min(dBFijos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(dBFijos[i]);
		}
		System.out.println(length + " Fijo record(s) retrieved."); 
		
		System.out.println("Listing Fibra by Criteria...");
		DB.FibraCriteria dBFibraCriteria = new DB.FibraCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//dBFibraCriteria.ID.eq();
		dBFibraCriteria.setMaxResults(ROW_COUNT);
		DB.Fibra[] dBFibras = dBFibraCriteria.listFibra();
		length =dBFibras== null ? 0 : Math.min(dBFibras.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(dBFibras[i]);
		}
		System.out.println(length + " Fibra record(s) retrieved."); 
		
		System.out.println("Listing Television by Criteria...");
		DB.TelevisionCriteria dBTelevisionCriteria = new DB.TelevisionCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//dBTelevisionCriteria.ID.eq();
		dBTelevisionCriteria.setMaxResults(ROW_COUNT);
		DB.Television[] dBTelevisions = dBTelevisionCriteria.listTelevision();
		length =dBTelevisions== null ? 0 : Math.min(dBTelevisions.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(dBTelevisions[i]);
		}
		System.out.println(length + " Television record(s) retrieved."); 
		
		System.out.println("Listing Paquete by Criteria...");
		DB.PaqueteCriteria dBPaqueteCriteria = new DB.PaqueteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//dBPaqueteCriteria.ID.eq();
		dBPaqueteCriteria.setMaxResults(ROW_COUNT);
		DB.Paquete[] dBPaquetes = dBPaqueteCriteria.listPaquete();
		length =dBPaquetes== null ? 0 : Math.min(dBPaquetes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(dBPaquetes[i]);
		}
		System.out.println(length + " Paquete record(s) retrieved."); 
		
		System.out.println("Listing Canal by Criteria...");
		DB.CanalCriteria dBCanalCriteria = new DB.CanalCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//dBCanalCriteria.ID.eq();
		dBCanalCriteria.setMaxResults(ROW_COUNT);
		DB.Canal[] dBCanals = dBCanalCriteria.listCanal();
		length =dBCanals== null ? 0 : Math.min(dBCanals.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(dBCanals[i]);
		}
		System.out.println(length + " Canal record(s) retrieved."); 
		
		System.out.println("Listing Incidencia by Criteria...");
		DB.IncidenciaCriteria dBIncidenciaCriteria = new DB.IncidenciaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//dBIncidenciaCriteria.ID.eq();
		dBIncidenciaCriteria.setMaxResults(ROW_COUNT);
		DB.Incidencia[] dBIncidencias = dBIncidenciaCriteria.listIncidencia();
		length =dBIncidencias== null ? 0 : Math.min(dBIncidencias.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(dBIncidencias[i]);
		}
		System.out.println(length + " Incidencia record(s) retrieved."); 
		
		System.out.println("Listing Factura by Criteria...");
		DB.FacturaCriteria dBFacturaCriteria = new DB.FacturaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//dBFacturaCriteria.ID.eq();
		dBFacturaCriteria.setMaxResults(ROW_COUNT);
		DB.Factura[] dBFacturas = dBFacturaCriteria.listFactura();
		length =dBFacturas== null ? 0 : Math.min(dBFacturas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(dBFacturas[i]);
		}
		System.out.println(length + " Factura record(s) retrieved."); 
		
		System.out.println("Listing Administrador by Criteria...");
		DB.AdministradorCriteria dBAdministradorCriteria = new DB.AdministradorCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//dBAdministradorCriteria.ID.eq();
		dBAdministradorCriteria.setMaxResults(ROW_COUNT);
		DB.Administrador[] dBAdministradors = dBAdministradorCriteria.listAdministrador();
		length =dBAdministradors== null ? 0 : Math.min(dBAdministradors.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(dBAdministradors[i]);
		}
		System.out.println(length + " Administrador record(s) retrieved."); 
		
		System.out.println("Listing Terminal by Criteria...");
		DB.TerminalCriteria dBTerminalCriteria = new DB.TerminalCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//dBTerminalCriteria.ID.eq();
		dBTerminalCriteria.setMaxResults(ROW_COUNT);
		DB.Terminal[] dBTerminals = dBTerminalCriteria.listTerminal();
		length =dBTerminals== null ? 0 : Math.min(dBTerminals.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(dBTerminals[i]);
		}
		System.out.println(length + " Terminal record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListProyectoFinalData listProyectoFinalData = new ListProyectoFinalData();
			try {
				listProyectoFinalData.listTestData();
				//listProyectoFinalData.listByCriteria();
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
