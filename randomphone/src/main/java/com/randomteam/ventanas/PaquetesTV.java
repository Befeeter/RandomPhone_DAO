package com.randomteam.ventanas;
import java.util.Vector;

import com.vaadin.data.HasValue;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.components.grid.MultiSelectionModel;

import DB.BD_Principal;
import DB.Paquete;
import DB.iComercial;

public class PaquetesTV extends PaquetesTV_ventana {
	/*
	private Label tituloL;
	private TextField buscarTF;
	private Paquete paqueteLS;
	private Button guardarB;
	public PaquetesContratadosCm vPaquetesContratadosCm;
	public Vector<Paquete> vPaquete = new Vector<Paquete>();
	*/
/*
	public Informar enviarDatos() {
		throw new UnsupportedOperationException();
	}*/
	iComercial iCm = new BD_Principal();
	private Paquete[] paquetestv = iCm.cargarPaquetesTV();
	public PaquetesTV(){
		
		buscarTF.setPlaceholder("Nombre...");
		buscarTF.addValueChangeListener(this::onNameFilterTextChange);
		paquetesLS.addColumn(Paquete::getNombre).setCaption("Nombre").setSortable(true);
		paquetesLS.setItems(paquetestv);
		MultiSelectionModel<Paquete> selectionModel = (MultiSelectionModel<Paquete>) paquetesLS
				.setSelectionMode(SelectionMode.MULTI);
	}
	
	private void onNameFilterTextChange(HasValue.ValueChangeEvent<String> event) {
		ListDataProvider<Paquete> dataProvider = (ListDataProvider<Paquete>) paquetesLS.getDataProvider();
		dataProvider.setFilter(Paquete::getNombre, s -> caseInsensitiveContains(s, event.getValue()));
	}
	private Boolean caseInsensitiveContains(String where, String what) {
		return where.toLowerCase().contains(what.toLowerCase());
	}
}
