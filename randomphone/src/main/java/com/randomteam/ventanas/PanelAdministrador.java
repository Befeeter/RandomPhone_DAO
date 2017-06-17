package com.randomteam.ventanas;

public class PanelAdministrador extends panelAdministrador_ventana {
	/*
	private Label tituloL;
	private Button serviciosB;
	private Button comercialesB;
	private Button listadoIncidenciasB;
	private Button listadoClientesB;
	public SitioWebAdministrador vSitioWebAdministrador;
	public Comerciales vComerciales;
	public Servicios vServicios;
	public ListadoIncidencias vListadoIncidencias;
	public ListadoClientes vListadoClientes;
	*/
	public PanelAdministrador () {
		serviciosB.addClickListener(ClickEvent -> {
			this.removeAllComponents();
			this.addComponent(new Servicios());
		});
		
		comercialesB.addClickListener(ClickEvent -> {
			this.removeAllComponents();
			this.addComponent(new Comerciales());
		});

		listadoIncidenciasB.addClickListener(ClickEvent -> {
			this.removeAllComponents();
			this.addComponent(new ListadoIncidencias());
		});
		
		listadoClientesB.addClickListener(ClickEvent -> {
			this.removeAllComponents();
			this.addComponent(new ListadoClientes());
		});
	}
}