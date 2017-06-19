package com.randomteam.ventanas;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinService;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import DB.Cliente;

public class ModificarServiciosCm extends ModificarServiciosCm_ventana {
	/*
	 * 
	
	private Button terminalesB;
	public MiCuentaComercial vMiCuentaComercial;
	public Terminales vTerminales;
	public PaquetesContratadosCm vPaquetesContratadosCm;
	 */
	private Cliente c =(Cliente) VaadinService.getCurrentRequest().getWrappedSession().getAttribute("cliente");
	
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
		
		
		this.terminalesB.addClickListener(ClickEvent ->{
			Window subWindow = new Window("Terminales");
			VerticalLayout subcontent = new VerticalLayout();
			subcontent.addComponent(new Terminales(c));
			subWindow.setContent(subcontent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("400px");
			subWindow.setWidth("400px");
			
			this.getUI().addWindow(subWindow);
		});
	}
}