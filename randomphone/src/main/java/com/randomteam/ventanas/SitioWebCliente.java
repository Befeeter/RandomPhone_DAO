package com.randomteam.ventanas;

import com.vaadin.server.VaadinService;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;

public class SitioWebCliente extends sitioWebCliente_ventana {
/*
public class SitioWebCliente extends SitioWeb {
	private Button miCuenta;
	public Cliente vCliente;
	public MiCuenta vMiCuenta;*/
	
	public SitioWebCliente() {
		this.addComponent(new MiCuenta());
		
		
		
		
		
		
		MenuBar.Command logout = new MenuBar.Command() {

			@Override
			public void menuSelected(MenuItem selectedItem) {
			VaadinService.getCurrentRequest().getWrappedSession().invalidate();
			logout();
			}
		};
		
		menu.getItems().get(2).getChildren().get(0).setCommand(logout);
		
	}
	
	private void logout(){
		this.getUI().setContent(new SitioWebInternauta());
	}
}