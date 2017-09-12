/**
 * Licensee: University of Almeria
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateProyectoFinalData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = DB.ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			DB.Persona dBPersona = DB.PersonaDAO.createPersona();
			// Initialize the properties of the persistent object here
			DB.PersonaDAO.save(dBPersona);
			DB.Cliente dBCliente = DB.ClienteDAO.createCliente();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : incidencia, factura, estado
			DB.ClienteDAO.save(dBCliente);
			DB.Comercial dBComercial = DB.ComercialDAO.createComercial();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : incidencia, estado
			DB.ComercialDAO.save(dBComercial);
			DB.Servicio dBServicio = DB.ServicioDAO.createServicio();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : factura, estado, precio
			DB.ServicioDAO.save(dBServicio);
			DB.Movil dBMovil = DB.MovilDAO.createMovil();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : datos, minutos
			DB.MovilDAO.save(dBMovil);
			DB.Fijo dBFijo = DB.FijoDAO.createFijo();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : minutos
			DB.FijoDAO.save(dBFijo);
			DB.Fibra dBFibra = DB.FibraDAO.createFibra();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : vbaj, vsub
			DB.FibraDAO.save(dBFibra);
			DB.Television dBTelevision = DB.TelevisionDAO.createTelevision();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : paquete
			DB.TelevisionDAO.save(dBTelevision);
			DB.Paquete dBPaquete = DB.PaqueteDAO.createPaquete();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : canal, estado, precio, television
			DB.PaqueteDAO.save(dBPaquete);
			DB.Canal dBCanal = DB.CanalDAO.createCanal();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : paquete, estado, precio
			DB.CanalDAO.save(dBCanal);
			DB.Incidencia dBIncidencia = DB.IncidenciaDAO.createIncidencia();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : cliente, telefono, tiene, comercial
			DB.IncidenciaDAO.save(dBIncidencia);
			DB.Factura dBFactura = DB.FacturaDAO.createFactura();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : terminal, servicio, total, cliente
			DB.FacturaDAO.save(dBFactura);
			DB.Administrador dBAdministrador = DB.AdministradorDAO.createAdministrador();
			// Initialize the properties of the persistent object here
			DB.AdministradorDAO.save(dBAdministrador);
			DB.Terminal dBTerminal = DB.TerminalDAO.createTerminal();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : estado, factura
			DB.TerminalDAO.save(dBTerminal);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateProyectoFinalData createProyectoFinalData = new CreateProyectoFinalData();
			try {
				createProyectoFinalData.createTestData();
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
