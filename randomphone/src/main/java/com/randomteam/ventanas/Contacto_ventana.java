package com.randomteam.ventanas;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.declarative.Design;

/** 
 * !! DO NOT EDIT THIS FILE !!
 * 
 * This class is generated by Vaadin Designer and will be overwritten.
 * 
 * Please make a subclass with logic and additional interfaces as needed,
 * e.g class LoginView extends LoginDesign implements View { }
 */
@DesignRoot
@AutoGenerated
@SuppressWarnings("serial")
public class Contacto_ventana extends CssLayout {
	protected TextField asuntoTF;
	protected ComboBox<java.lang.String> tipoCB;
	protected TextField telefonoTF;
	protected TextArea mensajeTA;
	protected Button enviarB;

	public Contacto_ventana() {
		Design.read(this);
	}
}
