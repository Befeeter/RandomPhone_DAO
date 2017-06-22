package com.randomteam.ventanas;

import java.sql.Date;
import java.util.Iterator;

import com.vaadin.ui.Notification;
import com.vaadin.ui.Window;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.components.grid.MultiSelectionModel;

import DB.BD_Principal;
import DB.Canal;
import DB.Movil;
import DB.Paquete;
import DB.iAdministrador;

public class CrearPaquete extends CrearPaquete_ventana{
	/*
	private Label nombreL;
	private TextField nombreTF;
	private Label precioL;
	private TextField precioTF;
	private Label fechaAltaL;
	private Date fechaAltaD;
	private Label estadoL;
	private Button estadoB;
	private CanalDisp canalesLS;
	private Button crearB;
	public TarifasTelevision vTarifasTelevision;
	public CanalDisp vCanalDisp;
	*/
	/*public Informar enviarDatos() {
		throw new UnsupportedOperationException();
	}*/
	iAdministrador iA = new BD_Principal();
	private Canal[] canales;
	Canal[] canalesActuales;
	Canal[] canalesNuevos;
	
	public CrearPaquete () {
		canales = iA.cargarCanalesDisp();
		canalesLS.addColumn(Canal::getNombre).setCaption("Nombre").setSortable(true);
		canalesLS.setItems(canales);
		
		MultiSelectionModel<Canal> selectionModel = (MultiSelectionModel<Canal>) canalesLS
				.setSelectionMode(SelectionMode.MULTI);
		
		crearB.addClickListener(ClickEvent -> {
			//
			if (!(nombreTF.isEmpty()||precioTF.isEmpty()||fecha_altaD.isEmpty()||!Informar.isNumeric(precioTF.getValue()))) {
				Paquete paquete = new Paquete();
				paquete.setNombre(nombreTF.getValue()+"");
				paquete.setPrecio(Float.parseFloat(precioTF.getValue()));
				paquete.setFecha_alta(Date.valueOf(fecha_altaD.getValue()));
				if (estadoB.getValue() == 1.0) {
					paquete.setEstado(true);
				} else
					paquete.setEstado(false);
				
				boolean correcto=false;
	
				correcto = iA.crearPaquete(paquete);
				Canal[] canalesAnadir;
				int size = canalesLS.getSelectedItems().size();
				canalesAnadir = new Canal[size];
				canalesAnadir = canalesLS.getSelectedItems().toArray(canalesAnadir);
				if (canalesAnadir.length>0) {
					correcto = iA.anadirCanalesAPaquete(paquete, canalesAnadir);
				}
	
				if (correcto) {
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
	/*
	public CrearPaquete (Paquete paquete) {
		canales = iA.cargarCanalesDisp();
		canalesLS.addColumn(Canal::getNombre).setCaption("Nombre").setSortable(true);
		canalesLS.setItems(canales);
		
		MultiSelectionModel<Canal> selectionModel = (MultiSelectionModel<Canal>) canalesLS
				.setSelectionMode(SelectionMode.MULTI);

		
		nombreTF.setValue(paquete.getNombre()+"");
		precioTF.setValue(paquete.getPrecio()+"");
		fecha_altaD.setValue(paquete.getFecha_alta().toLocalDate());
		if (paquete.isEstado()) {
			estadoB.setValue(1.0);
		} else
			estadoB.setValue(0.0);
		for (Canal canal : iA.cargarCanalesPaquete(paquete)) {
			canalesLS.select(canal);
		}
		// obtenemos los canales actuales del paquete

		int size = canalesLS.getSelectedItems().size();
		canalesActuales = new Canal[size];
		canalesActuales = canalesLS.getSelectedItems().toArray(canalesActuales);
		
		crearB.addClickListener(ClickEvent -> {
			//
			if (!(nombreTF.isEmpty()||precioTF.isEmpty()||fecha_altaD.isEmpty()||!Informar.isNumeric(precioTF.getValue()))) {
				paquete.setNombre(nombreTF.getValue()+"");
				paquete.setPrecio(Float.parseFloat(precioTF.getValue()));
				paquete.setFecha_alta(Date.valueOf(fecha_altaD.getValue()));
				if (estadoB.getValue() == 1.0) {
					paquete.setEstado(true);
				} else
					paquete.setEstado(false);
				
				boolean correcto=false;
	
				correcto = iA.editarPaquete(paquete, paquete);
				
				if (canalesActuales.length>0) {
					correcto = iA.anadirCanalesAPaquete(paquete, canalesActuales);
				}
	
				if (correcto) {
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
	}*/
}