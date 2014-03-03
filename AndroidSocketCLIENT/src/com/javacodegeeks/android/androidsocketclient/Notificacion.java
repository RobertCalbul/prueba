package com.javacodegeeks.android.androidsocketclient;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class Notificacion extends Notification {
	public Context context;

	@SuppressWarnings("deprecation")
	public Notificacion(Context context, String msg) {
		this.context = context;
		int icono = R.drawable.ic_launcher;

		Notification notificacion = new Notification(icono, "Sistema Bibloteca",System.currentTimeMillis());

		Context contextoAplicacion = this.context.getApplicationContext();
		Intent intentNotificacion = new Intent(this.context,this.context.getClass());
		PendingIntent intentPendiente = PendingIntent.getActivity(this.context,0, intentNotificacion, Intent.FLAG_ACTIVITY_NEW_TASK);

		String titulo = "Solicitud Libros";
		String mensaje = msg;
		notificacion.setLatestEventInfo(contextoAplicacion, titulo, mensaje,intentPendiente);
		notificacion.flags |= Notification.FLAG_AUTO_CANCEL;
		String servicioNotificacion = Context.NOTIFICATION_SERVICE;
		NotificationManager mgr = (NotificationManager) this.context.getSystemService(servicioNotificacion);
		mgr.notify(1, notificacion);

	}
}