package com.randomteam.ventanas;

import java.util.Vector;

import com.vaadin.data.HasValue;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.components.grid.MultiSelectionModel;

import DB.BD_Principal;
import DB.Incidencia;
import DB.iAdministrador;

public class ListadoIncidencias extends ListadoIncidencias_ventana {
	/*
	 * private Label tituloL; private TextField buscarTF; private Label
	 * sinAsignarL; private Label cibernautaL; private IncidenciaSinAsig
	 * cibernautaLS; private Label clienteL; private IncidenciaSinAsig
	 * clienteLS; private Label asignadasL; private IncidenciaAsig asignadasLS;
	 * private Label completadasL; private IncidenciaComp completadasLS; private
	 * Button asignarB; private Button eliminarB; public PanelAdministrador
	 * vPanelAdministrador; public Vector<IncidenciaSinAsig> vIncidenciaSinAsig
	 * = new Vector<IncidenciaSinAsig>(); public Vector<IncidenciaAsig>
	 * vIncidenciaAsig = new Vector<IncidenciaAsig>(); public
	 * Vector<IncidenciaComp> vIncidenciaComp = new Vector<IncidenciaComp>();
	 * public EditarIncidencia vEditarIncidencia; public AsignarComercial
	 * vAsignarComercial;
	 */
	iAdministrador iA = new BD_Principal();
	Incidencia[] incidenciasSinAsigCiber = iA.cargarIncidenciasSinAsignarCibernauta();
	Incidencia[] incidenciasSinAsigClientes = iA.cargarIncidenciasSinAsignarCLientes();
	Incidencia[] incidenciasAsig = iA.cargarIncidenciasAsignadas();
	Incidencia[] incidenciasCompletadas = iA.cargarIncidenciasCompletadas();

