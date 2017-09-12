package DB;

import java.io.Serializable;
import java.util.ArrayList;
import org.orm.PersistentException;



public class BD_Principal implements iInternauta, iCliente, iComercial, iAdministrador, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 273674673655872937L;
	BD_Canales canal = new BD_Canales();
	BD_Clientes cliente = new BD_Clientes();
	BD_Comerciales comercial = new BD_Comerciales();
	BD_fibras fibra = new BD_fibras();
	BD_Fijos fijo = new BD_Fijos();
	BD_Incidencias incidencia = new BD_Incidencias();
	BD_Moviles movil = new BD_Moviles();
	BD_Paquetes paquete = new BD_Paquetes();
	BD_Televisiones television = new BD_Televisiones();
	BD_Terminales terminal = new BD_Terminales();

	public Servicio[] cargarOfertas() {
		ArrayList<Servicio> serviciosDisp = new ArrayList<>();
		Servicio[] tMovil = cargarTarifasMovil();
		Servicio[] tFijo = cargarTarifasFijo();
		Servicio[] tFibra = cargarTarifasFibra();
		Servicio[] tTv = cargarTarifasTelevision();

		for (Servicio movil : tMovil)
			if (movil.getEstado())
				serviciosDisp.add(movil);

		for (Servicio fijo : tFijo)
			if (fijo.getEstado())
				serviciosDisp.add(fijo);

		for (Servicio fibra : tFibra)
			if (fibra.getEstado())
				serviciosDisp.add(fibra);

		for (Servicio tv : tTv)
			if (tv.getEstado())
				serviciosDisp.add(tv);

		return serviciosDisp.toArray(new Servicio[serviciosDisp.size()]);
	}

	public boolean altaTerminal(Terminal[] terminales, int facturaId) {
		try {
			return this.terminal.altaTerminal(terminales, facturaId);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean modificarTerminal(Terminal[] terminales, int facturaId) {
		try {
			return this.terminal.modificarTerminal(terminales, facturaId);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean modificarServicios(Servicio[] servicios, int idFactura) {
		int total = 0;
		try {
			ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
			Factura factura = FacturaDAO.getFacturaByORMID(idFactura);
			factura.servicio.clear();
			System.out.println("Limpio los servicios anteriores");
			for (Servicio servicio : servicios) {
				factura.servicio.add(servicio);
				total += servicio.getPrecio();
				System.out.println("añado el servicio: " + servicio.getNombre());
			}
			factura.setTotal(total);
			FacturaDAO.save(factura);
			ClienteDAO.save(factura.getCliente());
			ProyectoFinalPersistentManager.instance().getSession().getTransaction().commit();
			return true;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				ProyectoFinalPersistentManager.instance().getSession().getTransaction().rollback();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public Factura[] cargarFacturas(int id_cliente) {

		try {
			ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
			Factura[] facturas = FacturaDAO.listFacturaByQuery("ClientePersonaId='" + id_cliente + "'", null);
			ProyectoFinalPersistentManager.instance().getSession().getTransaction().commit();
			return facturas;			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				ProyectoFinalPersistentManager.instance().getSession().getTransaction().rollback();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public int comprobarUsuario(String email, String contrasenia){
		try {
			return this.cliente.comprobarUsuario(email, contrasenia);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public int comprobarAdmin(String email, String contrasenia) {

		Administrador administrador;

		try {
			ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
			administrador = AdministradorDAO.loadAdministradorByQuery("Email='" + email + "'", null);
			ProyectoFinalPersistentManager.instance().getSession().getTransaction().commit();
			if (contrasenia.equals(administrador.getContrasena()))
				return administrador.getORMID();
			else
				return -1;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				ProyectoFinalPersistentManager.instance().getSession().getTransaction().rollback();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public boolean crearIncidencia(Incidencia incidencia) {

		try {
			return this.incidencia.crearIncidencia(incidencia);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public Servicio[] cargarOfertas(Servicio tipo) {
		ArrayList<Servicio> serviciosDisp = new ArrayList<>();
		Servicio[] servicios;
		if (tipo.getClass() == (new Movil().getClass())) {
			servicios = cargarTarifasMovil();
			for (Servicio movil : servicios)
				if (movil.getEstado())
					serviciosDisp.add(movil);
			return serviciosDisp.toArray(new Servicio[serviciosDisp.size()]);
		}
		if (tipo.getClass() == (new Fibra().getClass())) {
			servicios = cargarTarifasFibra();
			for (Servicio fibra : servicios)
				if (fibra.getEstado())
					serviciosDisp.add(fibra);
			return serviciosDisp.toArray(new Servicio[serviciosDisp.size()]);
		}
		if (tipo.getClass() == (new Fijo().getClass())) {
			servicios = cargarTarifasFijo();
			for (Servicio fijo : servicios)
				if (fijo.getEstado())
					serviciosDisp.add(fijo);
			return serviciosDisp.toArray(new Servicio[serviciosDisp.size()]);
		}
		if (tipo.getClass() == (new Television()).getClass()) {
			servicios = cargarTarifasTelevision();
			for (Servicio tv : servicios)
				if (tv.getEstado())
					serviciosDisp.add(tv);
			return serviciosDisp.toArray(new Servicio[serviciosDisp.size()]);
		}
		return null;
	}

	public Cliente cargarDatosCliente(String dni) {
		try {
			return this.cliente.cargarDatosCliente(dni);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Cliente cargarDatosCliente(int id) {
		try {
			return this.cliente.cargarDatosCliente(id);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean modificarDatosP(Cliente cliente) {
		try {
			return this.cliente.modificarDatosP(cliente);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Servicio[] cargarServiciosCliente(int id) {

		try {
			ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
			Factura[] facturas = FacturaDAO.listFacturaByQuery("ClientePersonaId=" + id, null);
			ProyectoFinalPersistentManager.instance().getSession().getTransaction().commit();
			return facturas[0].servicio.toArray();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				ProyectoFinalPersistentManager.instance().getSession().getTransaction().rollback();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public Paquete[] cargarPaquetesTV() {
		return this.paquete.cargarPaquetesTV();
	}

	public Canal[] cargarCanalesDisp() {
		try {
			return canal.cargarCanalesDisp();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Incidencia[] cargarIncidencias(int id_cliente) {
		try {
			return this.incidencia.cargarIncidencias(id_cliente);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Incidencia[] cargarIncidenciasCm(int id_comercial) {
		try {
			return this.incidencia.cargarIncidenciasCm(id_comercial);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean actualizarIncidencia(Incidencia incidencia) {
		try {
			return this.incidencia.actualizarIncidencia(incidencia);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public int crearFacturaServicios(Cliente cliente, Servicio[] serviciosContratados, int total) {		
		java.util.Date date = new java.util.Date();
		Factura factura = new Factura();
		factura.setFecha_ini(date);
		factura.setTotal(total);
		for (Servicio servicio : serviciosContratados)
			factura.servicio.add(servicio);
		try {
			ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
			cliente.factura.add(factura);
			ClienteDAO.save(cliente);
			ProyectoFinalPersistentManager.instance().getSession().getTransaction().commit();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				ProyectoFinalPersistentManager.instance().getSession().getTransaction().rollback();
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return cliente.factura.toArray()[0].getID();
	}

	public int altaCliente(Cliente cliente) {
		try {
			return this.cliente.altaCliente(cliente);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public Paquete[] cargarPaquetesDisp() {
		return this.paquete.cargarPaquetesDisp();
	}

	public boolean responderIncidencia(Incidencia incidencia) {
		try {
			return this.incidencia.responderIncidencia(incidencia);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean crearIncidenciaCliente(Incidencia incidencia) {
		try {
			return this.incidencia.crearIncidenciaCliente(incidencia);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean anadirObservacion(Incidencia incidencia) {
		try {
			return this.incidencia.anadirObservacion(incidencia);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Cliente[] cargarListadoClientes() {
		try {
			return this.cliente.cargarListadoClientes();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean asignarIncidencia(Incidencia incidencia, Comercial comercial) {
		try {
			return this.incidencia.asginarIncidencia(incidencia, comercial);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean editarIncidencia(Incidencia incidencia) {
		try {
			return this.incidencia.editarIncidencia(incidencia);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean editarEstadoIncidencia(Incidencia incidencia) {
		try {
			return this.incidencia.editarEstadoIncidencia(incidencia);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Incidencia[] cargarIncidenciasSinAsignarCibernauta() {
		try {
			return this.incidencia.cargarIncidenciasSinAsignarCibernauta();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Incidencia[] cargarIncidenciasSinAsignarCLientes() {
		try {
			return this.incidencia.cargarIncidenciasSinAsignarClientes();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Incidencia[] cargarIncidenciasAsignadas() {
		try {
			return this.incidencia.cargarIncidenciasAsignadas();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Incidencia[] cargarIncidenciasCompletadas() {
		try {
			return this.incidencia.cargarIncidenciasCompletadas();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean eliminarIncidencias(Incidencia[] incidencias) {
		try {
			return this.incidencia.eliminarIncidencias(incidencias);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean eliminarComercial(Comercial comercial) {
		try {
			return this.comercial.eliminarComercial(comercial);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean editarComercial(Comercial comercial) {
		try {
			return this.comercial.editarComercial(comercial);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean altaComercial(Comercial comercial) {
		try {
			return this.comercial.altaComercial(comercial);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Comercial[] cargarComerciales() {
		try {
			return this.comercial.cargarComerciales();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean crearCanal(Canal canal) {
		try {
			return this.canal.crearCanal(canal);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean editarCanal(Canal canal) {
		try {
			return this.canal.EditarCanal(canal);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Movil[] cargarTarifasMovil() {
		try {
			return this.movil.cargarTarifasMovil();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Fijo[] cargarTarifasFijo() {
		try {
			return this.fijo.cargarTarifasFijo();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Fibra[] cargarTarifasFibra() {
		try {
			return this.fibra.cargarTarifasFibra();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Television[] cargarTarifasTelevision() {
		try {
			return this.television.cargarTarifasTelevision();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Canal[] cargarCanalesTv() {
		try {
			return this.canal.cargarCanalesTv();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean crearPaquete(DB.Paquete paquete) {
		return this.paquete.crearPaquete(paquete);
	}

	public Canal[] cargarCanalesPaquete(DB.Paquete paquete) {
		try {
			return this.canal.cargarCanalesPaquete(paquete);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean anadirCanalesAPaquete(DB.Paquete paquete, Canal[] canales) {
		return this.paquete.anadirCanalesAPaquete(paquete, canales);
	}
	
	public boolean eidtarEstadoPaquete(Paquete paquete, boolean estado){
		return this.paquete.eidtarEstadoPaquete(paquete, estado);
	}
	
	public boolean eliminarCanalesAPaquete(Paquete paquete, Canal[] canales){
		return this.paquete.eliminarCanalesAPaquete(paquete, canales);
	}

	public boolean eliminarCanal(Canal canal) {
		try {
			return this.canal.eliminarCanal(canal);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean eliminarPaquete(DB.Paquete paquete) {
		return this.paquete.eliminarPaquete(paquete);
	}

	public boolean eliminarTarifaMovil(int mesesAdaptacion, Movil movil) {
		try {
			return this.movil.eliminarTarifaMovil(mesesAdaptacion, movil);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean eliminarTarifaFijo(Fijo fijo, int mesesAdaptacion) {
		try {
			return this.fijo.eliminarTarifaFijo(fijo, mesesAdaptacion);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean eliminarTarifaFibra(Fibra fibra, int mesesAdaptacion) {
		try {
			return this.fibra.eliminarTarifaFibra(fibra, mesesAdaptacion);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean crearTarifaMovil(Movil movil) {
		try {
			return this.movil.crearTarifaMovil(movil);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean crearTarifaFijo(Fijo fijo) {
		try {
			return this.fijo.crearTarifaFijo(fijo);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean crearTarifaFibra(Fibra fibra) {
		try {
			return this.fibra.crearTarifaFibra(fibra);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean editarTarifaMovil(Movil movil) {
		try {
			return this.movil.editarTarifaMovil(movil);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean editarTarifaFijo(Fijo fijo) {
		try {
			return this.fijo.editarTarifaFijo(fijo);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean editarTarifaFibra(Fibra fibra) {// probar!!
		try {
			return this.fibra.editarTarifaFibra(fibra);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public String comprobarUsuario(String email) {
		try {
			return this.cliente.comprobarUsuario(email);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Paquete[] cargarPaquetesCliente(int idCliente) {// probar!!
		return this.paquete.cargarPaquetesCliente(idCliente);
	}

}
