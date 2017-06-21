package com.randomteam.ventanas;

import com.vaadin.data.Binder;
import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.data.ValueContext;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Notification;

import DB.BD_Principal;
import DB.Cliente;
import DB.Persona;
import DB.iComercial;

public class ModificarDatosCliente extends ModificarDatosCliente_ventana {
	/*
	 * private Label tituloL; private Label documentoL; private TextField
	 * documentoTF; private Button enviarB; public PanelAdministracionComercial
	 * vPanelAdministracionComercial; public MiCuentaComercial
	 * vMiCuentaComercial;
	 */
	Binder<Persona> binder = new Binder<>();
	iComercial iCm = new BD_Principal();
	Cliente cliente = null;

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

		entrarB.setClickShortcut(KeyCode.ENTER);
		entrarB.addClickListener(ClickEvent ->{
			cliente = iCm.cargarDatosCliente(this.documentoTF.getValue());
			cliente.setIncidencia(iCm.cargarIncidencias(cliente.getId()));
			if (cliente != null){
				VaadinService.getCurrentRequest().getWrappedSession().setAttribute("usuario", cliente);
				this.getUI().setContent(new SitioWebComercial());
				this.getUI().getWindows().iterator().next().close();
			}
			else
				Notification.show("Error! Cliente no encontrado");
		});
		
	}

	public boolean comprobarDocumento(Object string_documento) {
		throw new UnsupportedOperationException();

	}
}