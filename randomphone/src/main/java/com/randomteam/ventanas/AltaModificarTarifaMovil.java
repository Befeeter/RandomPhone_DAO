package com.randomteam.ventanas;

import java.util.Collection;
import java.util.Iterator;

import com.vaadin.ui.Notification;
import com.vaadin.ui.Window;

import DB.BD_Principal;
import DB.Movil;
import DB.iAdministrador;

public class AltaModificarTarifaMovil extends AltaModificarTarifaMovil_ventana {
	/*
	 * private Label minutosL; private TextField minutosTF; private Label
	 * datosL; private TextField datosTF; public TarifasMovil vTarifasMovil;
	 */
	iAdministrador iA = new BD_Principal();

	public AltaModificarTarifaMovil() {
		submit.addClickListener(ClickEvent -> {
			if (!(nombreTF.isEmpty() || minutosTF.isEmpty() || datosTF.isEmpty()
					|| !Informar.isNumericInt(minutosTF.getValue()) || !Informar.isNumeric(precioTF.getValue())
					|| !Informar.isNumericInt(datosTF.getValue()))) {
				// obtener datos tarifa
				Movil tarifa = new Movil();
				tarifa.setMinutos(Integer.parseInt(minutosTF.getValue()));
				tarifa.setDatos(Integer.parseInt(datosTF.getValue()));
				tarifa.setNombre(nombreTF.getValue());
				tarifa.setPrecio(Float.parseFloat(precioTF.getValue()));
				if (estadoB.getValue() == 1.0) {
					tarifa.setEstado(true);
				} else
					tarifa.setEstado(false);

				// crear tarifa
				if (iA.crearTarifaMovil(tarifa)) {
					Notification.show("Creada con exito!");
					// cerrar ventana
					Iterator<Window> it = this.getUI().getWindows().iterator();
					it.next();
					it.next().close();
				} else
					Notification.show("Error! Ups algo fue mal!");
			} else {
				Notification.show("Algún campo vacio o incorrecto!");
			}
		});
	}

	public AltaModificarTarifaMovil(Movil movil) {
		// establezco los valores de los campos a editar
		minutosTF.setValue(movil.getMinutos() + "");
		datosTF.setValue(movil.getDatos() + "");
		nombreTF.setValue(movil.getNombre() + "");
		precioTF.setValue(movil.getPrecio() + "");
		if (movil.isEstado()) {
			estadoB.setValue(1.0);
		} else
			estadoB.setValue(0.0);
		//
		submit.addClickListener(ClickEvent -> {
			movil.setMinutos(Integer.parseInt(minutosTF.getValue()));
			movil.setDatos(Integer.parseInt(datosTF.getValue()));
			movil.setNombre(nombreTF.getValue());
			movil.setPrecio(Float.parseFloat(precioTF.getValue()));
			if (estadoB.getValue() == 1.0) {
				movil.setEstado(true);
			} else
				movil.setEstado(false);

			// editar tarifa
			if (iA.editarTarifaMovil(movil)) {
				// cerrar ventana
				Notification.show("Editada con exito!");
				Iterator<Window> it = this.getUI().getWindows().iterator();
				it.next();
				it.next().close();
			} else
				Notification.show("Error! Ups algo fue mal!");

		});
	}
}