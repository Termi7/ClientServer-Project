import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.Timer;


//client
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException{
		
		//int port = 3000;
		
		int rep;
		int com;
		int[] tmp;
		int qut = 0;
		long avgTime;
		//String ipAddr = "139.62.210.153";
		
		String IpAddr;
		int Port =  0;
				Scanner input = new Scanner(System.in);

		do {
		System.out.println("Please Enter The IP: ");
			IpAddr = input.nextLine();
		System.out.println("Please Enter The Port: ");
			Port = input.nextInt();
			
		System.out.println("IP: " + IpAddr + " ,Port: " + Port);
		}while( IpAddr == null || Port == 0);
		
		
		
			while(true) {
				
				getInput gin = new getInput();//call getInput
				tmp = gin.userInput(); //get user input
				
				System.out.println("Number Of Commands: " + tmp[0] + " Number Of Repeate: " + tmp[1]);
				
				com = tmp[0]; //says which command to run
				rep = tmp[1]; //says how many times to run the command
				
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
				
				//initialize timer
				
				//make rep number threads, to send com command to server
				
				clientThread clientTh[] = new clientThread[rep];
				
				
				long startTime = System.currentTimeMillis();

				
				for(int i = 0; i < rep; ++i) {
				clientTh[i] = new clientThread(IpAddr, Port, com);
				clientTh[i].start();
				try {
					clientTh[i].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				}
				
				//for(int x = 0; x < rep; ++x) {
				//	try {
				//		clientTh[x].join();
				//	} catch (InterruptedException e) {
					//	e.printStackTrace();
					//}
					
					
				//}
				
				//System.out.println("Test 2");

				
				long elapsedTime = System.currentTimeMillis() - startTime;

				//total time
				System.out.println("Total Time: " + elapsedTime);
				//avg time
				avgTime = (elapsedTime / rep);
				System.out.println("Avg Time: " + avgTime);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				//System.out.println("Test 3");

				
				System.out.println("Would you like to quit?");
				System.out.println("Press 1 for yes, Press any other int for no");
				
				qut = input.nextInt();
			
				
				if(qut == 1) {System.exit(0);}
				
				
				
				
			}//end while loop
	
		
		
		
	}//end main   
}//end client


