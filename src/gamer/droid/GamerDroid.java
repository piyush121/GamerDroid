package gamer.droid;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class GamerDroid extends Activity {
    /** Called when the activity is first created. */
	

	Button enterButton;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        
        
        
        enterButton = (Button)findViewById(R.id.enterButton);
        enterButton.setOnClickListener(new OnClickListener()
        {
        	public void onClick(View v)
        	{
        		startTheGame();
        	}
        }
        );
        
        
        
       
		
    }

    public void startTheGame()
    {
    	startActivity(new Intent(this, enterip.class));
    }
    
	public void startActivity(OnClickListener onClickListener, Class<maingame> class1) {
		// TODO Auto-generated method stub
		
	}
}