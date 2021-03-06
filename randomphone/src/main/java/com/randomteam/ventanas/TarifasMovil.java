package com.randomteam.ventanas;

import com.vaadin.server.VaadinService;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.components.grid.MultiSelectionModel;
import com.vaadin.ui.renderers.ButtonRenderer;

import DB.BD_Principal;
import DB.Incidencia;
import DB.Movil;
import DB.iAdministrador;

public class TarifasMovil extends TarifasMovil_ventana {
	/*
	 * public class TarifasMovil extends TarifasTelefono { public
	 * AltaModificarTarifaMovil vAltaModificarTarifaMovil;
	 */
	iAdministrador iA = new BD_Principal();
	Movil[] tarifas;

	public TarifasMovil() {
		tarifas = iA.cargarTarifasMovil();
		// grid
		tarifasLS.addColumn(Movil::getNombre).setCaption("Nombre").setSortable(true);
		tarifasLS.addColumn(Movil::getEstado).setCaption("Estado").setSortable(true);
		tarifasLS.setItems(tarifas);

		tarifasLS.addItemClickListener(event -> {
			// iselec = event.getItem();

			// Creamos Ventana Emergente con los detalles de la reclamación
			// seleccionada en el Grid
			Window subWindow = new Window("Editar tarifa");
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(new AltaModificarTarifaMovil(event.getItem()));
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("800px");
			subWindow.setWidth("400px");
			subWindow.addCloseListener(Event -> {
				tarifas = iA.cargarTarifasMovil();
				tarifasLS.setItems(tarifas);
			});
			this.getUI().addWindow(subWindow);
		});
		MultiSelectionModel<Movil> selectionModel = (MultiSelectionModel<Movil>) tarifasLS
				.setSelectionMode(SelectionMode.MULTI);
		selectionModel.addMultiSelectionListener(event -> {
			eliminarB.setEnabled(event.getNewSelection().size() > 0);
		});

		// Botón Eliminar
		eliminarB.addClickListener(ClickEvent -> {
			//obtener elementos a eliminar
			Movil[] tarifasEliminar;
			int size = tarifasLS.getSelectedItems().size();
			tarifasEliminar = new Movil[size];
			tarifasEliminar = tarifasLS.getSelectedItems().toArray(tarifasEliminar);
			
			// Creamos Ventana Emergente para crear tarifa
			Window subWindow = new Window("Eliminar tarifa");
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(new MesesAdaptacion(tarifasEliminar));
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("800px");
			subWindow.setWidth("400px");
			subWindow.addCloseListener(Event -> {
				tarifas = iA.cargarTarifasMovil();
				tarifasLS.setItems(tarifas);
			});
			this.getUI().addWindow(subWindow);
		});

		// Botón Tarifa
		crearTarifaB.addClickListener(ClickEvent -> {

			// Creamos Ventana Emergente para crear tarifa
			Window subWindow = new Window("Crear tarifa");
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(new AltaModificarTarifaMovil());
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("800px");
			subWindow.setWidth("400px");
			subWindow.addCloseListener(Event -> {
				tarifas = iA.cargarTarifasMovil();
				tarifasLS.setItems(tarifas);
			});
			this.getUI().addWindow(subWindow);
		});
	}
}