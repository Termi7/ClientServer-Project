import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.*;
import java.net.*;


//server
public class Server {

	public static void main(String[] args) throws IOException {
		int port = 3012; //port numb
		int command; // variable to tell which command to run
		int number;  //variable to tell how many times to run the command
		 String comnd = null;
		 String tmpp;
			ServerSocket servSoc = new ServerSocket(port);
			servSoc.setReuseAddress(true);
			while(true) {
	try {
				
				Socket socket = servSoc.accept();
	
				cliHandle socket1 = new cliHandle(socket);
				new Thread(socket1).start();
				
	}//end try
	catch(IOException e) {
		
	}//end catch
			}//end while
	}//end main method
} //end Server class


