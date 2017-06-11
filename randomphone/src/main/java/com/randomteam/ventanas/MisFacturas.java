package com.randomteam.ventanas;

import java.sql.Date;

import com.vaadin.server.VaadinService;
import com.vaadin.ui.JavaScript;
import com.vaadin.ui.renderers.ButtonRenderer;

import DB.BD_Principal;
import DB.Cliente;
import DB.Factura;
import DB.iCliente;

public class MisFacturas extends MisFacturas_ventana {

	iCliente c = new BD_Principal();
	Cliente cliente = (Cliente) VaadinService.getCurrentRequest().getWrappedSession().getAttribute("usuario");
	/*
	 * private Label tituloL; private Factura facturasLS; public Factura
	 * vFactura; public MiCuenta vMiCuenta;
	 */

	public MisFacturas() {
		Factura[] facturas = c.cargarFacturas(cliente.getId());
		this.facturasLS.addColumn(Factura::getFecha_ini).setCaption("Fecha Inicio").setSortable(true);
		this.facturasLS.addColumn(Factura::getFecha_fin).setCaption("Fecha fin").setSortable(true);
		this.facturasLS.addColumn(Factura::getTotal).setCaption("Total").setSortable(true);
		this.facturasLS.addColumn(Factura -> "Imprimir", new ButtonRenderer(clickEvent -> {
			JavaScript.getCurrent().execute("print();");
		}));
		facturasLS.setItems(facturas);

		// cargamos la tabla Facturas
	}
}