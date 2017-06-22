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
	
	public CrearPaquete () {
		canales = iA.cargarCanalesDisp();
		canalesLS.addColumn(Canal::getNombre).setCaption("Nombre").setSortable(true);
		canalesLS.setItems(canales);
		
		MultiSelectionModel<Canal> selectionModel = (MultiSelectionModel<Canal>) canalesLS
				.setSelectionMode(SelectionMode.MULTI);
		
		crearB.addClickListener(ClickEvent -> {
			//
			Paquete paquete = new Paquete();
			paquete.setNombre(nombreTF.getValue()+"");
			paquete.setPrecio(Integer.parseInt(precioTF.getValue()));
			paquete.setFecha_alta(Date.valueOf(fecha_altaD.getValue()));
			if (estadoB.getValue() == 1.0) {
				paquete.setEstado(true);
			} else
				paquete.setEstado(false);
			
			boolean correcto=false;

			correcto = iA.crearPaquete(paquete);
			Canal[] canalesAñadir;
			int size = canalesLS.getSelectedItems().size();
			canalesAñadir = new Canal[size];
			canalesAñadir = canalesLS.getSelectedItems().toArray(canalesAñadir);
			if (canalesAñadir.length>0) {
				correcto = iA.añadirCanalesAPaquete(paquete, canalesAñadir);
			}

			if (correcto) {
				Notification.show("Creado con exito!");
				// cerrar ventana
				Iterator<Window> it = this.getUI().getWindows().iterator();
				it.next().close();
			} else
				Notification.show("Error! Ups algo fue mal!");
		});
	}
}