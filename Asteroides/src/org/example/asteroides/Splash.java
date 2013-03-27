package org.example.asteroides;

import org.example.task.LoadingTask;
import org.example.task.LoadingTask.LoadingTaskFinishedListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ProgressBar;

public class Splash extends Activity implements LoadingTaskFinishedListener {

	private long ms = 0;
	private long splashTime = 2000;
	private boolean splashActive = true;
	private boolean paused = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		// Ocultar el titulo
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_splash);

		ProgressBar progressBar = (ProgressBar) findViewById(R.id.activity_splash_progress_bar);

		new LoadingTask(progressBar, this).execute(); 
		
//		TimerTask task = new TimerTask() {
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				// ResourceManager
//
//				// *Carga de Imagenes Sonidos etc.
//
//				finish();
//				Intent intent = new Intent(Splash.this, Localizacion.class);
//				startActivity(intent);
//			}
//		};
//
//		/*Lanza el timer de carga*/
//		Timer timer = new Timer();
//		timer.schedule(task, splashTime);
	}

	@Override
	public void onTaskFinished() {
		finish();
		Intent intent = new Intent(Splash.this, Localizacion.class);
		startActivity(intent);
		
	}
}
