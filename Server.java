/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author najlaalhajri
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
public static void main(String[]args) throws IOException {
	
	
	ServerSocket servSocket=new ServerSocket(6666); 
	while (true) {
		System.out.print(" waiting for clints ....");
		Socket socket=servSocket.accept();
		
		new ServerThread(socket).start();
		
	}//end while
}//end main
}//end class




class ServerThread extends Thread{

	 Socket socket;

	public ServerThread(Socket socket) {
		this.socket=socket;
	}
	
	public void run() {
		try {
		System.out.println("  client connected ");
		InputStream in=socket.getInputStream();
		OutputStream out=socket.getOutputStream();
		byte[] buffer=new byte[1024];
		in.read(buffer);
		String Req=new String(buffer).trim();
		System.out.println("   received from client  "+Req);
		String result=getInfo(Req);
		out.write(result.getBytes());
		socket.close();
		}//end try
		catch(IOException e) {
			System.out.println("  cI/O Exception ");
		}//end catch
	}
	
	
	
	

public String getInfo(String Req) {
	
	switch(Req) {
	
	case"BMW":
		return "Manufacturer Country: Germany \n Year:2022 \n type:7series\n  price:150k";
		
	
	case"Toyota":
		return"Manufacturer Country: japan\nYear:2021 \n type: land cruiser price:90k";
		
		
	case"Audi":
		
		return"Manufacturer Country: Germany \\n Year:2020 \\n type:Q5 \n  price:100k";
	
		
	case"Genesis":
		return "Manufacturer Country: South Korea \n Year:2023 \n type:gv80 \n  price:120k";
	
	
	default:
		return	"please select one of the available items";
	
	
	
	}
	//return Req;
	
}
} //end ServerThread class
