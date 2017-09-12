package DB;

import org.orm.PersistentException;

public interface iInternauta {
	
	public Cliente cargarDatosCliente(String dni);

	public int comprobarUsuario(String email, String contrasenia) throws PersistentException;

	public boolean crearIncidencia(Incidencia incidencia) throws PersistentException;

	public Servicio[] cargarOfertas();

	public Servicio[] cargarOfertas(Servicio tipo);
	
	public String comprobarUsuario(String email);

	//public void resetPass(String email);
}