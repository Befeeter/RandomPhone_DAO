package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.Incidencia;

public class BD_Incidencias {
	public BD_Principal bD_Principal_incidencias;
	public Incidencia[] incidencia = new Incidencia[0];

	public void crearIncidencia(Incidencia incidencia) {
		bD_Principal_incidencias.crearIncidencia(incidencia);
	}

	public boolean asginarIncidencia(Incidencia incidencia, Comercial comercial) {
		return bD_Principal_incidencias.asignarIncidencia(incidencia, comercial);
	}

	/*public Incidencia cargarIncidencia(int id_incidencia) {
		Incidencia incidencia = new Incidencia();
		incidencia.setId(id_incidencia);
		return bD_Principal_incidencias.cargarIncidencia(incidencia);
	}*/

	public boolean editarIncidencia(Incidencia incidencia, Incidencia nuevaIncidencia) {
		return bD_Principal_incidencias.editarIncidencia(incidencia);
	}

	public Incidencia[] cargarIncidenciasSinAsignarCibernauta() {
		return bD_Principal_incidencias.cargarIncidenciasSinAsignarCibernauta();
	}

	public Incidencia[] cargarIncidenciasSinAsignarClientes() {
		return bD_Principal_incidencias.cargarIncidenciasSinAsignarCLientes();
	}

	public Incidencia[] cargarIncidenciasCompletadas() {
		return bD_Principal_incidencias.cargarIncidenciasCompletadas();
	}

	public boolean eliminarIncidencias(Incidencia[] incidencias) {
		return bD_Principal_incidencias.eliminarIncidencias(incidencias);
	}
/*
	public Incidencia[] incidenciasActivasComercial(Comercial comercial) {
		return bD_Principal_incidencias.incidenciasas(comercial);
	}*/

	public Incidencia[] cargarIncidenciasCliente(int id_cliente) {
		return bD_Principal_incidencias.cargarIncidencias(id_cliente);
	}

	public Incidencia[] cargarIncidenciasComercial(int id_comercial) {
		return bD_Principal_incidencias.cargarIncidenciasCm(id_comercial);
	}
}