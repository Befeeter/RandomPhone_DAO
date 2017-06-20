package com.randomteam.ventanas;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Iterator;

import com.vaadin.ui.Notification;
import com.vaadin.ui.Window;

import DB.BD_Principal;
import DB.Comercial;
import DB.Fibra;
import DB.iAdministrador;

public class AltaModificarComercial extends AltaModificarComercial_ventana{
	/*
	private Label tituloL;
	private Label nombreL;
	private TextField nombreTF;
	private Label apellidosL;
	private TextField apellidosTF;
	private Label dniL;
	private TextField dniTF;
	private Date fechaContratacionD;
	private Label estadoL;
	private Button estadoB;
	private Button aceptarB;
	public Comerciales vComerciales;

	public informar enviarDatos() {
		throw new UnsupportedOperationException();
	}
	*/
	iAdministrador iA = new BD_Principal();
	
	public AltaModificarComercial() {
		aceptarB.addClickListener(ClickEvent -> {
			Comercial comercial = new Comercial();
			comercial.setNombre(nombreTF.getValue());
			comercial.setApellidos(apellidosTF.getValue());
			comercial.setDocumento(dniTF.getValue());
			comercial.setFecha_alta(Date.valueOf(fechacontratacionD.getValue()));
			if (estadoB.getValue() == 1.0) {
				comercial.setEstado(true);
			} else
				comercial.setEstado(false);

			// crear comercial
			if (iA.altaComercial(comercial)) {
				Notification.show("Creado con exito!");
				// cerrar ventana
				Iterator<Window> it = this.getUI().getWindows().iterator();
				it.next();
				it.next().close();
			} else
				Notification.show("Error! Ups algo fue mal!");
		});
	}
	
	public AltaModificarComercial(Comercial comercial) {
		aceptarB.addClickListener(ClickEvent -> {
			// obtener datos del comercial
			asdf
			comercial.setNombre(nombreTF.getValue());
			comercial.setApellidos(apellidosTF.getValue());
			comercial.setDocumento(dniTF.getValue());
			comercial.setFecha_alta(Date.valueOf(fechacontratacionD.getValue()));
			if (estadoB.getValue() == 1.0) {
				comercial.setEstado(true);
			} else
				comercial.setEstado(false);

			// crear comercial
			if (iA.altaComercial(comercial)) {
				Notification.show("Creado con exito!");
				// cerrar ventana
				Iterator<Window> it = this.getUI().getWindows().iterator();
				it.next();
				it.next().close();
			} else
				Notification.show("Error! Ups algo fue mal!");
		});
	}
}