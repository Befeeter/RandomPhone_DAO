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
			} else
				Notification.show("Error! Ups algo fue mal!");
		});
	}
	
	public AltaModificarTarifaMovil (Movil movil) {
		// establezco los valores de los campos a editar
		minutosTF.setValue(movil.getMinutos()+"");
		datosTF.setValue(movil.getDatos()+"");
		nombreTF.setValue(movil.getNombre()+"");
		precioTF.setValue(movil.getPrecio()+"");
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
			if (iA.editarTarifaMovil(movil, movil)) {
				Notification.show("Editada con exito!");
			} else
				Notification.show("Error! Ups algo fue mal!");
		});
	}
}