package com.randomteam.ventanas;

import java.util.ArrayList;
import java.util.spi.CurrencyNameProvider;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.renderers.ImageRenderer;

import DB.BD_Principal;
import DB.Fibra;
import DB.Fijo;
import DB.Movil;
import DB.Servicio;
import DB.Television;
import DB.iInternauta;

public class SitioWebInternauta extends sitioWebInternauta_ventana implements View {
	/*
	 * public class SitioWebInternauta extends SitioWeb { private Button login;
	 * public internauta vinternauta; public Login vLogin;
	 */
	private iInternauta iI = new BD_Principal();
	private Servicio[] serviciosDisp = null;

	public SitioWebInternauta() {
		Page.getCurrent().getStyles().add(".form-template{overflow: hidden !important;}");
		serviciosDisp = iI.cargarOfertas();
		Column<Servicio, ThemeResource> imageColum = ofertasGrid.addColumn(
				p -> new ThemeResource("imagenes/" + p.getNombre().substring(0, 4) + ".png"), new ImageRenderer());
		ofertasGrid.addColumn(Servicio::getNombre).setCaption("Nombre");
		ofertasGrid.addColumn(Servicio::getPrecio).setCaption("Precio");
		Column<Servicio, ThemeResource> llamada = ofertasGrid.addColumn(p -> new ThemeResource("imagenes/Llam.png"),
				new ImageRenderer());
		ofertasGrid.addItemClickListener(event -> {
			Window subWindow = new Window("Solicitar LLamada");
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(new SolicitarLlamada());
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			this.getUI().addWindow(subWindow);
		});
		ofertasGrid.setStyleName("ofertas_grid");
		ofertasGrid.setItems(serviciosDisp);
		ofertasGrid.setSizeFull();

		MenuBar.Command ofertasMovil = new MenuBar.Command() {
			public void menuSelected(MenuItem selectedItem) {
				ArrayList<Servicio> servMovil = new ArrayList<>();
				serviciosDisp = iI.cargarOfertas(new Movil());
				ofertasGrid.setItems(serviciosDisp);
			}
		};

		MenuBar.Command ofertasFibra = new MenuBar.Command() {
			public void menuSelected(MenuItem selectedItem) {
				ArrayList<Servicio> servMovil = new ArrayList<>();
				serviciosDisp = iI.cargarOfertas(new Fibra());
				ofertasGrid.setItems(serviciosDisp);
			}
		};

		MenuBar.Command ofertasFijo = new MenuBar.Command() {
			public void menuSelected(MenuItem selectedItem) {
				ArrayList<Servicio> servMovil = new ArrayList<>();
				serviciosDisp = iI.cargarOfertas(new Fijo());
				ofertasGrid.setItems(serviciosDisp);
			}
		};

		MenuBar.Command ofertasTelevision = new MenuBar.Command() {
			public void menuSelected(MenuItem selectedItem) {
				ArrayList<Servicio> servMovil = new ArrayList<>();
				serviciosDisp = iI.cargarOfertas(new Television());
				ofertasGrid.setItems(serviciosDisp);
			}
		};

		MenuBar.Command muestracontacto = new MenuBar.Command() {
			public void menuSelected(MenuItem selectedItem) {
				Window subWindow = new Window("Contacto");
				VerticalLayout subContent = new VerticalLayout();
				subContent.addComponent(new Contacto());
				subWindow.setContent(subContent);
				subWindow.center();
				subWindow.setModal(true);
				subWindow.setHeight("800px");
				subWindow.setWidth("400px");
				//Popout Ventana COntacto desde Menú				
				getUI().addWindow(subWindow);
			}
		};

//		MenuBar.Command muestraLogin = new MenuBar.Command() {
//
//			@Override
//			public void menuSelected(MenuItem selectedItem) {
//				if (cuerpoLy.getComponentCount() == 1) {
//					cuerpoLy.removeAllComponents();
//					cuerpoLy.addComponent(new Login());
//				} else
//					cuerpoLy.addComponent(new Login());
//
//			}
//		};
		
		MenuBar.Command muestraLogin = new MenuBar.Command() {

			@Override
			public void menuSelected(MenuItem selectedItem) {
				Window subWindow = new Window("Login");
				VerticalLayout subContent = new VerticalLayout();
				subContent.addComponent(new Login());
				subWindow.setContent(subContent);
				subWindow.center();
				subWindow.setModal(true);
				subWindow.setHeight("450px");
				subWindow.setWidth("500px");
				//Popout Ventana COntacto desde Menú				
				getUI().addWindow(subWindow);
			}
		};

		menu.getItems().get(0).getChildren().get(0).setCommand(ofertasMovil);
		menu.getItems().get(0).getChildren().get(1).setCommand(ofertasFijo);
		menu.getItems().get(0).getChildren().get(2).setCommand(ofertasTelevision);
		menu.getItems().get(0).getChildren().get(3).setCommand(ofertasFibra);
		menu.getItems().get(1).setCommand(muestracontacto);
		// contacto.addItem("prueba", mycommand);
		menu.getItems().get(2).setCommand(muestraLogin);

	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}
}