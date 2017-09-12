package db_old;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.Paquete;

public class BD_Paquetes {
	public BD_Principal bD_Principal_paquetes;
	public Paquete[] paquete = new Paquete[0];

	Connection conexion;
	PreparedStatement ps;
	ResultSet rs;
	int sizerow;

	public Servicio[] cargarOfertas() {
		return bD_Principal_paquetes.cargarOfertas();
	}

	public Paquete[] cargarPaquetesCliente(int idCliente) {
		ArrayList<Paquete> paquetesCliente = new ArrayList<>();
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT paquete.Nombre FROM paquete INNER JOIN television ON paquete.TelevisionServicioId=television.ServicioId INNER JOIN servicio ON television.ServicioId=servicio.Id INNER JOIN servicio_factura on servicio_factura.ServicioId=television.ServicioId INNER JOIN factura ON factura.Id=servicio_factura.FacturaId INNER JOIN cliente on cliente.PersonaId=factura.ClientePersonaId WHERE cliente.PersonaId="
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
	 * public void guardarPaquetePer(Canal[] canales) { throw new
	 * UnsupportedOperationException(); }
	 */

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

	public Paquete[] cargarPaquetes() {
		return bD_Principal_paquetes.cargarPaquetesTV();
	}

	public boolean crearPaquete(Paquete paquete) {
		return bD_Principal_paquetes.crearPaquete(paquete);
	}

	/*
	 * public boolean editarPaquete(Paquete paquete, Paquete paqueteNueva) {
	 * return bD_Principal_paquetes.editar; }
	 */
	/*
	 * public Canal[] cargarCanalesPaquete(Paquete paquete) {
	 * bD_Principal_paquetes.cargarCanalesPaquete(paquete); }
	 */
	public boolean anadirCanalesAPaquete(Paquete paquete, Canal[] canales) {
		return bD_Principal_paquetes.anadirCanalesAPaquete(paquete, canales);
	}

	/*
	 * public boolean eliminarCanalesPaquete(Canal[] canales) { return
	 * bD_Principal_paquetes.eliminar }
	 */
	public boolean eliminarPaquete(Paquete paquete) {
		return bD_Principal_paquetes.eliminarPaquete(paquete);
	}
}