package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import DB.Incidencia;

public class BD_Incidencias {
	public BD_Principal bD_Principal_incidencias;
	public Incidencia[] incidencia = new Incidencia[0];
	
	Connection conexion;
	PreparedStatement ps;
	ResultSet rs;
	int sizerow;
	
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

	public boolean crearIncidencia(Incidencia incidencia) {
		return bD_Principal_incidencias.crearIncidencia(incidencia);
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

	public boolean asginarIncidencia(Incidencia incidencia, Comercial comercial) {
		return bD_Principal_incidencias.asignarIncidencia(incidencia, comercial);
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
				incidencia.setCliente(bD_Principal_incidencias.cargarDatosCliente(id_cliente));
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

	public boolean editarIncidencia(Incidencia incidencia) {
		return bD_Principal_incidencias.editarIncidencia(incidencia);
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
				incidencia.setCliente(bD_Principal_incidencias.cargarDatosCliente(rs.getInt(3)));
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

	public Incidencia[] cargarIncidenciasSinAsignarCibernauta() {
		return bD_Principal_incidencias.cargarIncidenciasSinAsignarCibernauta();
	}

	public Incidencia[] cargarIncidenciasSinAsignarClientes() {
		return bD_Principal_incidencias.cargarIncidenciasSinAsignarCLientes();
	}

	public Incidencia[] cargarIncidenciasCompletadas() {
		return bD_Principal_incidencias.cargarIncidenciasCompletadas();
	}

	public boolean eliminarIncidencias(Incidencia[] incidencias) {
		return bD_Principal_incidencias.eliminarIncidencias(incidencias);
	}
/*
	public Incidencia[] incidenciasActivasComercial(Comercial comercial) {
		return bD_Principal_incidencias.incidenciasas(comercial);
	}*/
	
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

	public Incidencia[] cargarIncidenciasCliente(int id_cliente) {
		return bD_Principal_incidencias.cargarIncidencias(id_cliente);
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
				incidencia.setCliente(bD_Principal_incidencias.cargarDatosCliente(rs.getInt(3)));
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
}