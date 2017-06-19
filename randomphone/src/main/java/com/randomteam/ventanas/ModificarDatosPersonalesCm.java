package com.randomteam.ventanas;

import com.vaadin.server.VaadinService;
import com.vaadin.ui.Notification;

import DB.BD_Principal;
import DB.Cliente;
import DB.iComercial;

public class ModificarDatosPersonalesCm extends ModificarDatosPersonalesCM_ventana {
	/*
	 * public class ModificarDatosPersonalesCm extends ModificarDatosPersonales
	 * { private Label contraseniaL; private TextField contraseniaTF; public
	 * MiCuentaComercial vMiCuentaComercial;
	 */
	Cliente c = (Cliente) VaadinService.getCurrentRequest().getWrappedSession().getAttribute("usuario");
	iComercial iCm = new BD_Principal();

	public ModificarDatosPersonalesCm() {
		this.nombreTF.setValue(c.getNombre());
		this.apellidoTF.setValue(c.getApellidos());
		this.correoTF.setValue(c.getEmail());
		this.telefonoTF.setValue(String.valueOf(c.getTelefono()));
		this.passwordTF.setValue(c.getContrasena());

		cancelarB.addClickListener(ClickEvent -> {
			this.getUI().setContent(new SitioWebComercial());
		});

		aceptarB.addClickListener(ClickEvent -> {
			c.setNombre(this.nombreTF.getValue());
			c.setApellidos(this.apellidoTF.getValue());
			c.setEmail(this.correoTF.getValue());
			c.setTelefono(Integer.parseInt(this.telefonoTF.getValue()));
			c.setContrasena(this.passwordTF.getValue());

			if (comprobarContrasenia(c.getContrasena()))
				if (iCm.modificarDatosP(c)) {
					Notification.show("Datos Actualizados Correctamente");
					this.getUI().setContent(new SitioWebComercial());
				} else
					Notification.show("Error al actualizar los datos");
			else
				Notification.show("La contraseña no cumple el formato adecuado");
		});

	}

	public boolean comprobarContrasenia(String contrasenia) {
		if (contrasenia.length() >= 8)
			if (contrasenia.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}"))
				return true;
			else
				return false;
		return false;
	}
}