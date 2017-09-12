package com.randomteam.ventanas;

import java.util.ArrayList;

import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Notification;

import DB.BD_Principal;
import DB.Cliente;
import DB.Terminal;
import DB.TerminalDAO;
import DB.iComercial;

public class Terminales extends Terminales_ventana {
	/*
	 * private Label tituloL; private Label routerL; private Button routerB;
	 * private Label decodificadorL; private Button decodificadorB; private
	 * Label estadoL; private Button guardarB; public ModificarServiciosCm
	 * vModificarServiciosCm; public AltaNuevoCliente vAltaNuevoCliente;
	 */

	// Constructor Ventana Terminales Cuando el Cliente no existe (Nueva Alta).
	private Terminal[] terminales;
	private ArrayList<Terminal> termselec = new ArrayList<>();
	private Terminal aux;

	public Terminales() {

		guardarB.addClickListener(ClickEvent -> {
			if (routerB.getValue() == 1.0) {
				Terminal terminal = new Terminal();
				terminal.setTipo("Router");
				terminal.setEstado(true);
				aux = terminal;
				termselec.add(aux);
			}
			if (dcodificadorB.getValue() == 1.0) {
				Terminal terminal = new Terminal();
				terminal.setTipo("Decodificador");
				terminal.setEstado(true);
				aux = terminal;
				termselec.add(aux);
			}
			if (!termselec.isEmpty()) {
				terminales = termselec.toArray(new Terminal[termselec.size()]);
				VaadinService.getCurrentRequest().getWrappedSession().setAttribute("Terminales", terminales);
				Notification.show("Terminal Asignado con exito!!");
				this.getUI().getWindows().iterator().next().close();
			} else
				Notification.show("Error, algo fue mal, Suicidio");

		});
	}

	// Constructor Ventana Terminales Cuando el Cliente ya existe.
	public Terminales(Cliente c) {
	
		 iComercial iC = new BD_Principal();
		 int facturaId = c.factura.toArray()[0].getID();
		dcodificadorB.setValue(0.0);
		routerB.setValue(0.0);
		 
		terminales = c.factura.toArray()[0].terminal.toArray();
		for (Terminal terminal : terminales) {
			if (terminal.getTipo().equals("Decodificador"))
				dcodificadorB.setValue(1.0);
			if (terminal.getTipo().equals("Router"))
				routerB.setValue(1.0);
		}
		
		guardarB.addClickListener(ClickEvent -> {
			if (routerB.getValue() == 1.0) {
				Terminal terminal = new Terminal();
				terminal.setTipo("Router");
				terminal.setEstado(true);
				aux = terminal;
				termselec.add(aux);
			}
			if (dcodificadorB.getValue() == 1.0) {
				Terminal terminal = new Terminal();
				terminal.setTipo("Decodificador");
				terminal.setEstado(true);
				aux = terminal;
				termselec.add(aux);
			}
			
				terminales = termselec.toArray(new Terminal[termselec.size()]);
				if (iC.modificarTerminal(terminales, facturaId)){
				Notification.show("Terminal Asignado con exito!!");
				this.getUI().getWindows().iterator().next().close();
			} else
				Notification.show("Error, algo fue mal, Suicidio");

		});

	}

	public Informar enviarDatos() {
		throw new UnsupportedOperationException();
	}
}