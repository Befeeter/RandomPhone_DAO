package com.randomteam.ventanas;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
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
public class ModificarServicios_ventana extends CssLayout {
	protected Label movilL;
	protected ComboBox<DB.Servicio> movilCB;
	protected Label fijoL;
	protected ComboBox<DB.Servicio> fijoCB;
	protected Label fibraL;
	protected ComboBox<DB.Servicio> fibraCB;
	protected Label televisionL;
	protected ComboBox<DB.Servicio> televisionCB;
	protected CssLayout paqueteLayout;
	protected Button televisionB;
	protected Button cancelarB;
	protected Button aceptarB;

	public ModificarServicios_ventana() {
		Design.read(this);
	}
}
