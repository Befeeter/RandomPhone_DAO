package com.randomteam.ventanas;

import java.util.ArrayList;
import java.util.Vector;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinService;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import DB.BD_Principal;
import DB.Cliente;
import DB.Fibra;
import DB.Fijo;
import DB.Movil;
import DB.Paquete;
import DB.Servicio;
import DB.Television;
import DB.iCliente;
import DB.iComercial;

public class ModificarServicios extends ModificarServicios_ventana {
	/*
	 * private Label serviciosL; private img movilI; private TarifaE movilLS;
	 * private img telefonoI; private TarifaE telefonoLS; private img fibraI;
	 * private TarifaE fibraLS; private img televisionI; private TarifaE
	 * televisionLS; private Button televisionB; private Button aceptarB; public
	 * MiCuenta vMiCuenta; public Vector<TarifaE> vTarifaE = new
	 * Vector<TarifaE>(); public PaquetesContratados vPaquetesContratados;
	 */

	iCliente iC = new BD_Principal();
	iComercial iCm = new BD_Principal();
	private Cliente c = (Cliente) VaadinService.getCurrentRequest().getWrappedSession().getAttribute("usuario");
	private Servicio[] servicios = iC.cargarServiciosCliente(c.getId());
	private ArrayList<Servicio> sMovilD = new ArrayList<>();
	private ArrayList<Servicio> sFijoD = new ArrayList<>();
	private ArrayList<Servicio> sFibraD = new ArrayList<>();
	private ArrayList<Servicio> sTvD = new ArrayList<>();

	public ModificarServicios() {
		Page.getCurrent().getStyles().add(".form-template{overflow: hidden !important;}");
		
		this.movilL.setContentMode(ContentMode.HTML);
		this.movilL.setValue(VaadinIcons.PHONE.getHtml());
		this.fijoL.setContentMode(ContentMode.HTML);
		this.fijoL.setValue(VaadinIcons.PHONE_LANDLINE.getHtml());
		this.fibraL.setContentMode(ContentMode.HTML);
		this.fibraL.setValue(VaadinIcons.BUILDING.getHtml());
		this.televisionL.setContentMode(ContentMode.HTML);
		this.televisionL.setValue(VaadinIcons.MOVIE.getHtml());

		movilCB.setItemCaptionGenerator(Servicio::getNombre);
		movilCB.setEmptySelectionAllowed(false);
		fijoCB.setItemCaptionGenerator(Servicio::getNombre);
		fijoCB.setEmptySelectionAllowed(false);
		fibraCB.setItemCaptionGenerator(Servicio::getNombre);
		fibraCB.setEmptySelectionAllowed(false);
		televisionCB.setItemCaptionGenerator(Servicio::getNombre);
		televisionCB.setEmptySelectionAllowed(false);

		
		//Establecemos El Servicio Que ya tiene contratado el usuario
		for (Servicio servicio : servicios) {
			if (servicio.getNombre().contains("Movil")) {
				movilCB.setValue(servicio);
			}

			if (servicio.getNombre().contains("Fijo")) {				
				fijoCB.setValue(servicio);
			}
			if (servicio.getNombre().contains("Fibra")) {
				fibraCB.setValue(servicio);
			}
			if (servicio.getNombre().contains("Televisión")) {
				televisionCB.setValue(servicio);
			}
		}

	
		//añadimos la posibilidad de Modificar el servicio a uno de los dispoinbles
		if (!movilCB.isEmpty()) {
			movilCB.setEnabled(true);
			Movil[] tMovil = iCm.cargarTarifasMovil();
			for (Movil movil : tMovil)
				if (movil.isEstado()) {
					Servicio aux = new Servicio();
					aux.setId(movil.getId());
					aux.setNombre(movil.getNombre());
					sMovilD.add(aux);
				}
			movilCB.setItems(sMovilD);
		}
		if (!fijoCB.isEmpty()) {
			fijoCB.setEnabled(true);
			Fijo[] tFijo = iCm.cargarTarifasFijo();
			for (Fijo fijo : tFijo)
				if(fijo.isEstado()){
					Servicio aux = new Servicio();
					aux.setId(fijo.getId());
					aux.setNombre(fijo.getNombre());
					sFijoD.add(aux);
				}
			fijoCB.setItems(sFijoD);
		}
		if (!fibraCB.isEmpty()) {
			fibraCB.setEnabled(true);
			Fibra[] tFibra = iCm.cargarTarifasFibra();
			for (Fibra fibra : tFibra)
				if(fibra.isEstado()){
					Servicio aux = new Servicio();
					aux.setId(fibra.getId());
					aux.setNombre(fibra.getNombre());
					sFibraD.add(aux);
				}
			fibraCB.setItems(sFibraD);
		}
		if (!televisionCB.isEmpty()) {
			televisionCB.setEnabled(true);
			Television[] tTelevision = iCm.cargarTarifasTelevision();
			for (Television tv : tTelevision)
				if (tv.isEstado()){
					Servicio aux = new Servicio();
					aux.setId(tv.getId());
					aux.setNombre(tv.getNombre());					
					sTvD.add(aux);
				}
			televisionCB.setItems(sTvD);
		}
		
		//Botón Aceptar
		aceptarB.addClickListener(ClickEvent->{
			ArrayList<Servicio> nServicios = new ArrayList<>();
			if (!movilCB.isEmpty())
				nServicios.add(movilCB.getValue());
			if(!fijoCB.isEmpty())
				nServicios.add(fijoCB.getValue());
			if(!fibraCB.isEmpty())
				nServicios.add(fibraCB.getValue());
			if(!televisionCB.isEmpty())
				nServicios.add(televisionCB.getValue());
			servicios = nServicios.toArray(new Servicio[nServicios.size()]);
			int idFactura = c.getFactura()[0].getId();
			if(iC.modificarServicios(servicios, idFactura)){
				Notification.show("Servicios Actualizados Correctamente");
				this.removeAllComponents();
				this.addComponent(new ModificarServicios());
			}
			else
				Notification.show("Ups Algo fue mal, habla con un Administrador");
			
		});

		// Botón Cancelar.
		cancelarB.addClickListener(ClickEvent -> {
			this.getUI().setContent(new SitioWebCliente());
		});

		// Botón Paquete Personalizado
		televisionB.addClickListener(ClickEvent -> {
			Window subWindow = new Window("Paquete Personalizado");
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(new PaquetePersonalizado());
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			this.getUI().addWindow(subWindow);
		});
	}

	public Informar enviarDatos() {
		throw new UnsupportedOperationException();
	}
}