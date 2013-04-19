package org.example.asteroides;

import or.example.resourceManager.SoundManager;

import org.example.asteroides.interfaces.AlmacenPuntuaciones;
import org.example.asteroides.puntuaciones.AlmacenPuntuacionesArray;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Localizacion extends Activity {

	Button acercaDe;
	MediaPlayer mp;
	public static AlmacenPuntuaciones almacen = new AlmacenPuntuacionesArray();

	/* main */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_localizacion);

		acercaDe = (Button) findViewById(R.id.button4);

		// SoundManager.getInstance().playSoundLoop(SoundManager.SOUND_START);

		mp = MediaPlayer.create(this, R.raw.audio);

		//mp.start();

		acercaDe.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// Finish
				finish();
				SoundManager.getInstance().unloadAll();

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
		/** true -> el menú ya está visible */
	}

	public void lanzarAcercaDe(View view) {

		Intent i = new Intent(this, AcercaDe.class);

		startActivity(i);

	}

	public void lanzarPreferencias(View view) {

		Intent i = new Intent(this, Preferencias.class);

		startActivity(i);

	}

	public void lanzarJuego(View view) {

		Intent i = new Intent(this, Juego.class);

		startActivity(i);

	}

	public void lanzarPuntuaciones(View view) {

		Intent i = new Intent(this, Puntuaciones.class);

		startActivity(i);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.acercaDe:
			lanzarAcercaDe(null);
			break;
		case R.id.config:
			lanzarPreferencias(null);
			break;

		}
		return true;
		/** true -> consumimos el item, no se propaga */
	}

	@Override
	protected void onPause() {
		super.onPause();
		mp.pause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		mp.start();
	}

	@Override
	protected void onDestroy() {
		mp.release();
		super.onDestroy();
	}
	
	@Override
	   protected void onSaveInstanceState(Bundle estadoGuardado){
	          super.onSaveInstanceState(estadoGuardado);
	          if (mp != null) {
	                 int pos = mp.getCurrentPosition();
	                 estadoGuardado.putInt("posicion", pos);
	          }
	   }
	 
	   @Override
	   protected void onRestoreInstanceState(Bundle estadoGuardado){
	          super.onRestoreInstanceState(estadoGuardado);
	          if (estadoGuardado != null && mp != null) {
	                 int pos = estadoGuardado.getInt("posicion");
	                 mp.seekTo(pos);
	          }
	   }
	 

}
