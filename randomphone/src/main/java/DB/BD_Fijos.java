package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.Fijo;

public class BD_Fijos {
	public BD_Principal bD_Principal_fijos;
	public Fijo[] fijo = new Fijo[0];
	Connection conexion;
    PreparedStatement ps;
    ResultSet rs;

	public Servicio[] cargarOfertas() {
		throw new UnsupportedOperationException();
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
				Fijo Fijo = new Fijo(rs.getInt(5), rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getBoolean(4));
				tarifasFijo[i - 1] = Fijo;
				rs.next();
			}

		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
		}
		return tarifasFijo;
	}

	public boolean eliminarTarifaFijo(Fijo fijo) {
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
			String insertarTarifa = "INSERT INTO Fijo (Minutos, ServicioId) "
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

	public boolean editarTarifaFijo(Fijo fijo) {
		try {
			conexion = Conexion.getConnection();
			String modificarServicio = "UPDATE servicio "
					+ "SET Nombre='"+fijo.getNombre()+"', Precio="+fijo.getPrecio()+", Estado="+fijo.isEstado()+" "
							+ "WHERE id="+ fijo.getId();
			String modificarTarifa = "UPDATE fijo "
					+ "SET Minutos='"+fijo.getMinutos()+"'"
							+ "WHERE servicioid="+ fijo.getId();
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