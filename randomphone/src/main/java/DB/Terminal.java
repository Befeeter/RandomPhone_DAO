package DB;

public class Terminal {
	private int id;
	private String tipo;
	private boolean estado;
	public Factura factura;
	public BD_Terminales bD_Terminales;
	
	public Terminal(String tipo, boolean estado){
		this.tipo = tipo;
		this.estado = estado;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	public BD_Terminales getbD_Terminales() {
		return bD_Terminales;
	}
	public void setbD_Terminales(BD_Terminales bD_Terminales) {
		this.bD_Terminales = bD_Terminales;
	}
	
	
	
}