	public ListadoIncidencias() {
		// Busqueda
		buscarTF.setPlaceholder("Asunto...");
		buscarTF.addValueChangeListener(this::onNameFilterTextChange);

		// Creamos Grid cibernauta sin asignar cibernauta
		cibernautaLS.addColumn(Incidencia::getAsunto).setCaption("Asunto").setSortable(true);
		cibernautaLS.addColumn(Incidencia::getFecha_alta).setCaption("Fecha alta").setSortable(true);
		cibernautaLS.setItems(incidenciasSinAsigCiber);
		cibernautaLS.addItemClickListener(event -> {
			// Creamos Ventana Emergente
			// seleccionada en el Grid
			Window subWindow = new Window("Editar incidencia");
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(new EditarIncidencia(event.getItem()));
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("700px");
			subWindow.setWidth("600px");
			subWindow.addCloseListener(Event -> {
				incidenciasSinAsigCiber = iA.cargarIncidenciasSinAsignarCibernauta();
				cibernautaLS.setItems(incidenciasSinAsigCiber);
			});
			this.getUI().addWindow(subWindow);
		});
		MultiSelectionModel<Incidencia> selectionModel = (MultiSelectionModel<Incidencia>) cibernautaLS
				.setSelectionMode(SelectionMode.MULTI);
		selectionModel.addMultiSelectionListener(event -> {
			eliminarB.setEnabled(event.getNewSelection().size() > 0);
			asignarB.setEnabled(event.getNewSelection().size() > 0);
		});

		// Creamos Grid sin asignar cliente
		clienteLS.addColumn(Incidencia::getAsunto).setCaption("Asunto").setSortable(true);
		clienteLS.addColumn(Incidencia::getFecha_alta).setCaption("Fecha alta").setSortable(true);
		clienteLS.setItems(incidenciasSinAsigClientes);
		clienteLS.addItemClickListener(event -> {
			// Creamos Ventana Emergente
			// seleccionada en el Grid
			Window subWindow = new Window("Editar incidencia");
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(new EditarIncidencia(event.getItem()));
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("700px");
			subWindow.setWidth("600px");
			subWindow.addCloseListener(Event -> {
				incidenciasSinAsigClientes = iA.cargarIncidenciasSinAsignarCibernauta();
				clienteLS.setItems(incidenciasSinAsigClientes);
			});
			this.getUI().addWindow(subWindow);
		});
		MultiSelectionModel<Incidencia> selectionModel2 = (MultiSelectionModel<Incidencia>) clienteLS
				.setSelectionMode(SelectionMode.MULTI);
		selectionModel2.addMultiSelectionListener(event -> {
			eliminarB.setEnabled(event.getNewSelection().size() > 0);
			asignarB.setEnabled(event.getNewSelection().size() > 0);
		});

		// Creamos Grid asignadas
		asignadasLS.addColumn(Incidencia::getAsunto).setCaption("Asunto").setSortable(true);
		asignadasLS.addColumn(Incidencia::getIdComercial).setCaption("Comercial").setSortable(true);
		asignadasLS.addColumn(Incidencia::getFecha_alta).setCaption("Fecha alta").setSortable(true);
		asignadasLS.setItems(incidenciasAsig);
		asignadasLS.addItemClickListener(event -> {
			// Creamos Ventana Emergente
			// seleccionada en el Grid
			Window subWindow = new Window("Editar incidencia");
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(new EditarIncidencia(event.getItem()));
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("700px");
			subWindow.setWidth("600px");
			subWindow.addCloseListener(Event -> {
				incidenciasAsig = iA.cargarIncidenciasSinAsignarCibernauta();
				asignadasLS.setItems(incidenciasAsig);
			});
			this.getUI().addWindow(subWindow);
		});
		MultiSelectionModel<Incidencia> selectionModel3 = (MultiSelectionModel<Incidencia>) asignadasLS
				.setSelectionMode(SelectionMode.MULTI);
		selectionModel3.addMultiSelectionListener(event -> {
			eliminarB.setEnabled(event.getNewSelection().size() > 0);
			asignarB.setEnabled(event.getNewSelection().size() > 0);
		});

		// Creamos Grid completadas
		completadasLS.addColumn(Incidencia::getAsunto).setCaption("Asunto").setSortable(true);
		completadasLS.addColumn(Incidencia::getFecha_alta).setCaption("Fecha alta").setSortable(true);
		completadasLS.setItems(incidenciasCompletadas);
		completadasLS.addItemClickListener(event -> {
			// Creamos Ventana Emergente
			// seleccionada en el Grid
			Window subWindow = new Window("Editar incidencia");
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(new EditarIncidencia(event.getItem()));
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("700px");
			subWindow.setWidth("600px");
			subWindow.addCloseListener(Event -> {
				incidenciasCompletadas = iA.cargarIncidenciasSinAsignarCibernauta();
				completadasLS.setItems(incidenciasCompletadas);
			});
			this.getUI().addWindow(subWindow);
		});

		// Botón Eliminar
		eliminarB.addClickListener(ClickEvent -> {
			eliminarIncidencias(cibernautaLS);
			eliminarIncidencias(clienteLS);
			eliminarIncidencias(asignadasLS);
		});

		// Botón asignar
		asignarB.addClickListener(ClickEvent -> {
			// obtener elementos a asignar
			Incidencia[] incidenciasAsignarCiber;
			int size = cibernautaLS.getSelectedItems().size();
			incidenciasAsignarCiber = new Incidencia[size];
			incidenciasAsignarCiber = cibernautaLS.getSelectedItems().toArray(incidenciasAsignarCiber);

			Incidencia[] incidenciasAsignarCli;
			size = clienteLS.getSelectedItems().size();
			incidenciasAsignarCli = new Incidencia[size];
			incidenciasAsignarCli = clienteLS.getSelectedItems().toArray(incidenciasAsignarCli);

			Incidencia[] incidenciasAsigar;
			size = asignadasLS.getSelectedItems().size();
			incidenciasAsigar = new Incidencia[size];
			incidenciasAsigar = asignadasLS.getSelectedItems().toArray(incidenciasAsigar);

			// asignar comercial
			Window subWindow = new Window("Asignar incidencia");
			VerticalLayout subContent = new VerticalLayout();
			subContent.addComponent(
					new AsignarComercial(incidenciasAsignarCiber, incidenciasAsignarCli, incidenciasAsigar));
			subWindow.setContent(subContent);
			subWindow.center();
			subWindow.setModal(true);
			subWindow.setHeight("800px");
			subWindow.setWidth("600px");
			subWindow.addCloseListener(Event -> {
				// recargar
				incidenciasSinAsigCiber = iA.cargarIncidenciasSinAsignarCibernauta();
				cibernautaLS.setItems(incidenciasSinAsigCiber);
				//
				incidenciasSinAsigClientes = iA.cargarIncidenciasSinAsignarCLientes();
				clienteLS.setItems(incidenciasSinAsigClientes);
				//
				incidenciasAsig = iA.cargarIncidenciasAsignadas();
				asignadasLS.setItems(incidenciasAsig);
				//
				incidenciasCompletadas = iA.cargarIncidenciasCompletadas();
				completadasLS.setItems(incidenciasCompletadas);
			});
			this.getUI().addWindow(subWindow);
		});

	}

