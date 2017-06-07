package DB;

import DB.Factura;

public class Servicio {
	private int id;
	private String nombre;
	private float precio;
	private boolean estado;
	public Factura[] factura = new Factura[0];
	
	public Servicio(){
		
	}
	
	public Servicio (int id, String nombre, float precio, boolean estado){
		this.id=id;
		this.nombre=nombre;
		this.precio=precio;
		this.estado=estado;
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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Factura[] getFactura() {
		return factura;
	}

	public void setFactura(Factura[] factura) {
		this.factura = factura;
	}
	
	
}