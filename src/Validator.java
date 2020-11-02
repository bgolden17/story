import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Validator {

	public static String getString(Scanner scnr, String prompt) {
		System.out.print(prompt);
		String input = scnr.nextLine();
		return input;
	}

	/**
	 * Prompt the user until they enter a valid integer.
	 */
	public static int getInt(Scanner scnr, String prompt) {
		boolean inputIsInvalid = true;
		int input = 0; // <-- we have to put something here to make Java happy.

		do {
			System.out.print(prompt);
			if (scnr.hasNextInt()) {
				input = scnr.nextInt();
				scnr.nextLine(); // <-- clear remainder of line.
				inputIsInvalid = false;
			} else {
				scnr.nextLine(); // <-- clear out bad input
				System.out.println("You must enter a valid integer. Try again");
			}
		} while (inputIsInvalid);
		return input;
	}

	/**
	 * Prompt the user until they enter a valid double.
	 */
	public static double getDouble(Scanner scnr, String prompt) {
		System.out.print(prompt);
		
		do {
			if(scnr.hasNextDouble()) {
				double input = scnr.nextDouble();
				scnr.nextLine(); // <-- clear remainder of line.
				return input;
			}else {
				System.out.println("You must enter a valid number. Try again");
				System.out.print(prompt);
				scnr.nextLine(); // <-- clear bad input
			}
		} while (true);
	}
	
	public static double getDouble2(Scanner scnr, String prompt) {
		System.out.print(prompt);
		
		do {
			try {
				double input = scnr.nextDouble();
				scnr.nextLine(); // <-- clear remainder of line.
				return input;
			} catch (InputMismatchException e) {
				System.out.println("You must enter a valid number. Try again");
				System.out.print(prompt);
				scnr.nextLine(); // <-- clear bad input
			}
		} while (true);
	}

	/**
	 * Prompt the user until they enter a valid integer between min and max
	 * inclusive.
	 */
	public static int getIntInRange(Scanner scnr, String prompt, int min,
			int max) {
		boolean withIn = false;
		int input = getInt(scnr, prompt);

		while (withIn == false) {

			if (input <= max && input >= min) {
				withIn = true;
			} else {
				withIn = false;
				System.out.println("Your number was not within the range " + min + " to " + max + ". Try again.");
				input = getInt(scnr, prompt);
			}
		}
		return input;
	}

	/**
	 * Prompt the user until they enter a valid integer equal to or greater than
	 * min.
	 */
	public static int getIntAtOrAbove(Scanner scnr, String prompt, int min) {
		boolean flag = true;
		int input = 0;
		while (flag) {
			input = getInt(scnr, prompt);
			if (input >= min) {
				flag = false;
			} else {
				System.out.println("Your number must not be less than " + min + ". Try again.");
			}
		}
		return input;
	}
	
	private static final Set<String> VALID_YES = new HashSet<>(
			Arrays.asList("yes", "y", "yeah", "ok", "sure"));
	private static final Set<String> VALID_NO = new HashSet<>(
			Arrays.asList("no", "n", "nope"));

	public static boolean getYesNo(Scanner scnr, String prompt) {
		while (true) {
			String userInput = getString(scnr, prompt).toLowerCase();
			if (VALID_YES.contains(userInput)) {
				return true;
			} else if (VALID_NO.contains(userInput)) {
				return false;
			} else {
				System.out.println("Your answer must be yes or no.");
			}
		}
	}
	
	public static String getPaymentType (Scanner scnr, String prompt) {
		boolean validInfo = false;
		while (validInfo == false) {
		System.out.println(prompt);
		String paymentType = scnr.nextLine();
		if (paymentType.toLowerCase().contains("card")) {
			validInfo = true;
			return "card";
		} else if (paymentType.toLowerCase().contains("check")) {
			validInfo = true;
			return "check";
		} else if (paymentType.toLowerCase().contains("cash")) {
			validInfo = true;
			return "cash";
		} else {
			System.out.println("Payment method is invalid.");
			validInfo = false;
		}
		}
		return null;
	}
	
	public static String getCheckNum (Scanner scnr, String prompt) {
		boolean validInfo = false;
		while (validInfo == false) {
			System.out.println(prompt);
			String checkNum = scnr.nextLine();
		    boolean flagOne = Character.isDigit(checkNum.charAt(0));
		    boolean flagTwo = Character.isDigit(checkNum.charAt(1));
		    boolean flagThree = Character.isDigit(checkNum.charAt(2));
		    boolean flagFour = Character.isDigit(checkNum.charAt(3));
		    boolean flagFive = (checkNum.length() < 5);
			if (flagOne && flagTwo && flagThree && flagFour && flagFive) {
				validInfo = true;
				return checkNum;
			} else {
				System.out.println("Check number was invalid");
				validInfo = false;
			}	    
			}
		return null;
	}
	
	public static String getCardNum (Scanner scnr, String prompt) {
		boolean validInfo = false;
		boolean flagOne = false;
		boolean flagTwo = false;
		boolean flagThree =	false;	
		boolean flagFour =	false;
		boolean flagFive = false;
		boolean flagSix = false;
		boolean flagSeven =	false;	
		boolean flagEight =	false;
		boolean flagNine = false;
		boolean flagTen = false;
		boolean flagEleven = false;	
		boolean flagTwelve = false;
		boolean flagThirteen =	false;
		boolean flagFourteen = false;
		boolean flagFifteen = false;
		boolean flagSixteen = false;	
		
		while (validInfo == false) {
			System.out.println(prompt);
			String cardNum = scnr.nextLine();
			if (cardNum.length() == 16) {
			flagOne = Character.isDigit(cardNum.charAt(0));
			flagTwo = Character.isDigit(cardNum.charAt(1));
			flagThree = Character.isDigit(cardNum.charAt(2));
			flagFour = Character.isDigit(cardNum.charAt(3));
			flagFive = Character.isDigit(cardNum.charAt(4));
			flagSix = Character.isDigit(cardNum.charAt(5));
			flagSeven = Character.isDigit(cardNum.charAt(6));
			flagEight = Character.isDigit(cardNum.charAt(7));
			flagNine = Character.isDigit(cardNum.charAt(8));
			flagTen = Character.isDigit(cardNum.charAt(9));
			flagEleven = Character.isDigit(cardNum.charAt(10));
			flagTwelve = Character.isDigit(cardNum.charAt(11));
			flagThirteen = Character.isDigit(cardNum.charAt(12));
			flagFourteen = Character.isDigit(cardNum.charAt(13));
			flagFifteen = Character.isDigit(cardNum.charAt(14));
			flagSixteen = Character.isDigit(cardNum.charAt(15));
			}
			if (flagOne && flagTwo && flagThree && flagFour && flagFive && flagSix && flagSeven && flagEight && flagNine && flagTen && flagEleven && flagTwelve && flagThirteen && flagFourteen && flagFifteen && flagSixteen) {
				validInfo = true;
				return cardNum;
			} else {
				System.out.println("Card number is invalid.");
				validInfo = false;
			}
			}
		return "oops";
	}
	
	public static String getCardExp (Scanner scnr, String prompt) {
		boolean validInfo = false;
		boolean flagOne = false;
		boolean flagTwo = false;
		boolean flagThree =	false;	
		boolean flagFour =	false;	
		boolean flagFive = false;
				
		while (validInfo == false) {
			System.out.println(prompt);
			String cardExp = scnr.nextLine();
			validInfo = isValidCardExp(cardExp);
			if (validInfo)
				return cardExp;
			else {
				System.out.println("Invalid input.");
			}
		}
		return null;
	}
	
	public static boolean isValidCardExp(String cardExp)
	{
		boolean validInfo = false;
		boolean flagOne = false;
		boolean flagTwo = false;
		boolean flagThree =	false;	
		boolean flagFour =	false;	
		boolean flagFive = false;
				
			if (cardExp.length() == 5) {
			flagOne = Character.isDigit(cardExp.charAt(0));
			flagTwo = Character.isDigit(cardExp.charAt(1));
			flagThree = Character.isDigit(cardExp.charAt(3));
			flagFour = Character.isDigit(cardExp.charAt(4));
			flagFive = (cardExp.charAt(2) == '/');
			}
			if (flagOne && flagTwo && flagThree && flagFour && flagFive) {
				validInfo = true;
				return true;
			} else {
				return false;
			}
	}
	
	public static String getCardCvv (Scanner scnr, String prompt) {
		boolean validInfo = false;
		while (validInfo == false) {
			System.out.println(prompt);
			String cardCvv = scnr.nextLine();
			validInfo = isValidCardCvv(cardCvv);
			if (validInfo)
			{
				return cardCvv;
			}
			else {
				System.out.println("Invalid input.");
			}
		}
		return null;
	}
	
	public static boolean isValidCardCvv (String cardCvv)
	{
		boolean flagOne = false;
		boolean flagTwo = false;
		boolean flagThree = false;
		
		if (cardCvv.length() == 3) {
		flagOne = Character.isDigit(cardCvv.charAt(0));
		flagTwo = Character.isDigit(cardCvv.charAt(1));
		flagThree = Character.isDigit(cardCvv.charAt(2));
		}
		
		if (flagOne && flagTwo && flagThree) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String getItem(Scanner scnr, String prompt, Map map) {
		boolean flag = true;
		String input = "";
		String firstLetter;
		
		while (flag) {
			input = getString(scnr, prompt);
			String[] words = input.split(" ");
			for (int i =0; i < words.length; i++)
			{
				firstLetter = words[i].substring(0,1).toUpperCase();
				words[i] = firstLetter + words[i].substring(1);
			}
			input = "";
			for (int i =0; i < words.length; i++)
			{
				input += words[i] + " ";
			}
			input = input.substring(0,input.length()-1);
			if (map.containsKey(input)) {
				flag = false;
			} else {
				System.out.println("Invalid input. Try again.");
			}
		}
		return input;
	}

}