package com.randomteam.ventanas;

import java.util.Vector;

import com.vaadin.data.HasValue;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.event.selection.MultiSelectionEvent;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.components.grid.MultiSelectionModel;

import DB.BD_Principal;
import DB.Cliente;
import DB.Incidencia;
import DB.iCliente;

public class MisIncidencias extends MisIncidencias_ventana {
	/*
	 * private Label incidenciasL; private TextField buscarTF; private Label
	 * estadoL; private Label fechaL; private Button ordenarEstadoB; private
	 * Button ordenarFechaB; private Incidencia incidenciasLs; private Button
	 * nuevaIncidenciaB; private TextArea historialTA; public MiCuenta
	 * vMiCuenta; public Vector<Incidencia> vIncidencia = new
	 * Vector<Incidencia>(); public NuevaReclamacion vNuevaReclamacion;
	 */
	private Incidencia iselec = null;
	iCliente c = new BD_Principal();
	Cliente cliente = (Cliente) VaadinService.getCurrentRequest().getWrappedSession().getAttribute("usuario");
	Incidencia[] incidencias = c.cargarIncidencias(cliente.getId());

	public MisIncidencias() {

		
		//Creamos TextField de Busqueda
		buscarTF.setPlaceholder("Asunto...");
		buscarTF.addValueChangeListener(this::onNameFilterTextChange);
		
		
		// Creamos Grid Incidencias
		incidenciasLS.addColumn(Incidencia::getAsunto).setCaption("Asunto").setSortable(true);
		incidenciasLS.addColumn(Incidencia::getEstado).setCaption("Estado").setSortable(true);
		incidenciasLS.addColumn(Incidencia::getFecha_alta).setCaption("Fecha Alta").setSortable(true);
		incidenciasLS.setItems(incidencias);
		incidenciasLS.addItemClickListener(event -> {
			iselec = event.getItem();
			// Creamos Ventana Emergente con los detalles de la reclamación
			// seleccionada en el Grid
			Window subWindow = new Window(iselec.getAsunto());
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(new Reclamacion(iselec));
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			this.getUI().addWindow(subWindow);
		});
		MultiSelectionModel<Incidencia> selectionModel = (MultiSelectionModel<Incidencia>) incidenciasLS
				.setSelectionMode(SelectionMode.MULTI);
		selectionModel.addMultiSelectionListener(event -> {
			eliminarB.setEnabled(event.getNewSelection().size() > 0);
		});

		// Botón Eliminar
		eliminarB.addClickListener(ClickEvent -> {
			Incidencia[] eliminar;
			int size = incidenciasLS.getSelectedItems().size();
			eliminar = new Incidencia[size];
			eliminar = incidenciasLS.getSelectedItems().toArray(eliminar);
			if (c.eliminarIncidencias(eliminar) == true) {
				Notification.show("Eliminadas Con exito!");
				incidencias = c.cargarIncidencias(cliente.getId());
				incidenciasLS.setItems(incidencias);

			} else
				Notification.show("Error! Ups algo fue mal!");
		});
		
		//Botón Nueva Reclamación
		nuevaIncidenciaB.addClickListener(ClickEvent ->{

		
			// Creamos Ventana Emergente para crear reclamación
			Window subWindow = new Window("Crear Incidencia");
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(new NuevaReclamacion());
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("600px");
			subWindow.setWidth("400px");
			subWindow.addCloseListener(Event ->{
				incidencias = c.cargarIncidencias(cliente.getId());
				incidenciasLS.setItems(incidencias);
			});
			this.getUI().addWindow(subWindow);
		});
	}
	
	 private void onNameFilterTextChange(HasValue.ValueChangeEvent<String> event) {
	        ListDataProvider<Incidencia> dataProvider = (ListDataProvider<Incidencia>) incidenciasLS.getDataProvider();
	        dataProvider.setFilter(Incidencia::getAsunto, s -> caseInsensitiveContains(s, event.getValue()));
	    }
	 
	 private Boolean caseInsensitiveContains(String where, String what) {
	        return where.toLowerCase().contains(what.toLowerCase());
	    }
}