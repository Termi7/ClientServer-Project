import java.util.Scanner;

public class getInput {
	
	public int[] userInput(){
//class to get input from the user and pass it to client to be sent to the server.
		int numComm;
		int numRep;
	Scanner input = new Scanner(System.in);
	
	
	
	
	do {
	System.out.println("What Command Would You Like To Run?");
	System.out.println("Type 1 For Time & Date");
	System.out.println("Type 2 For Uptime");
	System.out.println("Type 3 For Memory Use");
	System.out.println("Type 4 For NetStat");
	System.out.println("Type 5 For Current Users");
	System.out.println("Type 6 For Running Processes");
	numComm = input.nextInt();
	//add if statements to make sure it is only 1-6
	}while(numComm < 1 || numComm > 6);
	
	
	
	
	/////////////////////////////////////////////////////////////////
	
	
	do {
	System.out.println("How Many Times Would You Like To Repeat The Command?");
	System.out.println("1, 5, 10, 15, 20, 25, 100");
	numRep = input.nextInt();
	}while(numRep != 1 && numRep != 5 && numRep != 10 && numRep != 15 && numRep != 20 && numRep != 25 && numRep !=  100);
	
	
	
	
	//add if commands to make sure only specified value is chosen
	/////////////////////////////////////////////////////////////////
	System.out.println("Chose command " + numComm + " and " + numRep + " repeats.");
	
	//pass numCOmm and numRep back to client
	int[] arr = {numComm, numRep};
	return arr;
	}//end userInput method
}//end getInput class
