package com.randomteam.ventanas;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.ContentMode;

public class ModificarServiciosCm extends ModificarServiciosCm_ventana {
	/*
	 * 
	
	private Button terminalesB;
	public MiCuentaComercial vMiCuentaComercial;
	public Terminales vTerminales;
	public PaquetesContratadosCm vPaquetesContratadosCm;
	 */
	
	public ModificarServiciosCm(){
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
}