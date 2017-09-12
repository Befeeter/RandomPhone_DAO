package db_old;

public interface iCliente {

	public Cliente cargarDatosCliente(int id);

	public boolean modificarDatosP(Cliente cliente);

	public Servicio[] cargarServiciosCliente(int id);

	public boolean modificarServicios(Servicio[] servicio, int idFactura);

	public Paquete[] cargarPaquetesCliente(int idCliente);

	//public void cargarPaquetePersonal(Paquete paquete);

	public Canal[] cargarCanalesDisp();

	//public void addCanalPaquete(Canal[] canales);

	//public void deleteCanalPaquete(Canal[] canales);

	public Factura[] cargarFacturas(int id_cliente);

	public Incidencia[] cargarIncidencias(int id_cliente);

	public boolean crearIncidencia(Incidencia incidencia);

	public boolean actualizarIncidencia(Incidencia incidencia);
	
	public boolean eliminarIncidencias(Incidencia[] incidencias);
}