package DB;

import java.sql.Date;

import DB.Incidencia;

public class Comercial extends Persona {
	private Date fecha_alta;
	private Date fecha_baja;
	private boolean estado;
	public Incidencia[] incidencia = new Incidencia[0];
	public BD_Comerciales bD_Comerciales;
}