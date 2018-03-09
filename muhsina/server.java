import java.util.*;
import java.net.*;
import java.io.*;

class server implements Runnable
{  static Socket s;	
	public void run()
	{
			try
			{			
			InputStream i=s.getInputStream();
			Scanner sc=new Scanner(i);
			String str="";
			while(!str.equals("stop"))
			{
			str=sc.next();
			System.out.println(str);
			Thread.sleep(100);
			}
			}
			catch(Exception e){}	
	}
	public static void main(String arg[])
	{
		try
		{
			s=new Socket("172.20.13.116",1048);
			Thread t=new Thread(new client());
			t.start();
			OutputStream os=s.getOutputStream();
			PrintStream ps=new PrintStream(os);
			Scanner sc=new Scanner(System.in);
			String str="";
			while(!str.equals("stop"))
			{
			 str=sc.next();
			ps.println(str);
			Thread.sleep(100);
			}
		}
		catch(Exception e)
		{

			System.out.println(e);
		}
	}
}
