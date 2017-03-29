package com.randomteam.ventanas;

public class Administrador extends Administrador_ventana{
	//public SitioWebAdministrador vSitioWebAdministrador;
	public Administrador(){
		this.administradorLY.addComponent(new AltaNuevoCliente());
	}
}