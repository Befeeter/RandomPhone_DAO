package com.randomteam.ventanas;

import java.util.Vector;

import com.vaadin.data.HasValue;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.components.grid.MultiSelectionModel;

import DB.BD_Principal;
import DB.Cliente;
import DB.Incidencia;
import DB.iAdministrador;

public class ListadoClientes extends ListadoClientes_ventana {
	/*
	 * private Label tituloL; private TextField buscarTF; private Label
	 * incidenciasL; private Label fechaAltaL; private Button
	 * ordenarIncidenciasB; private Button ordenarFechaAltaB; private ClienteE
	 * clientesLS; public PanelAdministrador vPanelAdministrador; public
	 * Vector<ClienteE> vClienteE = new Vector<ClienteE>();
	 */
	iAdministrador iA = new BD_Principal();

	public ListadoClientes() {
		Cliente[] clientes = iA.cargarListadoClientes();
		// Busqueda
		buscarTF.setPlaceholder("Nombre...");
		buscarTF.addValueChangeListener(this::onNameFilterTextChange);

		// Creamos Grid Incidencias
		clientesLS.addColumn(Cliente::getNombre).setCaption("Nombre").setSortable(true);
		clientesLS.addColumn(Cliente::getNumIncidencias).setCaption("Incidencias").setSortable(true);
		clientesLS.addColumn(Cliente::getFecha_altta).setCaption("Fecha Alta").setSortable(true);
		clientesLS.setItems(clientes);
		clientesLS.addItemClickListener(event -> {
			Cliente cliente = event.getItem();
			VaadinService.getCurrentRequest().getWrappedSession().setAttribute("usuario", cliente);

			// seleccionada en el Grid
			Window subWindow = new Window(cliente.getNombre());
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(new MiCuenta());
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			this.getUI().addWindow(subWindow);
		});

	}

	private void onNameFilterTextChange(HasValue.ValueChangeEvent<String> event) {
		ListDataProvider<Cliente> dataProvider = (ListDataProvider<Cliente>) clientesLS.getDataProvider();
		dataProvider.setFilter(Cliente::getNombre, s -> caseInsensitiveContains(s, event.getValue()));
	}

	private Boolean caseInsensitiveContains(String where, String what) {
		return where.toLowerCase().contains(what.toLowerCase());
	}
}