package com.randomteam.ventanas;

import java.util.Collection;

import org.orm.PersistentException;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Window;

import DB.BD_Principal;
import DB.iInternauta;
import DB.Incidencia;

public class SolicitarLlamada extends solicitarLlamada_ventana{
	/*private Label tituloL;
	private Label descripcionL;
	private TextField telefonoTF;
	private Button enviarB;
	public Oferta vOferta;*/

	iInternauta iIn = new BD_Principal();
	private int telefono;
	private Incidencia solCall = new Incidencia();
	
	public SolicitarLlamada (String asunto){
		enviarB.setClickShortcut(KeyCode.ENTER);
		enviarB.addClickListener(ClickEvent->{
		telefono = Integer.parseInt(telefonoTF.getValue());
		solCall.setTelefono(telefono);
		solCall.setTipo("Informacion");
		solCall.setAusnto(asunto);
		solCall.setTexto("");
		solCall.setObservaciones("");
		solCall.setRespuesta("");
		try {
			if (iIn.crearIncidencia(solCall)){
				Notification.show("Llamada registrada con Exito!");
				Collection<Window> win =this.getUI().getCurrent().getWindows();
				win.iterator().next().close();
			}
			else
				Notification.show("Ups!! Algo fue mal, lo sentimos, muerase");
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		});
		
		
	}
}