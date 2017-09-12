package db_old;

public interface iInternauta {
	
	public Cliente cargarDatosCliente(String dni);

	public int comprobarUsuario(String email, String contrasenia);

	public boolean crearIncidencia(Incidencia incidencia);

	public Servicio[] cargarOfertas();

	public Servicio[] cargarOfertas(Servicio tipo);
	
	public String comprobarUsuario(String email);

	//public void resetPass(String email);
}