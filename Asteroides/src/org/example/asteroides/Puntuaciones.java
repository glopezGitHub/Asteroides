package org.example.asteroides;

import org.example.adapters.PuntuacionesArrayAdapter;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class Puntuaciones extends ListActivity  {

	
	@Override public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_puntuaciones);
        
        
        PuntuacionesArrayAdapter adapter = new PuntuacionesArrayAdapter(
        		this, R.layout.elemento_lista, Localizacion.almacen.listaPuntuaciones(10));
        
        setListAdapter(adapter);
        
    }
}
