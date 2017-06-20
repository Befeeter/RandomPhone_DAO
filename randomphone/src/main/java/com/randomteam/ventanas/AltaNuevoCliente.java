package com.randomteam.ventanas;

import java.util.ArrayList;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import DB.BD_Clientes;
import DB.BD_Principal;
import DB.Fibra;
import DB.Fijo;
import DB.Movil;
import DB.Paquete;
import DB.iComercial;

public class AltaNuevoCliente extends AltaNuevoCliente_ventana {
	/*
	 * private Label tituloL; private Label nombreL; private TextField nombreTF;
	 * private Label apellidoL; private TextField apellidoTF; private Label
	 * documentoL; private TextField documentoTF; private Label emailL; private
	 * TextField emailTF; private Label telefonoL; private TextField telefonoTF;
	 * private Label tituloServicioL; private img movilI; private TarifaE
	 * movilLS; private img telefonoI; private TarifaE telefonoLS; private img
	 * fibraI; private TarifaE fibraLS; private img televisionI; private TarifaE
	 * televisionLS; private Button terminalesB; private Button darAltaB; public
	 * PanelAdministracionComercial vPanelAdministracionComercial; public
	 * TarifaE vTarifaE; public Terminales vTerminales;
	 */
	/*
	 * public Informar enviarDatos() { throw new
	 * UnsupportedOperationException(); }
	 */
	private iComercial iC = new BD_Principal();
	private Movil[] sMovil = iC.cargarTarifasMovil();
	private ArrayList<Movil> sMovilD = new ArrayList<Movil>();
	private Fijo[] sFijo = iC.cargarTarifasFijo();
	private ArrayList<Fijo> sFijoD = new ArrayList<Fijo>();
	private Fibra[] sFibra = iC.cargarTarifasFibra();
	private ArrayList<Fibra> sFibraD = new ArrayList<Fibra>();
	private Paquete[] sTv = null; // iC.cargarPaquetesDisp();
	private ArrayList<Paquete> sTvD = new ArrayList<Paquete>();
	// cargar Servicios Disponibles
	// private Movil[] tMovil = iC.cargarServiciosDisp();

	public AltaNuevoCliente() {
		this.movilL.setContentMode(ContentMode.HTML);
		this.movilL.setValue(VaadinIcons.PHONE.getHtml());
		this.fijoL.setContentMode(ContentMode.HTML);
		this.fijoL.setValue(VaadinIcons.PHONE_LANDLINE.getHtml());
		this.fibraL.setContentMode(ContentMode.HTML);
		this.fibraL.setValue(VaadinIcons.BUILDING.getHtml());
		this.televisionL.setContentMode(ContentMode.HTML);
		this.televisionL.setValue(VaadinIcons.MOVIE.getHtml());

		// Establecemos el Caption a mosotrar en el combobox del objeto
		// correspondiente.
		movilLS.setItemCaptionGenerator(Movil::getNombre);
		fijoLS.setItemCaptionGenerator(Fijo::getNombre);
		fibraLS.setItemCaptionGenerator(Fibra::getNombre);
		televisionLS.setItemCaptionGenerator(Paquete::getNombre);

		// Cargamos Los servicios activos Disponibles.
		for (Movil movil : sMovil)
			if (movil.isEstado() == true)
				sMovilD.add(movil);
		movilLS.setItems(sMovilD);

		for (Fijo fijo : sFijo)
			if (fijo.isEstado() == true)
				sFijoD.add(fijo);
		fijoLS.setItems(sFijoD);

		for (Fibra fibra : sFibra)
			if (fibra.isEstado() == true)
				sFibraD.add(fibra);
		fibraLS.setItems(sFibraD);

		/*
		 * for (Paquete paquete : sTv) if (paquete.isEstado() == true)
		 * televisionLS.setItems(paquete);
		 */

		// Ventana emergente para establecer Terminales
		terminalesB.addClickListener(ClickEvent -> {
			Window subWindow = new Window("Terminales");
			VerticalLayout subcontent = new VerticalLayout();
			subcontent.addComponent(new Terminales());
			subWindow.setContent(subcontent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("400px");
			subWindow.setWidth("400px");

			this.getUI().addWindow(subWindow);
		});

	}

	public boolean comprobarDocumento(Object string_documento) {
		throw new UnsupportedOperationException();
	}
}