package com.randomteam.ventanas;
import java.util.Vector;

public class MiCuenta {
	private Label nombreL;
	private Button modificarDatosB;
	private Button modificarServiciosB;
	private Button misFacturasB;
	private Button misIncidenciasB;
	private Label consumoL;
	private Bar consumoBR;
	private Label consumoMovilL;
	private Label consumoFIbraL;
	private Label consumoTvL;
	private Label consumoFijoL;
	private Label datosL;
	public Vector<MisFacturas> vMisFacturas = new Vector<MisFacturas>();
	public SitioWebCliente vSitioWebCliente;
	public Login vLogin;
	public MisIncidencias vMisIncidencias;
	public ModificarServicios vModificarServicios;
	public ModificarDatosPersonales vModificarDatosPersonales;
}