package com.randomteam.ventanas;

import java.util.ArrayList;

import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Notification;

import DB.Cliente;
import DB.Terminal;

public class Terminales extends Terminales_ventana {
	/*private Label tituloL;
	private Label routerL;
	private Button routerB;
	private Label decodificadorL;
	private Button decodificadorB;
	private Label estadoL;
	private Button guardarB;
	public ModificarServiciosCm vModificarServiciosCm;
	public AltaNuevoCliente vAltaNuevoCliente;*/
	
	
	//Constructor Ventana Terminales Cuando el Cliente no existe (Nueva Alta).
	private Terminal[] terminales;
	private ArrayList<Terminal> termselec = new ArrayList<>();
	private Terminal aux;
	public Terminales(){
		
		
		
		guardarB.addClickListener(ClickEvent ->{
			if(routerB.getValue() == 1.0){
				aux = new Terminal("Router", true);
				termselec.add(aux);
			}
			if(dcodificadorB.getValue() == 1.0){
				aux = new Terminal("Decodificador", true);
				termselec.add(aux);
				
				if (!termselec.isEmpty()){
					terminales = termselec.toArray(new Terminal[termselec.size()]);
					VaadinService.getCurrentRequest().getWrappedSession().setAttribute("Terminales", terminales);
					Notification.show("Terminal Asignado con exito!!");
					this.getUI().getWindows().iterator().next().close();
				}
				else
					Notification.show("Error, algo fue mal, Suicidio");
			}
		});
		
		
		
			
		
	}
	
	
	//Constructor Ventana Terminales Cuando el Cliente ya existe.
	public Terminales(Cliente c){
		
	}
	public Informar enviarDatos() {
		throw new UnsupportedOperationException();
	}
}