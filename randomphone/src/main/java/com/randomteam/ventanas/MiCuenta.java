package com.randomteam.ventanas;
import java.util.Vector;

import com.vaadin.server.VaadinService;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

import DB.BD_Principal;
import DB.Cliente;
import DB.iCliente;

public class MiCuenta extends MiCuenta_ventana {
	/*
	private Label nombreL;
	private Button modificarDatosB;
	private Button modificarServiciosB;
	private Button misFacturasB;
	private Button misIncidenciasB;
	private Label consumoL;
	private Bar consumoBR;
	private Label consumoMovilL;
	private Label consumoFIbraL;
	private Label consumoTvL;
	private Label consumoFijoL;
	private Label datosL;
	public Vector<MisFacturas> vMisFacturas = new Vector<MisFacturas>();
	public SitioWebCliente vSitioWebCliente;
	public Login vLogin;
	public MisIncidencias vMisIncidencias;
	public ModificarServicios vModificarServicios;
	public ModificarDatosPersonales vModificarDatosPersonales;
	*/
	iCliente ic = new BD_Principal();
	Cliente c = new Cliente();
	
	public MiCuenta (String email, String password) {
		c = (Cliente) VaadinService.getCurrentRequest().getWrappedSession().getAttribute("usuario");
		cargarCuenta();
	}
	
	public void cargarCuenta () {
		Cliente cliente = ic.cargarDatosCliente(c.getId());
		this.nombreL.setValue(cliente.getNombre() + " " + cliente.getApellidos());
		/*DB.Servicio[] servicios = ic.cargarServiciosCliente(c.getId());
		for (DB.Servicio servicio : servicios) {
			this.serviciosLS.setColumns(servicio.toString());
		}*/
		//this.consumoBar.setValue(cliente.);
	}
}