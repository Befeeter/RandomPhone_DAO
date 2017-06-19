package com.randomteam.ventanas;

import java.util.Collection;

import com.vaadin.server.VaadinService;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Window;

import DB.BD_Principal;
import DB.Cliente;
import DB.Comercial;
import DB.Incidencia;
import DB.iComercial;

//public class NuevaReclamacionComercial extends NuevaReclamacion {
public class NuevaReclamacionComercial extends NuevaReclamacionComercial_ventana {
	/*private Label documentoL;
	private TextField documentoTF;
	public IncidenciasEnCurso vIncidenciasEnCurso;*/
	
	private Incidencia incidencia = new Incidencia();
	private iComercial iC = new BD_Principal();
	private Comercial cm =(Comercial) VaadinService.getCurrentRequest().getWrappedSession().getAttribute("comercial");
	private Cliente c = new Cliente();
	
	public NuevaReclamacionComercial(){
		enviarB.addClickListener(ClickEvent ->{
			c = iC.cargarDatosCliente(this.documentoTF.getValue());
			incidencia.setCliente(c);
			incidencia.setComercial(cm);
			incidencia.setAsunto(this.asuntoTF.getValue());
			incidencia.setTipo(this.tipoLS.getValue().toString());
			incidencia.setTexto(this.mensajeTA.getValue());
			
			if (iC.crearIncidenciaCliente(incidencia) == true){
				Notification.show("Incidencia creada con Exito!!");
				Collection<Window> win =this.getUI().getCurrent().getWindows();
				win.iterator().next().close();
				
			}
			else
				Notification.show("Ups! Error, algo fue mal");
		});
	}
}