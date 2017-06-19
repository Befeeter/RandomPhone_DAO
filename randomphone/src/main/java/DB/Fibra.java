package DB;

public class Fibra extends Servicio {
	private int vsub;
	private int vbaj;
	public BD_fibras bD_fibras;
	
	public Fibra () {
		
	}
	
	public Fibra (int vsub, int vbaj, int id, String nombre, float precio, boolean estado) {
		super(id, nombre, precio, estado);
		this.vsub = vbaj;
		this.vbaj = vbaj;
	}

	public int getVsub() {
		return vsub;
	}

	public int getVbaj() {
		return vbaj;
	}

	public BD_fibras getbD_fibras() {
		return bD_fibras;
	}

	public void setVsub(int vsub) {
		this.vsub = vsub;
	}

	public void setVbaj(int vbaj) {
		this.vbaj = vbaj;
	}

	public void setbD_fibras(BD_fibras bD_fibras) {
		this.bD_fibras = bD_fibras;
	}
}