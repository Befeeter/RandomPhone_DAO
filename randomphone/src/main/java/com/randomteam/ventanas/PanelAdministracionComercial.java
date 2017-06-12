package com.randomteam.ventanas;

import com.vaadin.server.VaadinService;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.MenuBar.MenuItem;

public class PanelAdministracionComercial extends PanelAdministracionComercial_ventana{
	/*private Label tituloL;
	private Button altaClienteB;
	private Button modificarDatosClienteB;
	private Button incidenciasEnCurso;
	public SitioWebComercial vSitioWebComercial;
	public IncidenciasEnCurso vIncidenciasEnCurso;
	public AltaNuevoCliente vAltaNuevoCliente;
	public ModificarDatosCliente vModificarDatosCliente;
	*/
	
	
	public PanelAdministracionComercial(){
		
		altaClienteB.addClickListener(ClickEvent->{
			this.removeAllComponents();
			this.addComponent(new AltaNuevoCliente());
		});
		
		modificarDatosCliente.addClickListener(ClickEvent ->{
			// Creamos Ventana Emergente para Cambiar a vista UsuarioComercial
			Window subWindow = new Window("Modificar Datos Cliente");
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(new ModificarDatosCliente());
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("330px");
			subWindow.setWidth("400px");
			this.getUI().addWindow(subWindow);
		});
		
	}
	

}