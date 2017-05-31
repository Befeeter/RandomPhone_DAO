package DB;

import java.sql.Date;

import DB.Canal;

public class Paquete {
	private int id;
	private String nombre;
	private float precio;
	private Date fecha_alta;
	private boolean estado;
	public BD_Paquetes bD_Paquetes;
	public Canal[] canal = new Canal[0];
	public Television television;
}