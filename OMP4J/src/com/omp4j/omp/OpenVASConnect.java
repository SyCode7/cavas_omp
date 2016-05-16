package com.omp4j.omp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;


public class OpenVASConnect {
	
	Socket sock;
//	byte [] openvas_server = new byte (192,168,29,132);
	int port = 80;
	String filename = "/var/lib/openvas/opencassd.messages";
	String command = "tail" + filename;
	
	public static void main(String[] args) {
		new OpenVASConnect();
	}
	
	public OpenVASConnect(){
		openSocket();
		try{
			BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
			wr.write(command);
			wr.flush();
			
			
			//read from socket
			
			BufferedReader rd = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			String str;
			while ((str = rd.readLine()) != null) {
				System.out.println(str);
			}
			rd.close();
		}
		catch (IOException e)
		{
		System.err.println(e);
		}
	}

	

	private void openSocket() {
	
		try{ 
//			InetAddress addr = InetAddress.getLocalHost();
			Socket socket = new Socket("192,168,29,132", 5555);
//			SocketAddress sockaddr = new InetSocketAddress(addr, port);
			sock = new Socket();
			int timeout = 20;
//			socket.connect();
			
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
		catch (SocketTimeoutException ss)
		{
			ss.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
