package exercise3;

import javax.swing.JOptionPane;

public class StaticMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JOptionPane.showMessageDialog(null, "This is the last exercise Prof. Wallace!\n"
				+ "It is about the parameters of JOptionPane.showMessageDialog", "Welcome!",1);
		
		showJOptionPane("This message has no title nor customized icon!");
		showJOptionPane("This message has a title but no customized icon!", "I have a title!");
		showJOptionPane("This message has a title and a customized icon!", "I have a title!", 2);
	}

	private static void showJOptionPane(String message) {

		JOptionPane.showMessageDialog(null, message);
	}

	private static void showJOptionPane(String message, String title) {

		JOptionPane.showMessageDialog(null, message, title, 1);
	}

	private static void showJOptionPane(String message, String title, int icon) {

		JOptionPane.showMessageDialog(null, message, title, icon);
	}
}
