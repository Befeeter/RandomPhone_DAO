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
		throw new UnsupportedOperationException();
	}

	public boolean asginarIncidencia(Incidencia incidencia, Comercial comercial) {
		throw new UnsupportedOperationException();
	}

	public Incidencia cargarIncidencia(int id_incidencia) {
		throw new UnsupportedOperationException();
	}

	public boolean editarIncidencia(Incidencia incidencia, Incidencia nuevaIncidencia) {
		throw new UnsupportedOperationException();
	}

	public Incidencia[] cargarIncidenciasSinAsignarCibernauta() {
		throw new UnsupportedOperationException();
	}

	public Incidencia[] cargarIncidenciasSinAsignarClientes() {
		throw new UnsupportedOperationException();
	}

	public Incidencia[] cargarIncidenciasCompletadas() {
		throw new UnsupportedOperationException();
	}

	public boolean eliminarIncidencias(Incidencia[] incidencias) {
		throw new UnsupportedOperationException();
	}

	public Incidencia[] incidenciasActivasComercial(Comercial comercial) {
		throw new UnsupportedOperationException();
	}

	public Incidencia[] cargarIncidenciasCliente(int id_cliente) {
		throw new UnsupportedOperationException();
	}

	public Incidencia[] cargarIncidenciasComercial(int id_comercial) {
		throw new UnsupportedOperationException();
	}
}