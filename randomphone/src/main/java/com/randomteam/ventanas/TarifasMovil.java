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
		tarifasLS.addColumn(Movil::isEstado).setCaption("Estado").setSortable(true);
		tarifasLS.setItems(tarifas);

		tarifasLS.addItemClickListener(event -> {
			// iselec = event.getItem();

			// Creamos Ventana Emergente con los detalles de la reclamación
			// seleccionada en el Grid
			Window subWindow = new Window("Asunto");
			VerticalLayout subContent = new VerticalLayout();
			// subContent.addComponent(new Reclamacion(iselec));
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			this.getUI().addWindow(subWindow);
		});
		MultiSelectionModel<Movil> selectionModel = (MultiSelectionModel<Movil>) tarifasLS
				.setSelectionMode(SelectionMode.MULTI);
		selectionModel.addMultiSelectionListener(event -> {
			eliminarB.setEnabled(event.getNewSelection().size() > 0);
		});

		// Botón Eliminar
		eliminarB.addClickListener(ClickEvent -> {
			// Creamos Ventana Emergente para crear tarifa
			Window subWindow = new Window("Eliminar tarifa");
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(new MesesAdaptacion());
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("600px");
			subWindow.setWidth("400px");
			this.getUI().addWindow(subWindow);
			
			int mesesAdaptacion = (int) VaadinService.getCurrentRequest().getWrappedSession().getAttribute("mesesAdaptacion");
			//
			Movil[] eliminar;
			int size = tarifasLS.getSelectedItems().size();
			eliminar = new Movil[size];
			eliminar = tarifasLS.getSelectedItems().toArray(eliminar);
			// Para cada tarifa seleccionada la elimino
			for (Movil movil : eliminar) {
				if (iA.eliminarTarifaMovil(mesesAdaptacion, movil) == true) {
					Notification.show("Eliminadas Con exito!");
					tarifas = iA.cargarTarifasMovil();
					tarifasLS.setItems(tarifas);

				} else
					Notification.show("Error! Ups algo fue mal!");
			}
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
			subWindow.setHeight("600px");
			subWindow.setWidth("400px");
			subWindow.addCloseListener(Event -> {
				tarifas = iA.cargarTarifasMovil();
				tarifasLS.setItems(tarifas);
			});
			this.getUI().addWindow(subWindow);
		});
	}
}