package com.randomteam.ventanas;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.Slider;
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
public class CrearPaquete_ventana extends CssLayout {
	protected Label nombreL;
	protected TextField nombreTF;
	protected Label precioL;
	protected TextField precioTF;
	protected Label fechaL;
	protected DateField fecha_altaD;
	protected Label estadoL;
	protected Slider estadoB;
	protected Grid<DB.Canal> canalesLS;
	protected Button crearB;

	public CrearPaquete_ventana() {
		Design.read(this);
	}
}
