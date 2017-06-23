package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import DB.Movil;

public class BD_Moviles {
	public BD_Principal bD_Principal_moviles;
	public Movil[] movil = new Movil[0];
	Connection conexion;
    PreparedStatement ps;
    ResultSet rs;

	public Servicio[] cargarOfertas() {
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
				Movil movil = new Movil(rs.getInt(5), rs.getInt(6), rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getBoolean(4));
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

	public boolean eliminarTarifaMovil(Movil tarifa) {
		try {
			conexion = Conexion.getConnection();
			String consulta = "DELETE from movil " + "WHERE ServicioId=" + tarifa.getId();
			String consulta2 = "DELETE from servicio " + "WHERE id=" + tarifa.getId();

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
			String insertarServicio = "INSERT INTO servicio (Nombre, Precio, Estado) "
					+ "VALUES ('"+movil.getNombre()+"','"+movil.getPrecio()+"', "+movil.isEstado()+")";
			ps = conexion.prepareStatement(insertarServicio);
            ps.execute(insertarServicio);
			// obtendo el id de la persona que se ha creado para ponerlo como persona id para que sea corresponda con el cliente
			String consultaIdServicio = "SELECT id FROM servicio WHERE Nombre='" + movil.getNombre()+"'";
			ps = conexion.prepareStatement(consultaIdServicio);
			rs = ps.executeQuery();
			rs.first();
			int servicioId = rs.getInt(1);
			// creo la tarifa
			String insertarTarifa = "INSERT INTO movil (Minutos, Datos, ServicioId) "
					+ "VALUES ('"+movil.getMinutos()+"','"+movil.getDatos()+"', '"+servicioId+"')";
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
}