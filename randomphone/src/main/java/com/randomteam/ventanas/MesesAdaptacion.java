package com.randomteam.ventanas;

import com.vaadin.server.VaadinService;

public class MesesAdaptacion extends MesesAdaptacion_ventana {
	/*
	private Label mesesL;
	private TextField mesesTF;
	private Button aceptarB;
	public Tarifa vTarifa;
	*/
	public MesesAdaptacion() {
		aceptarB.addClickListener(ClickEvent ->{
			VaadinService.getCurrentRequest().getWrappedSession().setAttribute("mesesAdaptacion", mesesTF.getValue());
		});
	}
}