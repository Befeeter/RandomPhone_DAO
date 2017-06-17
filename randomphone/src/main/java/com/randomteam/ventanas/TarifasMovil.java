package com.randomteam.ventanas;

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

	public TarifasMovil() {
		Movil [] tarifas = iA.cargarTarifasMovil();
		// grid
		/*tarifasLS.addColumn(tarifa -> "Delete",
			      new ButtonRenderer(clickEvent -> {
			          tarifasLS.remove(clickEvent.getItem());
			          tarifasLS.setItems(tarifas);
			    }));
		tarifasLS.addComponentColumn(movil -> {
		      Button button = new Button("Click me!");
		      button.addClickListener(click ->
		            Notification.show("Clicked: " + tarifa.toString()));
		      return button;
		});*/
		tarifasLS.addColumn(Movil::getNombre).setCaption("Nombre").setSortable(true);
		tarifasLS.addColumn(Movil::isEstado).setCaption("Estado").setSortable(true);
		tarifasLS.setItems(tarifas);

		/*tarifasLS.addItemClickListener(event -> {
			//iselec = event.getItem();
			
			// Creamos Ventana Emergente con los detalles de la reclamación
			// seleccionada en el Grid
			Window subWindow = new Window("Asunto");
			VerticalLayout subContent = new VerticalLayout();
			//subContent.addComponent(new Reclamacion(iselec));
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			this.getUI().addWindow(subWindow);
		});*/
		MultiSelectionModel<Movil> selectionModel = (MultiSelectionModel<Movil>) tarifasLS.setSelectionMode(SelectionMode.MULTI);
		selectionModel.addMultiSelectionListener(event -> {
			eliminarB.setEnabled(event.getNewSelection().size() > 0);
		});
	}
}