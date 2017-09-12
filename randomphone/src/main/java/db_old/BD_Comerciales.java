package db_old;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.Comercial;

public class BD_Comerciales {
	public BD_Principal bD_Principal_comerciales;
	public Comercial[] comercial = new Comercial[0];
	
	Connection conexion;
    PreparedStatement ps;
    ResultSet rs;

	public Comercial[] cargarListaDeComerciales() {
		Comercial [] comerciales = null;
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * FROM persona INNER JOIN comercial "
					+ "ON persona.Id=comercial.PersonaId WHERE comercial.Estado=1";
			ps = conexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            rs.last();
            int sizerow = rs.getRow();
            comerciales = new Comercial [sizerow];
            rs.first();
            for (int i=0; i <sizerow; i++) {
        		Comercial comercial = new Comercial();
        		comercial.setId(rs.getInt(1));
            	comercial.setDocumento(rs.getString(2));
    			comercial.setNombre(rs.getString(3));
    			comercial.setApellidos(rs.getString(4));
    			comercial.setContrasena(rs.getString(5));
    			comercial.setEmail(rs.getString(6));
    			comercial.setFecha_alta(rs.getDate(7));
    			comercial.setEstado(true);
    			comercial.setFecha_baja(rs.getDate(9));
            	comerciales[i] = comercial;
            	rs.next();
            }
            ps.close();
            conexion.close();
        } catch (SQLException exception) {
        	System.out.println(exception.getMessage());
        }
        return comerciales;
	}

	public boolean eliminarComercial(Comercial comercial) {
		try {
			conexion = Conexion.getConnection();
			String consulta = "DELETE from comercial "
					+ "WHERE id="+ comercial.getId();
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

	public boolean editarComercial(Comercial comercial) {
		try {
			conexion = Conexion.getConnection();
			String modificarComercial = "UPDATE comercial "
					+ "SET Fecha_alta='"+comercial.getFecha_alta()+"', Estado="+comercial.isEstado()+", Fecha_baja="+comercial.getFecha_baja()+" "
							+ "WHERE personaId="+ comercial.getId();
			String modificarPersona = "UPDATE persona "
					+ "SET Documento='"+comercial.getDocumento()+"', Nombre='"+comercial.getNombre()+"', Apellidos='"+comercial.getApellidos()+"', Contrasena='"+comercial.getContrasena()+"', Email='"+comercial.getEmail()+ "' "
							+ "WHERE id="+ comercial.getId();
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
					+ "VALUES ('"+comercial.getDocumento()+"','"+comercial.getNombre()+"', '"+comercial.getApellidos()+"', '"+comercial.getContrasena()+"', '"+comercial.getEmail()+"')";
			//ps = conexion.prepareStatement(insertarPersona);
            //ps.execute(insertarPersona);
			// obtendo el id de la persona que se ha creado para ponerlo como persona id para que sea corresponda con el comercial
			String consultaIdPersona = "SELECT id FROM persona WHERE Documento='" + comercial.getDocumento()+"'";
			ps = conexion.prepareStatement(consultaIdPersona);
			rs = ps.executeQuery();
			rs.first();
			int personaId = rs.getInt(1);
			// creo el comercial
			String insertarCliente = "INSERT INTO comercial (Fecha_alta, Estado, Fecha_baja, PersonaId) "
					+ "VALUES ('"+comercial.getFecha_alta()+"',"+comercial.isEstado()+", "+comercial.getFecha_baja()+", "+personaId+")";
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
		Comercial [] comerciales = null;
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * FROM persona INNER JOIN comercial "
					+ "ON persona.Id=comercial.PersonaId WHERE comercial.Estado=1";
			ps = conexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            rs.last();
            int sizerow = rs.getRow();
            comerciales = new Comercial [sizerow];
            rs.first();
            for (int i=0; i <sizerow; i++) {
        		Comercial comercial = new Comercial();
        		comercial.setId(rs.getInt(1));
            	comercial.setDocumento(rs.getString(2));
    			comercial.setNombre(rs.getString(3));
    			comercial.setApellidos(rs.getString(4));
    			comercial.setContrasena(rs.getString(5));
    			comercial.setEmail(rs.getString(6));
    			comercial.setFecha_alta(rs.getDate(7));
    			comercial.setEstado(true);
    			comercial.setFecha_baja(rs.getDate(9));
            	comerciales[i] = comercial;
            	rs.next();
            }
            ps.close();
            conexion.close();
        } catch (SQLException exception) {
        	System.out.println(exception.getMessage());
        }
        return comerciales;
	}
}