package org.example.asteroides;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class Puntuaciones extends ListActivity  {

	
	@Override public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_puntuaciones);
        
        setListAdapter(new ArrayAdapter<String>(this,
                      R.layout.elemento_lista,
                      R.id.titulo,
                      Localizacion.almacen.listaPuntuaciones(10)));
        
    }
}
