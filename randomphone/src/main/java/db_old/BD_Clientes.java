package db_old;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import DB.Cliente;

public class BD_Clientes {
	public BD_Principal bD_Principal_clientes;
	public Cliente[] cliente = new Cliente[0];
	
	Connection conexion;
    PreparedStatement ps;
    ResultSet rs;
    
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
    
	public Cliente[] cargarListadoClientes() {
		Cliente [] clientes = null;
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
            clientes = new Cliente [sizerow];
            rs.first();
            for (int i=0; i <sizerow; i++) {
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

	public Cliente cargarDatosCliente(int id) {
		Cliente cliente = new Cliente();
		cliente.setId(id);
		Connection conexion;
		PreparedStatement ps;
		ResultSet rs;
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * FROM persona "
					+ "INNER JOIN cliente ON persona.Id=cliente.PersonaId "
					+ "INNER JOIN factura ON cliente.PersonaId=factura.ClientePersonaId "
					+ "INNER JOIN servicio_factura ON factura.Id=servicio_factura.FacturaId "
					+ "INNER JOIN servicio on servicio_factura.ServicioId=servicio.Id "
					+ "WHERE persona.Id= "+ id + " AND cliente.Estado=1";
			ps = conexion.prepareStatement(consulta);
			rs = ps.executeQuery();
			rs.first();
			//Cargamos El cliente
			cliente.setDocumento(rs.getString(2));
			cliente.setNombre(rs.getString(3));
			cliente.setApellidos(rs.getString(4));
			cliente.setContrasena(rs.getString(5));
			cliente.setEmail(rs.getString(6));
			cliente.setFecha_altta(rs.getDate(7));
			cliente.setEstado(true);
			cliente.setTelefono(rs.getInt(9));
			
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
		}
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

	public void crearCliente(Cliente cliente) {
		try {
			conexion = Conexion.getConnection();
			// creo la persona
			String insertarPersona = "INSERT INTO persona (Documento, Nombre, Apellidos, Contrasena, Email) "
					+ "VALUES ('"+cliente.getDocumento()+"','"+cliente.getNombre()+"', '"+cliente.getApellidos()+"', '"+cliente.getContrasena()+"', '"+cliente.getEmail()+"')";
			ps = conexion.prepareStatement(insertarPersona);
            ps.execute(insertarPersona);
			// obtendo el id de la persona que se ha creado para ponerlo como persona id para que sea corresponda con el cliente
			String consultaIdPersona = "SELECT id FROM persona WHERE Documento='" + cliente.getDocumento()+"'";
			ps = conexion.prepareStatement(consultaIdPersona);
			rs = ps.executeQuery();
			rs.first();
			int personaId = rs.getInt(1);
			// creo el cliente
			String insertarCliente = "INSERT INTO cliente (Fecha_altta, Estado, Telefono, PersonaId) "
					+ "VALUES ('"+cliente.getFecha_altta()+"',"+cliente.isEstado()+", "+cliente.getTelefono()+", "+personaId+")";
            ps = conexion.prepareStatement(insertarCliente);
            ps.execute(insertarCliente);
			ps.close();
            conexion.close();
        } catch (SQLException exception) {
        	System.out.println(exception.getMessage());
        }
	}

	public Cliente cargarDatosCliente(String dni) {
		Cliente cliente = new Cliente();
		cliente.setDocumento(dni);
		Connection conexion;
		PreparedStatement ps;
		ResultSet rs;
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * FROM persona "
					+ "INNER JOIN cliente ON persona.Id=cliente.PersonaId "
					+ "INNER JOIN factura ON cliente.PersonaId=factura.ClientePersonaId "
					+ "INNER JOIN servicio_factura ON factura.Id=servicio_factura.FacturaId "
					+ "INNER JOIN servicio on servicio_factura.ServicioId=servicio.Id "
					+ "WHERE persona.Documento= '"+ dni + "' AND cliente.Estado=1";
			ps = conexion.prepareStatement(consulta);
			rs = ps.executeQuery();
			rs.first();
			//Cargamos El cliente
			cliente.setId(rs.getInt(1));
			cliente.setDocumento(rs.getString(2));
			cliente.setNombre(rs.getString(3));
			cliente.setApellidos(rs.getString(4));
			cliente.setContrasena(rs.getString(5));
			cliente.setEmail(rs.getString(6));
			cliente.setFecha_altta(rs.getDate(7));
			cliente.setEstado(true);
			cliente.setTelefono(rs.getInt(9));
			
		} catch (SQLException exception) {
			// JOptionPane.showMessageDialog(null, "Impossivel registar armazém
			// " + exception, "Armazém", JOptionPane.ERROR_MESSAGE);
			System.out.println(exception.getMessage());
		}
		return cliente;
	}

	public void modificarPaquetesCliente(Cliente cliente) {
		throw new UnsupportedOperationException();
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
}