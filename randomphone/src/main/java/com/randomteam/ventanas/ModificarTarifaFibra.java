package com.randomteam.ventanas;

import java.util.Iterator;

import com.vaadin.ui.Notification;
import com.vaadin.ui.Window;

import DB.BD_Principal;
import DB.Fibra;
import DB.iAdministrador;

public class ModificarTarifaFibra extends ModificarTarifaFibra_ventana {
	/*
	 * public class ModificarTarifaFibra extends AltaModificarTarifas { private
	 * Label bajadaL; private TextField bajadaTF; private Label subidaL; private
	 * TextFIeld subidaTF; public TarifasFibra vTarifasFibra;
	 */

	iAdministrador iA = new BD_Principal();

	public ModificarTarifaFibra() {
		submit.addClickListener(ClickEvent -> {
			if (!(nombreTF.isEmpty() || subidaTF.isEmpty() || bajadaTF.isEmpty()
					|| !Informar.isNumericInt(subidaTF.getValue()) || !Informar.isNumeric(precioTF.getValue())
					|| !Informar.isNumericInt(bajadaTF.getValue()))) {
				// obtener datos tarifa
				Fibra tarifa = new Fibra();
				tarifa.setVsub(Integer.parseInt(subidaTF.getValue()));
				tarifa.setVbaj(Integer.parseInt(bajadaTF.getValue()));
				tarifa.setNombre(nombreTF.getValue());
				tarifa.setPrecio(Float.parseFloat(precioTF.getValue()));
				if (estadoB.getValue() == 1.0) {
					tarifa.setEstado(true);
				} else
					tarifa.setEstado(false);

				// crear tarifa
				if (iA.crearTarifaFibra(tarifa)) {
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

	public ModificarTarifaFibra(Fibra fibra) {
		// establezco los valores de los campos a editar
		subidaTF.setValue(fibra.getVsub() + "");
		bajadaTF.setValue(fibra.getVbaj() + "");
		nombreTF.setValue(fibra.getNombre() + "");
		precioTF.setValue(fibra.getPrecio() + "");
		if (fibra.getEstado()) {
			estadoB.setValue(1.0);
		} else
			estadoB.setValue(0.0);
		//
		submit.addClickListener(ClickEvent -> {
			if (!(nombreTF.isEmpty() || subidaTF.isEmpty() || bajadaTF.isEmpty()
					|| !Informar.isNumericInt(subidaTF.getValue()) || !Informar.isNumeric(precioTF.getValue())
					|| !Informar.isNumericInt(bajadaTF.getValue()))) {
				fibra.setVsub(Integer.parseInt(subidaTF.getValue()));
				fibra.setVbaj(Integer.parseInt(bajadaTF.getValue()));
				fibra.setNombre(nombreTF.getValue());
				fibra.setPrecio(Float.parseFloat(precioTF.getValue()));
				if (estadoB.getValue() == 1.0) {
					fibra.setEstado(true);
				} else
					fibra.setEstado(false);

				// editar tarifa
				if (iA.editarTarifaFibra(fibra)) {
					Notification.show("Editada con exito!");
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
}