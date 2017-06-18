package com.randomteam.ventanas;

import com.vaadin.ui.Notification;

import DB.BD_Principal;
import DB.Movil;
import DB.iAdministrador;

public class AltaModificarTarifaMovil extends AltaModificarTarifaMovil_ventana {
	/*
	private Label minutosL;
	private TextField minutosTF;
	private Label datosL;
	private TextField datosTF;
	public TarifasMovil vTarifasMovil;
	*/
	iAdministrador iA = new BD_Principal();
	
	public AltaModificarTarifaMovil () {
		submit.addClickListener(ClickEvent -> {
			//obtener datos tarifa
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
				tarifa.setEstado(true);
			} else
				Notification.show("Error! Ups algo fue mal!");
		});
	}
}