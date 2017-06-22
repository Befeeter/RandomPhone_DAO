package com.randomteam.ventanas;

import java.util.Iterator;

import com.vaadin.data.HasValue;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.components.grid.MultiSelectionModel;

import DB.BD_Principal;
import DB.Paquete;
import DB.Canal;
import DB.Incidencia;
import DB.iAdministrador;

public class TarifasTelevision extends TarifasTelevision_ventana {
	/*
	 * private Label tituloPaquetesL; private Label tituloCanalesL; private
	 * TextField buscarTF; private Button eliminarSeleccionB; private Paquete
	 * paquetesLS; private Canal canalesLS; private Button crearPaqueteB;
	 * private Button editarPaqueteB; private Button crearCanalB; private Button
	 * eidtarCanalB; public Servicios vServicios; public Paquete vPaquete;
	 * public Canal vCanal; public CrearModificarCanal vCrearModificarCanal;
	 * public CrearPaquete vCrearPaquete; public EditarPaquete vEditarPaquete;
	 */

	iAdministrador iA = new BD_Principal();
	Paquete[] paquetes;
	Canal[] canales;

	public TarifasTelevision() {

		// Busqueda
		buscarPaquetesTF.setPlaceholder("Nombre...");
		buscarPaquetesTF.addValueChangeListener(this::onNameFilterTextChange);
		buscarCanalesTF.setPlaceholder("Nombre...");
		buscarCanalesTF.addValueChangeListener(this::onNameFilterTextChange2);

		paquetes = iA.cargarPaquetesTV();
		// grid
		paquetesLS.addColumn(Paquete::getNombre).setCaption("Nombre").setSortable(true);
		paquetesLS.setItems(paquetes);
		/*
		paquetesLS.addItemClickListener(event -> {
			// Creamos Ventana Emergente
			// seleccionada en el Grid
			Window subWindow = new Window("Editar Paquete");
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(new CrearPaquete(event.getItem()));
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("750px");
			subWindow.setWidth("400px");
			subWindow.addCloseListener(Event -> {
				paquetes = iA.cargarPaquetesTV();
				paquetesLS.setItems(paquetes);
			});
			this.getUI().addWindow(subWindow);
		});*/
		MultiSelectionModel<Paquete> selectionModel = (MultiSelectionModel<Paquete>) paquetesLS
				.setSelectionMode(SelectionMode.MULTI);
		selectionModel.addMultiSelectionListener(event -> {
			eliminarPaqueteB.setEnabled(event.getNewSelection().size() > 0);
		});

		// Botón Eliminar
		eliminarPaqueteB.addClickListener(ClickEvent -> {
			// obtener elementos a eliminar
			Paquete[] eliminar;
			int size = paquetesLS.getSelectedItems().size();
			eliminar = new Paquete[size];
			eliminar = paquetesLS.getSelectedItems().toArray(eliminar);
			boolean correcto = false;
			for (Paquete paquete : eliminar) {
				correcto = iA.eliminarPaquete(paquete);
			}
			if (correcto) {
				Notification.show("Eliminadas Con exito!");
			} else
				Notification.show("Error! Ups algo fue mal!");
			paquetes = iA.cargarPaquetesTV();
			paquetesLS.setItems(paquetes);
		});

		// Botón crear
		crearPaqueteB.addClickListener(ClickEvent -> {
			// Creamos Ventana Emergente para crear
			Window subWindow = new Window("Crear paquete");
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(new CrearPaquete());
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("900px");
			subWindow.setWidth("400px");
			subWindow.addCloseListener(Event -> {
				paquetes = iA.cargarPaquetesTV();
				paquetesLS.setItems(paquetes);
			});
			this.getUI().addWindow(subWindow);
		});

		//
		// Canales
		//

		canales = iA.cargarCanalesTv();
		// grid
		canalesLS.addColumn(Canal::getNombre).setCaption("Nombre").setSortable(true);
		canalesLS.setItems(canales);

		canalesLS.addItemClickListener(event -> {
			// Creamos Ventana Emergente
			// seleccionada en el Grid
			Window subWindow = new Window("Editar Canal");
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(new CrearModificarCanal(event.getItem()));
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("850px");
			subWindow.setWidth("400px");
			subWindow.addCloseListener(Event -> {
				canales = iA.cargarCanalesTv();
				canalesLS.setItems(canales);
			});
			this.getUI().addWindow(subWindow);
		});
		MultiSelectionModel<Canal> selectionModel2 = (MultiSelectionModel<Canal>) canalesLS
				.setSelectionMode(SelectionMode.MULTI);
		selectionModel2.addMultiSelectionListener(event -> {
			eliminarCanalB.setEnabled(event.getNewSelection().size() > 0);
		});

		// Botón Eliminar
		eliminarCanalB.addClickListener(ClickEvent -> {
			// obtener elementos a eliminar
			Canal[] eliminar;
			int size = canalesLS.getSelectedItems().size();
			eliminar = new Canal[size];
			eliminar = canalesLS.getSelectedItems().toArray(eliminar);
			boolean correcto = false;
			for (Canal canal : eliminar) {
				correcto = iA.eliminarCanal(canal);
			}
			if (correcto) {
				Notification.show("Eliminados Con exito!");
			} else
				Notification.show("Error! Ups algo fue mal!");
			canales = iA.cargarCanalesTv();
			canalesLS.setItems(canales);
		});

		// Botón crear
		crearCanalB.addClickListener(ClickEvent -> {
			// Creamos Ventana Emergente para crear
			Window subWindow = new Window("Crear canal");
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(new CrearModificarCanal());
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("800px");
			subWindow.setWidth("400px");
			subWindow.addCloseListener(Event -> {
				canales = iA.cargarCanalesTv();
				canalesLS.setItems(canales);
			});
			this.getUI().addWindow(subWindow);
		});
	}

	private void onNameFilterTextChange(HasValue.ValueChangeEvent<String> event) {
		ListDataProvider<Paquete> dataProvider = (ListDataProvider<Paquete>) paquetesLS.getDataProvider();
		dataProvider.setFilter(Paquete::getNombre, s -> caseInsensitiveContains(s, event.getValue()));
	}
	
	private void onNameFilterTextChange2(HasValue.ValueChangeEvent<String> event) {
		ListDataProvider<Canal> dataProvider2 = (ListDataProvider<Canal>) canalesLS.getDataProvider();
		dataProvider2.setFilter(Canal::getNombre, s -> caseInsensitiveContains(s, event.getValue()));
	}

	private Boolean caseInsensitiveContains(String where, String what) {
		return where.toLowerCase().contains(what.toLowerCase());
	}
}