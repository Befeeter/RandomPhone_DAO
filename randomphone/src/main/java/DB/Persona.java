package DB;

public class Persona {
	public Persona(int id, String documento, String nombre, String apellidos, String contrasena, String email) {
		super();
		this.id = id;
		this.documento = documento;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.contrasena = contrasena;
		this.email = email;
	}

	private int id;
	private String documento;
	private String nombre;
	private String apellidos;
	private String contrasena;
	private String email;
	
	public Persona (){
		this.documento = "123456";
		this.nombre = "";
		this.apellidos = "";
		this.contrasena = "";
		this.email = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}