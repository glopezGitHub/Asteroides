package org.example.asteroides;

import or.example.resourceManager.SoundManager;

import org.example.task.LoadingTask;
import org.example.task.LoadingTask.LoadingTaskFinishedListener;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.ProgressBar;

public class Splash extends Activity implements LoadingTaskFinishedListener {

	private boolean stop = false;
	private AsyncTask splashTask =null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		// Ocultar el titulo
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		//Establecemos la ventana de splash
		setContentView(R.layout.activity_splash);

		//Mostramos el progressBar
		ProgressBar progressBar = (ProgressBar) findViewById(R.id.activity_splash_progress_bar);
		
		/*Creamos la tarea*/
		splashTask = new LoadingTask(progressBar, this).execute();

		SoundManager.getInstance().initSouns(this);
	
	}

	@Override
	public void onTaskFinished() {
		if (!stop) {
			Intent intent = new Intent(Splash.this, Localizacion.class);
			startActivity(intent);
			finish();
		}
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		/*Si cancelamos antes de que carge hay que cancelar la tarea y finalizar*/
		if ((keyCode == KeyEvent.KEYCODE_BACK)) {
			stop = true;
			splashTask.cancel(true);
			finish();			
		}

		return true;
	}

}
