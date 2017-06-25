package DB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
	int sizerow;

	public Servicio[] cargarOfertas() {
		ArrayList<Servicio> serviciosDisp = new ArrayList<>();
		Servicio[] tMovil = cargarTarifasMovil();
		Servicio[] tFijo = cargarTarifasFijo();
		Servicio[] tFibra = cargarTarifasFibra();
		Servicio[] tTv = cargarTarifasTelevision();

		for (Servicio movil : tMovil)
			if (movil.isEstado())
				serviciosDisp.add(movil);

		for (Servicio fijo : tFijo)
			if (fijo.isEstado())
				serviciosDisp.add(fijo);

		for (Servicio fibra : tFibra)
			if (fibra.isEstado())
				serviciosDisp.add(fibra);

		for (Servicio tv : tTv)
			if (tv.isEstado())
				serviciosDisp.add(tv);

		return serviciosDisp.toArray(new Servicio[serviciosDisp.size()]);
	}

	public boolean altaTerminal(Terminal[] terminales, int facturaId) {
		try {
			conexion = Conexion.getConnection();
			for (int i = 0; i < terminales.length; i++) {
				String consulta = "INSERT INTO `terminal` (`Id`, `FacturaId`, `Tipo`, `Estado`) VALUES (NULL, '"
						+ facturaId + "', '" + terminales[i].getTipo() + "', " + terminales[i].isEstado() + ")";
				ps = conexion.prepareStatement(consulta);
				ps.executeUpdate();
			}
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
			return false;
		}
		return true;
	}

	public boolean modificarServicios(Servicio[] servicios, int idFactura) {

		try {
			conexion = Conexion.getConnection();
			String consulta = "DELETE FROM servicio_factura WHERE servicio_factura.FacturaId='" + idFactura + "'";
			ps = conexion.prepareStatement(consulta);
			ps.executeUpdate();
			for (int i = 0; i < servicios.length; i++) {
				consulta = "INSERT INTO `servicio_factura` (`ServicioId`, `FacturaId`) VALUES ('" + servicios[i].getId()
						+ "', '" + idFactura + "')";
				ps = conexion.prepareStatement(consulta);
				ps.executeUpdate();
			}
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
			return false;
		}
		return true;
	}

	public Factura[] cargarFacturas(int id_cliente) {

		Factura[] facturas = null;
		int sizerow;
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
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
		return facturas;
	}

	public int comprobarUsuario(String email, String contrasenia) {
		int idCliente = -1;
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
			ps.close();
			conexion.close();
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
			ps.close();
			conexion.close();
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

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		if (incidencia.getCliente() == null) {
			incidencia.setCliente(new Cliente());
		}
		if (incidencia.getComercial() == null)
			incidencia.setComercial(new Comercial());

		try {
			conexion = Conexion.getConnection();
			String consulta = "INSERT INTO `incidencia` (`Id`, `ComercialPersonaId`, `ClientePersonaId`, `Ausnto`, `Tipo`, `Telefono`, `Texto`, `Respuesta`, `Estado`, `fecha_alta`, `cliente`, `observaciones`) VALUES (NULL, '"
					+ incidencia.getComercial().getId() + "', '" + incidencia.getCliente().getId() + "', '"
					+ incidencia.getAsunto() + "', '" + incidencia.getTipo() + "', '" + incidencia.getTelefono()
					+ "', '" + incidencia.getTexto() + "', '" + incidencia.getRespuesta() + "', '"
					+ incidencia.getEstado() + "', '" + dateFormat.format(date) + "', " + incidencia.isCliente() + ", '"
					+ incidencia.getObservaciones() + "');";
			ps = conexion.prepareStatement(consulta);
			ps.executeUpdate();
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
			return false;

		}
		return true;

	}

	public Servicio[] cargarOfertas(Servicio tipo) {
		ArrayList<Servicio> serviciosDisp = new ArrayList<>();
		Servicio[] servicios;
		if (tipo.getClass() == (new Movil().getClass())) {
			servicios = cargarTarifasMovil();
			for (Servicio movil : servicios)
				if (movil.isEstado())
					serviciosDisp.add(movil);
			return serviciosDisp.toArray(new Servicio[serviciosDisp.size()]);
		}
		if (tipo.getClass() == (new Fibra().getClass())) {
			servicios = cargarTarifasFibra();
			for (Servicio fibra : servicios)
				if (fibra.isEstado())
					serviciosDisp.add(fibra);
			return serviciosDisp.toArray(new Servicio[serviciosDisp.size()]);
		}
		if (tipo.getClass() == (new Fijo().getClass())) {
			servicios = cargarTarifasFijo();
			for (Servicio fijo : servicios)
				if (fijo.isEstado())
					serviciosDisp.add(fijo);
			return serviciosDisp.toArray(new Servicio[serviciosDisp.size()]);
		}
		if (tipo.getClass() == (new Television()).getClass()) {
			servicios = cargarTarifasTelevision();
			for (Servicio tv : servicios)
				if (tv.isEstado())
					serviciosDisp.add(tv);
			return serviciosDisp.toArray(new Servicio[serviciosDisp.size()]);
		}
		return null;
	}

	public Cliente cargarDatosCliente(String dni) {
		Cliente cliente = new Cliente();
		cliente.setDocumento(dni);
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
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
			return null;
		}
		// Cargamos Facturas del cliente
		cliente.setFactura(cargarFacturas(cliente.getId()));
		// Cargamos Incidencias del cliente
		// cliente.setIncidencia(cargarIncidencias(cliente.getId()));
		return cliente;

	}

	public Cliente cargarDatosCliente(int id) {
		Cliente cliente = new Cliente();
		cliente.setId(id);
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
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
		}
		// Cargamos Facturas del cliente
		cliente.setFactura(cargarFacturas(id));
		// Cargamos Incidencias del cliente
		// cliente.setIncidencia(cargarIncidencias(id));
		return cliente;
	}

	public boolean modificarDatosP(Cliente cliente) {

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
			ps.close();
			conexion.close();
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
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
		}
		return servicios;
	}

	public Paquete[] cargarPaquetesTV() {
		Paquete[] paquetes = null;
		int sizerow;
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * FROM paquete";
			ps = conexion.prepareStatement(consulta);
			rs = ps.executeQuery();
			rs.last();
			sizerow = rs.getRow();
			paquetes = new Paquete[sizerow];
			rs.first();
			for (int i = 1; i <= sizerow; i++) {
				// Creamos Tantas tarifas como resultados tiene la consulta
				Paquete paquete = new Paquete(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getFloat(4),
						rs.getDate(5), rs.getBoolean(6));
				paquetes[i - 1] = paquete;
				rs.next();
			}
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
		}
		return paquetes;
	}

	public Canal[] cargarCanalesDisp() {
		Canal[] canales = null;
		int sizerow;
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * FROM canal WHERE estado=1";
			ps = conexion.prepareStatement(consulta);
			rs = ps.executeQuery();
			rs.last();
			sizerow = rs.getRow();
			canales = new Canal[sizerow];
			rs.first();
			for (int i = 1; i <= sizerow; i++) {
				// Creamos Tantas tarifas como resultados tiene la consulta
				Canal canal = new Canal(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getDate(4), rs.getBoolean(5));
				canales[i - 1] = canal;
				rs.next();
			}
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
		}
		return canales;
	}

	public Incidencia[] cargarIncidencias(int id_cliente) {
		Incidencia[] incidencias = null;
		int sizerow = 0;
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
						rs.getString(7), rs.getString(8), rs.getString(9), rs.getDate(10), rs.getBoolean(11),
						rs.getString(12));
				incidencias[i - 1] = incidencia;
				rs.next();
				incidencia.setCliente(cargarDatosCliente(id_cliente));
			}
			ps.close();
			conexion.close();
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
						rs.getString(7), rs.getString(8), rs.getString(9), rs.getDate(10), rs.getBoolean(11),
						rs.getString(12));
				incidencias[i - 1] = incidencia;
				incidencia.setCliente(cargarDatosCliente(rs.getInt(3)));
				rs.next();
			}
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
		}
		return incidencias;
	}

	public boolean actualizarIncidencia(Incidencia incidencia) {

		try {
			conexion = Conexion.getConnection();
			// Actualizamos Respuesta.
			String consulta = "UPDATE `incidencia` SET `Texto`= '" + incidencia.getTexto() + "' WHERE incidencia.id='"
					+ incidencia.getId() + "'";
			ps = conexion.prepareStatement(consulta);
			ps.executeUpdate();
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
			return false;
		}
		return true;
	}

	public int crearFacturaServicios(Cliente cliente, Servicio[] serviciosContratados, int total) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		int facturaId = -1;
		try {
			conexion = Conexion.getConnection();
			// creo la persona
			String insertarFactura = "INSERT INTO `factura` (`Id`, `ClientePersonaId`, `Fecha_ini`, `Fecha_fin`, `Total`) VALUES (NULL, '"
					+ cliente.getId() + "', '" + dateFormat.format(date) + "', '2017-07-20', '" + total + "')";
			ps = conexion.prepareStatement(insertarFactura);
			ps.execute(insertarFactura);
			// obtendo el id de la persona que se ha creado para ponerlo como
			// persona id para que sea corresponda con el cliente
			String consultaIdFactura = "SELECT id FROM factura WHERE factura.ClientePersonaId='" + cliente.getId()
					+ "'";
			ps = conexion.prepareStatement(consultaIdFactura);
			rs = ps.executeQuery();
			rs.first();
			facturaId = rs.getInt(1);
			// anado los servicios del cliente.
			for (int i = 0; i < serviciosContratados.length; i++) {
				String consulta = "INSERT INTO `servicio_factura` (`ServicioId`, `FacturaId`) VALUES ('"
						+ serviciosContratados[i].getId() + "', '" + facturaId + "')";
				ps = conexion.prepareStatement(consulta);
				ps.executeUpdate();
			}
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
			return -1;
		}
		return facturaId;
	}

	public int altaCliente(Cliente cliente) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		int personaId = -1;
		try {
			conexion = Conexion.getConnection();
			// creo la persona
			String insertarPersona = "INSERT INTO persona (Documento, Nombre, Apellidos, Contrasena, Email) "
					+ "VALUES ('" + cliente.getDocumento() + "','" + cliente.getNombre() + "', '"
					+ cliente.getApellidos() + "', '" + cliente.getContrasena() + "', '" + cliente.getEmail() + "')";
			ps = conexion.prepareStatement(insertarPersona);
			ps.execute(insertarPersona);
			// obtendo el id de la persona que se ha creado para ponerlo como
			// persona id para que sea corresponda con el cliente
			String consultaIdPersona = "SELECT id FROM persona WHERE Documento='" + cliente.getDocumento() + "'";
			ps = conexion.prepareStatement(consultaIdPersona);
			rs = ps.executeQuery();
			rs.first();
			personaId = rs.getInt(1);
			// creo el cliente
			String insertarCliente = "INSERT INTO cliente (Fecha_altta, Estado, Telefono, PersonaId) " + "VALUES ('"
					+ dateFormat.format(cliente.getFecha_altta()) + "'," + cliente.isEstado() + ", "
					+ cliente.getTelefono() + ", " + personaId + ")";
			ps = conexion.prepareStatement(insertarCliente);
			ps.execute(insertarCliente);
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
			return -1;
		}
		return personaId;
	}

	public DB.Paquete[] cargarPaquetesDisp() {
		ArrayList<Paquete> paquetesDisp = new ArrayList<>();
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * FROM paquete WHERE paquete.Estado=1";
			ps = conexion.prepareStatement(consulta);
			rs = ps.executeQuery();
			rs.last();
			sizerow = rs.getRow();
			rs.first();
			for (int i = 1; i <= sizerow; i++) {
				// Creamos Tantos Paquetes como resultados tiene la consulta
				Paquete paquete = new Paquete(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getFloat(4),
						rs.getDate(5), rs.getBoolean(6));
				paquetesDisp.add(paquete);
				rs.next();
			}
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
		}
		return (Paquete[]) paquetesDisp.toArray();
	}

	public boolean responderIncidencia(Incidencia incidencia) {

		try {
			conexion = Conexion.getConnection();
			// Actualizamos Respuesta.
			String consulta = "UPDATE `incidencia` SET `Respuesta`= '" + incidencia.getRespuesta()
					+ "' WHERE incidencia.id='" + incidencia.getId() + "'";
			ps = conexion.prepareStatement(consulta);
			ps.executeUpdate();
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
			return false;
		}
		return true;

	}

	public boolean crearIncidenciaCliente(Incidencia incidencia) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();

		try {
			conexion = Conexion.getConnection();
			String consulta = "INSERT INTO `incidencia` (`Id`, `ComercialPersonaId`, `ClientePersonaId`, `Ausnto`, `Tipo`, `Telefono`, `Texto`, `Respuesta`, `Estado`, `fecha_alta`, `cliente`, `observaciones`) VALUES (NULL, '"
					+ incidencia.getComercial().getId() + "', '" + incidencia.getCliente().getId() + "', '"
					+ incidencia.getAsunto() + "', '" + incidencia.getTipo() + "', '" + incidencia.getCliente().getId()
					+ "', '" + incidencia.getTexto() + "', '" + incidencia.getRespuesta() + "', 'Asignada', '"
					+ dateFormat.format(date) + "' " + ", " + incidencia.isCliente() + ", '"
					+ incidencia.getObservaciones() + "')";
			ps = conexion.prepareStatement(consulta);
			ps.executeUpdate();
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
			return false;

		}
		return true;
	}

	public boolean anadirObservacion(Incidencia incidencia) {
		try {
			conexion = Conexion.getConnection();
			// Actualizamos Respuesta.
			String consulta = "UPDATE `incidencia` SET `observaciones`= '" + incidencia.getObservaciones()
					+ "' WHERE incidencia.id='" + incidencia.getId() + "'";
			ps = conexion.prepareStatement(consulta);
			ps.executeUpdate();
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
			return false;

		}
		return true;
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

	public boolean asignarIncidencia(Incidencia incidencia, Comercial comercial) {
		try {
			conexion = Conexion.getConnection();
			// Actualizamos
			String consulta = "UPDATE `incidencia` SET `Estado`='Asignada', `ComercialPersonaId`='" + comercial.getId()
					+ "'" + " WHERE `Incidencia`.`Id`='" + incidencia.getId() + "'";
			ps = conexion.prepareStatement(consulta);
			ps.executeUpdate();
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
			System.out.println("holaaaaaaaaaaaaaa");
			return false;
		}
		return true;
	}

	public boolean editarIncidencia(Incidencia incidencia) {
		try {
			conexion = Conexion.getConnection();
			// Actualizamos
			String consulta = "UPDATE `incidencia` SET `Ausnto`='" + incidencia.getAsunto() + "', `Tipo`='"
					+ incidencia.getTipo() + "', `Telefono`='" + incidencia.getTelefono() + "', `Texto`='"
					+ incidencia.getTexto() + "', `Estado`='" + incidencia.getEstado() + "', `fecha_alta`='"
					+ incidencia.getFecha_alta() + "', `Cliente`=" + incidencia.isCliente() + ", `Observaciones`='"
					+ incidencia.getObservaciones() + "' " + "WHERE `Incidencia`.`Id`='" + incidencia.getId() + "'";
			ps = conexion.prepareStatement(consulta);
			ps.executeUpdate();
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
			System.out.println("holaaaaaaaaaaaaaa");
			return false;
		}
		return true;
	}

	public boolean editarEstadoIncidencia(Incidencia incidencia) {

		try {
			conexion = Conexion.getConnection();
			// Actualizamos Respuesta.
			String consulta = "UPDATE `incidencia` SET `Estado`= '" + incidencia.getEstado() + "' WHERE incidencia.id='"
					+ incidencia.getId() + "'";
			ps = conexion.prepareStatement(consulta);
			ps.executeUpdate();
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
			return false;
		}
		return true;
	}

	public Incidencia[] cargarIncidenciasSinAsignarCibernauta() {
		Incidencia[] incidencias = null;
		int sizerow = 0;
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * FROM incidencia where estado='SinAsignar' AND cliente='0'";
			ps = conexion.prepareStatement(consulta);
			rs = ps.executeQuery();
			rs.last();
			sizerow = rs.getRow();
			incidencias = new Incidencia[sizerow];
			rs.first();
			for (int i = 1; i <= sizerow; i++) {
				// Creamos Tantas incidencias como resultados tiene la consulta
				Incidencia incidencia = new Incidencia(rs.getInt(1), rs.getString(4), rs.getString(5), rs.getInt(6),
						rs.getString(7), rs.getString(8), rs.getString(9), rs.getDate(10), rs.getBoolean(11),
						rs.getString(12));
				incidencias[i - 1] = incidencia;
				incidencia.setCliente(cargarDatosCliente(rs.getInt(3)));
				Comercial comercial = new Comercial();
				comercial.setId(rs.getInt(2));
				incidencia.setComercial(comercial);
				rs.next();
			}
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
		}
		return incidencias;
	}

	public Incidencia[] cargarIncidenciasSinAsignarCLientes() {
		Incidencia[] incidencias = null;
		int sizerow = 0;
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * FROM incidencia where estado='SinAsignar'  AND cliente='1'";
			ps = conexion.prepareStatement(consulta);
			rs = ps.executeQuery();
			rs.last();
			sizerow = rs.getRow();
			incidencias = new Incidencia[sizerow];
			rs.first();
			for (int i = 1; i <= sizerow; i++) {
				// Creamos Tantas incidencias como resultados tiene la consulta
				Incidencia incidencia = new Incidencia(rs.getInt(1), rs.getString(4), rs.getString(5), rs.getInt(6),
						rs.getString(7), rs.getString(8), rs.getString(9), rs.getDate(10), rs.getBoolean(11),
						rs.getString(12));
				incidencias[i - 1] = incidencia;
				incidencia.setCliente(cargarDatosCliente(rs.getInt(3)));
				Comercial comercial = new Comercial();
				comercial.setId(rs.getInt(2));
				incidencia.setComercial(comercial);
				rs.next();
			}
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
		}
		return incidencias;
	}

	public Incidencia[] cargarIncidenciasAsignadas() {
		Incidencia[] incidencias = null;
		int sizerow = 0;
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * FROM incidencia where estado='Asignada'";
			ps = conexion.prepareStatement(consulta);
			rs = ps.executeQuery();
			rs.last();
			sizerow = rs.getRow();
			incidencias = new Incidencia[sizerow];
			rs.first();
			for (int i = 1; i <= sizerow; i++) {
				// Creamos Tantas incidencias como resultados tiene la consulta
				Incidencia incidencia = new Incidencia(rs.getInt(1), rs.getString(4), rs.getString(5), rs.getInt(6),
						rs.getString(7), rs.getString(8), rs.getString(9), rs.getDate(10), rs.getBoolean(11),
						rs.getString(12));
				incidencias[i - 1] = incidencia;
				incidencia.setCliente(cargarDatosCliente(rs.getInt(3)));
				Comercial comercial = new Comercial();
				comercial.setId(rs.getInt(2));
				incidencia.setComercial(comercial);
				rs.next();
			}
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
		}
		return incidencias;
	}

	public Incidencia[] cargarIncidenciasCompletadas() {
		Incidencia[] incidencias = null;
		int sizerow = 0;
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * FROM incidencia where estado='Completada'";
			ps = conexion.prepareStatement(consulta);
			rs = ps.executeQuery();
			rs.last();
			sizerow = rs.getRow();
			incidencias = new Incidencia[sizerow];
			rs.first();
			for (int i = 1; i <= sizerow; i++) {
				// Creamos Tantas incidencias como resultados tiene la consulta
				Incidencia incidencia = new Incidencia(rs.getInt(1), rs.getString(4), rs.getString(5), rs.getInt(6),
						rs.getString(7), rs.getString(8), rs.getString(9), rs.getDate(10), rs.getBoolean(11),
						rs.getString(12));
				incidencias[i - 1] = incidencia;
				incidencia.setCliente(cargarDatosCliente(rs.getInt(3)));
				Comercial comercial = new Comercial();
				comercial.setId(rs.getInt(2));
				incidencia.setComercial(comercial);
				rs.next();
			}
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
		}
		return incidencias;
	}

	public boolean eliminarIncidencias(Incidencia[] incidencias) {

		try {
			conexion = Conexion.getConnection();
			// Actualizamos Telefono.
			for (int i = 0; i < incidencias.length; i++) {
				String consulta = "DELETE FROM `incidencia` WHERE `incidencia`.`Id` = '" + incidencias[i].getId() + "'";
				ps = conexion.prepareStatement(consulta);
				ps.executeUpdate();
				// Actualizamos Resto de datos
			}
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
			return false;
		}
		return true;

	}

	public boolean eliminarComercial(Comercial comercial) {
		try {
			conexion = Conexion.getConnection();
			String consulta = "DELETE from comercial " + "WHERE personaid=" + comercial.getId();
			String consulta2 = "DELETE from persona " + "WHERE id=" + comercial.getId();
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

	public boolean editarComercial(Comercial comercial) {
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
			ps = conexion.prepareStatement(insertarPersona);
			ps.execute(insertarPersona);
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
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}

		return comerciales;
	}

	public boolean crearCanal(Canal canal) {
		try {
			conexion = Conexion.getConnection();
			// creo el canal
			String insertar = "INSERT INTO `canal` (`Id`, `Nombre`, `Precio`, `Fecha_alta`, `Estado`) "
					+ "VALUES (NULL, '"+canal.getNombre()+"', '"+canal.getPrecio()+"', '"+canal.getFecha_alta()+"', "+canal.isEstado()+")";
			ps = conexion.prepareStatement(insertar);
			ps.execute(insertar);
			ps.close();
			conexion.close();
			return true;
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
			return false;
		}
	}

	public boolean editarCanal(Canal canal) {
		try {
			conexion = Conexion.getConnection();
			String editarCanal = "UPDATE `canal` "
					+ "SET `Nombre` = '"+canal.getNombre()+"', `Precio` = '"+canal.getPrecio()+"', `"
							+ "Fecha_alta` = '"+canal.getFecha_alta()+"', `Estado` = "+canal.isEstado()+""
									+ " WHERE `canal`.`Id` = " + canal.getId();
			ps = conexion.prepareStatement(editarCanal);
			ps.execute(editarCanal);
			ps.close();
			conexion.close();
			return true;
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
			return false;
		}
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
			ps.close();
			conexion.close();
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
			ps.close();
			conexion.close();
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
				Fibra fibra = new Fibra(rs.getInt(5), rs.getInt(6), rs.getInt(1), rs.getString(2), rs.getFloat(3),
						rs.getBoolean(4));
				tarifasFibra[i - 1] = fibra;
				rs.next();
			}
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
		}
		return tarifasFibra;
	}

	public Television[] cargarTarifasTelevision() {
		ArrayList<Television> serviciosTv = new ArrayList<>();

		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * FROM television INNER JOIN servicio ON television.ServicioId=servicio.Id WHERE servicio.Estado=1";
			ps = conexion.prepareStatement(consulta);
			rs = ps.executeQuery();
			rs.last();
			sizerow = rs.getRow();
			rs.first();
			for (int i = 1; i <= sizerow; i++) {
				// Creamos Tantas tarifas como resultados tiene la consulta
				Television sTV = new Television(rs.getInt("ServicioId"), rs.getString("Nombre"), rs.getFloat("Precio"),
						rs.getBoolean("Estado"));
				serviciosTv.add(sTV);
				rs.next();
			}
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
		Television[] serviciosDisp = serviciosTv.toArray(new Television[serviciosTv.size()]);
		return serviciosDisp;
	}

	public Canal[] cargarCanalesTv() {
		Canal[] canales = null;
		int sizerow;
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * FROM canal";
			ps = conexion.prepareStatement(consulta);
			rs = ps.executeQuery();
			rs.last();
			sizerow = rs.getRow();
			canales = new Canal[sizerow];
			rs.first();
			for (int i = 1; i <= sizerow; i++) {
				// Creamos Tantas tarifas como resultados tiene la consulta
				Canal canal = new Canal(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getDate(4), rs.getBoolean(5));
				canales[i - 1] = canal;
				rs.next();
			}
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
		}
		return canales;
	}

	public boolean crearPaquete(DB.Paquete paquete) {
		try {
			conexion = Conexion.getConnection();
			// creo el paquete
			String insertar = "INSERT INTO `paquete` (`Id`, `TelevisionServicioId`, `Nombre`, `Precio`, `Fecha_alta`, `Estado`) "
					+ "VALUES (NULL, '"+paquete.getTelevision().getId()+"', '"+paquete.getNombre()+"', '"+paquete.getPrecio()+"', '"+paquete.getFecha_alta()+"', "+paquete.isEstado()+")";
			ps = conexion.prepareStatement(insertar);
			ps.execute(insertar);
			ps.close();
			conexion.close();
			return true;
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
			return false;
		}
	}
