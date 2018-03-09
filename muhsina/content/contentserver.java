import java.io.*;
import java.net.*;
public class contentserver
{
	public static void main (String args[]) throws Exception
	{
		ServerSocket s = new ServerSocket(2000);
		System.out.println("server ready for connection");
		Socket sock = s.accept();
		System.out.println("connection is successfull");
		InputStream istream = sock.getInputStream();
		BufferedReader fileread = new BufferedReader( new InputStreamReader(istream));
		String fname = fileread.readLine();
		BufferedReader contentread = new BufferedReader(new FileReader(fname));
		OutputStream ostream = sock.getOutputStream();
		PrintWriter pwrite = new PrintWriter(ostream, true);
		
		

		String str;
		while((str=contentread.readLine())!= null)
		{
			pwrite.println(str);

		}
		sock.close();
		s.close();
		pwrite.close();
		fileread.close();
		contentread.close();
	}
}
