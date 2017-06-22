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

	public Paquete() {
		this.television = new Television();
	}

	public Paquete(int id, int idTv, String nombre, float precio, Date fecha_alta, boolean estado) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.fecha_alta = fecha_alta;
		this.estado = estado;
		this.television = new Television();
		this.television.setId(idTv);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Date getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public BD_Paquetes getbD_Paquetes() {
		return bD_Paquetes;
	}

	public void setbD_Paquetes(BD_Paquetes bD_Paquetes) {
		this.bD_Paquetes = bD_Paquetes;
	}

	public Canal[] getCanal() {
		return canal;
	}

	public void setCanal(Canal[] canal) {
		this.canal = canal;
	}

	public Television getTelevision() {
		return television;
	}

	public void setTelevision(Television television) {
		this.television = television;
	}

}