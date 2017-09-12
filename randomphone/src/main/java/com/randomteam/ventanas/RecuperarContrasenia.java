package com.randomteam.ventanas;

import java.util.Iterator;

import org.omg.CORBA.Environment;
import org.orm.PersistentException;

import com.vaadin.ui.Notification;
import com.vaadin.ui.Window;

import DB.BD_Principal;
import DB.Cliente;
import DB.Incidencia;
import DB.iInternauta;

public class RecuperarContrasenia extends recuperarContrasenia_ventana{
	/*
	private Label recuperarL;
	private Label emailL;
	private TextField emailTF;
	private Button aceptarB;
	public Login vLogin;
	*/
/*
	public Informar enviarDatos() {
		throw new UnsupportedOperationException();
	}*/
	
	private Cliente c ;
	private String email;
	iInternauta iI = new BD_Principal();
	private Incidencia resetpass;
	private String dni;
	
	public RecuperarContrasenia(){


		aceptarB.addClickListener(ClickEvent->{
			email = emailTF.getValue();
			dni = iI.comprobarUsuario(email);
			if (dni != null){
				resetpass = new Incidencia();
				resetpass.setCliente(true);
				resetpass.setAusnto("Recuperar Contrasenia");
				resetpass.setTexto("Usuario Solicita Recuperar su contrasena");
				c = iI.cargarDatosCliente(dni);
				resetpass.setTiene(c);
				try {
					if(iI.crearIncidencia(resetpass)){
						Iterator<Window> it = this.getUI().getWindows().iterator();
						it.next();
						it.next().close();
					}
				} catch (PersistentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
				Notification.show("Usuario Introducido no existe!");
				
		});
	}
	
}