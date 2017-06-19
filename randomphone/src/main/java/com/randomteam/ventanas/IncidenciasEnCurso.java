package com.randomteam.ventanas;

import java.util.Vector;

import javax.swing.Icon;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.renderers.ButtonRenderer;

import DB.BD_Incidencias;
import DB.BD_Principal;
import DB.Comercial;
import DB.Incidencia;
import DB.iComercial;

public class IncidenciasEnCurso extends IncidenciasEnCurso_ventana {
	/*
	 * private Label tituloL; private IncidenciaCurso incidenciasLS; private
	 * Button crearIncidenciaB; public PanelAdministracionComercial
	 * vPanelAdministracionComercial; public Vector<IncidenciaCurso>
	 * vIncidenciaCurso = new Vector<IncidenciaCurso>(); public
	 * NuevaReclamacionComercial vNuevaReclamacionComercial;
	 */

	iComercial iC = new BD_Principal();
	Comercial cm = (Comercial) VaadinService.getCurrentRequest().getWrappedSession().getAttribute("comercial");
	private Incidencia iselec = new Incidencia();
	Incidencia[] incidencias = null;

	public IncidenciasEnCurso() {

		incidencias = iC.cargarIncidenciasCm(cm.getId());
		incidenciasLS.addColumn(Incidencia::getAsunto).setCaption("Asunto").setSortable(true);
		incidenciasLS.addColumn(Incidencia::getEstado).setCaption("Estado").setSortable(true);
		incidenciasLS.addColumn(Incidencia -> "Completar", new ButtonRenderer(ClickEvent -> {
			iselec = (Incidencia) ClickEvent.getItem();
			iselec.setEstado("Completada");
			if (iC.editarEstadoIncidencia(iselec) == true) {
				Notification.show("Completada Con existo");
				incidencias = iC.cargarIncidenciasCm(cm.getId());
				incidenciasLS.setItems(incidencias);
			} else
				Notification.show("Error al actualizar Estado");

		}));
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
		incidenciasLS.setItems(incidencias);
		
		crearIncidenciaB.addClickListener(ClickEvent ->{
			// Creamos Ventana Emergente para crear reclamación a Cliente
			Window subWindow = new Window("Crear Incidencia");
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(new NuevaReclamacionComercial());
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("600px");
			subWindow.setWidth("400px");
			subWindow.addCloseListener(Event ->{
				incidencias = iC.cargarIncidenciasCm(cm.getId());
				incidenciasLS.setItems(incidencias);
			});
			this.getUI().addWindow(subWindow);
		});
	}
}