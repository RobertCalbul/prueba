package com.javacodegeeks.android.androidsocketclient;

import java.util.List;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class Client extends Activity implements OnClickListener{
	Context context;
	public List<String> ARR;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		this.context = this;
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
		
		Intent service = new Intent(this.context, servicio.class);
		startService(service);

	}

	@Override
	public void onClick(View v) {
		

		//for(int i=0; i<a.size();i++)Toast.makeText(context, ""+a.get(i), Toast.LENGTH_LONG).show();
		
		int contador=0;
		// TODO Auto-generated method stub
		System.out.print(contador);
			contador = 0;
				
	}
}