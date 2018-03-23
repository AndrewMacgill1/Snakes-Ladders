
import java.util.Random;
import java.util.Scanner;

     // import javax.swing.SwingUtilities;
	// version1.1
public class MainGame {

	public static void main(String[] args) {
		
		CheckerBoardJavaExample CheckerBoard = new CheckerBoardJavaExample(); 
        final int SIZE = 600; 
        CheckerBoard.setSize(SIZE, SIZE);
        CheckerBoard.setLocationRelativeTo(null);
        CheckerBoard.setVisible(true); 

		
		Player nick = new Player();
		Player andy = new Player();
		Player jawad = new Player();
		
		int noOfTurns = 0;
		int currentRoll = 0;		
		int winSquare = 100;
		String winner = "";
		
		while (nick.win(winSquare) == false && andy.win(winSquare) == false && jawad.win(winSquare) == false) {
			System.out.println("Nick, hit enter to roll");
			@SuppressWarnings("resource")
			Scanner nickRoll = new Scanner(System.in);
			if ("".equals(nickRoll.nextLine())) {
				noOfTurns ++;
			currentRoll = diceRoll();
			nick.position = nick.position + currentRoll;
			if (nick.position > winSquare) nick.position = nick.position - currentRoll;
			if (nick.position < winSquare) nick.position = snakes(nick.position);
			if (nick.position < winSquare) nick.position = ladders(nick.position);
			System.out.println("\nNick is on square " + nick.position);
			}
			System.out.println("Andy, hit enter to roll");
			@SuppressWarnings("resource")
			Scanner andyRoll = new Scanner(System.in);
			if ("".equals(andyRoll.nextLine())) {
			currentRoll = diceRoll();
			andy.position = andy.position + currentRoll;
			if (andy.position > winSquare) andy.position = andy.position - currentRoll;
			if (andy.position < winSquare) andy.position = snakes(andy.position);
			if (andy.position < winSquare) andy.position = ladders(andy.position);
			System.out.println("\nAndy is on square " + andy.position);
			}
			System.out.println("Jawad, hit enter to roll");
			@SuppressWarnings("resource")
			Scanner jawadRoll = new Scanner(System.in);
			if ("".equals(jawadRoll.nextLine())) {
			currentRoll = diceRoll();
			jawad.position = jawad.position + currentRoll;
			if (jawad.position > winSquare) jawad.position = jawad.position - currentRoll;
			if (jawad.position < winSquare) jawad.position = snakes(jawad.position);
			if (jawad.position < winSquare) jawad.position = ladders(jawad.position);
			System.out.println("\nJawad is on square " + jawad.position);
			}
		}
			
		
		if (nick.win(winSquare) == true) {
			System.out.println("Nick has won");
			winner = "Nick";
		}
		if (andy.win(winSquare) == true) {
			System.out.println("Andy has won");
			winner = "Andy";
		}
		if (jawad.win(winSquare) == true) {
			System.out.println("Jawad has won");
			winner = "Jawad";
		}
		
		System.out.println("Total number of turns until " + winner +" won was " + noOfTurns);

	}
	
	public static int diceRoll() {
		
		Random rand = new Random();
		
		int rolledNumber = 1 + rand.nextInt(6);
		
		return rolledNumber;
	}
	
	public static int snakes(int position) {
		int[] sneks = new int[105];
		
		for (int i = 0; i<100; i++) {
			
			sneks [i] = i;
		}
		
		sneks [15] = 5;
		sneks [45] = 24;
		sneks [48] = 10;
		sneks [61] = 18;
		sneks [63] = 59;
		sneks [73] = 52;
		sneks [88] = 67;
		sneks [91] = 87;
		sneks [94] = 74;
		sneks [98] = 79;
		
		return sneks[position];		
	}
	
	public static int ladders(int position) {
		int[] lads = new int[105];
		
		for (int i = 0; i<100; i++) {
			
			lads [i] = i;
		}
		
		lads [1] = 37;
		lads [6] = 13;
		lads [7] = 30;
		lads [14] = 25;
		lads [20] = 41;
		lads [27] = 83;
		lads [35] = 43;
		lads [50] = 66;
		lads [70] = 90;
		lads [77] = 97;
		lads [86] = 93;
		
		return lads[position];	
				
	}
	
}
