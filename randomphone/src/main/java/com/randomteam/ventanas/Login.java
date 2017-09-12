package com.randomteam.ventanas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.orm.PersistentException;

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
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;


import DB.Cliente;
import DB.Comercial;
import DB.Persona;
import DB.iAdministrador;
import DB.iInternauta;
import DB.AdministradorDAO;
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
	int idPersona = -1;
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

		//He olvidado la contraseña
		
		resetPassLk.addClickListener(ClickEvent->{
			// Creamos Ventana Emergente para crear reclamación
			Window subWindow = new Window("Recuperar Contraseña");
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(new RecuperarContrasenia());
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("600px");
			subWindow.setWidth("400px");
			subWindow.addCloseListener(Event ->{
				Notification.show("Revise su e-mail");
			});
			this.getUI().addWindow(subWindow);
		});
		
		
		
		//pulsar enter ejecuta el click
		iniciarSesionB.setClickShortcut(KeyCode.ENTER);
		iniciarSesionB.addClickListener(ClickEvent -> {
			email = emailTF.getValue();
			password = passwordTF.getValue();
			try {
				idPersona = it.comprobarUsuario(email, password);
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
					Collection<Window> win =this.getUI().getCurrent().getWindows();
					win.iterator().next().close();
					}
					else
						Notification.show("Usuario o contraseña Erroneos!");
				} else
					Notification.show("Comercial No Encontrado!");
			} else if (email.contains("@administrador.es")) {
				if (idPersona != -1) {
					Notification.show("Administrador!");
					VaadinService.getCurrentRequest().getWrappedSession().setAttribute("administrador", idPersona);
					DB.Administrador administrador = null;
					try {
						administrador = AdministradorDAO.getAdministradorByORMID(idPersona);
					} catch (PersistentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//DB.Administrador administrador = new DB.Administrador();
					//administrador.setId(idAdmin);
					this.getUI().setContent(new SitioWeb(administrador));
					Collection<Window> win =this.getUI().getCurrent().getWindows();
					win.iterator().next().close();

				} else
					Notification.show("Usuario o Contraseña Erroneo!");
			} else if (idPersona != -1) {
				// Creamos un objeto cliente que se mantiene en la sesión HTML
				cliente = ic.cargarDatosCliente(idPersona);
				VaadinService.getCurrentRequest().getWrappedSession().setAttribute("usuario", cliente);
				Notification.show("Bienvenido "+cliente.getNombre());
				// recuperamos objeto cliente de la sesión HTML
				// cliente = (Cliente)
				// VaadinService.getCurrentRequest().getWrappedSession().getAttribute("usuario");
				// Cerrar session HTTP
				// VaadinService.getCurrentRequest().getWrappedSession().invalidate();
				this.getUI().setContent(new SitioWebCliente());
				Collection<Window> win =this.getUI().getCurrent().getWindows();
				win.iterator().next().close();
				// this.addComponent(new MiCuenta(email, password));
			}

			else {
				//VaadinService.getCurrentRequest().getWrappedSession().setAttribute("administrador", 0);
				//this.getUI().setContent(new SitioWebAdministrador());
				Notification.show("Usuario o Contraseña Erroneo!");
			}
		});

	}

}