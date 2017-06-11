package com.randomteam.ventanas;

public class Reclamacion extends Reclamacion_ventana {
	/*
	 * private Label tituloL; private Label consultaL; private Text consultaT;
	 * private Label respuestaL; private Text respuestaT; private TextArea
	 * nuevaConsultaTA; private Button enviarB; public Incidencia vIncidencia;
	 */

	public Reclamacion(DB.Incidencia iselec) {
		this.tituloL.setValue(iselec.getAsunto());
		this.consultaT.setValue(iselec.getTexto());
	}

	public Informar enviarDatos() {
		throw new UnsupportedOperationException();
	}
}