package com.randomteam.ventanas;

import com.vaadin.ui.Notification;

import DB.BD_Principal;
import DB.Fijo;
import DB.iAdministrador;

public class AltaModificarTarifaTelefono extends AltaModificarTarifaTelefono_ventana {

	/*
	 * private Label minutosL; private TextField minutosTF; public
	 * TarifasTelefono vTarifasTelefono;
	 */
	iAdministrador iA = new BD_Principal();

	public AltaModificarTarifaTelefono() {
		submit.addClickListener(ClickEvent -> {
			// obtener datos tarifa
			Fijo tarifa = new Fijo();
			tarifa.setMinutos(Integer.parseInt(minutosTF.getValue()));
			tarifa.setNombre(nombreTF.getValue());
			tarifa.setPrecio(Float.parseFloat(precioTF.getValue()));
			if (estadoB.getValue() == 1.0) {
				tarifa.setEstado(true);
			} else
				tarifa.setEstado(false);

			// crear tarifa
			if (iA.crearTarifaFijo(tarifa)) {
				Notification.show("Editada con exito!");
			} else
				Notification.show("Error! Ups algo fue mal!");
		});
	}
	
	public AltaModificarTarifaTelefono(Fijo fijo) {
		// establezco los valores de los campos a editar
		minutosTF.setValue(fijo.getMinutos() + "");
		nombreTF.setValue(fijo.getNombre() + "");
		precioTF.setValue(fijo.getPrecio() + "");
		if (fijo.isEstado()) {
			estadoB.setValue(1.0);
		} else
			estadoB.setValue(0.0);
		//
		submit.addClickListener(ClickEvent -> {
			fijo.setMinutos(Integer.parseInt(minutosTF.getValue()));
			fijo.setNombre(nombreTF.getValue());
			fijo.setPrecio(Float.parseFloat(precioTF.getValue()));
			if (estadoB.getValue() == 1.0) {
				fijo.setEstado(true);
			} else
				fijo.setEstado(false);

			// editar tarifa
			if (iA.editarTarifaFijo(fijo, fijo)) {
				Notification.show("Editada con exito!");
			} else
				Notification.show("Error! Ups algo fue mal!");
		});
	}

}