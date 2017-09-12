package com.randomteam.ventanas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.omg.CORBA.Environment;

import com.vaadin.data.Binder;
import com.vaadin.data.HasValue.ValueChangeEvent;
import com.vaadin.data.HasValue.ValueChangeListener;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinService;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import DB.BD_Principal;
import DB.Cliente;
import DB.ClienteDAO;
import DB.Fibra;
import DB.Fijo;
import DB.Movil;
import DB.Paquete;
import DB.Servicio;
import DB.Television;
import DB.Terminal;
import DB.iComercial;

public class AltaNuevoCliente extends AltaNuevoCliente_ventana {
	/*
	 * private Label tituloL; private Label nombreL; private TextField nombreTF;
	 * private Label apellidoL; private TextField apellidoTF; private Label
	 * documentoL; private TextField documentoTF; private Label emailL; private
	 * TextField emailTF; private Label telefonoL; private TextField telefonoTF;
	 * private Label tituloServicioL; private img movilI; private TarifaE
	 * movilLS; private img telefonoI; private TarifaE telefonoLS; private img
	 * fibraI; private TarifaE fibraLS; private img televisionI; private TarifaE
	 * televisionLS; private Button terminalesB; private Button darAltaB; public
	 * PanelAdministracionComercial vPanelAdministracionComercial; public
	 * TarifaE vTarifaE; public Terminales vTerminales;
	 */
	/*
	 * public Informar enviarDatos() { throw new
	 * UnsupportedOperationException(); }
	 */
	private iComercial iC = new BD_Principal();
	private Movil[] sMovil = iC.cargarTarifasMovil();
	private ArrayList<Movil> sMovilD = new ArrayList<Movil>();
	private Fijo[] sFijo = iC.cargarTarifasFijo();
	private ArrayList<Fijo> sFijoD = new ArrayList<Fijo>();
	private Fibra[] sFibra = iC.cargarTarifasFibra();
	private ArrayList<Fibra> sFibraD = new ArrayList<Fibra>();
	private Television[] sTv = iC.cargarTarifasTelevision();
	private ArrayList<Television> sTvD = new ArrayList<Television>();
	private Cliente cliente;
	private ArrayList<Servicio> serviciosContratados = new ArrayList<>();
	private Terminal[] terminales;
	private int facturaId;
	// cargar Servicios Disponibles
	// private Movil[] tMovil = iC.cargarServiciosDisp();

	public AltaNuevoCliente() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new java.util.Date();
		if (VaadinService.getCurrentRequest().getWrappedSession().getAttribute("Terminales") != null)
			VaadinService.getCurrentRequest().getWrappedSession().setAttribute("Terminales", null);
			
		this.movilL.setContentMode(ContentMode.HTML);
		this.movilL.setValue(VaadinIcons.PHONE.getHtml());
		this.fijoL.setContentMode(ContentMode.HTML);
		this.fijoL.setValue(VaadinIcons.PHONE_LANDLINE.getHtml());
		this.fibraL.setContentMode(ContentMode.HTML);
		this.fibraL.setValue(VaadinIcons.BUILDING.getHtml());
		this.televisionL.setContentMode(ContentMode.HTML);
		this.televisionL.setValue(VaadinIcons.MOVIE.getHtml());

		// Establecemos el Caption a mosotrar en el combobox del objeto
		// correspondiente.
		movilLS.setItemCaptionGenerator(Movil::getNombre);
		fijoLS.setItemCaptionGenerator(Fijo::getNombre);
		fibraLS.setItemCaptionGenerator(Fibra::getNombre);
		televisionLS.setItemCaptionGenerator(Television::getNombre);

		// Cargamos Los servicios activos Disponibles.
		for (Movil movil : sMovil)
			if (movil.getEstado() == true)
				sMovilD.add(movil);
		movilLS.setItems(sMovilD);

		for (Fijo fijo : sFijo)
			if (fijo.getEstado() == true)
				sFijoD.add(fijo);
		fijoLS.setItems(sFijoD);

		for (Fibra fibra : sFibra)
			if (fibra.getEstado() == true)
				sFibraD.add(fibra);
		fibraLS.setItems(sFibraD);

