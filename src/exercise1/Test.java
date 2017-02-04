package exercise1;

import java.security.SecureRandom;
import javax.swing.JOptionPane;

public class Test {

	private final SecureRandom randomIndex = new SecureRandom();
	// Counters
	private int correctAnswers, incorrectAnswers = 0;

	// Questions
	private final String[] question = { "What programming paradigm does java follow?",
			"What is an Object in OO Programming?", "Where is the java source code compiled?",
			"What is the correct way to create an Object?",
			"Which of the following placeholders should be used to print off a String?" };

	private final String[] options = { "a) Functional\nb) Object-Oriented\nc) Logical\nd) Procedural", // Options
																										// for
																										// Q1

			"a) An entity that can be described with attributes, behaviour and state\nb) A essential part of the Operating System that runs the JVM\nc) "
					+ "A way of programming\nd) A package that contains classes in Java", // Options
																							// for
																							// Q2

			"a) It is compiled in the Operating System\nb) It is compiled in the JVM\nc) It is never compiled\nd) The programmer compiles it himself", // Options
																																						// for
																																						// Q3

			"a) Classname variable = new Classname\nb) variable = new Classname\nc) Classname variable = new Classname(parameters)\nd) Classname variable", // Options
																																							// for
																																							// Q4

			"a) %f\nb) %d\nc) %n\nd) %s" }; // Options for Q5

	// Array that contains the correct answer options. This array works in
	// parallel with the question's array
	private final String[] answerOption = { "b", "a", "b", "c", "d" };

	// Array that contains the correct answer sentence so it can be prompted to
	// the user when he answers incorrectly
	private final String[] answerSentence = { "b) Object-Oriented",
			"a) An entity that can be described with attributes, behaviour and state", "b) It is compiled in the JVM",
			"c) Classname variable = new Classname(parameters)", "d) %s" };

	///////////////////////////////////////////////////////////////////////////
	
	private final String[] correctAnswerM = { "Correct!", "Good job, Keep it up!", "Excellent, nice work!",
			"Wow! I did not know that you were this good!" };

	private final String[] incorrectAnswerM = { "Incorrect answer", "Wrong. Try again", "Not even close!",
			"Oops! Looks like someone have lost some marks" };

	// Generate and prompt questions

	public void simulateQuestion() {

		// Boolean value that will be set to true if the question is answered
		// correctly
		boolean flag = false;

		// Iterate through the question's array, prompting the questions its and
		// options
		for (int i = 0; i < this.question.length; i++) {

			flag = checkAnswer(JOptionPane.showInputDialog("Question " + (i + 1) + "!\n\n" + this.question[i] + "\n\n" + this.options[i]), i);

			if (flag)
				JOptionPane.showMessageDialog(null, generateMessage(flag, i), "Congratulations!", 1);

			else
				JOptionPane.showMessageDialog(null, generateMessage(flag, i), "Too bad!", 0);
		}

	}

	public void inputAnswer() {

		JOptionPane.showMessageDialog(null, "Now it is my turn to test you Prof. Wallace! Muahaha!", "Welcome!", 1);
		this.simulateQuestion();

		// Showing summary; correct, incorrect and total score
		JOptionPane.showMessageDialog(null,
				"Summary:\n\n" + "Questions answered correctly: " + this.correctAnswers + "\n"
						+ "Questions answered wrongly: " + this.incorrectAnswers
						+ "\n---------------------------------------------\n" + "Total: "
						+ (((double) this.correctAnswers / (double) this.question.length) * 100) + "%/100%",
				"Marks", 1);

		if (((double) this.correctAnswers / (double) this.question.length) * 100 < 50)
			JOptionPane.showMessageDialog(null, "You have failed the test! Come on, it was easy.", "Failed", 0);

		else
			JOptionPane.showMessageDialog(null, "You have approved the test!", "Congratulations!", 1);

	}

	// Checks if the question is correct
	public boolean checkAnswer(String answer, int questionNumber) {

		if (this.answerOption[questionNumber].equals(answer)) {
			this.correctAnswers++;
			return true;
		}

		else {
			this.incorrectAnswers++;
			return false;
		}
	}

	// Method that returns the appropriate message when the answer is correct or
	// not
	public String generateMessage(boolean flag, int questionNumber) {

		// Correct answer
		if (flag) {

			switch (this.randomIndex.nextInt(4)) {

			case 0:
				return this.correctAnswerM[0];

			case 1:
				return this.correctAnswerM[1];

			case 2:
				return this.correctAnswerM[2];

			case 3:
				return this.correctAnswerM[3];

			}
		}

		// Incorrect answer
		else {

			switch (this.randomIndex.nextInt(4)) {

			case 0:
				return this.incorrectAnswerM[0] + "\n\n" + "The correct answer is:\n\n"
						+ this.answerSentence[questionNumber];

			case 1:
				return this.incorrectAnswerM[1] + "\n\n" + "The correct answer is:\n\n"
						+ this.answerSentence[questionNumber];

			case 2:
				return this.incorrectAnswerM[2] + "\n\n" + "The correct answer is:\n\n"
						+ this.answerSentence[questionNumber];

			case 3:
				return this.incorrectAnswerM[3] + "\n\n" + "The correct answer is:\n\n"
						+ this.answerSentence[questionNumber];

			}

		}

		return "";

	}

}
