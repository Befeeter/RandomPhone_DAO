package DB;

import java.sql.Date;

import DB.Factura;
import DB.Incidencia;

public class Cliente extends Persona {
	private Date fecha_altta;
	private boolean estado;
	private int telefono;
	public BD_Clientes bD_Clientes;
	public Factura[] factura = new Factura[0];
	public Incidencia[] incidencia = new Incidencia[0];
}