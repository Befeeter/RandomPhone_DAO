package com.randomteam.ventanas;

public class SitioWebCliente extends sitioWebCliente_ventana {
/*
public class SitioWebCliente extends SitioWeb {
	private Button miCuenta;
	public Cliente vCliente;
	public MiCuenta vMiCuenta;*/
	
	public SitioWebCliente() {
		this.addComponent(new MiCuenta("", ""));
	}
}