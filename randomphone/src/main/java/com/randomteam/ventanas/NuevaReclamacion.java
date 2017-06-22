package com.randomteam.ventanas;

import java.util.Collection;

import com.vaadin.server.VaadinService;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Window;

import DB.BD_Principal;
import DB.Cliente;
import DB.Comercial;
import DB.Incidencia;
import DB.iCliente;

public class NuevaReclamacion extends NuevaReclamacion_ventana {
	/*
	 * private Label asuntoL; private TextField asuntoTF; private Label tipoL;
	 * private List tipoLS; private Label mensajeL; private TextArea mensajeTA;
	 * private Button enviarB; public MisIncidencias vMisIncidencias;
	 * 
	 * public Informar enviarDatos() { throw new
	 * UnsupportedOperationException(); }
	 */

	Incidencia incidencia = new Incidencia();
	Cliente c = (Cliente) VaadinService.getCurrentRequest().getWrappedSession().getAttribute("usuario");
	iCliente iC = new BD_Principal();

	public NuevaReclamacion() {

		enviarB.addClickListener(ClickEvent -> {
			if (!(asuntoTF.isEmpty() || mensajeTA.isEmpty())) {
				incidencia.setAsunto(this.asuntoTF.getValue());
				incidencia.setTipo(tipoLS.getValue().toString());
				incidencia.setTexto(this.mensajeTA.getValue());
				incidencia.setCliente(c);
				incidencia.setIsCliente(true);
				incidencia.setComercial(new Comercial());
				incidencia.getComercial().setId(0);

				if (iC.crearIncidencia(incidencia) == true) {
					Notification.show("Incidencia creada con Exito!!");
					Collection<Window> win = this.getUI().getCurrent().getWindows();
					win.iterator().next().close();

				} else
					Notification.show("Ups! Error, algo fue mal");
			} else {
				Notification.show("Algún campo vacio o incorrecto!");
			}
		});

	}

}