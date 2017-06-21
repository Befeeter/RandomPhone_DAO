package com.randomteam.ventanas;

import java.util.Random;

import com.vaadin.server.Page;
import com.vaadin.server.VaadinService;

import DB.BD_Principal;
import DB.Cliente;
import DB.Servicio;
import DB.iCliente;
import DB.Comercial;
import DB.Incidencia;

public class MiCuenta extends MiCuenta_ventana {
	/*
	 * private Label nombreL; private Button modificarDatosB; private Button
	 * modificarServiciosB; private Button misFacturasB; private Button
	 * misIncidenciasB; private Label consumoL; private Bar consumoBR; private
	 * Label consumoMovilL; private Label consumoFIbraL; private Label
	 * consumoTvL; private Label consumoFijoL; private Label datosL; public
	 * Vector<MisFacturas> vMisFacturas = new Vector<MisFacturas>(); public
	 * SitioWebCliente vSitioWebCliente; public Login vLogin; public
	 * MisIncidencias vMisIncidencias; public ModificarServicios
	 * vModificarServicios; public ModificarDatosPersonales
	 * vModificarDatosPersonales;
	 */
	iCliente ic = new BD_Principal();
	Cliente c = new Cliente();
	DB.Servicio[] servicios = null;
	Random randomgenerator = new Random();
	float consumo;

	public MiCuenta() {
		Page.getCurrent().getStyles().add(".form-template{overflow: hidden !important;}");
		
		c = (Cliente) VaadinService.getCurrentRequest().getWrappedSession().getAttribute("usuario");
		cargarCuenta();
		c.setIncidencia(ic.cargarIncidencias(c.getId()));
		// Botón ModificarDatosPersonales
		mDatosPersonales.addClickListener(ClickEvent -> {
			this.removeAllComponents();
			this.addComponent(new ModificarDatosPersonales());
		});

		// Botón MisServicios
		mServicios.addClickListener(ClickEvent -> {
			this.removeAllComponents();
			this.addComponent(new ModificarServicios());
		});

		// Botón Mis Facturas
		misFacturas.addClickListener(ClickEvent -> {
			this.removeAllComponents();
			this.addComponent(new MisFacturas());
		});

		// Botón Mis Incidencias
		misIncidencias.addClickListener(ClickEvent -> {
			this.removeAllComponents();
			this.addComponent(new MisIncidencias());
		});
	}

	public MiCuenta(Comercial comercial) {

		Comercial cM = comercial;
		c = (Cliente) VaadinService.getCurrentRequest().getWrappedSession().getAttribute("usuario");
		Incidencia[] incidencias = ic.cargarIncidencias(c.getId());
		cargarCuenta();
		this.incidenciasL.setVisible(true);
		this.incidenciasL.setValue(incidenciasL.getValue()+" "+incidencias.length);

		// Botón ModificarDatosPersonales
		mDatosPersonales.addClickListener(ClickEvent -> {
			this.removeAllComponents();
			this.addComponent(new ModificarDatosPersonalesCm());
		});

		// Botón MisServicios
		mServicios.addClickListener(ClickEvent -> {
			this.removeAllComponents();
			this.addComponent(new ModificarServiciosCm());
		});

		// Botón Mis Facturas
		misFacturas.addClickListener(ClickEvent -> {
			this.removeAllComponents();
			this.addComponent(new MisFacturas());
		});

		// Botón Mis Incidencias
		misIncidencias.addClickListener(ClickEvent -> {
			this.removeAllComponents();
			this.addComponent(new MisIncidencias());
		});

	}

	public void cargarCuenta() {
		consumo = randomgenerator.nextInt(1024);
		consumocss.setCaption(consumo + " MB de 1024MB");
		consumoBar.setValue((consumo * 100) / 102400);
		Cliente cliente = ic.cargarDatosCliente(c.getId());
		this.nombreL.setValue(cliente.getNombre() + " " + cliente.getApellidos());
		servicios = ic.cargarServiciosCliente(c.getId());
		this.serviciosLS.addColumn(Servicio::getNombre).setCaption("Servicio")
				.setStyleGenerator(item -> "v-align-center");
		this.serviciosLS.addColumn(Servicio::getPrecio).setCaption("Precio")
				.setStyleGenerator(item -> "v-align-center");
		this.serviciosLS.setItems(servicios);
		// this.serviciosLS.addColumn(Float.toString(servicios[0].getPrecio())).setCaption("Precio");
		/*
		 * DB.Servicio[] servicios = ic.cargarServiciosCliente(c.getId()); for
		 * (DB.Servicio servicio : servicios) {
		 * this.serviciosLS.setColumns(servicio.toString()); }
		 */
		// this.consumoBar.setValue(cliente.);
	}
}