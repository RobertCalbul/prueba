package com.javacodegeeks.android.androidsocketclient;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class servicio extends Service {
	
	private Timer			mTimer	= null;
	public String			cadena;
	private int				tiempo	= 1;
	public List <String>	Arreglo = new ArrayList<String>();
	public Context context;
	
	
	@Override
	public IBinder onBind(Intent arg0) {
	
		return null;
	}
	
	@Override
	public void onCreate() {
	
		super.onCreate();
		
		this.mTimer = new Timer();
		this.mTimer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
			
				ejecutarTarea();
			}
		}, 0, (10000 * tiempo));
	}
	
	private void ejecutarTarea() {
	
		Thread t = new Thread(new Runnable() {
			
			public void run() {
			
				NotifyManager notificacion = new NotifyManager();
				String titleNotify = "Tienes una notificación";
				// httpHandler().post("http://192.168.0.106/otro.php", "1");
				List <String> cadena = new httpHandler().post("http://181.226.227.15/otro.php", "1");
				
				String libros = "Estan disponibles: ";
				for (int i = 0; i < cadena.size(); i++) {
					Arreglo.add(cadena.get(i));
					libros += cadena.get(i) + "\n";
				}
				Intent intent = new Intent(context, Client.class);
				
				notificacion.playNotification(getApplicationContext(), Client.class, libros, titleNotify, R.drawable.ic_launcher);
				
			}
			
		});
		t.start();
	}
}