/*
	public Canal[] cargarCanalesPaquete(DB.Paquete paquete) {
		Canal[] canales = null;
		int sizerow;
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * FROM canal inner join paquete_canal on canal.id=paquete_canal.canalid inner join paquete on paquete.id=paquete_canal.paqueteid WHERE paquete.id=" + paquete.getId();
			ps = conexion.prepareStatement(consulta);
			rs = ps.executeQuery();
			rs.last();
			sizerow = rs.getRow();
			canales = new Canal[sizerow];
			rs.first();
			for (int i = 1; i <= sizerow; i++) {
				// Creamos Tantas tarifas como resultados tiene la consulta
				Canal canal = new Canal(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getDate(4), rs.getBoolean(5));
				canales[i - 1] = canal;
				rs.next();
			}
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
		}
		return canales;
	}
*/
	public boolean anadirCanalesAPaquete(DB.Paquete paquete, Canal[] canales) {
		try {
			conexion = Conexion.getConnection();
			String buscarPaquete = "SELECT * from paquete WHERE nombre='" +paquete.getNombre()+"'";
			ps = conexion.prepareStatement(buscarPaquete);
			rs = ps.executeQuery();
			rs.first();
			int paqueteId = rs.getInt(1);
			for (Canal canal : canales) {
				//
				String anadirCanal = "INSERT INTO paquete_canal (PaqueteId, CanalId) " + "VALUES ('"+paqueteId
						+ "', '" + canal.getId() + "')";
				ps = conexion.prepareStatement(anadirCanal);
				ps.execute(anadirCanal);
			}
			ps.close();
			conexion.close();
			return true;
		} catch (SQLException exception) {
			System.out.println(exception.getMessage() + "Fallo anadir canales");
			return false;
		}
	}

	public boolean eliminarCanal(Canal canal) {
		try {
			conexion = Conexion.getConnection();
			String consulta = "DELETE from canal WHERE id=" + canal.getId();

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

	public boolean eliminarPaquete(DB.Paquete paquete) {
		try {
			conexion = Conexion.getConnection();
			String consulta = "DELETE from paquete_canal WHERE paqueteid=" + paquete.getId();
			String consulta2 = "DELETE from paquete WHERE id=" + paquete.getId();
			
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
			String insertarServicio = "INSERT INTO servicio (Nombre, Precio, Estado) " + "VALUES ('" + "Movil "
					+ movil.getNombre() + "','" + movil.getPrecio() + "', " + movil.isEstado() + ")";
			ps = conexion.prepareStatement(insertarServicio);
			ps.execute(insertarServicio);
			// obtengo id servicio
			String consultaIdServicio = "SELECT id FROM servicio WHERE Nombre='Movil " + movil.getNombre() + "'";
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
			String insertarServicio = "INSERT INTO servicio (Nombre, Precio, Estado) " + "VALUES ('" + "Fijo "
					+ fijo.getNombre() + "','" + fijo.getPrecio() + "', " + fijo.isEstado() + ")";
			ps = conexion.prepareStatement(insertarServicio);
			ps.execute(insertarServicio);
			// obtendo el id del servicio
			String consultaIdServicio = "SELECT id FROM servicio WHERE Nombre='Fijo " + fijo.getNombre() + "'";
			ps = conexion.prepareStatement(consultaIdServicio);
			rs = ps.executeQuery();
			rs.first();
			int servicioId = rs.getInt(1);
			// creo la tarifa
			String insertarTarifa = "INSERT INTO fijo (Minutos, ServicioId) " + "VALUES ('" + fijo.getMinutos() + "', '"
					+ servicioId + "')";
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
			String insertarServicio = "INSERT INTO servicio (Nombre, Precio, Estado) " + "VALUES ('" + "Fibra "
					+ fibra.getNombre() + "','" + fibra.getPrecio() + "', " + fibra.isEstado() + ")";
			ps = conexion.prepareStatement(insertarServicio);
			ps.execute(insertarServicio);
			// obtendo el id del servicio
			String consultaIdServicio = "SELECT id FROM servicio WHERE Nombre='Fibra " + fibra.getNombre() + "'";
			ps = conexion.prepareStatement(consultaIdServicio);
			rs = ps.executeQuery();
			rs.first();
			int servicioId = rs.getInt(1);
			// creo la tarifa
			String insertarTarifa = "INSERT INTO fibra (Vsub, Vbaj, ServicioId) " + "VALUES ('" + fibra.getVsub()
					+ "', '" + fibra.getVsub() + "', '" + servicioId + "')";
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

	public boolean editarTarifaMovil(Movil movil) {
		try {
			conexion = Conexion.getConnection();
			String modificarServicio = "UPDATE servicio " + "SET Nombre='" + movil.getNombre() + "', Precio="
					+ movil.getPrecio() + ", Estado=" + movil.isEstado() + " " + "WHERE id=" + movil.getId();
			String modificarTarifa = "UPDATE movil " + "SET Minutos='" + movil.getMinutos() + "', Datos='"
					+ movil.getDatos() + "' " + "WHERE servicioid=" + movil.getId();
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

	public boolean editarTarifaFijo(Fijo fijo) {
		try {
			conexion = Conexion.getConnection();
			String modificarServicio = "UPDATE servicio " + "SET Nombre='" + fijo.getNombre() + "', Precio="
					+ fijo.getPrecio() + ", Estado=" + fijo.isEstado() + " " + "WHERE id=" + fijo.getId();
			String modificarTarifa = "UPDATE fijo " + "SET Minutos='" + fijo.getMinutos() + "'" + "WHERE servicioid="
					+ fijo.getId();
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

	public boolean editarTarifaFibra(Fibra fibra) {
		try {
			conexion = Conexion.getConnection();
			String modificarServicio = "UPDATE servicio " + "SET Nombre='" + fibra.getNombre() + "', Precio="
					+ fibra.getPrecio() + ", Estado=" + fibra.isEstado() + " " + "WHERE id=" + fibra.getId();
			String modificarTarifa = "UPDATE fibra " + "SET Vsub='" + fibra.getVsub() + "', Vbaj='" + fibra.getVbaj()
					+ "' " + "WHERE servicioid=" + fibra.getId();
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
	
	public String comprobarUsuario (String email){
		String dni = null;
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * FROM cliente INNER JOIN persona ON cliente.PersonaId=cliente.PersonaId WHERE persona.Email='"+email+"' and cliente.Estado=1";
			ps = conexion.prepareStatement(consulta);
			rs = ps.executeQuery(consulta);
			rs.first();
			dni = rs.getString("Documento");
			if (dni != null)
				return dni;
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
			return dni;
		}
		return dni;
	}
	
	public Paquete[] cargarPaquetesCliente(int idCliente) {
		ArrayList<Paquete> paquetesCliente = new ArrayList<>();
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT paquete.Nombre FROM paquete INNER JOIN television ON paquete.TelevisionServicioId=television.ServicioId INNER JOIN servicio ON television.ServicioId=servicio.Id INNER JOIN cliente WHERE cliente.PersonaId="
					+ idCliente;
			ps = conexion.prepareStatement(consulta);
			rs = ps.executeQuery();
			rs.last();
			sizerow = rs.getRow();
			rs.first();
			for (int i = 1; i <= sizerow; i++) {
				// Creamos Tantas paquetes como resultados tiene la consulta
				paquetesCliente.add(new Paquete(rs.getString("Nombre")));
				rs.next();
			}
			ps.close();
			conexion.close();
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
			return null;
		}
		return paquetesCliente.toArray(new Paquete[paquetesCliente.size()]);

	}

	/*
	@Override
	public Comercial[] cargarListaDeComerciales() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Incidencia cargarIncidencia(Incidencia incidencia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Incidencia[] incidenciasActivasComercial(Comercial comercial) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Incidencia[] cargarIncidenciasComercial() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean borrarCanal(Canal canal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editarPaquete(Paquete paquete, Paquete paqueteNuevo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarCanalesPaquete(Canal[] canales) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Servicio[] cargarServiciosDisp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente selecionarCliente(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarServiciosCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPaqueteCliente(Cliente cliente, Paquete paquete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarPaqueteCliente(Cliente cliente, Paquete paquete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Paquete[] cargarPaquetes(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cargarPaquetePersonal(Paquete paquete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCanalPaquete(Canal[] canales) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCanalPaquete(Canal[] canales) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetPass(String email) {
		// TODO Auto-generated method stub
		
	}
	 */
}
