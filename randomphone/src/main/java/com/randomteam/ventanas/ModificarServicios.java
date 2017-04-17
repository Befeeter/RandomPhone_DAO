package com.randomteam.ventanas;
import java.util.Vector;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.ContentMode;

public class ModificarServicios extends ModificarServicios_ventana {
	/*
	private Label serviciosL;
	private img movilI;
	private TarifaE movilLS;
	private img telefonoI;
	private TarifaE telefonoLS;
	private img fibraI;
	private TarifaE fibraLS;
	private img televisionI;
	private TarifaE televisionLS;
	private Button televisionB;
	private Button aceptarB;
	public MiCuenta vMiCuenta;
	public Vector<TarifaE> vTarifaE = new Vector<TarifaE>();
	public PaquetesContratados vPaquetesContratados;
	*/

	public ModificarServicios(){
		this.movilL.setContentMode(ContentMode.HTML);
		this.movilL.setValue(VaadinIcons.PHONE.getHtml());
		this.fijoL.setContentMode(ContentMode.HTML);
		this.fijoL.setValue(VaadinIcons.PHONE_LANDLINE.getHtml());
		this.fibraL.setContentMode(ContentMode.HTML);
		this.fibraL.setValue(VaadinIcons.BUILDING.getHtml());
		this.televisionL.setContentMode(ContentMode.HTML);
		this.televisionL.setValue(VaadinIcons.MOVIE.getHtml());
		this.televisionB.setContentMode(ContentMode.HTML);
		this.televisionB.setValue(VaadinIcons.MODAL_LIST.getHtml());
	}
	
	public Informar enviarDatos() {
		throw new UnsupportedOperationException();
	}
}