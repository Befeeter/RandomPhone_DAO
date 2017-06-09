package com.randomteam.ventanas;

import com.vaadin.server.VaadinService;

import DB.Cliente;

public class ModificarDatosPersonales extends ModificarDatosPersonales_ventana {
	/*
	private Label tituloL;
	private Label nombreL;
	private TextField nombreTF;
	private Label apellidosL;
	private TextField apellidosTF;
	private Label emailL;
	private TextField emailTF;
	private Button cancelarB;
	private Button aceptarB;
	private Label telefonoL;
	private TextField telefonoTF;
	public MiCuenta vMiCuenta;
	*/
	
	Cliente c = (Cliente) VaadinService.getCurrentRequest().getWrappedSession().getAttribute("usuario");

	public ModificarDatosPersonales(){
		
		//Cargamos los datos actuales del cliente.
		this.nombreTF.setValue(c.getNombre());
		this.apellidoTF.setValue(c.getApellidos());
		this.correoTF.setValue(c.getEmail());
		this.telefonoTF.setValue(Integer.toString(c.getTelefono()));
		
		
		//Botón Cancelar vuelve a Mi Pagina (cliente)
		cancelarB.addClickListener(ClickEvent -> {
			this.getUI().setContent(new SitioWebCliente());
		});
		
		aceptarB.addClickListener(ClickEvent ->{
			//Actualizamos el objeto cliente
			c.setNombre(this.nombreTF.getValue());
			c.setApellidos(this.apellidoTF.getValue());
			c.setEmail(this.correoTF.getValue());
			c.setTelefono(Integer.parseInt(this.telefonoTF.getValue()));
			
			//Falta añadir consulta a la BDD con UPDATE.
		});
	}
	
	public Informar enviarDatos() {
		throw new UnsupportedOperationException();
	}
}