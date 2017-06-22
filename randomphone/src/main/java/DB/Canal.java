package DB;



import java.sql.Date;

import DB.Paquete;

public class Canal {
	
	private int id;
	private String nombre;
	private float precio;
	private Date fecha_alta;
	private boolean estado;
	//public Paquete[] paquete = new Paquete[0];
	//public BD_Canales bD_Canales;
	
	public Canal(int id, String nombre, float precio, Date date, boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.fecha_alta = date;
		this.estado = estado;
		//this.paquete = paquete;
	}
	public Canal() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public Date getFecha_alta() {
		return fecha_alta;
	}
	public boolean isEstado() {
		return estado;
	}/*
	public Paquete[] getPaquete() {
		return paquete;
	}
	public BD_Canales getbD_Canales() {
		return bD_Canales;
	}*/
	public void setId(int id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}/*
	public void setPaquete(Paquete[] paquete) {
		this.paquete = paquete;
	}
	public void setbD_Canales(BD_Canales bD_Canales) {
		this.bD_Canales = bD_Canales;
	}*/

}