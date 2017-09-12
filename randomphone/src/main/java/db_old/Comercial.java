package db_old;

import java.sql.Date;

import DB.Incidencia;

public class Comercial extends Persona {
	private Date fecha_alta;
	private Date fecha_baja;
	private boolean estado;
	public Incidencia[] incidencia = new Incidencia[0];
	public BD_Comerciales bD_Comerciales;

	public Comercial() {
		this.setId(0);

	}

	public Comercial(int id, String documento, String nombre, String apellidos, String contrasena, String email,
			Date fecha_alta, boolean estado) {
		this.setId(id);
		this.setDocumento(documento);
		this.setNombre(nombre);
		this.setApellidos(apellidos);
		this.setContrasena(contrasena);
		this.setEmail(email);
		this.fecha_alta = fecha_alta;
		this.fecha_baja = null;
		this.estado = estado;
	}

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
	
	public int getNumincidenciasActivas () {
		iComercial ic = new BD_Principal();
		return ic.cargarIncidenciasCm(this.getId()).length;
	}
}