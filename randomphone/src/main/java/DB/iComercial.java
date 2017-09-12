package DB;

import org.orm.PersistentException;

// import BD.Cliente.Paquete;
// import DB.Cliente.Paquete;

public interface iComercial {
	public Cliente cargarDatosCliente(String dni);

	public int crearFacturaServicios(Cliente cliente, Servicio[] serviciosContratados, int total);

	public boolean altaTerminal(Terminal[] terminales, int facturaId);
	
	public boolean modificarTerminal(Terminal[] terminales, int facturaId);

	public int altaCliente(Cliente cliente);

	//public Servicio[] cargarServiciosDisp();

	public Movil[] cargarTarifasMovil();

	public Fijo[] cargarTarifasFijo();

	public Fibra[] cargarTarifasFibra();

	public Television[] cargarTarifasTelevision();

	//public Cliente selecionarCliente(String dni);

	public boolean modificarDatosP(Cliente cliente);
	
	public boolean modificarServicios(Servicio[] servicios, int idFactura);

	//public void modificarServiciosCliente(Cliente cliente);

	public DB.Paquete[] cargarPaquetesDisp();
	
	public Paquete[] cargarPaquetesTV();

	public Incidencia[] cargarIncidencias(int id_cliente);
	
	public Paquete[] cargarPaquetesCliente(int idCliente);

	//public void addPaqueteCliente(Cliente cliente, Paquete paquete);

	//public void eliminarPaqueteCliente(Cliente cliente, Paquete paquete);

	public Incidencia[] cargarIncidenciasCm(int id_comercial);

	public boolean editarEstadoIncidencia(Incidencia incidencia);

	public boolean responderIncidencia(Incidencia incidencia);

	public boolean crearIncidenciaCliente(Incidencia incidencia);

	public boolean anadirObservacion(Incidencia incidencia);

	public Comercial[] cargarComerciales();
}