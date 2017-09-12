package DB;

import java.io.Serializable;



import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import DB.Cliente;

public class BD_Clientes implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6214867971413961118L;
	public BD_Principal bD_Principal_clientes;
	public Cliente[] cliente = new Cliente[0];


	public int altaCliente(Cliente cliente) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			ClienteDAO.save(cliente);
			t.commit();
			return cliente.getORMID();
		} catch (PersistentException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			t.rollback();
		} catch (Exception e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return -1;
	}

	public int comprobarUsuario(String email, String contrasenia) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		Cliente cliente = null;
		Comercial comercial = null;
		Administrador[] administradores = AdministradorDAO.listAdministradorByQuery(null, null);
		Administrador admin = null;

		try {
			cliente = ClienteDAO.loadClienteByQuery("Estado=1 AND Email='" + email + "'", null);
			comercial = ComercialDAO.loadComercialByQuery("Email='" + email + "'", null);
			t.commit();
			for (Administrador administrador : administradores) {
				if (administrador.getEmail().equals(email)) {
					admin = administrador;
					break;
				}

			}

			if (cliente != null) {
				System.out.println(cliente.getID());
				if (contrasenia.equals(cliente.getContrasena()))
					return cliente.getORMID();
				else
					return -1;
			}

			if (comercial != null) {
				if (contrasenia.equals(comercial.getContrasena()))
					return comercial.getORMID();
				else
					return -1;
			}
			if (admin != null) {
				if (contrasenia.equals(admin.getContrasena()))
					return admin.getORMID();
				else
					return -1;
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			t.rollback();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ProyectoFinalPersistentManager.instance().getSession().close();
		}
		return -1;
	}

	public String comprobarUsuario(String email) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		String dni = null;
		Cliente cliente;

		try {
			cliente = ClienteDAO.loadClienteByQuery("Email='" + email + "' and Estado=1", null);
			dni = cliente.getDocumento();
			t.commit();
		} catch (PersistentException e) {
			t.rollback();
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return dni;
	}

	public Cliente[] cargarListadoClientes() throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			Cliente[] clientes = ClienteDAO.listClienteByQuery(null, null);
			t.commit();
			return clientes;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			t.rollback();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public Cliente cargarDatosCliente(int id) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			Cliente cliente = ClienteDAO.loadClienteByQuery("Id='" + id + "' AND Estado=1", null);
			t.commit();
			return cliente;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			t.rollback();
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public boolean modificarDatosP(Cliente cliente) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			PersonaDAO.save(cliente);
			ClienteDAO.save(cliente);			
			t.commit();
			return true;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			t.rollback();
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public void crearCliente(Cliente cliente) {

	}

	public Cliente cargarDatosCliente(String dni) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			Cliente cliente = ClienteDAO.loadClienteByQuery("Documento='" + dni + "' AND Estado=1", null);
			t.commit();
			return cliente;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			t.rollback();
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

}