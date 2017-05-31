package DB;

import java.sql.Date;

import DB.Paquete;

public class Canal {
	private int id;
	private String nombre;
	private float precio;
	private Date fecha_alta;
	private boolean estado;
	public Paquete[] paquete = new Paquete[0];
	public BD_Canales bD_Canales;
}