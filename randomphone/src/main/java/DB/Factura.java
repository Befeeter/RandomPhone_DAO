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
}