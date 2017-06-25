package DB;

public interface iAdministrador {

	public Cliente[] cargarListadoClientes();

	//public Comercial[] cargarListaDeComerciales();

	public boolean asignarIncidencia(Incidencia incidencia, Comercial comercial);

	//public Incidencia cargarIncidencia(Incidencia incidencia);

	public boolean editarIncidencia(Incidencia incidencia);

	public Incidencia[] cargarIncidenciasSinAsignarCibernauta();

	public Incidencia[] cargarIncidenciasSinAsignarCLientes();
	
	public Incidencia[] cargarIncidenciasAsignadas();

	public Incidencia[] cargarIncidenciasCompletadas();

	public boolean eliminarIncidencias(Incidencia[] incidencias);

	//public Incidencia[] incidenciasActivasComercial(Comercial comercial);

	public boolean eliminarComercial(Comercial comercial);

	public boolean editarComercial(Comercial comercial);

	public boolean altaComercial(Comercial comercial);

	public Comercial[] cargarComerciales();

	//public Incidencia[] cargarIncidenciasComercial();

	public boolean crearCanal(Canal canal);

	public boolean editarCanal(Canal canal);

	//public boolean borrarCanal(Canal canal);

	public Movil[] cargarTarifasMovil();

	public Fijo[] cargarTarifasFijo();

	public Fibra[] cargarTarifasFibra();

	public Television[] cargarTarifasTelevision();

	public Canal[] cargarCanalesTv();
	
	public Canal[] cargarCanalesDisp();
	
	public boolean eliminarCanal (Canal canal);
	
	public Paquete [] cargarPaquetesTV ();

	public boolean crearPaquete(Paquete paquete);

	//public boolean editarPaquete(Paquete paquete, Paquete paqueteNuevo);

	public Canal[] cargarCanalesPaquete(Paquete paquete);

	public boolean anadirCanalesAPaquete(Paquete paquete, Canal[] canales);

	//public boolean eliminarCanalesPaquete(Canal[] canales);

	public boolean eliminarPaquete(Paquete paquete);

	public boolean eliminarTarifaMovil(int mesesAdaptacion, Movil movil);

	public boolean eliminarTarifaFijo(Fijo fijo, int mesesAdaptacion);

	public boolean eliminarTarifaFibra(Fibra fibra, int mesesAdaptacion);

	public boolean crearTarifaMovil(Movil movil);

	public boolean crearTarifaFijo(Fijo fijo);

	public boolean crearTarifaFibra(Fibra fibra);

	public boolean editarTarifaMovil(Movil movil);

	public boolean editarTarifaFijo(Fijo fijo);

	public boolean editarTarifaFibra(Fibra fibra);
	
	public int comprobarAdmin (String email, String contrasenia);
}