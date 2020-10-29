package cmp405coding;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class socketdriver {
	public static void main(String [] args){
	
	socket mysocket = new socket(64506, false);
	InetAddress receiversAddress = null;
	
	try {
		receiversAddress = InetAddress.getByName("192.168.1.242");
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	int receiverPort = 64506;
	System.out.println();
	
	System.out.println("Receiver Port number is "+receiverPort);
	System.out.println("Receiver IP address is "+receiversAddress);
	
	System.out.println();
	
	mysocket.send("Hello world", receiversAddress, receiverPort);
	mysocket.send("Hello world 2", receiversAddress, receiverPort);
	mysocket.send("Hello world 3", receiversAddress, receiverPort);
	System.out.println();
	
	
	System.out.println("sending is done but we don't know if the message has been received.");
	System.out.println();
	
	 DatagramPacket inComingPacket = null;
	 do{
		 inComingPacket = mysocket.receive();
		 byte [] inComingBuffer = inComingPacket.getData();
		 String message = new String(inComingBuffer);
		 System.out.println("The received message: "+message);
	 }while(true);
	
	}

}
