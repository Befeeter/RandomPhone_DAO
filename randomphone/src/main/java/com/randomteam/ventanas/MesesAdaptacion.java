package com.randomteam.ventanas;

import com.vaadin.server.VaadinService;
import com.vaadin.ui.Notification;

import DB.BD_Principal;
import DB.Movil;
import DB.iAdministrador;

public class MesesAdaptacion extends MesesAdaptacion_ventana {
	/*
	 * private Label mesesL; private TextField mesesTF; private Button aceptarB;
	 * public Tarifa vTarifa;
	 */
	iAdministrador iA = new BD_Principal();
	
	public MesesAdaptacion() {

	}

	// constructor para eliminar las tarifas moviles
	public MesesAdaptacion(Movil[] eliminar) {
		aceptarB.addClickListener(ClickEvent -> {
			boolean correcto=true;
			// Para cada tarifa seleccionada la elimino
			for (Movil movil : eliminar) {
				if (!iA.eliminarTarifaMovil(Integer.parseInt(mesesTF.getValue()), movil))
					correcto = false;
			}
			if (correcto) {
				Notification.show("Eliminadas Con exito!");
				//this.getUI().close();
			} else
				Notification.show("Error! Ups algo fue mal!");
		});
	}
}