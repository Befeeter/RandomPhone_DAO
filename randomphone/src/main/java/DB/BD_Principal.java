package DB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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

	Connection conexion;
	PreparedStatement ps;
	ResultSet rs;

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

		Factura[] facturas = null;
		int sizerow;
		Connection conexion;
		PreparedStatement ps;
		ResultSet rs;
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * FROM factura WHERE factura.ClientePersonaId='" + id_cliente + "'";
			ps = conexion.prepareStatement(consulta);
			rs = ps.executeQuery();
			rs.last();
			sizerow = rs.getRow();
			facturas = new Factura[sizerow];
			rs.first();
			for (int i = 1; i <= sizerow; i++) {
				// Creamos Tantas Facturas como resultados tiene la consulta
				Factura factura = new Factura(rs.getInt(1), rs.getDate(3), rs.getDate(4), rs.getFloat(5));
				facturas[i - 1] = factura;
				rs.next();
			}

		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
		}
		return facturas;
	}

	public Servicio[] cargarServiciosDisp() {
		throw new UnsupportedOperationException();
	}

	public int comprobarUsuario(String email, String contrasenia) {
		int idCliente = -1;
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
			idCliente = rs.getInt(1);
			if (contrasenia.equals(password))
				return idCliente;
			else
				return -1;

		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
		}
		return -1;
	}

	public int comprobarAdmin(String email, String contrasenia) {
		String password = "";
		int idAdmin = -1;
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * FROM persona INNER JOIN administrador ON persona.Id=administrador.PersonaId WHERE persona.Email='"
					+ email + "'";
			ps = conexion.prepareStatement(consulta);
			rs = ps.executeQuery();
			rs.first();
			password = rs.getString(5);
			idAdmin = rs.getInt(1);
			if (contrasenia.equals(password))
				return idAdmin;
			else
				return -1;

		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
		}
		return -1;
	}

	public boolean crearIncidencia(Incidencia incidencia) {
		Connection conexion;
		PreparedStatement ps;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();

		try {
			conexion = Conexion.getConnection();
			String consulta = "INSERT INTO `incidencia` (`Id`, `ComercialPersonaId`, `ClientePersonaId`, `Ausnto`, `Tipo`, `Telefono`, `Texto`, `Estado`, `fecha_alta`) VALUES (NULL, '"
					+ incidencia.comercial.getId() + "', '" + incidencia.getCliente().getId() + "', '"
					+ incidencia.getAsunto() + "', '" + incidencia.getTipo() + "', '" + incidencia.getCliente().getId()
					+ "', '" + incidencia.getTexto() + "', 'Nueva', '" + dateFormat.format(date) + "')";
			ps = conexion.prepareStatement(consulta);
			ps.executeUpdate();

		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
			return false;

		}
		return true;

	}

	public Servicio[] cargarOfertas(Servicio tipo) {
		throw new UnsupportedOperationException();
	}

	public void resetPass(String email) {
		throw new UnsupportedOperationException();
	}

	public Cliente cargarDatosCliente(String dni) {
		Cliente cliente = new Cliente();
		cliente.setDocumento(dni);
		Connection conexion;
		PreparedStatement ps;
		ResultSet rs;
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * FROM persona INNER JOIN cliente ON persona.Id=cliente.PersonaId INNER JOIN factura ON cliente.PersonaId=factura.ClientePersonaId INNER JOIN servicio_factura ON factura.Id=servicio_factura.FacturaId INNER JOIN servicio on servicio_factura.ServicioId=servicio.Id WHERE persona.Documento='"
					+ cliente.getDocumento() + "' AND cliente.Estado=1";
			ps = conexion.prepareStatement(consulta);
			rs = ps.executeQuery();
			rs.first();
			// Cargamos El cliente
			cliente.setId(rs.getInt(1));
			cliente.setDocumento(rs.getString(2));
			cliente.setNombre(rs.getString(3));
			cliente.setApellidos(rs.getString(4));
			cliente.setContrasena(rs.getString(5));
			cliente.setEmail(rs.getString(6));
			cliente.setFecha_altta(rs.getDate(7));
			cliente.setEstado(true);
			cliente.setTelefono(rs.getInt(9));

		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
			return null;
		}
		return cliente;

	}

	public Cliente cargarDatosCliente(int id) {
		Cliente cliente = new Cliente();
		cliente.setId(id);
		Connection conexion;
		PreparedStatement ps;
		ResultSet rs;
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * FROM persona INNER JOIN cliente ON persona.Id=cliente.PersonaId INNER JOIN factura ON cliente.PersonaId=factura.ClientePersonaId INNER JOIN servicio_factura ON factura.Id=servicio_factura.FacturaId INNER JOIN servicio on servicio_factura.ServicioId=servicio.Id WHERE persona.Id="
					+ cliente.getId() + " AND cliente.Estado=1";
			ps = conexion.prepareStatement(consulta);
			rs = ps.executeQuery();
			rs.first();
			// Cargamos El cliente
			cliente.setDocumento(rs.getString(2));
			cliente.setNombre(rs.getString(3));
			cliente.setApellidos(rs.getString(4));
			cliente.setContrasena(rs.getString(5));
			cliente.setEmail(rs.getString(6));
			cliente.setFecha_altta(rs.getDate(7));
			cliente.setEstado(true);
			cliente.setTelefono(rs.getInt(9));

		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
		}
		return cliente;
	}

	public boolean modificarDatosP(Cliente cliente) {
		Connection conexion;
		PreparedStatement ps;

		try {
			conexion = Conexion.getConnection();
			// Actualizamos Telefono.
			String consulta = "UPDATE `cliente` SET `Telefono` = '" + cliente.getTelefono()
					+ "' WHERE `cliente`.`PersonaId` ='" + cliente.getId() + "'";
			ps = conexion.prepareStatement(consulta);
			ps.executeUpdate();
			// Actualizamos Resto de datos
			consulta = "UPDATE `persona` SET `Apellidos` = '" + cliente.getApellidos() + "', `Nombre` = '"
					+ cliente.getNombre() + "', `Email` = '" + cliente.getEmail() + "', `Contrasena` = '"
					+ cliente.getContrasena() + "' WHERE `persona`.`Id` = '" + cliente.getId() + "'";
			ps = conexion.prepareStatement(consulta);
			ps.executeUpdate();

		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
			return false;
		}
		return true;
	}

	public Servicio[] cargarServiciosCliente(int id) {

		Servicio servicios[] = null;
		int sizerow = 0;
		Connection conexion;
		PreparedStatement ps;
		ResultSet rs;
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * FROM servicio INNER JOIN servicio_factura ON servicio.Id=servicio_factura.ServicioId INNER JOIN factura ON servicio_factura.FacturaId=factura.Id WHERE factura.ClientePersonaId='"
					+ id + "'";
			ps = conexion.prepareStatement(consulta);
			rs = ps.executeQuery();
			rs.last();
			sizerow = rs.getRow();
			servicios = new Servicio[sizerow];
			rs.first();
			for (int i = 1; i <= sizerow; i++) {
				// Creamos Tantos Canales como resultados tiene la consulta
				Servicio servicio = new Servicio(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getBoolean(4));
				servicios[i - 1] = servicio;
				rs.next();
			}
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
		}
		return servicios;
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
		Incidencia[] incidencias = null;
		int sizerow = 0;
		Connection conexion;
		PreparedStatement ps;
		ResultSet rs;
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * FROM incidencia where incidencia.ClientePersonaId='" + id_cliente + "'";
			ps = conexion.prepareStatement(consulta);
			rs = ps.executeQuery();
			rs.last();
			sizerow = rs.getRow();
			incidencias = new Incidencia[sizerow];
			rs.first();
			for (int i = 1; i <= sizerow; i++) {
				// Creamos Tantas incidencias como resultados tiene la consulta
				Incidencia incidencia = new Incidencia(rs.getInt(1), rs.getString(4), rs.getString(5), rs.getInt(6),
						rs.getString(7), rs.getString(8), rs.getString(9), rs.getDate(10));
				incidencias[i - 1] = incidencia;
				rs.next();
			}
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
		}
		return incidencias;
	}

	public Incidencia[] cargarIncidenciasCm(int id_comercial) {
		Incidencia[] incidencias = null;
		int sizerow = 0;
		Connection conexion;
		PreparedStatement ps;
		ResultSet rs;
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * FROM incidencia where incidencia.ComercialPersonaId='" + id_comercial + "'";
			ps = conexion.prepareStatement(consulta);
			rs = ps.executeQuery();
			rs.last();
			sizerow = rs.getRow();
			incidencias = new Incidencia[sizerow];
			rs.first();
			for (int i = 1; i <= sizerow; i++) {
				// Creamos Tantas incidencias como resultados tiene la consulta
				Incidencia incidencia = new Incidencia(rs.getInt(1), rs.getString(4), rs.getString(5), rs.getInt(6),
						rs.getString(7), rs.getString(8), rs.getString(9), rs.getDate(10));
				incidencias[i - 1] = incidencia;
				rs.next();
			}
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
		}
		return incidencias;
	}

	public boolean actualizarIncidencia(Incidencia incidencia) {
		Connection conexion;
		PreparedStatement ps;

		try {
			conexion = Conexion.getConnection();
			// Actualizamos Respuesta.
			String consulta = "UPDATE `incidencia` SET `Texto`= '" + incidencia.getTexto() + "' WHERE incidencia.id='"
					+ incidencia.getId() + "'";
			ps = conexion.prepareStatement(consulta);
			ps.executeUpdate();
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
			return false;
		}
		return true;
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

	public boolean responderIncidencia(Incidencia incidencia) {
		Connection conexion;
		PreparedStatement ps;

		try {
			conexion = Conexion.getConnection();
			// Actualizamos Respuesta.
			String consulta = "UPDATE `incidencia` SET `Respuesta`= '" + incidencia.getRespuesta()
					+ "' WHERE incidencia.id='" + incidencia.getId() + "'";
			ps = conexion.prepareStatement(consulta);
			ps.executeUpdate();
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
			return false;
		}
		return true;

	}

	public boolean crearIncidenciaCliente(Incidencia incidencia) {
		Connection conexion;
		PreparedStatement ps;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();

		try {
			conexion = Conexion.getConnection();
			String consulta = "INSERT INTO `incidencia` (`Id`, `ComercialPersonaId`, `ClientePersonaId`, `Ausnto`, `Tipo`, `Telefono`, `Texto`, `Estado`, `fecha_alta`) VALUES (NULL, '"
					+ incidencia.getComercial().getId() + "', '" + incidencia.getCliente().getId() + "', '"
					+ incidencia.getAsunto() + "', '" + incidencia.getTipo() + "', '" + incidencia.getCliente().getId()
					+ "', '" + incidencia.getTexto() + "', 'Nueva', '" + dateFormat.format(date) + "')";
			ps = conexion.prepareStatement(consulta);
			ps.executeUpdate();

		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
			return false;

		}
		return true;
	}

	public void añadirObservacion(Incidencia incidencia) {
		throw new UnsupportedOperationException();
	}

	public Cliente[] cargarListadoClientes() {
		Cliente[] clientes = null;
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * FROM persona INNER JOIN cliente "
					+ "ON persona.Id=cliente.PersonaId INNER JOIN factura ON cliente.PersonaId=factura.ClientePersonaId "
					+ "INNER JOIN servicio_factura ON factura.Id=servicio_factura.FacturaId "
					+ "INNER JOIN servicio on servicio_factura.ServicioId=servicio.Id AND cliente.Estado=1";
			ps = conexion.prepareStatement(consulta);
			rs = ps.executeQuery();
			rs.last();
			int sizerow = rs.getRow();
			clientes = new Cliente[sizerow];
			rs.first();
			for (int i = 0; i < sizerow; i++) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt(1));
				cliente.setDocumento(rs.getString(2));
				cliente.setNombre(rs.getString(3));
				cliente.setApellidos(rs.getString(4));
				cliente.setContrasena(rs.getString(5));
				cliente.setEmail(rs.getString(6));
				cliente.setFecha_altta(rs.getDate(7));
				cliente.setEstado(true);
				cliente.setTelefono(rs.getInt(9));
				clientes[i] = cliente;
				rs.next();
			}
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
		return clientes;
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

	public boolean editarIncidencia(Incidencia incidencia) {
		throw new UnsupportedOperationException();
	}

	public boolean editarEstadoIncidencia(Incidencia incidencia) {
		Connection conexion;
		PreparedStatement ps;

		try {
			conexion = Conexion.getConnection();
			// Actualizamos Respuesta.
			String consulta = "UPDATE `incidencia` SET `Estado`= '" + incidencia.getEstado() + "' WHERE incidencia.id='"
					+ incidencia.getId() + "'";
			ps = conexion.prepareStatement(consulta);
			ps.executeUpdate();
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
			return false;
		}
		return true;
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
		Connection conexion;
		PreparedStatement ps;

		try {
			conexion = Conexion.getConnection();
			// Actualizamos Telefono.
			for (int i = 0; i < incidencias.length; i++) {
				String consulta = "DELETE FROM `incidencia` WHERE `incidencia`.`Id` = '" + incidencias[i].getId() + "'";
				ps = conexion.prepareStatement(consulta);
				ps.executeUpdate();
				// Actualizamos Resto de datos
			}

		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
			return false;
		}
		return true;

	}

	public Incidencia[] incidenciasActivasComercial(Comercial comercial) {
		throw new UnsupportedOperationException();
	}

	public boolean eliminarComercial(Comercial comercial) {
		try {
			conexion = Conexion.getConnection();
			String consulta = "DELETE from comercial " + "WHERE id=" + comercial.getId();
			ps = conexion.prepareStatement(consulta);
			ps.execute(consulta);
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
			return false;
		}
		return true;
	}

	public boolean editarComercial(Comercial comercial, Comercial comercialMod) {
		try {
			conexion = Conexion.getConnection();
			String modificarComercial = "UPDATE comercial " + "SET Fecha_alta='" + comercial.getFecha_alta()
					+ "', Estado=" + comercial.isEstado() + ", Fecha_baja=" + comercial.getFecha_baja() + " "
					+ "WHERE personaId=" + comercial.getId();
			String modificarPersona = "UPDATE persona " + "SET Documento='" + comercial.getDocumento() + "', Nombre='"
					+ comercial.getNombre() + "', Apellidos='" + comercial.getApellidos() + "', Contrasena='"
					+ comercial.getContrasena() + "', Email='" + comercial.getEmail() + "' " + "WHERE id="
					+ comercial.getId();
			ps = conexion.prepareStatement(modificarComercial);
			ps.execute(modificarComercial);
			ps = conexion.prepareStatement(modificarPersona);
			ps.execute(modificarPersona);
			ps.close();
			conexion.close();
			return true;
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
			return false;
		}
	}

	public boolean altaComercial(Comercial comercial) {
		try {
			conexion = Conexion.getConnection();
			// creo la persona
			String insertarPersona = "INSERT INTO persona (Documento, Nombre, Apellidos, Contrasena, Email) "
					+ "VALUES ('" + comercial.getDocumento() + "','" + comercial.getNombre() + "', '"
					+ comercial.getApellidos() + "', '" + comercial.getContrasena() + "', '" + comercial.getEmail()
					+ "')";
			// ps = conexion.prepareStatement(insertarPersona);
			// ps.execute(insertarPersona);
			// obtendo el id de la persona que se ha creado para ponerlo como
			// persona id para que sea corresponda con el comercial
			String consultaIdPersona = "SELECT id FROM persona WHERE Documento='" + comercial.getDocumento() + "'";
			ps = conexion.prepareStatement(consultaIdPersona);
			rs = ps.executeQuery();
			rs.first();
			int personaId = rs.getInt(1);
			// creo el comercial
			String insertarCliente = "INSERT INTO comercial (Fecha_alta, Estado, Fecha_baja, PersonaId) " + "VALUES ('"
					+ comercial.getFecha_alta() + "'," + comercial.isEstado() + ", " + comercial.getFecha_baja() + ", "
					+ personaId + ")";
			ps = conexion.prepareStatement(insertarCliente);
			ps.execute(insertarCliente);
			ps.close();
			conexion.close();
			return true;
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
			return false;
		}
	}

	public Comercial[] cargarComerciales() {
		Connection conexion;
		PreparedStatement ps;
		ResultSet rs;
		Comercial[] comerciales = null;
		int sizerow = 0;
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * FROM persona INNER JOIN comercial on persona.Id=comercial.PersonaId WHERE comercial.Estado=1";
			ps = conexion.prepareStatement(consulta);
			rs = ps.executeQuery();
			rs.last();
			sizerow = rs.getRow();
			comerciales = new Comercial[sizerow];
			rs.first();
			for (int i = 1; i <= sizerow; i++) {
				Comercial comercial = new Comercial(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getDate(7), rs.getBoolean(9));
				comerciales[i - 1] = comercial;
				rs.next();
			}

		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}

		return comerciales;
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
		Movil[] tarifasMovil = null;
		int sizerow;
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * FROM servicio INNER JOIN movil ON servicio.id=movil.servicioid";
			ps = conexion.prepareStatement(consulta);
			rs = ps.executeQuery();
			rs.last();
			sizerow = rs.getRow();
			tarifasMovil = new Movil[sizerow];
			rs.first();
			for (int i = 1; i <= sizerow; i++) {
				// Creamos Tantas tarifas como resultados tiene la consulta
				Movil movil = new Movil(rs.getInt(5), rs.getInt(6), rs.getInt(1), rs.getString(2), rs.getFloat(3),
						rs.getBoolean(4));
				tarifasMovil[i - 1] = movil;
				rs.next();
			}

		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
		}
		return tarifasMovil;
	}

	public Fijo[] cargarTarifasFijo() {
		Fijo[] tarifasFijo = null;
		int sizerow;
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * FROM servicio INNER JOIN fijo ON servicio.id=fijo.servicioid";
			ps = conexion.prepareStatement(consulta);
			rs = ps.executeQuery();
			rs.last();
			sizerow = rs.getRow();
			tarifasFijo = new Fijo[sizerow];
			rs.first();
			for (int i = 1; i <= sizerow; i++) {
				// Creamos Tantas tarifas como resultados tiene la consulta
				Fijo fijo = new Fijo(rs.getInt(5), rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getBoolean(4));
				tarifasFijo[i - 1] = fijo;
				rs.next();
			}

		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
		}
		return tarifasFijo;
	}

	public Fibra[] cargarTarifasFibra() {
		Fibra[] tarifasFibra = null;
		int sizerow;
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * FROM servicio INNER JOIN fibra ON servicio.id=fibra.servicioid";
			ps = conexion.prepareStatement(consulta);
			rs = ps.executeQuery();
			rs.last();
			sizerow = rs.getRow();
			tarifasFibra = new Fibra[sizerow];
			rs.first();
			for (int i = 1; i <= sizerow; i++) {
				// Creamos Tantas tarifas como resultados tiene la consulta
				Fibra fibra = new Fibra(rs.getInt(5), rs.getInt(6), rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getBoolean(4));
				tarifasFibra[i - 1] = fibra;
				rs.next();
			}

		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
		}
		return tarifasFibra;
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
		try {
			conexion = Conexion.getConnection();
			String consulta = "DELETE from movil " + "WHERE ServicioId=" + movil.getId();
			String consulta2 = "DELETE from servicio " + "WHERE id=" + movil.getId();

			ps = conexion.prepareStatement(consulta);
			ps.execute(consulta);
			ps = conexion.prepareStatement(consulta2);
			ps.execute(consulta2);
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
			return false;
		}
		return true;
	}

	public boolean eliminarTarifaFijo(Fijo fijo, int mesesAdaptacion) {
		try {
			conexion = Conexion.getConnection();
			String consulta = "DELETE from Fijo " + "WHERE ServicioId=" + fijo.getId();
			String consulta2 = "DELETE from servicio " + "WHERE id=" + fijo.getId();

			ps = conexion.prepareStatement(consulta);
			ps.execute(consulta);
			ps = conexion.prepareStatement(consulta2);
			ps.execute(consulta2);
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
			return false;
		}
		return true;
	}

	public boolean eliminarTarifaFibra(Fibra fibra, int mesesAdaptacion) {
		try {
			conexion = Conexion.getConnection();
			String consulta = "DELETE from fibra " + "WHERE ServicioId=" + fibra.getId();
			String consulta2 = "DELETE from servicio " + "WHERE id=" + fibra.getId();

			ps = conexion.prepareStatement(consulta);
			ps.execute(consulta);
			ps = conexion.prepareStatement(consulta2);
			ps.execute(consulta2);
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
			return false;
		}
		return true;
	}

	public boolean crearTarifaMovil(Movil movil) {
		try {
			conexion = Conexion.getConnection();
			// creo el servicio
			String insertarServicio = "INSERT INTO servicio (Nombre, Precio, Estado) " + "VALUES ('" + movil.getNombre()
					+ "','" + movil.getPrecio() + "', " + movil.isEstado() + ")";
			ps = conexion.prepareStatement(insertarServicio);
			ps.execute(insertarServicio);
			// obtendo el id de la persona que se ha creado para ponerlo como
			// persona id para que sea corresponda con el cliente
			String consultaIdServicio = "SELECT id FROM servicio WHERE Nombre='" + movil.getNombre() + "'";
			ps = conexion.prepareStatement(consultaIdServicio);
			rs = ps.executeQuery();
			rs.first();
			int servicioId = rs.getInt(1);
			// creo la tarifa
			String insertarTarifa = "INSERT INTO movil (Minutos, Datos, ServicioId) " + "VALUES ('" + movil.getMinutos()
					+ "','" + movil.getDatos() + "', '" + servicioId + "')";
			ps = conexion.prepareStatement(insertarTarifa);
			ps.execute(insertarTarifa);
			ps.close();
			conexion.close();
			return true;
		} catch (SQLException exception) {
			System.out.println(exception.getMessage() + "fallo crear tarifa movil");
			return false;
		}
	}

	public boolean crearTarifaFijo(Fijo fijo) {
		try {
			conexion = Conexion.getConnection();
			// creo el servicio
			String insertarServicio = "INSERT INTO servicio (Nombre, Precio, Estado) "
					+ "VALUES ('"+fijo.getNombre()+"','"+fijo.getPrecio()+"', "+fijo.isEstado()+")";
			ps = conexion.prepareStatement(insertarServicio);
            ps.execute(insertarServicio);
			// obtendo el id del servicio
			String consultaIdServicio = "SELECT id FROM servicio WHERE Nombre='" + fijo.getNombre()+"'";
			ps = conexion.prepareStatement(consultaIdServicio);
			rs = ps.executeQuery();
			rs.first();
			int servicioId = rs.getInt(1);
			// creo la tarifa
			String insertarTarifa = "INSERT INTO fijo (Minutos, ServicioId) "
					+ "VALUES ('"+fijo.getMinutos()+"', '"+servicioId+"')";
            ps = conexion.prepareStatement(insertarTarifa);
            ps.execute(insertarTarifa);
			ps.close();
            conexion.close();
            return true;
        } catch (SQLException exception) {
        	System.out.println(exception.getMessage());
        	return false;
        }
	}

	public boolean crearTarifaFibra(Fibra fibra) {
		try {
			conexion = Conexion.getConnection();
			// creo el servicio
			String insertarServicio = "INSERT INTO servicio (Nombre, Precio, Estado) "
					+ "VALUES ('"+fibra.getNombre()+"','"+fibra.getPrecio()+"', '"+fibra.isEstado()+"')";
			ps = conexion.prepareStatement(insertarServicio);
            ps.execute(insertarServicio);
			// obtendo el id del servicio
			String consultaIdServicio = "SELECT id FROM servicio WHERE Nombre='" + fibra.getNombre()+"'";
			ps = conexion.prepareStatement(consultaIdServicio);
			rs = ps.executeQuery();
			rs.first();
			int servicioId = rs.getInt(1);
			// creo la tarifa
			String insertarTarifa = "INSERT INTO fibra (Vsub, Vbaj, ServicioId) "
					+ "VALUES ('"+fibra.getVsub()+"', '"+fibra.getVsub()+"', '"+servicioId+"')";
            ps = conexion.prepareStatement(insertarTarifa);
            ps.execute(insertarTarifa);
			ps.close();
            conexion.close();
            return true;
        } catch (SQLException exception) {
        	System.out.println(exception.getMessage());
        	return false;
        }
	}

	public boolean editarTarifaMovil(Movil movil, Movil movilNuevo) {
		try {
			conexion = Conexion.getConnection();
			String modificarServicio = "UPDATE servicio "
					+ "SET Nombre='"+movil.getNombre()+"', Precio="+movil.getPrecio()+", Estado="+movil.isEstado()+" "
							+ "WHERE id="+ movil.getId();
			String modificarTarifa = "UPDATE movil "
					+ "SET Minutos='"+movil.getMinutos()+"', Datos='"+movil.getDatos()+"' "
							+ "WHERE servicioid="+ movil.getId();
			ps = conexion.prepareStatement(modificarServicio);
            ps.execute(modificarServicio);
            ps = conexion.prepareStatement(modificarTarifa);
            ps.execute(modificarTarifa);
			ps.close();
            conexion.close();
            return true;
        } catch (SQLException exception) {
        	System.out.println(exception.getMessage());
        	return false;
        }
	}

	public boolean editarTarifaFijo(Fijo fijo, Fijo fijoNuevo) {
		try {
			conexion = Conexion.getConnection();
			String modificarServicio = "UPDATE servicio "
					+ "SET Nombre='"+fijo.getNombre()+"', Precio="+fijo.getPrecio()+", Estado="+fijo.isEstado()+" "
							+ "WHERE id="+ fijo.getId();
			String modificarTarifa = "UPDATE fijo "
					+ "SET Minutos='"+fijo.getMinutos()+"'"
							+ "WHERE servicioid="+ fijo.getId();
			System.out.println(fijo.getId());
			ps = conexion.prepareStatement(modificarServicio);
            ps.execute(modificarServicio);
            ps = conexion.prepareStatement(modificarTarifa);
            ps.execute(modificarTarifa);
			ps.close();
            conexion.close();
            return true;
        } catch (SQLException exception) {
        	System.out.println(exception.getMessage());
        	return false;
        }
	}

	public boolean editarTarifaFibra(Fibra fibra, Fibra fibraNuevo) {
		try {
			conexion = Conexion.getConnection();
			String modificarServicio = "UPDATE servicio "
					+ "SET Nombre='"+fibra.getNombre()+"', Precio="+fibra.getPrecio()+", Estado="+fibra.isEstado()+" "
							+ "WHERE personaId="+ fibra.getId();
			String modificarTarifa = "UPDATE fibra "
					+ "SET Vsub='"+fibra.getVsub()+"', Vbaj='"+fibra.getVbaj()+"' "
							+ "WHERE id="+ fibra.getId();
			ps = conexion.prepareStatement(modificarServicio);
            ps.execute(modificarServicio);
            ps = conexion.prepareStatement(modificarTarifa);
            ps.execute(modificarTarifa);
			ps.close();
            conexion.close();
            return true;
        } catch (SQLException exception) {
        	System.out.println(exception.getMessage());
        	return false;
        }
	}

}