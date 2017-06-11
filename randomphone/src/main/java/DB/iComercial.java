package DB;

// import BD.Cliente.Paquete;
// import DB.Cliente.Paquete;

public interface iComercial {

	public void altaCliente(Cliente cliente);

	public Servicio[] cargarServiciosDisp();

	public Cliente selecionarCliente(String dni);

	public boolean modificarDatosP(Cliente cliente);

	public void modificarServiciosCliente(Cliente cliente);

	public DB.Paquete[] cargarPaquetesDisp();

	public void addPaqueteCliente(Cliente cliente, Paquete paquete);

	public void eliminarPaqueteCliente(Cliente cliente, Paquete paquete);

	public Incidencia[] cargarIncidencias(int id_comercial);

	public boolean responderIncidencia(Incidencia incidencia);

	public void crearIncidenciaCliente(Incidencia incidencia);

	public void añadirObservacion(Incidencia incidencia);
}