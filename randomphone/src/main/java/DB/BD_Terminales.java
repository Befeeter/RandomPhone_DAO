package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.Terminal;

public class BD_Terminales {
	public BD_Principal bD_Principal_terminales;
	public Terminal[] terminal = new Terminal[0];
	
	Connection conexion;
    PreparedStatement ps;
    ResultSet rs;
	
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
}