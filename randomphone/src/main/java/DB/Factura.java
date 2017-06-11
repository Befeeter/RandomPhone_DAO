package DB;

import java.sql.Date;

import DB.Servicio;
import DB.Terminal;

public class Factura {
	private int id;
	private Date fecha_ini;
	private Date fecha_fin;
	private float total;
	public Servicio[] servicio = new Servicio[0];
	public Cliente cliente;
	public Terminal[] terminal = new Terminal[0];
	
	
	
	public Factura (int id, Date fecha_ini, Date fecha_fin, float total){
		this.id = id;
		this.fecha_ini = fecha_ini;
		this.fecha_fin = fecha_fin;
		this.total = total;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha_ini() {
		return fecha_ini;
	}
	public void setFecha_ini(Date fecha_ini) {
		this.fecha_ini = fecha_ini;
	}
	public Date getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public Servicio[] getServicio() {
		return servicio;
	}
	public void setServicio(Servicio[] servicio) {
		this.servicio = servicio;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Terminal[] getTerminal() {
		return terminal;
	}
	public void setTerminal(Terminal[] terminal) {
		this.terminal = terminal;
	}
	
	
}