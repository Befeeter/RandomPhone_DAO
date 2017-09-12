package com.randomteam.ventanas;
import java.util.Vector;

import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.components.grid.MultiSelectionModel;

import DB.BD_Principal;
import DB.Fibra;
import DB.iAdministrador;

public class TarifasFibra extends TarifasFibra_ventana {
	/*
	private Label tituloL;
	private Tarifa tarifasLS;
	private Label estadoL;
	private Button crearTarifaB;
	public Servicios vServicios;
	public Vector<Tarifa> vTarifa = new Vector<Tarifa>();
	public ModificarTarifaFibra vModificarTarifaFibra;
	*/
	iAdministrador iA = new BD_Principal();
	Fibra[] tarifas;

	public TarifasFibra() {
		tarifas = iA.cargarTarifasFibra();
		// grid
		tarifasLS.addColumn(Fibra::getNombre).setCaption("Nombre").setSortable(true);
		tarifasLS.addColumn(Fibra::getEstado).setCaption("Estado").setSortable(true);
		tarifasLS.setItems(tarifas);

		tarifasLS.addItemClickListener(event -> {
			// iselec = event.getItem();

			// Creamos Ventana Emergente con los detalles de la reclamación
			// seleccionada en el Grid
			Window subWindow = new Window("Editar tarifa");
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(new ModificarTarifaFibra(event.getItem()));
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("600px");
			subWindow.setWidth("600px");
			subWindow.addCloseListener(Event -> {
				tarifas = iA.cargarTarifasFibra();
				tarifasLS.setItems(tarifas);
			});
			this.getUI().addWindow(subWindow);
		});
		MultiSelectionModel<Fibra> selectionModel = (MultiSelectionModel<Fibra>) tarifasLS
				.setSelectionMode(SelectionMode.MULTI);
		selectionModel.addMultiSelectionListener(event -> {
			eliminarB.setEnabled(event.getNewSelection().size() > 0);
		});

		// Botón Eliminar
		eliminarB.addClickListener(ClickEvent -> {
			//obtener elementos a eliminar
			Fibra[] tarifasEliminar;
			int size = tarifasLS.getSelectedItems().size();
			tarifasEliminar = new Fibra[size];
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
				tarifas = iA.cargarTarifasFibra();
				tarifasLS.setItems(tarifas);
			});
			this.getUI().addWindow(subWindow);
		});

		// Botón Tarifa
		crearTarifaB.addClickListener(ClickEvent -> {

			// Creamos Ventana Emergente para crear tarifa
			Window subWindow = new Window("Crear tarifa");
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(new ModificarTarifaFibra());
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("600px");
			subWindow.setWidth("600px");
			subWindow.addCloseListener(Event -> {
				tarifas = iA.cargarTarifasFibra();
				tarifasLS.setItems(tarifas);
			});
			this.getUI().addWindow(subWindow);
		});
	}
}