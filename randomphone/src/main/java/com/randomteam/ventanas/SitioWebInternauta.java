package com.randomteam.ventanas;

import java.util.spi.CurrencyNameProvider;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;

public class SitioWebInternauta extends sitioWebInternauta_ventana implements View {
	/*
	 * public class SitioWebInternauta extends SitioWeb { private Button login;
	 * public internauta vinternauta; public Login vLogin;
	 */
	public SitioWebInternauta() {

		MenuBar.Command muestracontacto = new MenuBar.Command() {
			public void menuSelected(MenuItem selectedItem) {
				if (cuerpoLy.getComponentCount() == 1) {
					cuerpoLy.removeAllComponents();
					cuerpoLy.addComponent(new Contacto());
				} else
					cuerpoLy.addComponent(new Contacto());
			}
		};

		MenuBar.Command muestraLogin = new MenuBar.Command() {

			@Override
			public void menuSelected(MenuItem selectedItem) {
				if (cuerpoLy.getComponentCount() == 1) {
					cuerpoLy.removeAllComponents();
					cuerpoLy.addComponent(new Login());
				} else
					cuerpoLy.addComponent(new Login());

			}
		};

		menu.getItems().get(1).setCommand(muestracontacto);
		// contacto.addItem("prueba", mycommand);
		menu.getItems().get(2).setCommand(muestraLogin);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}
}