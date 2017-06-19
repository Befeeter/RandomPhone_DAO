package com.randomteam.ventanas;

import java.util.Vector;

import com.vaadin.server.VaadinService;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;

public class SitioWeb extends sitioWeb_ventana{
	/*private img bannerI;
	private Button serviciosB;
	private Button contactoB;
	private Oferta ofertasLS;
	public Vector<Oferta> vOferta = new Vector<Oferta>();
	public Servicio vServicio;
	public Contacto vContacto;
	*/
	public SitioWeb(){
		
	}
	public SitioWeb(DB.Comercial comercial){
		MenuBar.Command pcontorl = new MenuBar.Command(){
			@Override
			public void menuSelected(MenuItem selectedItem){
				getUI().setContent(new SitioWeb(comercial));
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
		
		this.addComponent(new PanelAdministracionComercial());

	}
	
	public SitioWeb(DB.Administrador administrador){
		MenuBar.Command pcontorl = new MenuBar.Command(){
			@Override
			public void menuSelected(MenuItem selectedItem){
				getUI().setContent(new SitioWeb(administrador));
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
		
		this.addComponent(new PanelAdministrador());

	}
	private void logout(){
		this.getUI().setContent(new SitioWebInternauta());
	}
	
}