package exercise2;

import java.security.SecureRandom;

import javax.swing.JOptionPane;

public class LottoTest {

	private static SecureRandom rnd = new SecureRandom();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Calling the playLotto function
		playLotto();

	}

	private static void playLotto() {

		//Boolean value to control a loop
		boolean flag = false;
		int chosenNumber = 0;
		//String that will have a format to output information
		String runReport = "";
		int times = 0;
		JOptionPane.showMessageDialog(null, "Ready to lose some money Prof. Wallace?", "Welcome",1);
		
		while (!flag) {

			//This body is inside a try-catch to prevent the program from crashing if the user enters a letter
			try {
				
				chosenNumber = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Input a number between 3 and 27 to start to play the lotto!"));
				//Checking if the number is lesser than 3 or greater than 27
				if (chosenNumber < 3 || chosenNumber > 27)
					JOptionPane.showMessageDialog(null, "Your number is out-of-bounds, it must be between 3 and 27",
							"Error", 0);
				else
					flag = true;
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, "You must enter a number!", "Error", 0);
			}

		}

		while (times < 5) {

			//Creating Lotto Object with random numbers
			Lotto lotto = new Lotto(generateNumber(), generateNumber(), generateNumber());
			//Creating auxiliary array to display information
			int[] aux = new int[3];
			aux = lotto.getArray();	
			//Formating String
			runReport = String.format("Iteration number: %d\n\nThe generated numbers are:%n%nNumber 1:---------->%d%nNumber 2:---------->%d%nNumber 3:---------->%d"
					+ "\n\nYour number is: %d%n"
					+ "The sum of the numbers is: %d", times+1, aux[0], aux[1], aux[2], chosenNumber, lotto.sum());
			
			//Showing the generated numbers, the number chosen and the sum of them
			JOptionPane.showMessageDialog(null, runReport, "Numbers generated", 1);	
			
			//Win condition
			if (lotto.sum() == chosenNumber){
				JOptionPane.showMessageDialog(null, "Yay! You got lucky there! You win!", "Congratulations", 1);
				break;
			}

			else
				times++;
		}
		//Lose condition
		if (times == 5)
			JOptionPane.showMessageDialog(null, "Oh you are a loser! Thank you for your money!", "Too bad", 0);

	}

	//Generate random number
	private static int generateNumber() {

		return 1 + rnd.nextInt(9);
	}
}
