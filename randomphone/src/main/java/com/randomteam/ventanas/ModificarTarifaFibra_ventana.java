package com.randomteam.ventanas;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Slider;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
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
public class ModificarTarifaFibra_ventana extends VerticalLayout {
	protected Label tituloL;
	protected Label nombreL;
	protected TextField nombreTF;
	protected Label precioL;
	protected TextField precioTF;
	protected Label bajadaL;
	protected TextField bajadaTF;
	protected Label subidaL;
	protected TextField subidaTF;
	protected Label estadoL;
	protected Slider estadoB;
	protected Button submit;

	public ModificarTarifaFibra_ventana() {
		Design.read(this);
	}
}
