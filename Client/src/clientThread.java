import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;




public class clientThread extends Thread {

	//make private string/int for ip port and com
	private String Ipe;
	private int Prt;
	private int cm;
	//store them
	//this.ip in the run
	public clientThread(String IP, int port, int com) throws UnknownHostException, IOException {
		
		//pass IP port and com to the run() statement
		Ipe = IP;
		Prt = port;
		cm = com;
		
		//start the thread
		
		
	//clientThread.start();
	}//end client thread section
	
	@Override
	public void run() {
	String Fin = "";
		
	String ee = this.Ipe;
	int ff = this.Prt;
	int gg = this.cm;
		
	System.out.println("IP: " + ee + " Prt: " + Prt + " cmnd: " + cm);
	
		try {
		Socket clientSocket = new Socket(ee, ff);
		
		PrintWriter outPut1 = new PrintWriter(clientSocket.getOutputStream(), true);
		
		BufferedReader inPut1 = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		//System.out.println("Test 4");
		
		
		//outPut1.write(cm);
		outPut1.println(cm);
		outPut1.flush();
		
		
		
		//get the command output
		
		
		while((Fin = inPut1.readLine()) != null ) {
			System.out.println(Fin);
			
		}
		
		
		//clientSocket.close();
		
		
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
	
		
		
	}


	

} //end extends thread class
