package com.randomteam.ventanas;

import java.util.Iterator;

import org.orm.PersistentException;

import com.vaadin.data.Binder;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Window;

import DB.BD_Principal;
import DB.Incidencia;
import DB.iInternauta;

public class Contacto extends Contacto_ventana{
	/*
	private Label contactoL;
	private Label asuntoL;
	private TextField asuntoTF;
	private Label eresClienteL;
	private RadioButton si;
	private RadioButton no;
	private Label tipoL;
	private List tipo;
	private Label telefonoL;
	private TextField telefonoTF;
	private Label mensajeL;
	private TextField mensajeTF;
	private Button enviarB;
	public SitioWeb vSitioWeb;

	public Informar enviarDatos() {
		throw new UnsupportedOperationException();
	}
	*/
	private iInternauta iIn = new BD_Principal();
	private Incidencia incidencia = new Incidencia();
	public Contacto(){
		
		Binder<Incidencia> binder = new Binder<>();
		
		binder.forField(asuntoTF).asRequired("Asunto Requerido").bind(Incidencia::getAusnto, Incidencia::setAusnto);
		binder.forField(tipoCB).asRequired("Debe Seleccionar un tipo").bind(Incidencia::getTipo, Incidencia::setTipo);
		binder.forField(mensajeTA).asRequired("Debe introducir un Mensaje").bind(Incidencia::getTexto, Incidencia::setTexto);
		
		
		binder.addStatusChangeListener(event ->
		enviarB.setEnabled(binder.isValid()));
		enviarB.addClickListener(ClickEvent->{
			incidencia.setAusnto(asuntoTF.getValue());
			if (clienteR.getSelectedItem().get().equals("Option1")) {
				incidencia.setCliente(true);System.out.println("holaaaaaaaaaaaaaaaaa");
			}
			else{
				System.out.println("no soy cliente y lo sabes");
				incidencia.setCliente(false);
			}
			incidencia.setTipo(tipoCB.getValue()+"");
			incidencia.setTelefono(Integer.parseInt(telefonoTF.getValue()));
			incidencia.setTexto(mensajeTA.getValue()+"");

			// editar
			try {
				if (iIn.crearIncidencia(incidencia)) {
					Notification.show("Editada con exito!");
					// cerrar ventana
					Iterator<Window> it = this.getUI().getWindows().iterator();
					it.next().close();
				} else
					Notification.show("Error! Ups algo fue mal!");
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
}