package com.randomteam.ventanas;

import com.vaadin.data.Binder;
import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.data.ValueContext;
import com.vaadin.server.Page;

import DB.Persona;

public class ModificarDatosCliente extends ModificarDatosCliente_ventana {
	/*
	 * private Label tituloL; private Label documentoL; private TextField
	 * documentoTF; private Button enviarB; public PanelAdministracionComercial
	 * vPanelAdministracionComercial; public MiCuentaComercial
	 * vMiCuentaComercial;
	 */
	Binder<Persona> binder = new Binder<>();

	public ModificarDatosCliente() {
		// Elimina del estilo la barra scroll fea.
		Page.getCurrent().getStyles().add(".form-template{overflow: hidden !important;}");

		documentoTF.setMaxLength(9);
		documentoTF.addValueChangeListener(Event->{
			if (documentoTF.getValue().length() == 9)
				this.entrarB.setEnabled(true);						
		});
		
		// Validamos DNI Formato Correcto
		Validator<String> formatoDNI = new Validator<String>() {
			@Override
			public ValidationResult apply(String s, ValueContext valueContext) {
				if (s.matches("([0-9]{8})([A-Z])"))
					return ValidationResult.ok();
				else
					return ValidationResult.error("Formato de DNI incorrecto!");
			}
		};

		binder.forField(documentoTF).withValidator(formatoDNI).bind(Persona::getDocumento, Persona::setDocumento);

	}

	public boolean comprobarDocumento(Object string_documento) {
		throw new UnsupportedOperationException();

	}
}