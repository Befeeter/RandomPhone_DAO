package com.randomteam.ventanas;

import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.components.grid.MultiSelectionModel;

import DB.BD_Principal;
import DB.Fijo;
import DB.iAdministrador;

public class TarifasTelefono extends tarifasTelefono_ventana {
/*public class TarifasTelefono extends TarifasFibra {
	public AltaModificarTarifaTelefono vAltaModificarTarifaTelefono;*/

	iAdministrador iA = new BD_Principal();
	Fijo[] tarifas;

	public TarifasTelefono() {
		tarifas = iA.cargarTarifasFijo();
		// grid
		tarifasLS.addColumn(Fijo::getNombre).setCaption("Nombre").setSortable(true);
		tarifasLS.addColumn(Fijo::isEstado).setCaption("Estado").setSortable(true);
		tarifasLS.setItems(tarifas);

		tarifasLS.addItemClickListener(event -> {
			// iselec = event.getItem();

			// Creamos Ventana Emergente con los detalles de la reclamación
			// seleccionada en el Grid
			Window subWindow = new Window("Editar tarifa");
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(new AltaModificarTarifaTelefono(event.getItem()));
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("600px");
			subWindow.setWidth("400px");
			subWindow.addCloseListener(Event -> {
				tarifas = iA.cargarTarifasFijo();
				tarifasLS.setItems(tarifas);
			});
			this.getUI().addWindow(subWindow);
		});
		MultiSelectionModel<Fijo> selectionModel = (MultiSelectionModel<Fijo>) tarifasLS
				.setSelectionMode(SelectionMode.MULTI);
		selectionModel.addMultiSelectionListener(event -> {
			eliminarB.setEnabled(event.getNewSelection().size() > 0);
		});

		// Botón Eliminar
		eliminarB.addClickListener(ClickEvent -> {
			//obtener elementos a eliminar
			Fijo[] tarifasEliminar;
			int size = tarifasLS.getSelectedItems().size();
			tarifasEliminar = new Fijo[size];
			tarifasEliminar = tarifasLS.getSelectedItems().toArray(tarifasEliminar);
			
			// Creamos Ventana Emergente para crear tarifa
			Window subWindow = new Window("Eliminar tarifa");
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(new MesesAdaptacion(tarifasEliminar));
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("600px");
			subWindow.setWidth("400px");
			subWindow.addCloseListener(Event -> {
				tarifas = iA.cargarTarifasFijo();
				tarifasLS.setItems(tarifas);
			});
			this.getUI().addWindow(subWindow);
		});

		// Botón Tarifa
		crearTarifaB.addClickListener(ClickEvent -> {

			// Creamos Ventana Emergente para crear tarifa
			Window subWindow = new Window("Crear tarifa");
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(new AltaModificarTarifaTelefono());
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("600px");
			subWindow.setWidth("400px");
			subWindow.addCloseListener(Event -> {
				tarifas = iA.cargarTarifasFijo();
				tarifasLS.setItems(tarifas);
			});
			this.getUI().addWindow(subWindow);
		});
	}
}