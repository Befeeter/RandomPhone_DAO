package DB;

import DB.Paquete;

public class BD_Paquetes {
	public BD_Principal bD_Principal_paquetes;
	public Paquete[] paquete = new Paquete[0];

	public Servicio[] cargarOfertas() {
		return bD_Principal_paquetes.cargarOfertas();
	}
/*
	public Paquete[] cargarPaquetes(int id) {
		return bD_Principal_paquetes.cargarPaquetesTV();
	}
*/
	/*
	public void guardarPaquetePer(Canal[] canales) {
		throw new UnsupportedOperationException();
	}*/

	public Paquete[] cargarPaquetesDisp() {
		return bD_Principal_paquetes.cargarPaquetesDisp();
	}

	public Paquete[] cargarPaquetes() {
		return bD_Principal_paquetes.cargarPaquetesTV();
	}

	public boolean crearPaquete(Paquete paquete) {
		return bD_Principal_paquetes.crearPaquete(paquete);
	}
/*
	public boolean editarPaquete(Paquete paquete, Paquete paqueteNueva) {
		return bD_Principal_paquetes.editar;
	}
*/
	/*
	public Canal[] cargarCanalesPaquete(Paquete paquete) {
		bD_Principal_paquetes.cargarCanalesPaquete(paquete);
	}
*/
	public boolean añadirCanalesAPaquete(Paquete paquete, Canal[] canales) {
		return bD_Principal_paquetes.añadirCanalesAPaquete(paquete, canales);
	}
/*
	public boolean eliminarCanalesPaquete(Canal[] canales) {
		return bD_Principal_paquetes.eliminar
	}
*/
	public boolean eliminarPaquete(Paquete paquete) {
		return bD_Principal_paquetes.eliminarPaquete(paquete);
	}
}