	// para filtrar los grid
	private void onNameFilterTextChange(HasValue.ValueChangeEvent<String> event) {
		ListDataProvider<Incidencia> dataProvider = (ListDataProvider<Incidencia>) cibernautaLS.getDataProvider();
		dataProvider.setFilter(Incidencia::getAsunto, s -> caseInsensitiveContains(s, event.getValue()));

		ListDataProvider<Incidencia> dataProvider2 = (ListDataProvider<Incidencia>) clienteLS.getDataProvider();
		dataProvider2.setFilter(Incidencia::getAsunto, s -> caseInsensitiveContains(s, event.getValue()));

		ListDataProvider<Incidencia> dataProvider3 = (ListDataProvider<Incidencia>) asignadasLS.getDataProvider();
		dataProvider3.setFilter(Incidencia::getAsunto, s -> caseInsensitiveContains(s, event.getValue()));

		ListDataProvider<Incidencia> dataProvider4 = (ListDataProvider<Incidencia>) completadasLS.getDataProvider();
		dataProvider4.setFilter(Incidencia::getAsunto, s -> caseInsensitiveContains(s, event.getValue()));
	}

	private Boolean caseInsensitiveContains(String where, String what) {
		return where.toLowerCase().contains(what.toLowerCase());
	}

	private void eliminarIncidencias(Grid<Incidencia> grid) {
		// obtener elementos a eliminar
		Incidencia[] incidenciasEliminar;
		int size = grid.getSelectedItems().size();
		incidenciasEliminar = new Incidencia[size];
		incidenciasEliminar = grid.getSelectedItems().toArray(incidenciasEliminar);
		//
		boolean correcto = true;
		
		// Para cada incidencia seleccionada la elimino
		if (!iA.eliminarIncidencias(incidenciasEliminar)) {
			correcto = false;
		}
		if (correcto) {
			recargarIncidencias();
			Notification.show("Eliminadas Con exito!");
		} else
			Notification.show("Error! Ups algo fue mal!");
	}
	
	private void recargarIncidencias () {
		incidenciasSinAsigCiber = iA.cargarIncidenciasSinAsignarCibernauta();
		cibernautaLS.setItems(incidenciasSinAsigCiber);
		incidenciasSinAsigClientes = iA.cargarIncidenciasSinAsignarCibernauta();
		clienteLS.setItems(incidenciasSinAsigClientes);
		incidenciasAsig = iA.cargarIncidenciasSinAsignarCibernauta();
		asignadasLS.setItems(incidenciasAsig);
		incidenciasCompletadas = iA.cargarIncidenciasSinAsignarCibernauta();
		completadasLS.setItems(incidenciasCompletadas);
	}
}