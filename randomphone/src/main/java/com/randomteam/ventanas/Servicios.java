package com.randomteam.ventanas;

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
			this.removeAllComponents();
			this.addComponent(new TarifasMovil());
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