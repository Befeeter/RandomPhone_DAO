package com.randomteam.ventanas;

import java.util.ArrayList;

import com.vaadin.event.ContextClickEvent;
import com.vaadin.icons.VaadinIcons;
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
import DB.Servicio;
import DB.Television;
import DB.iCliente;
import DB.iComercial;

public class ModificarServiciosCm extends ModificarServiciosCm_ventana {
	/*
	 * 
	 * 
	 * private Button terminalesB; public MiCuentaComercial vMiCuentaComercial;
	 * public Terminales vTerminales; public PaquetesContratadosCm
	 * vPaquetesContratadosCm;
	 */
	iCliente iC = new BD_Principal();
	iComercial iCm = new BD_Principal();
	private Cliente c = (Cliente) VaadinService.getCurrentRequest().getWrappedSession().getAttribute("usuario");
	private Servicio[] servicios = iC.cargarServiciosCliente(c.getID());
	private ArrayList<Servicio> sMovilD = new ArrayList<>();
	private ArrayList<Servicio> sFijoD = new ArrayList<>();
	private ArrayList<Servicio> sFibraD = new ArrayList<>();
	private ArrayList<Servicio> sTvD = new ArrayList<>();

	// para controlar si se ha modificado el servicio
	private boolean modMovil = false;
	private boolean modFijo = false;
	private boolean modFibra = false;
	private boolean modTelevision = false;

	// para guardar los servicios actuales
	private Servicio movilActual = null;
	private Servicio fijoActual = null;
	private Servicio fibraActual = null;
	private Servicio televisionActual = null;

