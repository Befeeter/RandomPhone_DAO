package com.randomteam.ventanas;

import java.sql.Date;
import java.util.Iterator;

import com.vaadin.ui.Notification;
import com.vaadin.ui.Window;

import DB.BD_Principal;
import DB.Canal;
import DB.Paquete;
import DB.iAdministrador;

public class EditarPaquete extends EditarPaquete_ventana {
	/*
	 * private Label tituloL; private Label estadoL; private Button estadoB;
	 * private CanalDisp canalesLS; private Button a�adirCanalB; private Button
	 * eliminarCanalB; private Button guardarB; public TarifasTelevision
	 * vTarifasTelevision; public CanalDisp vCanalDisp; public CanalesTV
	 * vCanalesTV;
	 */
	iAdministrador iA = new BD_Principal();
	private Canal[] canales;

	public EditarPaquete(Paquete paquete) {
		canales = iA.cargarCanalesPaquete(paquete);
		canalesLS.addColumn(Canal::getNombre).setCaption("Nombre").setSortable(true);
		canalesLS.setItems(canales);
		/*
		 * MultiSelectionModel<Canal> selectionModel =
		 * (MultiSelectionModel<Canal>) canalesLS
		 * .setSelectionMode(SelectionMode.MULTI);
		 * 
		 */
		nombreL.setValue(paquete.getNombre() + "");
		/*if (paquete.isEstado()) {
			estadoB.setValue(1.0);
		} else
			estadoB.setValue(0.0);*/
		for (Canal canal : iA.cargarCanalesPaquete(paquete)) {
			canalesLS.select(canal);
		}

		aceptarB.addClickListener(ClickEvent -> {

			Iterator<Window> it = this.getUI().getWindows().iterator();
			it.next();
			it.next().close();
		});
	}

	public Informar enviarDatos() {
		throw new UnsupportedOperationException();
	}
}