package DB;

import DB.Paquete;

public class Television extends Servicio {
	public Paquete[] paquete;
	public BD_Televisiones bD_Televisiones;

	public Television() {
		this.setId(1);
	}

	public Television(int servicioID, String nombre, float precio, boolean estado) {
		this.setId(servicioID);
		this.setNombre(nombre);
		this.setPrecio(precio);
		this.setEstado(estado);
	}
}