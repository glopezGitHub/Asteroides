package org.example.asteroides.puntuaciones;

import java.util.Vector;

import org.example.asteroides.interfaces.AlmacenPuntuaciones;

public class AlmacenPuntuacionesArray implements AlmacenPuntuaciones{
	
	Vector<String> puntuaciones;
	
	
	public AlmacenPuntuacionesArray() {
		 
        puntuaciones= new Vector<String>();

        puntuaciones.add("123000 Pepito Domingez");

        puntuaciones.add("111000 Pedro Martinez");

        puntuaciones.add("011000 Paco Pérez");

   }
	 
	public void guardarPuntuacion(int puntos,String nombre, long fecha) 
	{
		puntuaciones.add(0, puntos + " "+ nombre);
	}
	
	
	@Override
	public Vector<String> listaPuntuaciones(int cantidad) {
		// TODO Auto-generated method stub
		return puntuaciones;
	}

}
