package gamer.droid;

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

import android.view.Display;
import android.widget.TextView;
import android.widget.Toast;

public class orientation extends Activity implements SensorEventListener {
    
    SensorManager sensorManager = null;
     
    //for accelerometer values
  
    boolean leftPressed=false;
	boolean rightPressed=false;
	boolean upPressed=false;
	boolean downPressed=false;
    Socket sock = null;
	OutputStream sOut = null;
	DataOutputStream sockOut = null;
	
    //for orientation values
   
     @Override
     public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        
        
        Bundle extras = getIntent().getExtras(); 
        
        Display display = getWindowManager().getDefaultDisplay(); 

        
        String ipAddr = extras.getString("ipaddr");
        
        
     
        	setContentView(R.layout.orientation);
        	
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
        	
        	 sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        //just some textviews, for data output
      
     }
     @Override
     protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), sensorManager.SENSOR_DELAY_GAME);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION), sensorManager.SENSOR_DELAY_GAME);
     }
     @Override
     protected void onStop() {
        super.onStop();
        sensorManager.unregisterListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER));
        sensorManager.unregisterListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION));
     }
     public void onSensorChanged(SensorEvent event) {
         synchronized (this) {
             switch (event.sensor.getType()){
                 case Sensor.TYPE_ACCELEROMETER:
                    
                 break;
             case Sensor.TYPE_ORIENTATION:
                 
                     
                     if( (!leftPressed) && ((event.values[1])>15))
                     { try {
								sockOut.writeInt(10);
								leftPressed = true;
						
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                     }
                     else if((!rightPressed) && ((event.values[1])<-15))
						{
                    	 try {
							sockOut.writeInt(20);
							rightPressed = true;
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						}
                     else
                     {
                    	 if(leftPressed && ((event.values[1])<15)) 
                    	 {
                    		 try {
								sockOut.writeInt(11);
                    		 } catch (IOException e){
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                    		 leftPressed=false;
                    	 }
                    	 else if(rightPressed && ((event.values[1])>-15) )
                    	 {
                    		 try {
								sockOut.writeInt(21);
								
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                    		 rightPressed=false;
                    	 }
                    	 }
                     
					
                     
                     if( (!upPressed) && ((event.values[2])<-15))
                     {
                    	 try {
								sockOut.writeInt(30);
								upPressed = true;
								
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                     }
                     else if((!downPressed) && ((event.values[2])>15))
						{
                    	 try {
							sockOut.writeInt(40);
							downPressed = true;
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						}
                     else
                     {
                    	 if(upPressed && ((event.values[2])>-15) )
                    	 {
                    		 try {
								sockOut.writeInt(31);
								
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                    		 upPressed=false;
                    	 }
                    	 else if(downPressed && ((event.values[2])<15) )
                    	 {
                    		 try {
								sockOut.writeInt(41);
								
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                    		 downPressed=false;
                    	 }
                    	 }
             break;
             }
             }
         }
      
     @Override
     public void onAccuracyChanged(Sensor sensor, int accuracy) {}  
     }
