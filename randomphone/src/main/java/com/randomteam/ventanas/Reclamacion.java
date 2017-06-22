package com.randomteam.ventanas;

import java.util.Collection;

import com.vaadin.server.VaadinService;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Window;

import DB.BD_Principal;
import DB.Cliente;
import DB.Comercial;
import DB.iCliente;
import DB.iComercial;

public class Reclamacion extends Reclamacion_ventana {
	/*
	 * private Label tituloL; private Label consultaL; private Text consultaT;
	 * private Label respuestaL; private Text respuestaT; private TextArea
	 * nuevaConsultaTA; private Button enviarB; public Incidencia vIncidencia;
	 */

	Cliente c = (Cliente) VaadinService.getCurrentRequest().getWrappedSession().getAttribute("usuario");
	iCliente iC = new BD_Principal();
	iComercial iCm = new BD_Principal();
	
	public Reclamacion(DB.Incidencia iselec) {
		this.tituloL.setValue(iselec.getAsunto());
		this.consultaT.setValue(iselec.getTexto());
		this.respuestaT.setValue(iselec.getRespuesta());
		
		if (VaadinService.getCurrentRequest().getWrappedSession().getAttributeNames().contains("comercial")){
			observacionesLY.setEnabled(true);
			observacionesLY.setVisible(true);
			this.observacioinesL.setValue(iselec.getObservaciones());
		}
		
		//Boton Enviar Comentario
		this.enviarB.addClickListener(ClickEvent ->{
			if (VaadinService.getCurrentRequest().getWrappedSession().getAttributeNames().contains("comercial")){
			iselec.setRespuesta(nuevaConsultaTA.getValue());
			if(iCm.responderIncidencia(iselec) == false)
				Notification.show("Ups Error algo fue mal");
			else
				Notification.show("Respuesta aplicada con Exito!");
			}
			else{
				iselec.setTexto(this.consultaT.getValue()+"\n "+nuevaConsultaTA.getValue());
				if(iC.actualizarIncidencia(iselec) == true)
					Notification.show("Actualización Aplicada con exito!");
				else
					Notification.show("UPS! Error algo fue mal");
			}
			Collection<Window> win =this.getUI().getCurrent().getWindows();
			win.iterator().next().close();
		});
		//Boton enviar Observacion
		this.observacionB.addClickListener(ClickEvent->{
			iselec.setObservaciones(observacionesTF.getValue());
			if (iCm.anadirObservacion(iselec) == true)
				Notification.show("Observación realizada correctamente");
			else
				Notification.show("Ups algo fue mal, pongase en contacto con el Administrador");
			Collection<Window> win = this.getUI().getCurrent().getWindows();
			win.iterator().next().close();
		});
	}

	public Informar enviarDatos() {
		throw new UnsupportedOperationException();
	}
}