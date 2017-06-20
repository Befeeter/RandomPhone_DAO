package com.randomteam.ventanas;

import java.util.Iterator;

import com.vaadin.data.Binder;
import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.data.ValueContext;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Window;

import DB.BD_Principal;
import DB.Fibra;
import DB.Fijo;
import DB.Movil;
import DB.Persona;
import DB.iAdministrador;

public class MesesAdaptacion extends MesesAdaptacion_ventana {
	/*
	 * private Label mesesL; private TextField mesesTF; private Button aceptarB;
	 * public Tarifa vTarifa;
	 */
	iAdministrador iA = new BD_Principal();
	Binder<Integer> binder = new Binder<>();

	public MesesAdaptacion() {

	}

	// constructor para eliminar las tarifas moviles
	public MesesAdaptacion(Movil[] eliminar) {
		// Validador solo numeros
		Validator<String> soloNumeros = new Validator<String>() {
			@Override
			public ValidationResult apply(String s, ValueContext valueContext) {
				if (s.matches("/^[0-9]+$/"))
					return ValidationResult.ok();
				else
					return ValidationResult.error("Solo números!");
			}
		};
		binder.forField(mesesTF).withValidator(soloNumeros).bind("");

		mesesTF.addValueChangeListener(Event -> {
			if (!mesesTF.isEmpty())
				aceptarB.setEnabled(true);
			else
				aceptarB.setEnabled(false);
		});

		aceptarB.addClickListener(ClickEvent -> {
			boolean correcto = true;
			// Para cada tarifa seleccionada la elimino

			for (Movil movil : eliminar) {
				if (!iA.eliminarTarifaMovil(Integer.parseInt(mesesTF.getValue()), movil))
					correcto = false;
			}
			if (correcto) {
				Notification.show("Eliminadas Con exito!");
				// cerrar ventana
				Iterator<Window> it = this.getUI().getWindows().iterator();
				it.next();
				it.next().close();
			} else
				Notification.show("Error! Ups algo fue mal!");
		});
	}

	// constructor para eliminar las tarifas fijo
	public MesesAdaptacion(Fijo[] eliminar) {
		// Validador solo numeros
		Validator<String> soloNumeros = new Validator<String>() {
			@Override
			public ValidationResult apply(String s, ValueContext valueContext) {
				if (s.matches("/^[0-9]+$/"))
					return ValidationResult.ok();
				else
					return ValidationResult.error("Solo números!");
			}
		};
		binder.forField(mesesTF).withValidator(soloNumeros);

		mesesTF.addValueChangeListener(Event -> {
			if (!mesesTF.isEmpty())
				aceptarB.setEnabled(true);
			else
				aceptarB.setEnabled(false);
		});

		aceptarB.addClickListener(ClickEvent -> {
			boolean correcto = true;
			// Para cada tarifa seleccionada la elimino
			for (Fijo fijo : eliminar) {
				if (!iA.eliminarTarifaFijo(fijo, Integer.parseInt(mesesTF.getValue())))
					correcto = false;
			}
			if (correcto) {
				Notification.show("Eliminadas Con exito!");
				// cerrar ventana
				Iterator<Window> it = this.getUI().getWindows().iterator();
				it.next();
				it.next().close();
			} else
				Notification.show("Error! Ups algo fue mal!");
		});
	}

	// constructor para eliminar las tarifas fibra
	public MesesAdaptacion(Fibra[] eliminar) {
		// Validador solo numeros
		Validator<String> soloNumeros = new Validator<String>() {
			@Override
			public ValidationResult apply(String s, ValueContext valueContext) {
				if (s.matches("/^[0-9]+$/"))
					return ValidationResult.ok();
				else
					return ValidationResult.error("Solo números!");
			}
		};
		binder.forField(mesesTF).withValidator(soloNumeros);

		mesesTF.addValueChangeListener(Event -> {
			if (!mesesTF.isEmpty())
				aceptarB.setEnabled(true);
			else
				aceptarB.setEnabled(false);
		});

		aceptarB.addClickListener(ClickEvent -> {
			boolean correcto = true;
			// Para cada tarifa seleccionada la elimino

			for (Fibra fibra : eliminar) {
				if (!iA.eliminarTarifaFibra(fibra, Integer.parseInt(mesesTF.getValue())))
					correcto = false;
			}
			if (correcto) {
				Notification.show("Eliminadas Con exito!");
				// cerrar ventana
				Iterator<Window> it = this.getUI().getWindows().iterator();
				it.next();
				it.next().close();
			} else
				Notification.show("Error! Ups algo fue mal!");
		});
	}
}