package com.randomteam.ventanas;

import java.util.Random;

import com.vaadin.server.VaadinService;

import DB.BD_Principal;
import DB.Cliente;
import DB.Comercial;
import DB.Incidencia;
import DB.Servicio;
import DB.iCliente;

public class MiCuentaComercial extends MiCuentaComercial_ventana {
/*public class MiCuentaComercial extends MiCuenta {
	private Label nIncidencias;
	public ClienteE vClienteE;
	public ModificarDatosCliente vModificarDatosCliente;
	public ModificarServiciosCm vModificarServiciosCm;
	public ModificarDatosPersonalesCm vModificarDatosPersonalesCm;
	*/
	iCliente ic = new BD_Principal();
	Cliente c = new Cliente();
	DB.Servicio[] servicios = null;
	Random randomgenerator = new Random();
	float consumo;
	
	public MiCuentaComercial(){
		
	Comercial cM = (Comercial) VaadinService.getCurrentRequest().getWrappedSession().getAttribute("comercial");
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