package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.Television;

public class BD_Televisiones {
	public BD_Principal bD_Principal_televisiones;
	public Television[] television = new Television[0];
	Connection conexion;
	PreparedStatement ps;
	ResultSet rs;
	int sizerow;

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
}