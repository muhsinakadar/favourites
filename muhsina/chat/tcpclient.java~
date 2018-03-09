import java.io.*;
import java.net.*;
class tcpclient
{
public static void main(String argv[]) throws Exception
{
String sentence;
String modifiedsentence;
System.out.println("Client waiting to establish a connection with server");
Socket clientsocket=new Socket("localhost",9000);
System.out.println("Client successfully established the connection with server and ready for data transfer");
BufferedReader inFromUser=new BufferedReader(new InputStreamReader(System.in));
sentence=inFromUser.readLine();

DataOutputStream outtoserver=new DataOutputStream(clientsocket.getOutputStream());
outtoserver.writeBytes(sentence+'\n');
BufferedReader inFromserver=new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
modifiedsentence=inFromserver.readLine();
System.out.println("result from server is..\n"+modifiedsentence);
System.out.println("Client closing connection with sever");
clientsocket.close();
}
}
