import java.util.*;
import java.net.*;
import java.io.*;

class client
{
	public static void main(String args[] ) throws Exception
	{
		Socket sock = new Socket("localhost",2000);
		System.out.println("enter the file name");
		BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
		String fname= keyRead.readLine();
		OutputStream ostream=sock.getOutputStream();
		PrintWriter pwrite = new PrintWriter(ostream,true);
		pwrite.println(fname);
		InputStream istream = sock.getInputStream();
		BufferedReader socketRead = new BufferedReader(new InputStreamReader(istream));
		String str;
		while((str = socketRead.readLine())!=null)
		{
			
			System.out.println(str);
		}
		pwrite.close();
		socketRead.close();
		keyRead.close();
	}
}