		for (Television paquete : sTv)
			if (paquete.getEstado() == true)
				sTvD.add(paquete);
		televisionLS.setItems(sTvD);

		
		ValueChangeListener valueListener = new ValueChangeListener() {
			
			public void valueChange (ValueChangeEvent event){
				if (!fibraLS.isEmpty() || !televisionLS.isEmpty())
				if (VaadinService.getCurrentRequest().getWrappedSession().getAttribute("Terminales") == null)
					darDeAltaB.setEnabled(false);
				else
					darDeAltaB.setEnabled(true);
			}
		};
		
		// Ventana emergente para establecer Terminales
		terminalesB.addClickListener(ClickEvent -> {
			Window subWindow = new Window("Terminales");
			VerticalLayout subcontent = new VerticalLayout();
			subcontent.addComponent(new Terminales());
			subWindow.setContent(subcontent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("400px");
			subWindow.setWidth("400px");
			subWindow.addCloseListener(Event ->{
				if (VaadinService.getCurrentRequest().getWrappedSession().getAttribute("Terminales") != null)
					darDeAltaB.setEnabled(true);
			});
			this.getUI().addWindow(subWindow);
		});

		Binder<Cliente> binder = new Binder<Cliente>();

		binder.forField(nombreTF).asRequired("Nombre No puede estar vacío").bind(Cliente::getNombre,
				Cliente::setNombre);
		binder.forField(apellidoTF).asRequired("Apellidos no puede estar vacío").bind(Cliente::getApellidos,
				Cliente::setApellidos);
		binder.forField(documentoTF).asRequired("DNI no puede estar vacio").bind(Cliente::getDocumento,
				Cliente::setDocumento);
		binder.forField(emailTF).asRequired("Email no puede estar vacío").bind(Cliente::getEmail, Cliente::setEmail);
		

		binder.addStatusChangeListener(event -> darDeAltaB.setEnabled(binder.isValid()));
		
		
		
		fibraLS.addValueChangeListener(valueListener);
		televisionLS.addValueChangeListener(valueListener);
		

		darDeAltaB.addClickListener(ClickEvent -> {
			this.cliente = ClienteDAO.createCliente();
			cliente.setNombre(nombreTF.getValue());
			cliente.setFecha_altta(date);
			cliente.setEstado(true);
			cliente.setApellidos(apellidoTF.getValue());
			cliente.setDocumento(documentoTF.getValue());
			cliente.setEmail(emailTF.getValue());
			cliente.setTelefono(Integer.parseInt(telefonoTF.getValue()));
			cliente.setContrasena("Hola00==");

			// cliente.setId(iC.altaCliente(cliente));

			if (iC.altaCliente(cliente) != -1) {

				if (!movilLS.isEmpty())
					serviciosContratados.add(movilLS.getValue());
				if (!fibraLS.isEmpty())
					serviciosContratados.add(fibraLS.getValue());
				if (!fijoLS.isEmpty())
					serviciosContratados.add(fijoLS.getValue());
				if (!televisionLS.isEmpty())
					serviciosContratados.add(televisionLS.getValue());
				if (!fibraLS.isEmpty() || !televisionLS.isEmpty()) {
					if (!VaadinService.getCurrentRequest().getWrappedSession().getAttributeNames()
							.contains("Terminales"))
						Notification.show("Error! Debe seleccionar el terminal correspondiente");
					else {
						terminales = (Terminal[]) VaadinService.getCurrentRequest().getWrappedSession()
								.getAttribute("Terminales");
						int total = 0;
						for (Servicio serv : serviciosContratados)
							total += serv.getPrecio();
						facturaId = iC.crearFacturaServicios(cliente,
								serviciosContratados.toArray(new Servicio[serviciosContratados.size()]), total);
						iC.altaTerminal(terminales, facturaId);
						Notification.show("Usuario Creado Correctamente");
						this.removeAllComponents();
						this.addComponent(new PanelAdministracionComercial());
					}
				} else {

					int total = 0;
					for (Servicio serv : serviciosContratados)
						total += serv.getPrecio();
					facturaId = iC.crearFacturaServicios(cliente,
							serviciosContratados.toArray(new Servicio[serviciosContratados.size()]), total);
					Notification.show("Usuario Creado Correctamente");
					this.removeAllComponents();
					this.addComponent(new PanelAdministracionComercial());
				}
			} else
				Notification.show("Error");

		});

	}

}