package exercise2;

import java.security.SecureRandom;

import javax.swing.JOptionPane;

public class LottoTest {

	private static SecureRandom rnd = new SecureRandom();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		playLotto();

	}

	private static void playLotto() {

		boolean flag = false;
		int chosenNumber = 0;
		String runReport = "";
		JOptionPane.showMessageDialog(null, "Ready to lose some money Prof. Wallace?", "Welcome",1);
		while (!flag) {

			try {

				chosenNumber = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Input a number between 3 and 27 to start to play the lotto!"));
				if (chosenNumber < 3 || chosenNumber > 27)
					JOptionPane.showMessageDialog(null, "Your number is out-of-bounds, it must be between 3 and 27",
							"Error", 0);
				else
					flag = true;
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, "You must enter a number!", "Error", 0);
			}

		}

		int times = 0;

		while (times < 5) {

			Lotto lotto = new Lotto(generateNumber(), generateNumber(), generateNumber());
			int[] aux = new int[3];
			aux = lotto.getArray();
			runReport = String.format("The generated numbers are:%n%nNumber 1:---------->%d%nNumber 2:---------->%d%nNumber 3:---------->%d"
					+ "\n\nYour number is: %d%n"
					+ "The sum of the numbers is: %d", aux[0], aux[1], aux[2], chosenNumber, lotto.sum());
			JOptionPane.showMessageDialog(null, runReport, "Numbers generated", 1);	
			if (lotto.sum() == chosenNumber){
				JOptionPane.showMessageDialog(null, "Yay! You got lucky there! You win!", "Congratulations", 1);
				break;
			}// win

			else
				times++;
		}

		if (times == 5)
			JOptionPane.showMessageDialog(null, "Oh you are a loser! Thank you for your money!", "Too bad", 0);

	}

	private static int generateNumber() {

		return 1 + rnd.nextInt(9);
	}
}
