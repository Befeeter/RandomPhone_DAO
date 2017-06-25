package com.randomteam.ventanas;

import com.vaadin.server.VaadinService;

import DB.BD_Principal;
import DB.BD_Televisiones;
import DB.Cliente;
import DB.Paquete;
import DB.iComercial;

//public class PaquetesContratadosCm extends PaquetesContratados {
public class PaquetesContratadosCm extends PaquetesContratadosCm_ventana {
	/*private Button añadirPaqueteB;
	public ModificarServiciosCm vModificarServiciosCm;
	public PaquetesTV vPaquetesTV;
	*/
	
	private Cliente c =(Cliente) VaadinService.getCurrentRequest().getWrappedSession().getAttribute("usuario");
	private iComercial iCm = new BD_Principal();
	private Paquete[] paquetesContratados = iCm.cargarPaquetesCliente(c.getId());
	public PaquetesContratadosCm(){
	paquetesGrid.addColumn(Paquete::getNombre).setCaption("Nombre");
	paquetesGrid.setItems(paquetesContratados);
	}
}