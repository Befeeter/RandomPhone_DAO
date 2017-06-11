package com.randomteam.ventanas;

import java.util.Vector;

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
			this.getUI().addWindow(subWindow);
		});
		MultiSelectionModel<Incidencia> selectionModel = (MultiSelectionModel<Incidencia>) incidenciasLS
				.setSelectionMode(SelectionMode.MULTI);
		selectionModel.addMultiSelectionListener(event -> {
//			MultiSelectionEvent<Incidencia> selection = null;
//			Notification.show(selection.getAddedSelection().size() + " items added, "
//					+ selection.getRemovedSelection().size() + " removed.");

			// Allow deleting only if there's any selected
			eliminarB.setEnabled(event.getNewSelection().size() > 0);
		});
		
		eliminarB.addClickListener(ClickEvent ->{
			Incidencia[] eliminar;
			int size=incidenciasLS.getSelectedItems().size();
			eliminar =new Incidencia[size];
			eliminar = incidenciasLS.getSelectedItems().toArray(eliminar);
			if (c.eliminarIncidencias(eliminar) == true){
				Notification.show("Eliminadas Con exito!");
				incidencias = c.cargarIncidencias(cliente.getId());
				incidenciasLS.setItems(incidencias);
				
				
			}
			else
				Notification.show("Error! Ups algo fue mal!");
		});
	}
}