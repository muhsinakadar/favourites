import java.net.*;
import java.io.*;
import java.util.*;

class client {

	public static void main(String args[]) throws Exception
	{
		// creates a client socket using the DatagramSocket class in java
                                      DatagramSocket socket=new DatagramSocket();
                                    // gets the local host ip address and host name
		InetAddress ip=InetAddress.getLocalHost();
		// creates a byte array for sending and receiving messages
                                      byte sendByte[]=new byte[1024];
		byte receiveByte[]=new byte[1024];
                                      System.out.println("Client ready for chatting:");
		while(true)
		{
			//Data Sending
                                                          //creates an input stream buffer by getting data from user input 
			DataInputStream din=new DataInputStream(System.in);
                                                          System.out.println("Client machine:");
                                                         // reads line by line from the input stream 
			String sendStr=din.readLine();
			// get data as bytes from the string and store in byte array sendByte for sending packet
                                                         sendByte=sendStr.getBytes();
                                                          //creates a datagram packet for sending with the following parameters - data to send, total length in bytes, ip address and port number
			DatagramPacket sendPacket=new DatagramPacket(sendByte,sendByte.length,ip,9000);
			// sends the packet to the socket using send()
                                                         socket.send(sendPacket);
			
			//Data Receiving from the server 
			DatagramPacket receivePacket=new DatagramPacket(receiveByte,receiveByte.length);
			socket.receive(receivePacket);
                                                        // gets the received packet and extract the data from it 
			String receiveStr=new String(receivePacket.getData());
                                                         // white space characters are removed and data is stored in  a string and displayed on the screen
			receiveStr=receiveStr.trim();
			System.out.println("From Server:"+receiveStr);
		}
	}

}
