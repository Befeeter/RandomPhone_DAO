package DB;

import DB.Paquete;

public class BD_Paquetes {
	public BD_Principal bD_Principal_paquetes;
	public Paquete[] paquete = new Paquete[0];

	public Servicio[] cargarOfertas() {
		throw new UnsupportedOperationException();
	}

	public Paquete[] cargarPaquetes(int id) {
		throw new UnsupportedOperationException();
	}

	public void guardarPaquetePer(Canal[] canales) {
		throw new UnsupportedOperationException();
	}

	public Paquete[] cargarPaquetesDisp() {
		throw new UnsupportedOperationException();
	}

	public Paquete[] cargarPaquetes() {
		throw new UnsupportedOperationException();
	}

	public boolean crearPaquete(Paquete paquete) {
		throw new UnsupportedOperationException();
	}

	public boolean editarPaquete(Paquete paquete, Paquete paqueteNueva) {
		throw new UnsupportedOperationException();
	}

	public Canal[] cargarCanalesPaquete(Paquete paquete) {
		throw new UnsupportedOperationException();
	}

	public boolean añadirCanalesAPaquete(Paquete paquete, Canal[] canales) {
		throw new UnsupportedOperationException();
	}

	public boolean eliminarCanalesPaquete(Canal[] canales) {
		throw new UnsupportedOperationException();
	}

	public boolean eliminarPaquete(Paquete paquete) {
		throw new UnsupportedOperationException();
	}
}