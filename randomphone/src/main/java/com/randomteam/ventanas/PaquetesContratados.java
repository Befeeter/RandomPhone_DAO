package com.randomteam.ventanas;
import java.util.Vector;

import com.vaadin.server.VaadinService;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import DB.BD_Principal;
import DB.Cliente;
import DB.Paquete;
import DB.iCliente;
import DB.iComercial;

public class PaquetesContratados extends PaquetesContratados_ventana {
	/*private Label tituloL;
	private PaquetePersonalizado paquetesLS;
	private Button canalesPersonalizadosB;
	public ModificarServicios vModificarServicios;
	public Vector<PaquetePersonalizado> vPaquetePersonalizado = new Vector<PaquetePersonalizado>();
	*/
	
	
	private Cliente c =(Cliente) VaadinService.getCurrentRequest().getWrappedSession().getAttribute("usuario");
	private iCliente iC = new BD_Principal();
	private Paquete[] paquetesContratados = iC.cargarPaquetesCliente(c.getId());
	public PaquetesContratados(){
	paquetesGrid.addColumn(Paquete::getNombre).setCaption("Nombre");
	paquetesGrid.setItems(paquetesContratados);
	
	
	
	canalesPersonalizadosB.addClickListener(ClickEvent -> {
		Window subWindow = new Window("Paquete Personalizado");
		VerticalLayout subContent = new VerticalLayout();
		subContent.addComponent(new PaquetePersonalizado());
		subWindow.setContent(subContent);
		subWindow.center();
		subWindow.setModal(true);
		this.getUI().addWindow(subWindow);
	});
	}
}