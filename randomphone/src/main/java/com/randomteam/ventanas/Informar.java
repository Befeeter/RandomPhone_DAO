package com.randomteam.ventanas;
public class Informar {
	/*
	private Label mensajeL;
	*/
	static boolean isNumeric(String cadena){
		try {
			Float.parseFloat(cadena);
			//Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
	static boolean isNumericInt(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
}