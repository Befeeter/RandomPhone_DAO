package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
/*
	public Paquete[] cargarPaquetes(int id) {
		return bD_Principal_paquetes.cargarPaquetesTV();
	}
*/
	/*
	public void guardarPaquetePer(Canal[] canales) {
		throw new UnsupportedOperationException();
	}*/

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
	public boolean editarPaquete(Paquete paquete, Paquete paqueteNueva) {
		return bD_Principal_paquetes.editar;
	}
*/
	/*
	public Canal[] cargarCanalesPaquete(Paquete paquete) {
		bD_Principal_paquetes.cargarCanalesPaquete(paquete);
	}
*/
	public boolean anadirCanalesAPaquete(Paquete paquete, Canal[] canales) {
		return bD_Principal_paquetes.anadirCanalesAPaquete(paquete, canales);
	}
/*
	public boolean eliminarCanalesPaquete(Canal[] canales) {
		return bD_Principal_paquetes.eliminar
	}
*/
	public boolean eliminarPaquete(Paquete paquete) {
		return bD_Principal_paquetes.eliminarPaquete(paquete);
	}
}