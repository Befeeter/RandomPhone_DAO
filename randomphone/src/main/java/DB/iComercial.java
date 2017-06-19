package DB;

// import BD.Cliente.Paquete;
// import DB.Cliente.Paquete;

public interface iComercial {
	public Cliente cargarDatosCliente(String dni);

	public void altaCliente(Cliente cliente);

	public Servicio[] cargarServiciosDisp();

	public Cliente selecionarCliente(String dni);

	public boolean modificarDatosP(Cliente cliente);

	public void modificarServiciosCliente(Cliente cliente);

	public DB.Paquete[] cargarPaquetesDisp();

	public void addPaqueteCliente(Cliente cliente, Paquete paquete);

	public void eliminarPaqueteCliente(Cliente cliente, Paquete paquete);

	public Incidencia[] cargarIncidenciasCm(int id_comercial);
	
	public boolean editarEstadoIncidencia(Incidencia incidencia);

	public boolean responderIncidencia(Incidencia incidencia);

	public boolean crearIncidenciaCliente(Incidencia incidencia);

	public void añadirObservacion(Incidencia incidencia);
	
	public Comercial[] cargarComerciales();
}