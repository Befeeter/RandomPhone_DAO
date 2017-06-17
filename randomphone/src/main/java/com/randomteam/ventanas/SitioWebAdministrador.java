package com.randomteam.ventanas;

import com.vaadin.server.VaadinService;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;

public class SitioWebAdministrador extends sitioWebCliente_ventana {
	public Administrador vAdministrador;
	public PanelAdministrador vPanelAdministrador;
		
	public SitioWebAdministrador() {
		this.addComponent(new PanelAdministrador());
		
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
		menu.getItems().get(2).getChildren().get(0).setCommand(logout);
		
	}
	
	private void logout(){
		this.getUI().setContent(new SitioWebInternauta());
	}
}