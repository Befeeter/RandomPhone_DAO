package com.randomteam.ventanas;

import com.vaadin.server.VaadinService;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;

import DB.Administrador;

public class SitioWebAdministrador extends sitioWebCliente_ventana {
	public Administrador vAdministrador;
	public PanelAdministrador vPanelAdministrador;
		
	public SitioWebAdministrador () {
		int idAdministrador = (int) VaadinService.getCurrentRequest().getWrappedSession().getAttribute("administrador");

		this.addComponent(new PanelAdministrador());
		
		MenuBar.Command padmin = new MenuBar.Command() {
			
			@Override
			public void menuSelected(MenuItem selectedItem) {
				getUI().setContent(new SitioWebAdministrador());
				
			}
		};
		
		MenuBar.Command pcontorl = new MenuBar.Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				getUI().setContent(new SitioWebAdministrador());
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
		menu.getItems().get(2).addItemBefore("Panel Administrador", null, padmin, menu.getItems().get(2).getChildren().get(0));
		menu.getItems().get(2).getChildren().get(1).setCommand(logout);
	}

	private void logout() {
		this.getUI().setContent(new SitioWebInternauta());
	}
}