package com.randomteam.ventanas;

import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import DB.Movil;

public class Servicios extends servicios_ventana {
	/*
	private Button movilB;
	private Button telefonoB;
	private Button fibraB;
	private Button televisionB;
	public PanelAdministrador vPanelAdministrador;
	public TarifasFibra vTarifasFibra;
	public TarifasTelevision vTarifasTelevision;
	*/
	
	public Servicios () {
		movilB.addClickListener(ClickEvent -> {
			/*this.removeAllComponents();
			this.addComponent(new TarifasMovil());*/
			
			// Creamos Ventana Emergente para crear tarifa
			Window subWindow = new Window("Tarifas Movil");
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(new TarifasMovil());
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("700px");
			subWindow.setWidth("600px");
			this.getUI().addWindow(subWindow);
		});
		
		telefonoB.addClickListener(ClickEvent -> {
			this.removeAllComponents();
			this.addComponent(new TarifasTelefono());
		});

		fibraB.addClickListener(ClickEvent -> {
			this.removeAllComponents();
			this.addComponent(new TarifasFibra());
		});
		
		televisionB.addClickListener(ClickEvent -> {
			this.removeAllComponents();
			this.addComponent(new TarifasTelevision());
		});
	}
}