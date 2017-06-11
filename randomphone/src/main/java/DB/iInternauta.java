package DB;

public interface iInternauta {

	public int comprobarUsuario(String email, String contrasenia);

	public boolean crearIncidencia(Incidencia incidencia);

	public Servicio[] cargarOfertas();

	public Servicio[] cargarOfertas(Servicio tipo);

	public void resetPass(String email);
}