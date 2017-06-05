package DB;

public interface iInternauta {

	public boolean comprobarUsuario(String email, String contrasenia);

	public void crearIncidencia(Incidencia incidencia);

	public Servicio[] cargarOfertas();

	public Servicio[] cargarOfertas(Servicio tipo);

	public void resetPass(String email);
}