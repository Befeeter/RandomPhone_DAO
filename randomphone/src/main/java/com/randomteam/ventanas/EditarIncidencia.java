package com.randomteam.ventanas;

import java.util.Iterator;

import com.vaadin.data.Binder;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Window;

import DB.BD_Principal;
import DB.Incidencia;
import DB.iAdministrador;

public class EditarIncidencia extends EditarIncidencia_ventana {
	/*
	 * private Label nombreClienteL; public ListadoIncidencias
	 * vListadoIncidencias;
	 *
	 * public void cargarDatos() { throw new UnsupportedOperationException(); }
	 */
	iAdministrador iA = new BD_Principal();

	public EditarIncidencia(Incidencia incidencia) {

		Binder<Incidencia> binder = new Binder<>();

		binder.forField(asuntoTF).asRequired("Asunto Requerido").bind(Incidencia::getAusnto, Incidencia::setAusnto);
		binder.forField(tipoCB).asRequired("Debe Seleccionar un tipo").bind(Incidencia::getTipo, Incidencia::setTipo);
		binder.forField(mensajeTA).asRequired("Debe introducir un Mensaje").bind(Incidencia::getTexto,
				Incidencia::setTexto);

		binder.addStatusChangeListener(event -> enviarB.setEnabled(binder.isValid()));

		// establezco los valores de los campos a editar
		clienteTF.setValue(incidencia.getTiene().getNombre() + "");
		asuntoTF.setValue(incidencia.getAusnto() + "");
		if (incidencia.getCliente())
			clienteR.setSelectedItem("Option1");
		else
			clienteR.setSelectedItem("Option2");
		tipoCB.setEmptySelectionAllowed(false);
		tipoCB.setValue(incidencia.getTipo());
		telefonoTF.setValue(incidencia.getTelefono() + "");
		mensajeTA.setValue(incidencia.getTexto() + "");
		observacionesTA.setValue(incidencia.getObservaciones() + "");
		//
		enviarB.addClickListener(ClickEvent -> {
			incidencia.setAusnto(asuntoTF.getValue());
			if (clienteR.getSelectedItem().get().equals("Option1")) {
				incidencia.setCliente(true);
			} else
				incidencia.setCliente(false);
			incidencia.setTipo(tipoCB.getValue() + "");
			incidencia.setTelefono(Integer.parseInt(telefonoTF.getValue()));
			incidencia.setTexto(mensajeTA.getValue() + "");
			incidencia.setObservaciones(observacionesTA.getValue() + "");

			// editar
			if (iA.editarIncidencia(incidencia)) {
				Notification.show("Editada con exito!");
				// cerrar ventana
				Iterator<Window> it = this.getUI().getWindows().iterator();
				it.next().close();
			} else
				Notification.show("Error! Ups algo fue mal!");
		});
	}
}
