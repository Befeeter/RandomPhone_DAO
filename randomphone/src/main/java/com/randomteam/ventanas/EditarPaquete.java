package com.randomteam.ventanas;

import java.sql.Date;
import java.util.Iterator;

import org.orm.PersistentException;

import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.components.grid.MultiSelectionModel;

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
	private boolean estado;

	public EditarPaquete(Paquete paquete){
		canales = iA.cargarCanalesPaquete(paquete);
		canalesLS.addColumn(Canal::getNombre).setCaption("Nombre").setSortable(true);
		canalesLS.setItems(canales);
		MultiSelectionModel<Canal> selectionModel = (MultiSelectionModel<Canal>) canalesLS
				.setSelectionMode(SelectionMode.MULTI);
		selectionModel.addMultiSelectionListener(event -> {
			rmCanalB.setEnabled(event.getNewSelection().size() > 0);
		});

		rmCanalB.addClickListener(ClickEvent -> {
			Canal[] eliminar;
			eliminar = new Canal[canalesLS.getSelectedItems().size()];
			eliminar = canalesLS.getSelectedItems().toArray(eliminar);
			if (iA.eliminarCanalesAPaquete(paquete, eliminar))
				Notification.show("Canales Eliminados con Exito");
			else
				Notification.show("Ups Algo fue mal!!!");
			canales = iA.cargarCanalesPaquete(paquete);
			canalesLS.setItems(canales);
		});

		addCanalB.addClickListener(ClickEvent -> {
			Window subWindow = new Window("Editar Paquete");
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(new CanalesTV(paquete));
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("500px");
			subWindow.setWidth("400px");
			subWindow.addCloseListener(Event -> {
				canales = iA.cargarCanalesPaquete(paquete);
				canalesLS.setItems(canales);
			});
			this.getUI().addWindow(subWindow);
		});
		if (paquete.getEstado())
			estadoSlider.setValue(1.0);
		else
			estadoSlider.setValue(0.0);
		/*
		 * MultiSelectionModel<Canal> selectionModel =
		 * (MultiSelectionModel<Canal>) canalesLS
		 * .setSelectionMode(SelectionMode.MULTI);
		 * 
		 */
		nombreL.setValue(paquete.getNombre() + "");
		/*
		 * if (paquete.isEstado()) { estadoB.setValue(1.0); } else
		 * estadoB.setValue(0.0);
		 */
		for (Canal canal : iA.cargarCanalesPaquete(paquete)) {
			canalesLS.select(canal);
		}

		aceptarB.addClickListener(ClickEvent -> {
			if(estadoSlider.getValue() == 1.0)
				estado = true;
			else
				estado = false;
			
			
			if (estado == paquete.getEstado()){
			Iterator<Window> it = this.getUI().getWindows().iterator();
			it.next();
			it.next().close();
			}
			else{
				if(iA.eidtarEstadoPaquete(paquete, estado)){
						Notification.show("Estado Actualizado Con exito!");
				Iterator<Window> it = this.getUI().getWindows().iterator();
				it.next();
				it.next().close();
				}
				else
					Notification.show("Error Actualizando Estado!!! :S");
			}
		});
	}

	public Informar enviarDatos() {
		throw new UnsupportedOperationException();
	}
}