package DB;

import java.sql.Date;

import DB.Factura;
import DB.Incidencia;

public class Cliente extends Persona {
	private Date fecha_altta;
	private boolean estado;
	private int telefono;
	// public BD_Clientes bD_Clientes;
	public Factura[] factura = new Factura[0];
	public Incidencia[] incidencia = new Incidencia[0];
	
	
	public Cliente(){
		this.setNombre(null);
		this.fecha_altta = null;
		this.estado = false;
		this.telefono = 0;
		
	}


	public Date getFecha_altta() {
		return fecha_altta;
	}


	public void setFecha_altta(Date fecha_altta) {
		this.fecha_altta = fecha_altta;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public Factura[] getFactura() {
		return factura;
	}


	public void setFactura(Factura[] factura) {
		this.factura = factura;
	}


	public Incidencia[] getIncidencia() {
		return incidencia;
	}


	public void setIncidencia(Incidencia[] incidencia) {
		this.incidencia = incidencia;
	}
	
}