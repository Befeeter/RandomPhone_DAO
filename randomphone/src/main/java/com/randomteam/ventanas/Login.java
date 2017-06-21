package com.randomteam.ventanas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.randomteam.randomphone.MyUI;
import com.vaadin.data.Binder;
import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.data.ValueContext;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;

import DB.Conexion;
import DB.Cliente;
import DB.Comercial;
import DB.Persona;
import DB.iAdministrador;
import DB.iInternauta;
import DB.BD_Principal;
import DB.iInternauta;
import DB.iCliente;
import DB.iComercial;

public class Login extends Login_ventana {
	/*
	 * private Label emailL; private TextField emailTF; private Label
	 * contraseniaL; private TextField contraseniaTF; private Button
	 * olvidoContrasenia; private Button iniciarB; public SitioWebInternauta
	 * vSitioWebInternauta; public MiCuenta vMiCuenta; public
	 * ActualizarContrasenia vActualizarContrasenia; public RecuperarContrasenia
	 * vRecuperarContrasenia;
	 */

	Binder<Persona> binder = new Binder<>();
	String email = "";
	String password = "";
	String debug = "";
	int idcliente = -1;
	iInternauta it = new BD_Principal();
	iCliente ic = new BD_Principal();
	iComercial iCm = new BD_Principal();
	Cliente cliente = new Cliente();
	Comercial[] comerciales = null;
	Comercial comercial = new Comercial();
	Administrador administrador = new Administrador();
	iAdministrador iA = new BD_Principal();

	public Login() {

		// Validamos Longitud Password
		Validator<String> longitud = new Validator<String>() {
			@Override
			public ValidationResult apply(String s, ValueContext valueContext) {
				if (s.length() < 8) {
					return ValidationResult.error("La contraseña debe de tener 8 caracteres o más");
				} else
					return ValidationResult.ok();
			}

		};
		// Validamos Formato Password
		Validator<String> formatops = new Validator<String>() {
			@Override
			public ValidationResult apply(String s, ValueContext valueContext) {
				if (s.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}"))
					return ValidationResult.ok();
				else
					return ValidationResult.error("La contraseña debe contener el siguiente formato"
							+ "\n - 1 digito.\n - 1 minuscula.\n - 1 mayuscula.\n - 1 Caracter especial");
			}
		};

		// Validamos Formato Email
		Validator<String> formatoem = new Validator<String>() {
			@Override
			public ValidationResult apply(String s, ValueContext valueContext) {
				if (s.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
					return ValidationResult.ok();
				else
					return ValidationResult.error("El formato del email debe ser 'asdf@prueba.com");
			}
		};

		binder.forField(passwordTF).withValidator(longitud).withValidator(formatops).bind(Persona::getContrasena,
				Persona::setContrasena);
		binder.forField(emailTF).withValidator(formatoem).bind(Persona::getEmail, Persona::setEmail);

		emailTF.addValueChangeListener(Event -> {
			if (!emailTF.isEmpty() && !passwordTF.isEmpty())
				iniciarSesionB.setEnabled(true);
			else
				iniciarSesionB.setEnabled(false);
		});
		passwordTF.addValueChangeListener(Event -> {
			if (!emailTF.isEmpty() && !passwordTF.isEmpty())
				iniciarSesionB.setEnabled(true);
			else
				iniciarSesionB.setEnabled(false);
		});

		
		
		//pulsar enter ejecuta el click
		iniciarSesionB.setClickShortcut(KeyCode.ENTER);
		iniciarSesionB.addClickListener(ClickEvent -> {
			email = emailTF.getValue();
			password = passwordTF.getValue();
			idcliente = it.comprobarUsuario(email, password);
			// Necesario revisar expresión regular para @Comercial.es
			if (email.contains("@comercial.es")) {
				Notification.show("Usuario Comercial!");
				comerciales = iCm.cargarComerciales();

				int i;
				for (i = 0; i < comerciales.length && !comerciales[i].getEmail().equals(email); i++)
					;

				if (i < comerciales.length) {
					VaadinService.getCurrentRequest().getWrappedSession().setAttribute("comercial", comerciales[i]);
					if(comerciales[i].getContrasena().toString().equals(password)){
					Notification.show("Bienvenido Comercial");
					this.getUI().setContent(new SitioWeb(comercial));
					}
					else
						Notification.show("Usuario o contraseña Erroneos!");
				} else
					Notification.show("Comercial No Encontrado!");
			} else if (email.contains("@administrador.es")) {
				int idAdmin = iA.comprobarAdmin(email, password);
				if (idAdmin != -1) {
					Notification.show("Administrador!");
					VaadinService.getCurrentRequest().getWrappedSession().setAttribute("usuario", idAdmin);
					DB.Administrador administrador = new DB.Administrador();
					administrador.setId(idAdmin);
					this.getUI().setContent(new SitioWeb(administrador));
				} else
					Notification.show("Usuario o Contraseña Erroneo!");
			} else if (idcliente != -1) {
				Notification.show("Prueba correcta, Usuario existe");
				// Creamos un objeto cliente que se mantiene en la sesión HTML
				VaadinService.getCurrentRequest().getWrappedSession().setAttribute("usuario",
						ic.cargarDatosCliente(idcliente));
				// recuperamos objeto cliente de la sesión HTML
				// cliente = (Cliente)
				// VaadinService.getCurrentRequest().getWrappedSession().getAttribute("usuario");
				// Cerrar session HTTP
				// VaadinService.getCurrentRequest().getWrappedSession().invalidate();
				this.getUI().setContent(new SitioWebCliente());
				// this.addComponent(new MiCuenta(email, password));
			}

			else {
				//DB.Administrador administrador = new DB.Administrador();
				//this.getUI().setContent(new SitioWeb(administrador));
				Notification.show("Usuario o Contraseña Erroneo!");
			}
		});

	}

}