package org.example.asteroides;

import org.example.asteroides.views.VistaJuego;

import android.app.Activity;
import android.os.Bundle;

public class Juego extends Activity {

	private VistaJuego vistaJuego;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.juego);
		vistaJuego = (VistaJuego) findViewById(R.id.VistaJuego);
	}

	@Override
	protected void onPause() {
		super.onPause();

		vistaJuego.pausar();

	}

	@Override
	protected void onResume() {
		super.onResume();
		
		vistaJuego.reanudar();
	}

	@Override
	protected void onDestroy() {
		
		vistaJuego.detener();
		super.onDestroy();
	}

}
