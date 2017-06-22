package com.randomteam.ventanas;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Iterator;

import com.vaadin.ui.Notification;
import com.vaadin.ui.Window;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.components.grid.MultiSelectionModel;

import DB.BD_Principal;
import DB.Canal;
import DB.iAdministrador;

public class CrearModificarCanal extends CrearModificarCanal_ventana{
	iAdministrador iA = new BD_Principal();
	private Canal[] canales;
	
	public CrearModificarCanal () {
		crearB.addClickListener(ClickEvent -> {
			//
			if (!(nombreTF.isEmpty()||precioTF.isEmpty()||fecha_altaD.isEmpty()||!Informar.isNumeric(precioTF.getValue()))) {
				Canal canal = new Canal();
				canal.setNombre(nombreTF.getValue()+"");
				canal.setPrecio(Integer.parseInt(precioTF.getValue()));
				canal.setFecha_alta(Date.valueOf(fecha_altaD.getValue()));
				if (estadoB.getValue() == 1.0) {
					canal.setEstado(true);
				} else
					canal.setEstado(false);
	
				if (iA.crearCanal(canal)) {
					Notification.show("Creado con exito!");
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
	
	public CrearModificarCanal(Canal canal) {
		// cargar datos
		nombreTF.setValue(canal.getNombre()+"");
		precioTF.setValue(canal.getPrecio()+"");
		fecha_altaD.setValue(canal.getFecha_alta().toLocalDate());
		if (canal.isEstado()) {
			estadoB.setValue(1.0);
		} else
			estadoB.setValue(0.0);
		
		crearB.addClickListener(ClickEvent -> {
			//
			if (!(nombreTF.isEmpty()||precioTF.isEmpty()||fecha_altaD.isEmpty()||!Informar.isNumeric(precioTF.getValue()))) {
				canal.setNombre(nombreTF.getValue()+"");
				canal.setPrecio(Float.parseFloat(precioTF.getValue()));
				canal.setFecha_alta(Date.valueOf(fecha_altaD.getValue()));
				if (estadoB.getValue() == 1.0) {
					canal.setEstado(true);
				} else
					canal.setEstado(false);
	
				if (iA.editarCanal(canal)) {
					Notification.show("Editado con exito!");
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

	/*
	private Label tituloL;
	private Label nombreL;
	private TextField nombreTF;
	private Label precioL;
	private TextField precioTF;
	private Label fechaAltaL;
	private Date fechaAltaD;
	private Label estadoL;
	private Button estadoB;
	private Button crearB;
	public TarifasTelevision vTarifasTelevision;

	public Informar enviarDatos() {
		throw new UnsupportedOperationException();
	}*/
}