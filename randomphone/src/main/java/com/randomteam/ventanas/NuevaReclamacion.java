package com.randomteam.ventanas;

import com.vaadin.server.VaadinService;

import DB.Cliente;
import DB.Incidencia;

public class NuevaReclamacion extends NuevaReclamacion_ventana {
	/*
	private Label asuntoL;
	private TextField asuntoTF;
	private Label tipoL;
	private List tipoLS;
	private Label mensajeL;
	private TextArea mensajeTA;
	private Button enviarB;
	public MisIncidencias vMisIncidencias;

	public Informar enviarDatos() {
		throw new UnsupportedOperationException();
	}
	*/
	
	Incidencia incidencia = new Incidencia();
	Cliente c = (Cliente) VaadinService.getCurrentRequest().getWrappedSession().getAttribute("usuario");
	
	public NuevaReclamacion(){
		
		enviarB.addClickListener(ClickEvent ->{
			incidencia.setAsunto(this.asuntoTF.getValue());
			incidencia.setTipo(tipoLS.getValue().toString());
			incidencia.setTexto(this.asuntoTF.getValue());
			
		});
	}
	
}