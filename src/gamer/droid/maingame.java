package gamer.droid;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class maingame extends Activity
{

	public ImageButton upButton;
	public ImageButton downButton;
	public ImageButton leftButton;
	public ImageButton rightButton;
	public ImageButton repositionButton;
	public ImageButton speedBreakerButton;
	public ImageButton nitrousButton;
	public ImageButton handBrakeButton;
	
	public ImageView image;
	public TextView text;
	public TextView text1;
	Socket sock = null;
	OutputStream sOut = null;
	DataOutputStream sockOut = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		  super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        
	        
	        Bundle extras = getIntent().getExtras(); 
	        
	        Display display = getWindowManager().getDefaultDisplay(); 
	   
	        
	        String ipAddr = extras.getString("ipaddr");
	        
	        try {
	        	
				sock = new Socket(ipAddr,6932);
				sOut = sock.getOutputStream();
				sockOut = new DataOutputStream(sOut);
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				Context context = getApplicationContext();
				CharSequence text = "There was an error connecting. Please try again."+e;
				int duration = Toast.LENGTH_LONG;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
				
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				Context context = getApplicationContext();
				CharSequence text = "There was an error connecting. Please try again."+e;
				int duration = Toast.LENGTH_LONG;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
				
				e.printStackTrace();
				e.printStackTrace();
			}
	      
	        
	        
	        
	        
	        
	      
	        
	        
	        leftButton= (ImageButton)this.findViewById(R.id.leftButton);
	        leftButton.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent ev) {
	         	  
	        	   int action = ev.getAction();
	        	   
	               if (action == MotionEvent.ACTION_DOWN)
	            	   	{
	            	   		try {
								sockOut.writeInt(10);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	            	   	}
	               else if (action == MotionEvent.ACTION_UP)
	           	   	{
	            	   try {
						sockOut.writeInt(11);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	           	   	}
				return true;
	           }
	       });
	        
	        
	        rightButton= (ImageButton)this.findViewById(R.id.rightButton);
	        rightButton.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent ev) {
	         	  
	        	   int action = ev.getAction();
	        	   
	               if (action == MotionEvent.ACTION_DOWN)
	            	   	{
	            	   		try {
								sockOut.writeInt(20);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	            	   	}
	               else if (action == MotionEvent.ACTION_UP)
	           	   	{
	            	   try {
						sockOut.writeInt(21);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	           	   	}
				return true;
	           }
	       });
	        
	        
	        upButton= (ImageButton)this.findViewById(R.id.upButton);
	        upButton.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent ev) {
	         	  
	        	   int action = ev.getAction();
	        	   
	               if (action == MotionEvent.ACTION_DOWN)
	            	   	{
	            	   		try {
								sockOut.writeInt(30);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	            	   	}
	               else if (action == MotionEvent.ACTION_UP)
	           	   	{
	            	   try {
						sockOut.writeInt(31);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	           	   	}
				return true;
	           }
	       });
	        
	        
	        downButton= (ImageButton)this.findViewById(R.id.downButton);
	        downButton.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent ev) {
	         	  
	        	   int action = ev.getAction();
	        	   
	               if (action == MotionEvent.ACTION_DOWN)
	            	   	{
	            	   		try {
								sockOut.writeInt(40);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	            	   	}
	               else if (action == MotionEvent.ACTION_UP)
	           	   	{
	            	   try {
						sockOut.writeInt(41);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	           	   	}
				return true;
	           }
	       });
	        
	        
	        handBrakeButton= (ImageButton)this.findViewById(R.id.handBrakeButton);
	        handBrakeButton.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent ev) {
	         	  
	        	   int action = ev.getAction();
	        	   
	               if (action == MotionEvent.ACTION_DOWN)
	            	   	{
	            	   		try {
								sockOut.writeInt(50);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	            	   	}
	               else if (action == MotionEvent.ACTION_UP)
	           	   	{
	            	   try {
						sockOut.writeInt(51);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	           	   	}
				return true;
	           }
	       });
	        
	        
	        nitrousButton= (ImageButton)this.findViewById(R.id.nitrousButton);
	        
	        nitrousButton.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent ev) {
	         	  
	        	   int action = ev.getAction();
	        	   
	               if (action == MotionEvent.ACTION_DOWN)
	            	   	{
	            	   		try {
								sockOut.writeInt(60);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	            	   	}
	               else if (action == MotionEvent.ACTION_UP)
	           	   	{
	            	   try {
						sockOut.writeInt(61);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	           	   	}
				return true;
	           }
	       });
	        
	        nitrousButton.layout(0, 0, 0, 0);
	        
	        speedBreakerButton= (ImageButton)this.findViewById(R.id.speedBreakerButton);
	        speedBreakerButton.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent ev) {
	         	  
	        	   int action = ev.getAction();
	        	   
	               if (action == MotionEvent.ACTION_DOWN)
	            	   	{
	            	   		try {
								sockOut.writeInt(70);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	            	   	}
	               else if (action == MotionEvent.ACTION_UP)
	           	   	{
	            	   try {
						sockOut.writeInt(71);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	           	   	}
				return true;
	           }
	       });
	        
	        
	        repositionButton= (ImageButton)this.findViewById(R.id.repositionButton);
	        repositionButton.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent ev) {
	         	  
	        	   int action = ev.getAction();
	        	   
	               if (action == MotionEvent.ACTION_DOWN)
	            	   	{
	            	   		try {
								sockOut.writeInt(130);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	            	   	}
	               else if (action == MotionEvent.ACTION_UP)
	           	   	{
	            	   try {
						sockOut.writeInt(131);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	           	   	}
				return true;
	           }
	       });
	        
	        	        
	}
}
