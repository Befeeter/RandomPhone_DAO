package DB;

public class Movil extends Servicio {
	private int minutos;
	private int datos;
	public BD_Moviles bD_Moviles;
	
	public Movil(int minutos, int datos, int id, String nombre, float precio, boolean estado) {
		super(id, nombre, precio, estado);
		this.minutos = minutos;
		this.datos = datos;
	}
	
	public Movil() {
		// TODO Auto-generated constructor stub
	}

	public int getMinutos() {
		return minutos;
	}
	public int getDatos() {
		return datos;
	}
	public BD_Moviles getbD_Moviles() {
		return bD_Moviles;
	}
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}
	public void setDatos(int datos) {
		this.datos = datos;
	}
	public void setbD_Moviles(BD_Moviles bD_Moviles) {
		this.bD_Moviles = bD_Moviles;
	}
}