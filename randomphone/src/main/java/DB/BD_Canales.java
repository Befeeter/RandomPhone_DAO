package DB;

import DB.Canal;

import java.awt.datatransfer.StringSelection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import com.vaadin.data.provider.Query;

public class BD_Canales {
	public BD_Principal bD_Principal_canales;
	public Canal[] canal = new Canal[0];
	int sizerow = 0;
	
	Connection conexion;
    PreparedStatement ps;
    ResultSet rs;  

	public Canal[] cargarCanales(int paqueteid) {
		Canal [] canales = null;
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * from canal INNER JOIN paquete_canal ON canal.id=paquete_canal.CanalId WHERE paquete_canal.PaqueteId="+paqueteid;
			ps = conexion.prepareStatement(consulta);
           // ps.setInt(1, paqueteid);
            rs = ps.executeQuery();
            rs.last();
            //Establecemos tamaño del Array de canales.
            sizerow = rs.getRow();
            canales = new Canal [sizerow];
            rs.first();
            for (int i=1; i <=sizerow; i++) {
            	//Creamos Tantos Canales como resultados tiene la consulta
            	Canal canal = new Canal (rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getDate(4), rs.getBoolean(5));
            	canales[i-1] = canal;
            	rs.next();
            }
            ps.close();
            conexion.close();
        } catch (SQLException exception) {
            //JOptionPane.showMessageDialog(null, "Impossivel registar armazém " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
        	System.out.println(exception.getMessage());
        }
        return canales;
	}
	
	public static void main (String Args []) {
		BD_Canales canales = new BD_Canales();
		Canal[] canalsefs = canales.cargarCanales(2);
		for (Canal canal : canalsefs) {
			System.out.print("Nombre: "+canal.getNombre().toString());
			System.out.println(" Precio: "+canal.getPrecio()+"€");
			
		}
	}

	public boolean crearCanal(Canal canal) {
		throw new UnsupportedOperationException();
	}

	public boolean EditarCanal(Canal canal, Canal canalNuevo) {
		throw new UnsupportedOperationException();
	}

	public boolean borrarCanal(Canal canal) {
		throw new UnsupportedOperationException();
	}

	public Canal[] cargarCanalesDisp() {
		throw new UnsupportedOperationException();
	}

	public Canal[] cargarCanales() {
		throw new UnsupportedOperationException();
	}
}