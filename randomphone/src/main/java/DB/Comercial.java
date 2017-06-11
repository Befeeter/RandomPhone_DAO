package DB;

import java.sql.Date;

import DB.Incidencia;

public class Comercial extends Persona {
	private Date fecha_alta;
	public Date getFecha_alta() {
		return fecha_alta;
	}
	public Date getFecha_baja() {
		return fecha_baja;
	}
	public boolean isEstado() {
		return estado;
	}
	public Incidencia[] getIncidencia() {
		return incidencia;
	}
	public BD_Comerciales getbD_Comerciales() {
		return bD_Comerciales;
	}
	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	public void setFecha_baja(Date fecha_baja) {
		this.fecha_baja = fecha_baja;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public void setIncidencia(Incidencia[] incidencia) {
		this.incidencia = incidencia;
	}
	public void setbD_Comerciales(BD_Comerciales bD_Comerciales) {
		this.bD_Comerciales = bD_Comerciales;
	}
	private Date fecha_baja;
	private boolean estado;
	public Incidencia[] incidencia = new Incidencia[0];
	public BD_Comerciales bD_Comerciales;
}