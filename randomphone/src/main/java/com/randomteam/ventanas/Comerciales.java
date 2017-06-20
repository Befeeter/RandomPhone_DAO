package com.randomteam.ventanas;

import com.vaadin.data.HasValue;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.components.grid.MultiSelectionModel;

import DB.BD_Principal;
import DB.Comercial;
import DB.Fibra;
import DB.iAdministrador;

public class Comerciales extends Comerciales_ventana{
	/*
	private Label tituloL;
	private TextField buscarTF;
	private ComercialE comercialesLS;
	private Label incidenciasL;
	private Button crearComercialB;
	public PanelAdministrador vPanelAdministrador;
	public ComercialE vComercialE;
	public IncidenciasActivas vIncidenciasActivas;
	public AltaModificarComercial vAltaModificarComercial;
	*/
	iAdministrador iA = new BD_Principal();
	Comercial[] comerciales = iA.cargarComerciales();

	public Comerciales() {
		// Busqueda
		buscarTF.setPlaceholder("Nombre...");
		buscarTF.addValueChangeListener(this::onNameFilterTextChange);

		// Creamos Grid comerciales
		comercialesLS.addColumn(Comercial::getNombre).setCaption("Nombre").setSortable(true);
		comercialesLS.addColumn(Comercial::getNumincidenciasActivas).setCaption("Incidencias").setSortable(true);
		comercialesLS.setItems(comerciales);
		comercialesLS.addItemClickListener(event -> {
			// Creamos Ventana Emergente
			// seleccionada en el Grid
			Window subWindow = new Window("Editar comercial");
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(new AltaModificarComercial(event.getItem()));
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("600px");
			subWindow.setWidth("600px");
			subWindow.addCloseListener(Event -> {
				comerciales = iA.cargarComerciales();
				comercialesLS.setItems(comerciales);
			});
			this.getUI().addWindow(subWindow);
		});
		MultiSelectionModel<Comercial> selectionModel = (MultiSelectionModel<Comercial>) comercialesLS
				.setSelectionMode(SelectionMode.MULTI);
		selectionModel.addMultiSelectionListener(event -> {
			eliminarB.setEnabled(event.getNewSelection().size() > 0);
		});

		// Botón Eliminar
		eliminarB.addClickListener(ClickEvent -> {
			//obtener elementos a eliminar
			Comercial[] comercialesEliminar;
			int size = comercialesLS.getSelectedItems().size();
			comercialesEliminar = new Comercial[size];
			comercialesEliminar = comercialesLS.getSelectedItems().toArray(comercialesEliminar);
			//
			boolean correcto = true;
			// Para cada tarifa seleccionada la elimino

			for (Comercial comercial : comercialesEliminar) {
				if (!iA.eliminarComercial(comercial))
					correcto = false;
			}
			if (correcto) {
				Notification.show("Eliminados Con exito!");
			} else
				Notification.show("Error! Ups algo fue mal!");
			
		});

		// Botón crear
		crearComercialB.addClickListener(ClickEvent -> {

			// Creamos Ventana Emergente para crear comercial
			Window subWindow = new Window("Crear comercial");
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(new AltaModificarComercial());
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("600px");
			subWindow.setWidth("600px");
			subWindow.addCloseListener(Event -> {
				comerciales = iA.cargarComerciales();
				comercialesLS.setItems(comerciales);
			});
			this.getUI().addWindow(subWindow);
		});

	}

	private void onNameFilterTextChange(HasValue.ValueChangeEvent<String> event) {
		ListDataProvider<Comercial> dataProvider = (ListDataProvider<Comercial>) comercialesLS.getDataProvider();
		dataProvider.setFilter(Comercial::getNombre, s -> caseInsensitiveContains(s, event.getValue()));
	}

	private Boolean caseInsensitiveContains(String where, String what) {
		return where.toLowerCase().contains(what.toLowerCase());
	}
}