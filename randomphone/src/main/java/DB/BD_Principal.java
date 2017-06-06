package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// import BD.Cliente.Paquete;
// import DB.Cliente.Paquete;

public class BD_Principal implements iInternauta, iCliente, iComercial, iAdministrador {
	public BD_Paquetes bD_Paquetes;
	public BD_Canales bD_Canales;
	public BD_fibras bD_fibras;
	public BD_Fijos bD_Fijos;
	public BD_Moviles bD_Moviles;
	public BD_Televisiones bD_Televisiones;
	public BD_Clientes bD_Clientes;
	public BD_Terminales bD_Terminales;
	public BD_Comerciales bD_Comerciales;
	public BD_Incidencias bD_Incidencias;
	public BD_Administradores bD_Administradores;

	public Servicio[] cargarOfertas() {
		throw new UnsupportedOperationException();
	}

	public Servicio[] cargarServiciosCliente() {
		throw new UnsupportedOperationException();
	}

	public void modificarServicios(Servicio[] parameter) {
		throw new UnsupportedOperationException();
	}

	public Factura[] cargarFacturas(int id_cliente) {
		throw new UnsupportedOperationException();
	}

	public Servicio[] cargarServiciosDisp() {
		throw new UnsupportedOperationException();
	}

	public boolean comprobarUsuario(String email, String contrasenia) {
		Connection conexion;
		PreparedStatement ps;
		ResultSet rs;
		String password = "";
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * FROM persona INNER JOIN cliente ON persona.Id=cliente.PersonaId WHERE cliente.Estado=1 AND persona.Email='"
					+ email + "'";
			ps = conexion.prepareStatement(consulta);
			rs = ps.executeQuery();
			rs.first();
			password = rs.getString(5);
			if (contrasenia.equals(password))
				return true;
			else
				return false;

		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
		}
		return false;
	}

	public void crearIncidencia(Incidencia incidencia) {
		throw new UnsupportedOperationException();
	}

	public Servicio[] cargarOfertas(Servicio tipo) {
		throw new UnsupportedOperationException();
	}

	public void resetPass(String email) {
		throw new UnsupportedOperationException();
	}

	public Cliente cargarDatosCliente(int id) {
		throw new UnsupportedOperationException();
	}

	public void modificarDatosP(Cliente cliente) {
		throw new UnsupportedOperationException();
	}

	public Servicio[] cargarServiciosCliente(int id) {
		throw new UnsupportedOperationException();
	}

	public DB.Paquete[] cargarPaquetes(int id) {
		throw new UnsupportedOperationException();
	}

	public void cargarPaquetePersonal(DB.Paquete paquete) {
		throw new UnsupportedOperationException();
	}

	public Canal[] cargarCanalesDisp() {
		throw new UnsupportedOperationException();
	}

	public void addCanalPaquete(Canal[] canales) {
		throw new UnsupportedOperationException();
	}

	public void deleteCanalPaquete(Canal[] canales) {
		throw new UnsupportedOperationException();
	}

	public Incidencia[] cargarIncidencias(int id_cliente) {
		throw new UnsupportedOperationException();
	}

	public void actualizarIncidencia(Incidencia incidencia) {
		throw new UnsupportedOperationException();
	}

	public void altaCliente(Cliente cliente) {
		throw new UnsupportedOperationException();
	}

	public Cliente selecionarCliente(String dni) {
		throw new UnsupportedOperationException();
	}

	public void modificarServiciosCliente(Cliente cliente) {
		throw new UnsupportedOperationException();
	}

	public DB.Paquete[] cargarPaquetesDisp() {
		throw new UnsupportedOperationException();
	}

	public void addPaqueteCliente(Cliente cliente, Paquete paquete) {
		throw new UnsupportedOperationException();
	}

	public void eliminarPaqueteCliente(Cliente cliente, Paquete paquete) {
		throw new UnsupportedOperationException();
	}

	public void responderIncidencia(Incidencia incidencia) {
		throw new UnsupportedOperationException();
	}

	public void crearIncidenciaCliente(Incidencia incidencia) {
		throw new UnsupportedOperationException();
	}

	public void añadirObservacion(Incidencia incidencia) {
		throw new UnsupportedOperationException();
	}

	public Cliente[] cargarListadoClientes() {
		throw new UnsupportedOperationException();
	}

	public Comercial[] cargarListaDeComerciales() {
		throw new UnsupportedOperationException();
	}

	public boolean asignarIncidencia(Incidencia incidencia, Comercial comercial) {
		throw new UnsupportedOperationException();
	}

	public Incidencia cargarIncidencia(Incidencia incidencia) {
		throw new UnsupportedOperationException();
	}

	public boolean editarIncidencia(Incidencia incidencia, Incidencia nuevaIncidencia) {
		throw new UnsupportedOperationException();
	}

	public Incidencia[] cargarIncidenciasSinAsignarCibernauta() {
		throw new UnsupportedOperationException();
	}

	public Incidencia[] cargarIncidenciasSinAsignarCLientes() {
		throw new UnsupportedOperationException();
	}

	public Incidencia[] cargarIncidenciasCompletadas() {
		throw new UnsupportedOperationException();
	}

	public boolean eliminarIncidencias(Incidencia[] incidencias) {
		throw new UnsupportedOperationException();
	}

	public Incidencia[] incidenciasActivasComercial(Comercial comercial) {
		throw new UnsupportedOperationException();
	}

	public boolean eliminarComercial(Comercial comercial) {
		throw new UnsupportedOperationException();
	}

	public boolean editarComercial(Comercial comercial, Comercial comercialMod) {
		throw new UnsupportedOperationException();
	}

	public boolean altaComercial(Comercial comercial) {
		throw new UnsupportedOperationException();
	}

	public Comercial[] cargarComerciales() {
		throw new UnsupportedOperationException();
	}

	public Incidencia[] cargarIncidenciasComercial() {
		throw new UnsupportedOperationException();
	}

	public boolean crearCanal(Canal canal) {
		throw new UnsupportedOperationException();
	}

	public boolean editarCanal(Canal canal, Canal canalNuevo) {
		throw new UnsupportedOperationException();
	}

	public boolean borrarCanal(Canal canal) {
		throw new UnsupportedOperationException();
	}

	public Movil[] cargarTarifasMovil() {
		throw new UnsupportedOperationException();
	}

	public Fijo[] cargarTarifasFijo() {
		throw new UnsupportedOperationException();
	}

	public Fibra[] cargarTarifasFibra() {
		throw new UnsupportedOperationException();
	}

	public DB.Paquete[] cargarPaquetesTv() {
		throw new UnsupportedOperationException();
	}

	public Canal[] cargarCanalesTv() {
		throw new UnsupportedOperationException();
	}

	public boolean crearPaquete(DB.Paquete paquete) {
		throw new UnsupportedOperationException();
	}

	public boolean editarPaquete(DB.Paquete paquete, DB.Paquete paqueteNuevo) {
		throw new UnsupportedOperationException();
	}

	public Canal[] cargarCanalesPaquete(DB.Paquete paquete) {
		throw new UnsupportedOperationException();
	}

	public boolean añadirCanalesAPaquete(DB.Paquete paquete, Canal[] canales) {
		throw new UnsupportedOperationException();
	}

	public boolean eliminarCanalesPaquete(Canal[] canales) {
		throw new UnsupportedOperationException();
	}

	public boolean eliminarPaquete(DB.Paquete paquete) {
		throw new UnsupportedOperationException();
	}

	public boolean eliminarTarifaMovil(int mesesAdaptacion, Movil movil) {
		throw new UnsupportedOperationException();
	}

	public boolean eliminarTarifaFijo(Fijo fijo, int mesesAdaptacion) {
		throw new UnsupportedOperationException();
	}

	public boolean eliminarTarifaFibra(Fibra fibra, int mesesAdaptacion) {
		throw new UnsupportedOperationException();
	}

	public boolean crearTarifaMovil(Movil movil) {
		throw new UnsupportedOperationException();
	}

	public boolean crearTarifaFijo(Fijo fijo) {
		throw new UnsupportedOperationException();
	}

	public boolean crearTarifaFibra(Fibra fibra) {
		throw new UnsupportedOperationException();
	}

	public boolean editarTarifaMovil(Movil movil, Movil movilNuevo) {
		throw new UnsupportedOperationException();
	}

	public boolean editarTarifaFijo(Fijo fijo, Fijo fijoNuevo) {
		throw new UnsupportedOperationException();
	}

	public boolean editarTarifaFibra(Fibra fibra, Fibra fibraNuevo) {
		throw new UnsupportedOperationException();
	}
}