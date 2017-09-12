package com.randomteam.ventanas;



import java.util.Iterator;

import com.vaadin.data.HasValue;
import com.vaadin.data.provider.ListDataProvider;

import com.vaadin.ui.Notification;
import com.vaadin.ui.Window;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.components.grid.MultiSelectionModel;

import DB.BD_Principal;
import DB.Canal;
import DB.Paquete;
import DB.iAdministrador;

public class CanalesTV extends CanalesTV_ventana {

	iAdministrador iA = new BD_Principal();
	Canal[] canales;

	public CanalesTV(Paquete paquete) {
		canales = iA.cargarCanalesTv();
		buscarTF.setPlaceholder("Nombre...");
		buscarTF.addValueChangeListener(this::onNameFilterTextChange2);
		// grid
		canalesLS.addColumn(Canal::getNombre).setCaption("Nombre").setSortable(true);
		canalesLS.setItems(canales);
		MultiSelectionModel<Canal> selectionModel2 = (MultiSelectionModel<Canal>) canalesLS
				.setSelectionMode(SelectionMode.MULTI);
		selectionModel2.addMultiSelectionListener(event -> {
			guardarB.setEnabled(event.getNewSelection().size() > 0);
		});
		
		guardarB.addClickListener(ClickEvent ->{
			Canal[] aAnadir;
			if (canalesLS.getSelectedItems().size() == 0)
				Notification.show("Error! Debe seleccionar al menos un canal");
			else{
				aAnadir = new Canal[canalesLS.getSelectedItems().size()];
				aAnadir = canalesLS.getSelectedItems().toArray(aAnadir);
				if (iA.anadirCanalesAPaquete(paquete, aAnadir))
					Notification.show("¡Canales Anhadidos correctamente!");
				else
					Notification.show("Error, algo fue mal!");
			}
			
			Iterator<Window> it = this.getUI().getWindows().iterator();
			it.next();
			it.next();
			it.next().close();
		});
	}
	
	private void onNameFilterTextChange2(HasValue.ValueChangeEvent<String> event) {
		ListDataProvider<Canal> dataProvider2 = (ListDataProvider<Canal>) canalesLS.getDataProvider();
		dataProvider2.setFilter(Canal::getNombre, s -> caseInsensitiveContains(s, event.getValue()));
	}

	private Boolean caseInsensitiveContains(String where, String what) {
		return where.toLowerCase().contains(what.toLowerCase());
	}
}