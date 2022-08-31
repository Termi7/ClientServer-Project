import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class cliHandle extends Thread {
private final Socket socket;

public cliHandle(Socket sock) {
	
	this.socket  = sock;
	
	
}



	@Override
	public void run() {
		int command; // variable to tell which command to run
		int number;  //variable to tell how many times to run the command
		 String comnd = null;
		 String tmpp;
	try {
		PrintWriter outPut = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader inPut = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		// make ability to get input and output
		System.out.println("it works to here");


		
			//not recieving command
			command = inPut.read(); //get command input from the client
			
			//this is what it hangs up on
			System.out.println("Command: " + command);
			
			
			//time and date, uptime, memory, netstat, current users, running processes
			
			
				
				//run commands and save output
				if(command == 49) {
					//set comnd
					comnd = "date";
					
					
					}//end if one
				if(command == 50) {
					//set comnd
					comnd = "uptime";
					

					
					}//end if two
				if(command == 51) {
					//set comnd
					comnd = "free";
					

					}//end if 3
				if(command == 52) {
					//set comnd
					comnd = "netstat -a";
					
					}//end if 4
				if(command == 53) {
					//set comnd
					comnd = "who";
					
					}//end if 5
				if(command == 54) {
					//set comnd
					comnd = "ps -ef";
					
					}//end if 6
				
					
					//run commands works if this does not
					Process p = Runtime.getRuntime().exec(comnd);
					
					BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
					
					

					
					while((tmpp = reader.readLine()) != null) {
						System.out.println(tmpp);
						
						
						outPut.println(tmpp);
						//send command output to client
						

						outPut.flush(); //? idk what this does
					} //end while
					socket.close();
	}
	catch(IOException e) {
		
	}
		
		
	}


	

} //end extends thread class
