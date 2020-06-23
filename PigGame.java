// import necessary pacakages
import java.lang.*;
import java.util.Random;
import java.util.Scanner;

// class PigGame - begin
class PigGame
{
	// one class needs to have a main() method 
	public static void main(String args[])
	{
		System.out.println("Welcome to the game of Pig!\n"); // display the header message

		Random randomNumber = new Random();	// to generate random numbers
		
		// declaration of variables 
		char    userChoice = 'r';			// choice of the user: roll again(r), hold(h)
		byte   	currentTurn = 1;			// track the current turn: 1-human, 2-computer
		int		diceResult;					// result of rolling the dice
		int   	humanTotalScore = 0;		// the total score of the human	
		int 	computerTotalScore = 0;		// the total score of the computer
		
		// keep playing as long as the scores are blow the winning target
		while (humanTotalScore < 100 && computerTotalScore < 100)
		{
			int turnScore = 0;				// the score of the current turn - clear for each turn

			if (currentTurn == 1)
			{			// it is the human turn
				// display the turn message
				System.out.println("It is human's turn.\n"); 
				System.out.println("--------------------");
				
				// start the human turn
				do
				{
					diceResult = randomNumber.nextInt(6) + 1;// roll the dice`
					turnScore += diceResult;				 // update the turnScore
					
					// display the outcome of rolling the dice
					System.out.println("\nYou rolled: " + diceResult + "\n");

					// if it is the end of human turn, display message as appropriate
					if (diceResult == 1)
					{
						System.out.println("You lose your turn! Your current turn gets 0 points.");
						currentTurn = 2;	// pass on the turn to the computer
						break;				// end the human turn
					} // end of if - diceResult

					// display the score and seek the decision of the human
					System.out.println("Your turn score is " + turnScore + " and your total score is " + humanTotalScore + "\n");
					System.out.println("If you hold, you will have " + turnScore + " points.\n");
					System.out.println("Enter 'r' to roll again, 'h' to hold.\n");
					Scanner userInput = new Scanner(System.in); // crete object to read the input
					userChoice = userInput.next().charAt(0);	// read a character from the user

				}
				while (userChoice == 'r'); // end of loop - human dice rolling
											// keep the human playing his turn
				if (diceResult != 1)
					humanTotalScore += turnScore; // update the total score only if the human holds his turn
				
				currentTurn = 2; // pass on the turn to the computer

			} 		// end of human turn
			else 	// it is the computer's turn
			{
				// display the turn message
				System.out.println("It is the computer's turn.\n");
				System.out.println("--------------------------\n");
				
				// start the computer turn  
				do
				{
					diceResult = randomNumber.nextInt(6) + 1;	// roll the dice
					turnScore += diceResult;					// update the turnScore
					
					// display the outcome of rolling the dice
					System.out.println("The computer rolled: " + diceResult + "\n");
					
					// if computer turn get 1, else if random number's total score
					if (diceResult == 1) 
					{
						System.out.println("The computer lost its turn! Computer's current turn gets 0 points.");
						break;					// end the computer's turn
					} // end of if - diceResult
					else if (turnScore >= 20) 
					{
						System.out.println("The current turnScore = " + turnScore + " >= 20, computer holds.");
						computerTotalScore += turnScore; // update the total score
						break;					// quit the computer's turn 
					}

				}
				while (true); 	// end of loop - computer dice rolling			
				currentTurn = 1; 	// pass on the turn to the human

			} // end of computer turn

			// display the summary messages
			System.out.println("\n=================================");
			System.out.println("\nYour total score is " + humanTotalScore);
			System.out.println("\nComputer's total score is " + computerTotalScore);
			System.out.println("\n=================================\n");

		} // end of while - scores check loop

		// decide the winner!!!
		if (humanTotalScore >= 100)
			System.out.println("\nYOU WIN!");
		else
			System.out.println("\nTHE COMPUTER WINS!");

	} // main method - end

} // class PigGame - end