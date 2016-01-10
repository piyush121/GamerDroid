package gamer.droid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class enterip extends Activity
{
	public EditText ipAddr;
	public Button connectButton;
	public Button motionConnectButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		  super.onCreate(savedInstanceState);
	        setContentView(R.layout.enterip);
	
	        ipAddr = (EditText)findViewById(R.id.enterIP);
	        
	       
	      
	        connectButton= (Button)this.findViewById(R.id.connectButton);
	      
	       connectButton.setOnClickListener(new OnClickListener() {
		
			public void onClick(View v) {
				proceed();
				// TODO Auto-generated method stub
				
			}
	       });
	       
	       motionConnectButton= (Button)this.findViewById(R.id.motionButton);
		      
	       motionConnectButton.setOnClickListener(new OnClickListener() {
		
			public void onClick(View v) {
				proceedMotion();
				// TODO Auto-generated method stub
				
			}
	       });
	}
	
	public void proceed()
	{
		Intent i =new Intent(this, maingame.class);
		i.putExtra("ipaddr", ipAddr.getText().toString());
		startActivity(i);
	}
	public void proceedMotion()
	{
		Intent i =new Intent(this, orientation.class);
		i.putExtra("ipaddr", ipAddr.getText().toString());
		startActivity(i);
	}
}