	public ModificarServiciosCm() {
		this.movilL.setContentMode(ContentMode.HTML);
		this.movilL.setValue(VaadinIcons.PHONE.getHtml());
		this.fijoL.setContentMode(ContentMode.HTML);
		this.fijoL.setValue(VaadinIcons.PHONE_LANDLINE.getHtml());
		this.fibraL.setContentMode(ContentMode.HTML);
		this.fibraL.setValue(VaadinIcons.BUILDING.getHtml());
		this.televisionL.setContentMode(ContentMode.HTML);
		this.televisionL.setValue(VaadinIcons.MOVIE.getHtml());
		movilCB.setItemCaptionGenerator(Servicio::getNombre);

		fijoCB.setItemCaptionGenerator(Servicio::getNombre);

		fibraCB.setItemCaptionGenerator(Servicio::getNombre);

		televisionCB.setItemCaptionGenerator(Servicio::getNombre);

		// Establecemos El Servicio Que ya tiene contratado el usuario
		// Establecemos El Servicio Que ya tiene contratado el usuario
		for (Servicio servicio : servicios) {
			if (servicio.getNombre().contains("Movil")) {
				movilCB.setValue(servicio);
				movilActual = servicio;
			}

			if (servicio.getNombre().contains("Fijo")) {
				fijoCB.setValue(servicio);
				fijoActual = servicio;
			}
			if (servicio.getNombre().contains("Fibra")) {
				fibraCB.setValue(servicio);
				fibraActual = servicio;
			}
			if (servicio.getNombre().contains("Televisión")) {
				televisionCB.setValue(servicio);
				televisionActual = servicio;
			}
		}

		// añadimos la posibilidad de Modificar el servicio a uno de los
		// dispoinbles

		Movil[] tMovil = iCm.cargarTarifasMovil();
		for (Movil movil : tMovil)
			if (movil.getEstado()) {
				/*
				 * Servicio aux = new Servicio(); aux.setId(movil.getId());
				 * aux.setNombre(movil.getNombre());
				 */
				sMovilD.add(movil);
			}
		movilCB.setItems(sMovilD);

		Fijo[] tFijo = iCm.cargarTarifasFijo();
		for (Fijo fijo : tFijo)
			if (fijo.getEstado()) {
				/*
				 * Servicio aux = new Servicio(); aux.setId(fijo.getID());
				 * aux.setNombre(fijo.getNombre());
				 */
				sFijoD.add(fijo);
			}
		fijoCB.setItems(sFijoD);

		Fibra[] tFibra = iCm.cargarTarifasFibra();
		for (Fibra fibra : tFibra)
			if (fibra.getEstado()) {
				/*
				 * Servicio aux = new Servicio(); aux.setId(fibra.getID());
				 * aux.setNombre(fibra.getNombre());
				 */
				sFibraD.add(fibra);
			}
		fibraCB.setItems(sFibraD);

		Television[] tTelevision = iCm.cargarTarifasTelevision();
		for (Television tv : tTelevision)
			if (tv.getEstado()) {
				/*
				 * Servicio aux = new Servicio(); aux.setId(tv.getID());
				 * aux.setNombre(tv.getNombre());
				 */
				sTvD.add(tv);
			}
		televisionCB.setItems(sTvD);

		movilCB.addValueChangeListener(ClickEvent -> {
			modMovil = true;
		});

		fijoCB.addValueChangeListener(ClickEvent -> {
			modFijo = true;
		});

		fibraCB.addValueChangeListener(ClickEvent -> {
			modFibra = true;
		});

		televisionCB.addValueChangeListener(ClickEvent -> {
			modTelevision = true;
		});

		// Boton Aceptar
		aceptarB.addClickListener(ClickEvent -> {
			ArrayList<Servicio> nServicios = new ArrayList<>();
			if (!movilCB.isEmpty() && modMovil)
				nServicios.add(movilCB.getValue());
			else if (movilActual != null && !modMovil)
				nServicios.add(movilActual);
			if (!fijoCB.isEmpty() && modFijo)
				nServicios.add(fijoCB.getValue());
			else if (fijoActual != null && !modFijo)
				nServicios.add(fijoActual);
			if (!fibraCB.isEmpty() && modFibra)
				nServicios.add(fibraCB.getValue());
			else if (fibraActual != null && !modFibra)
				nServicios.add(fibraActual);
			if (!televisionCB.isEmpty() && modTelevision)
				nServicios.add(televisionCB.getValue());
			else if (televisionActual != null && !modTelevision)
				nServicios.add(televisionActual);
			servicios = nServicios.toArray(new Servicio[nServicios.size()]);
			// mod
			int idFactura = c.factura.toArray()[0].getID();
			if (modMovil || modFijo || modFibra || modTelevision) {
				if (iC.modificarServicios(servicios, idFactura)) {
					Notification.show("Servicios Actualizados Correctamente");
					this.removeAllComponents();
					this.addComponent(new ModificarServiciosCm());
				} else
					Notification.show("Ups Algo fue mal, habla con un Administrador");
			} else {
				this.removeAllComponents();
				this.addComponent(new ModificarServiciosCm());
			}
		});
		/*
		 * aceptarB.addClickListener(ClickEvent -> { ArrayList<Servicio>
		 * nServicios = new ArrayList<>(); if (!movilCB.isEmpty())
		 * nServicios.add(movilCB.getValue()); if (!fijoCB.isEmpty())
		 * nServicios.add(fijoCB.getValue()); if (!fibraCB.isEmpty())
		 * nServicios.add(fibraCB.getValue()); if (!televisionCB.isEmpty())
		 * nServicios.add(televisionCB.getValue()); servicios =
		 * nServicios.toArray(new Servicio[nServicios.size()]); int idFactura =
		 * c.factura.toArray()[0].getID(); if (iCm.modificarServicios(servicios,
		 * idFactura)) {
		 * Notification.show("Servicios Actualizados Correctamente");
		 * this.removeAllComponents(); this.addComponent(new
		 * ModificarServiciosCm()); } else
		 * Notification.show("Ups Algo fue mal, habla con un Administrador");
		 * 
		 * });
		 */

		// Boton PaquetesCliente
		televisionB.addClickListener(ClickEvent -> {
			Window subWindow = new Window("Paquetes Contratados Cliente");
			VerticalLayout subcontent = new VerticalLayout();
			subcontent.addComponent(new PaquetesContratadosCm());
			subWindow.setContent(subcontent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("700px");
			subWindow.setWidth("700px");

			this.getUI().addWindow(subWindow);
		});

		// Botón Terminales
		this.terminalesB.addClickListener(ClickEvent -> {
			Window subWindow = new Window("Terminales");
			VerticalLayout subcontent = new VerticalLayout();
			subcontent.addComponent(new Terminales(c));
			subWindow.setContent(subcontent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("400px");
			subWindow.setWidth("400px");

			this.getUI().addWindow(subWindow);
		});
	}
}
