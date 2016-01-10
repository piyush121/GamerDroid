import java.io.InputStreamReader;
import java.net.*;
import java.io.*;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

class Server
{
	public static void main(String[] args)
	{	
		int myPort = 6932;
		int i=0,k=0;
		int j=0;
		//String xyz="Keyevent.VK_";
		
		//Initialinsing the string !!
		int[] controls = new int[15];
			controls[3]=KeyEvent.VK_W;
			controls[1]=KeyEvent.VK_A;
			controls[4]=KeyEvent.VK_S;
			controls[2]=KeyEvent.VK_D;
			controls[5]=KeyEvent.VK_SPACE;
			controls[6]=KeyEvent.VK_ALT;
			controls[8]=KeyEvent.VK_ESCAPE;
			controls[9]=KeyEvent.VK_ENTER;
			//controls[7]=KeyEvent.VK_RIGHTCONTROL;
			controls[11]=KeyEvent.VK_CONTROL;
			controls[10]=KeyEvent.VK_SHIFT;
			controls[12]=KeyEvent.VK_L;
			controls[13]=KeyEvent.VK_R;
		//End of String declaration
		
		
	
		try 
		{
		
			InetAddress ipadd=InetAddress.getLocalHost();
			
			System.out.println("\n\n\tEnter this IP when asked in client = "+ipadd.getHostAddress());
	  
			ServerSocket ss = new ServerSocket(myPort);
			Socket sock = ss.accept();
			InputStream sin = sock.getInputStream();
			OutputStream sout = sock.getOutputStream();
		
			DataInputStream in = new DataInputStream(sin);
			DataOutputStream out = new DataOutputStream(sout);
			
			InputStreamReader reader = new InputStreamReader(sin);
			
			System.out.println("\n\n\t\t\tConnected to a Client\n\t\t\t^^^^^^^^^^^^^^^^^^^^^\n\n");
			
			
			
			//Launching application after the clients are connected
			if(true)
			{
				try
				{
					Runtime rt = Runtime.getRuntime();
					Process p = rt.exec("notepad");
				}
				catch(Exception exc)
				{
					System.out.printf("Application not found !!");
				}					
			}
			//End Launching application
			int[] pressedkeys = new int[10];
			int ii=0,jj=0;
			int length = 0;
			while(true)
			{	
				i = in.readInt();
				System.out.println(i);
				k = i%10;
				j = (i/10);
				
				if(k==0)
					{
						pressedkeys[length++] = j;

					}
				if(k==1)
					{
						for(ii=0; ii < length; ii++)
							
								if(pressedkeys[ii] == j)
								{
									for(jj=ii;jj<length;jj++)
											pressedkeys[jj] = pressedkeys[jj+1];
											
							
									length--;
									break;
								}
					}
				
						
				try
				{
					Robot robo = new Robot();
					int number = 1;
					
						while(true)
						{
							for(ii=0;ii<length;ii++)
								{
								
								robo.keyPress(controls[pressedkeys[ii]]);
								
								}
							robo.delay(5);
							for(ii=0;ii<length;ii++)
							{
							
							robo.keyRelease(controls[pressedkeys[ii]]);}
							int available = in.available ();
							if(available>0)
								break;
						}
					
				} 
				catch (AWTException rob) 
				{
					rob.printStackTrace();
				}
			}
		}
		catch(Exception soc)
		{
			soc.printStackTrace();
		}
	}	
}