package com.randomteam.ventanas;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Label;

public class AsignarComercial extends AsignarComercial_ventana {
	
	//Label busquedaL;
	
	public AsignarComercial(){
		
		
		 
		 this.busquedaL.setContentMode(ContentMode.HTML);
		 this.busquedaL.setValue(VaadinIcons.SEARCH.getHtml());
		
	}
	/*
	private Label tituloL;
	private TextField buscarTF;
	private Comercial comercialesLS;
	private Button aceptarB;
	public ListadoIncidencias vListadoIncidencias;

	public informar enviarDatos() {
		throw new UnsupportedOperationException();
	}
	*/

}