package com.randomteam.ventanas;

import java.util.Iterator;

import com.vaadin.data.HasValue;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.sass.internal.selector.SimpleSelector;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.components.grid.MultiSelectionModel;

import DB.BD_Principal;
import DB.Comercial;
import DB.Incidencia;
import DB.iAdministrador;

public class AsignarComercial extends AsignarComercial_ventana {

	// Label busquedaL;

	iAdministrador iA = new BD_Principal();
	Comercial[] comerciales = iA.cargarComerciales();
	private Comercial[] comercialesA;

	public AsignarComercial() {

		this.busquedaL.setContentMode(ContentMode.HTML);
		this.busquedaL.setValue(VaadinIcons.SEARCH.getHtml());

	}
	/*
	 * private Label tituloL; private TextField buscarTF; private Comercial
	 * comercialesLS; private Button aceptarB; public ListadoIncidencias
	 * vListadoIncidencias;
	 * 
	 * public informar enviarDatos() { throw new
	 * UnsupportedOperationException(); }
	 */

	public AsignarComercial(Incidencia[] incidenciasAsignarCiber, Incidencia[] incidenciasAsignarCli,
			Incidencia[] incidenciasAsig) {
		// Busqueda
		buscarTF.setPlaceholder("Asunto...");
		buscarTF.addValueChangeListener(this::onNameFilterTextChange);

		comercialesLS.addColumn(Comercial::getNombre).setCaption("Nombre").setSortable(true);
		comercialesLS.addColumn(Comercial::getNumincidenciasActivas).setCaption("Incidencias activas")
				.setSortable(true);
		comercialesLS.setItems(comerciales);
		MultiSelectionModel<Comercial> selectionModel = (MultiSelectionModel<Comercial>) comercialesLS
				.setSelectionMode(SelectionMode.MULTI);
		selectionModel.addMultiSelectionListener(event -> {
			submit.setEnabled(event.getNewSelection().size() == 1);
		});

		// Botón submit
		submit.addClickListener(ClickEvent -> {
			boolean correcto = false;
			int size = comercialesLS.getSelectedItems().size();
			comercialesA = new Comercial[size];
			comercialesA = comercialesLS.getSelectedItems().toArray(comercialesA);
			
			for (int i = 0; i < incidenciasAsignarCiber.length; i++) {
				correcto = iA.asignarIncidencia(incidenciasAsignarCiber[i], comercialesA[0]);
			}
			for (int i = 0; i < incidenciasAsignarCli.length; i++) {
				correcto = iA.asignarIncidencia(incidenciasAsignarCli[i], comercialesA[0]);
			}
			for (int i = 0; i < incidenciasAsig.length; i++) {
				correcto = iA.asignarIncidencia(incidenciasAsig[i], comercialesA[0]);
			}

			if (correcto) {
				Notification.show("Asignadas Con exito!");
				Iterator<Window> it = this.getUI().getWindows().iterator();
				it.next().close();
			} else
				Notification.show("Error! Ups algo fue mal!");
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