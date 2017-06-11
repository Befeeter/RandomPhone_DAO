package DB;

import java.sql.Date;

public class Incidencia {
	private int id;
	private String asunto;
	private String tipo;
	private int telefono;
	private String texto;
	private String respuesta;
	private String estado;
	private Date fecha_alta;
	public Cliente cliente;
	public BD_Incidencias bD_Incidencias;
	public Comercial comercial;
	
	
	public Incidencia(){
		
	}
	
	public Incidencia(int id, String asunto, String tipo, int telefono, String texto, String respuesta, String estado, Date fecha_alta){
		this.id = id;
		this.asunto = asunto;
		this.tipo = tipo;
		this.telefono = telefono;
		this.texto = texto;
		this.respuesta = respuesta;
		this.estado = estado;		
		this.fecha_alta = fecha_alta;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String ausnto) {
		this.asunto = ausnto;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public BD_Incidencias getbD_Incidencias() {
		return bD_Incidencias;
	}
	public void setbD_Incidencias(BD_Incidencias bD_Incidencias) {
		this.bD_Incidencias = bD_Incidencias;
	}
	public Comercial getComercial() {
		return comercial;
	}
	public void setComercial(Comercial comercial) {
		this.comercial = comercial;
	}

	public Date getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	

	
	
}