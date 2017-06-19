package com.randomteam.ventanas;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import DB.BD_Clientes;
import DB.BD_Principal;
import DB.Movil;
import DB.iComercial;

public class AltaNuevoCliente extends AltaNuevoCliente_ventana {
	/*private Label tituloL;
	private Label nombreL;
	private TextField nombreTF;
	private Label apellidoL;
	private TextField apellidoTF;
	private Label documentoL;
	private TextField documentoTF;
	private Label emailL;
	private TextField emailTF;
	private Label telefonoL;
	private TextField telefonoTF;
	private Label tituloServicioL;
	private img movilI;
	private TarifaE movilLS;
	private img telefonoI;
	private TarifaE telefonoLS;
	private img fibraI;
	private TarifaE fibraLS;
	private img televisionI;
	private TarifaE televisionLS;
	private Button terminalesB;
	private Button darAltaB;
	public PanelAdministracionComercial vPanelAdministracionComercial;
	public TarifaE vTarifaE;
	public Terminales vTerminales;
*/
	/*public Informar enviarDatos() {
		throw new UnsupportedOperationException();
	}
	*/
	private iComercial iC = new BD_Principal();
	//cargar Servicios Disponibles
	//private Movil[] tMovil = iC.cargarServiciosDisp();
	
	public AltaNuevoCliente(){
		this.movilL.setContentMode(ContentMode.HTML);
		this.movilL.setValue(VaadinIcons.PHONE.getHtml());
		this.fijoL.setContentMode(ContentMode.HTML);
		this.fijoL.setValue(VaadinIcons.PHONE_LANDLINE.getHtml());
		this.fibraL.setContentMode(ContentMode.HTML);
		this.fibraL.setValue(VaadinIcons.BUILDING.getHtml());
		this.televisionL.setContentMode(ContentMode.HTML);
		this.televisionL.setValue(VaadinIcons.MOVIE.getHtml());
		
		
		
		
		
		//Ventana emergente para establecer Terminales
		terminalesB.addClickListener(ClickEvent->{
			Window subWindow = new Window("Terminales");
			VerticalLayout subcontent = new VerticalLayout();
			subcontent.addComponent(new Terminales());
			subWindow.setContent(subcontent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("400px");
			subWindow.setWidth("400px");
			
			this.getUI().addWindow(subWindow);
		});
		
	}

	public boolean comprobarDocumento(Object string_documento) {
		throw new UnsupportedOperationException();
	}
}