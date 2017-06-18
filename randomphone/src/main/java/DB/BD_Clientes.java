package DB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.Cliente;

public class BD_Clientes {
	public BD_Principal bD_Principal_clientes;
	public Cliente[] cliente = new Cliente[0];
	
	Connection conexion;
    PreparedStatement ps;
    ResultSet rs;
    /*
    public static void main (String Args []) {
    	BD_Clientes cli = new BD_Clientes();
    	Cliente cliente = cli.cargarDatosCliente(1);
    	//cliente.setId(id);
    	//cli.crearCliente(cliente);
    	cliente.setApellidos("apellidoss");
    	cli.modificarDatosP(cliente);
    	cli.cargarListadoClientes();
    	for (Cliente clien : cli.cargarListadoClientes()) {
    		System.out.println(clien.getFecha_altta());
    	}
    }
     */
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

	public void modificarDatosP(Cliente cliente) {
		try {
			conexion = Conexion.getConnection();
			String modificarCliente = "UPDATE cliente "
					+ "SET Fecha_altta='"+cliente.getFecha_altta()+"', Estado="+cliente.isEstado()+", Telefono="+cliente.getTelefono()+" "
							+ "WHERE personaId="+ cliente.getId();
			String modificarPersona = "UPDATE persona "
					+ "SET Documento='"+cliente.getDocumento()+"', Nombre='"+cliente.getNombre()+"', Apellidos='"+cliente.getApellidos()+"', Contrasena='"+cliente.getContrasena()+"', Email='"+cliente.getEmail()+ "' "
							+ "WHERE id="+ cliente.getId();
			ps = conexion.prepareStatement(modificarCliente);
            ps.execute(modificarCliente);
            ps = conexion.prepareStatement(modificarPersona);
            ps.execute(modificarPersona);
			ps.close();
            conexion.close();
        } catch (SQLException exception) {
        	System.out.println(exception.getMessage());
        }
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

	public void modificarServiciosCliente(Cliente cliente) {
		throw new UnsupportedOperationException();
	}
}