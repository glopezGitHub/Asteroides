package org.example.asteroides;

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

		setContentView(R.layout.activity_splash);

		ProgressBar progressBar = (ProgressBar) findViewById(R.id.activity_splash_progress_bar);

		splashTask = new LoadingTask(progressBar, this).execute();
	
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
		
		if ((keyCode == KeyEvent.KEYCODE_BACK)) {
			stop = true;
			splashTask.cancel(true);
			finish();			
		}

		return true;
	}

}
