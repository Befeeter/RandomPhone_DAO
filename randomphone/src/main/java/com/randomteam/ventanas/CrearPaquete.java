package com.randomteam.ventanas;

import java.sql.Date;
import java.util.Iterator;

import org.orm.PersistentException;

import com.vaadin.ui.Notification;
import com.vaadin.ui.Window;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.components.grid.MultiSelectionModel;

import DB.BD_Principal;
import DB.Canal;
import DB.Movil;
import DB.Paquete;
import DB.Television;
import DB.TelevisionDAO;
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
			if (!(nombreTF.isEmpty()||precioTF.isEmpty()||fecha_altaD.isEmpty()||!Informar.isNumeric(precioTF.getValue()))) {
				Paquete paquete = new Paquete();
				paquete.setNombre(nombreTF.getValue()+"");
				paquete.setPrecio(Float.parseFloat(precioTF.getValue()));
				paquete.setFecha_alta(Date.valueOf(fecha_altaD.getValue()));
				// television
				Television tv = null;
				try {
					tv = TelevisionDAO.getTelevisionByORMID(1);
				} catch (PersistentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				paquete.setTelevision(tv);
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
}