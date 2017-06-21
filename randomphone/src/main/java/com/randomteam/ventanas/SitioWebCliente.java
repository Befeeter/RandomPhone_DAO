package com.randomteam.ventanas;

import com.vaadin.server.VaadinService;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.MenuBar.MenuItem;

public class SitioWebCliente extends sitioWebCliente_ventana {
/*
public class SitioWebCliente extends SitioWeb {
	private Button miCuenta;
	public Cliente vCliente;
	public MiCuenta vMiCuenta;*/
	
	public SitioWebCliente() {
		this.addComponent(new MiCuenta());
		
		
		
		
		MenuBar.Command muestracontacto = new MenuBar.Command() {
			public void menuSelected(MenuItem selectedItem) {
				Window subWindow = new Window("Contacto");
				VerticalLayout subContent = new VerticalLayout();
				subContent.addComponent(new NuevaReclamacion());
				subWindow.setContent(subContent);
				subWindow.center();
				subWindow.setModal(true);
				subWindow.setHeight("600px");
				subWindow.setWidth("400px");
				//Popout Ventana COntacto desde Menú				
				getUI().addWindow(subWindow);
			}
		};
		
		MenuBar.Command pcontorl = new MenuBar.Command(){
			@Override
			public void menuSelected(MenuItem selectedItem){
				getUI().setContent(new SitioWebCliente());
			}
		};
		
		MenuBar.Command logout = new MenuBar.Command() {

			@Override
			public void menuSelected(MenuItem selectedItem) {
			VaadinService.getCurrentRequest().getWrappedSession().invalidate();
			logout();
			}
		};
		
		menu.getItems().get(0).setCommand(pcontorl);
		menu.getItems().get(1).setCommand(muestracontacto);
		menu.getItems().get(2).getChildren().get(0).setCommand(logout);
		
	}
	
	private void logout(){
		this.getUI().setContent(new SitioWebInternauta());
	}
}