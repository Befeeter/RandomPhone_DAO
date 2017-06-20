package com.randomteam.ventanas;

import com.vaadin.server.VaadinService;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import DB.Comercial;

public class SitioWebComercial extends sitioWebCliente_ventana {
	public Comercial vComercial;
	public PanelAdministracionComercial vPanelAdministracionComercial;

	public SitioWebComercial() {
		Comercial comercial = (Comercial) VaadinService.getCurrentRequest().getWrappedSession().getAttribute("comercial");
		

		Comercial cm = (Comercial) VaadinService.getCurrentRequest().getWrappedSession().getAttribute("comercial");

		//this.addComponent(new MiCuenta(cm));
		this.addComponent(new MiCuentaComercial());
		
		MenuBar.Command pcomercial = new MenuBar.Command() {
			
			@Override
			public void menuSelected(MenuItem selectedItem) {
				getUI().setContent(new SitioWeb(comercial));
				
			}
		};
		
		MenuBar.Command pcontorl = new MenuBar.Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				getUI().setContent(new SitioWebComercial());
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
		menu.getItems().get(2).addItemBefore("Menu Principal Comercial", null, pcomercial, menu.getItems().get(2).getChildren().get(0));
		menu.getItems().get(2).getChildren().get(1).setCommand(logout);

	}

	private void logout() {
		this.getUI().setContent(new SitioWebInternauta());
	}
}
