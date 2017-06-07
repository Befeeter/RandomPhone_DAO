package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.Cliente;

public class BD_Clientes {
	public BD_Principal bD_Principal_clientes;
	public Cliente[] cliente = new Cliente[0];

	public Cliente[] cargarListadoClientes() {
		throw new UnsupportedOperationException();
	}

	public Cliente cargarDatosCliente(int id) {
		Cliente cliente = new Cliente();
		cliente.setId(id);
		Connection conexion;
		PreparedStatement ps;
		ResultSet rs;
		try {
			conexion = Conexion.getConnection();
			String consulta = "SELECT * FROM persona INNER JOIN cliente ON persona.Id=cliente.PersonaId INNER JOIN factura ON cliente.PersonaId=factura.ClientePersonaId INNER JOIN servicio_factura ON factura.Id=servicio_factura.FacturaId INNER JOIN servicio on servicio_factura.ServicioId=servicio.Id WHERE persona.Id="
					+ cliente.getId() + " AND cliente.Estado=1";
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
		throw new UnsupportedOperationException();
	}

	public void crearCliente(Cliente cliente) {
		throw new UnsupportedOperationException();
	}

	public Cliente cargarDatosCliente(String dni) {
		throw new UnsupportedOperationException();
	}

	public void modificarPaquetesCliente(Cliente cliente) {
		throw new UnsupportedOperationException();
	}

	public void modificarServiciosCliente(Cliente cliente) {
		throw new UnsupportedOperationException();
	}
}