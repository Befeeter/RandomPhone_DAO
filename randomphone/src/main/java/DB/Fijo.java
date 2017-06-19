package DB;

public class Fijo extends Servicio {
	private int minutos;
	public BD_Fijos bD_Fijos;
	
	public Fijo (int minutos, int id, String nombre, float precio, boolean estado) {
		super(id, nombre, precio, estado);
		this.minutos = minutos;
	}

	public Fijo() {
		// TODO Auto-generated constructor stub
	}

	public int getMinutos() {
		return minutos;
	}

	public BD_Fijos getbD_Fijos() {
		return bD_Fijos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public void setbD_Fijos(BD_Fijos bD_Fijos) {
		this.bD_Fijos = bD_Fijos;
	}
}