package DB;

public class Administrador extends Persona {
	private String email;
	private String contrasena;
	public BD_Administradores bD_Administradores;
	
	public Administrador () {
		
	}
	
	public Administrador(int id, String documento, String nombre, String apellidos, String contrasena, String email,
			String email2, String contrasena2) {
		super(id, documento, nombre, apellidos, contrasena, email);
		email = email2;
		contrasena = contrasena2;
	}
	
	public String getEmail() {
		return email;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public BD_Administradores getbD_Administradores() {
		return bD_Administradores;
	}
	public void setbD_Administradores(BD_Administradores bD_Administradores) {
		this.bD_Administradores = bD_Administradores;
	}
}