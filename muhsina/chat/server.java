import java.io.*;
import java.net.*;
import java.util.*;

class server {

	public static void main(String args[]) throws Exception
	{
		DatagramSocket socket=new DatagramSocket(9000);
		byte receiveByte[]=new byte[1024];
		byte sendByte[]=new byte[1024];
                                                               
                                 	while(true)
		{
			//data receiving from a client machine and extracting data converting to string and displaying on the server
                                                         
			DatagramPacket receivePacket=new DatagramPacket(receiveByte,receiveByte.length);
			socket.receive(receivePacket);
                                                          System.out.println("Server machine:");
			String receiveStr=new String(receivePacket.getData());
			receiveStr=receiveStr.trim();
			System.out.println(" From Client:"+receiveStr);
			
			//data sending from Server to Client 
			DataInputStream din=new DataInputStream(System.in);
			System.out.print("Server:");
			String sendStr=din.readLine();
			sendByte=sendStr.getBytes();
                                                         //get the IP address and port number of the client machine from the data packet received from that client 
			InetAddress ip=receivePacket.getAddress();
			int port=receivePacket.getPort();
                                                        //creating a datagram packet with bytes of data, its length, ip address of the client and port number 
			DatagramPacket sendPacket=new DatagramPacket(sendByte,sendByte.length,ip,port);
                                                       // send the packet using send()
			socket.send(sendPacket);
		}
	}

}
