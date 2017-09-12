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

public class AltaModificarComercial extends AltaModificarComercial_ventana {
	/*
	 * private Label tituloL; private Label nombreL; private TextField nombreTF;
	 * private Label apellidosL; private TextField apellidosTF; private Label
	 * dniL; private TextField dniTF; private Date fechaContratacionD; private
	 * Label estadoL; private Button estadoB; private Button aceptarB; public
	 * Comerciales vComerciales;
	 * 
	 * public informar enviarDatos() { throw new
	 * UnsupportedOperationException(); }
	 */
	iAdministrador iA = new BD_Principal();

	public AltaModificarComercial() {
		aceptarB.addClickListener(ClickEvent -> {
			if (!(nombreTF.isEmpty()||fechacontratacionD.isEmpty()||emailTF.isEmpty()||apellidosTF.isEmpty()||dniTF.isEmpty()||contrasenaTF.isEmpty())) {
				Comercial comercial = new Comercial();
				comercial.setNombre(nombreTF.getValue());
				comercial.setApellidos(apellidosTF.getValue());
				comercial.setDocumento(dniTF.getValue());
				comercial.setContrasena(contrasenaTF.getValue());
				comercial.setEmail(emailTF.getValue());
				if (fechacontratacionD.getValue() != null)
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
					it.next().close();
				} else
					Notification.show("Error! Ups algo fue mal!");
			} else {
				Notification.show("Algún campo vacio o incorrecto!");
			}
		});
		
		cancelarB.addClickListener(ClickEvent -> {
			Iterator<Window> it = this.getUI().getWindows().iterator();
			it.next().close();
		});
	}

	public AltaModificarComercial(Comercial comercial) {
		// obtener datos del comercial
		nombreTF.setValue(comercial.getNombre());
		apellidosTF.setValue(comercial.getApellidos());
		dniTF.setValue(comercial.getDocumento());
		contrasenaTF.setValue(comercial.getContrasena());
		emailTF.setValue(comercial.getEmail());
		if (comercial.getFecha_alta() != null) {
			fechacontratacionD.setValue(LocalDate.of(comercial.getFecha_alta().getYear(), 
					comercial.getFecha_alta().getMonth()+1, comercial.getFecha_alta().getDate()));
		} if (comercial.getEstado()) {
			estadoB.setValue(1.0);
		} else
			estadoB.setValue(0.0);
		
		//aceptar
		aceptarB.addClickListener(ClickEvent -> {
			if (!(nombreTF.isEmpty()||fechacontratacionD.isEmpty()||emailTF.isEmpty()||apellidosTF.isEmpty()||dniTF.isEmpty()||contrasenaTF.isEmpty())) {
				comercial.setNombre(nombreTF.getValue());
				comercial.setApellidos(apellidosTF.getValue());
				comercial.setDocumento(dniTF.getValue());
				comercial.setContrasena(contrasenaTF.getValue());
				comercial.setEmail(emailTF.getValue());
				if (fechacontratacionD.getValue() != null)
					comercial.setFecha_alta(Date.valueOf(fechacontratacionD.getValue()));
				if (estadoB.getValue() == 1.0) {
					comercial.setEstado(true);
				} else
					comercial.setEstado(false);
	
				// crear comercial
				if (iA.editarComercial(comercial)) {
					Notification.show("Editado con exito!");
					// cerrar ventana
					Iterator<Window> it = this.getUI().getWindows().iterator();
					it.next().close();
				} else
					Notification.show("Error! Ups algo fue mal!");
			} else {
				Notification.show("Algún campo vacio o incorrecto!");
			}
		});
		
		cancelarB.addClickListener(ClickEvent -> {
			Iterator<Window> it = this.getUI().getWindows().iterator();
			it.next().close();
		});
	}
}