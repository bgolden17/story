import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PosTerminalMain {

	public static void main(String[] args) {
		//choose store type -- Coffee Shop 
		
		//create product class w name, category, description. 
		
		//store products in a text file, 12 items minimum.
		
		//Project includes at least 3 classes; classes interact meaningfully. Methods are short and modular
		// 1 main class, 2 product class, <-- 3 child class to product class
		
		// Main:
		//present menu, let user choose item (by number or letter) and quantity. display line total (item price * quantity)
		//Either through the menu or a separate question, allow them to re-display the menu and to complete the purchase
		//Give the subtotal, sales tax, and grand total
		
		
		//Main paymentOption method:
		//Ask for payment type—cash, credit, or check
		//For cash, ask for amount tendered and provide change
		//For check, get the check number.
		//For credit, get the credit card number, expiration, and CVV.
		
		//Main totalCalc Method;
		//At the end, display a receipt with all items ordered, subtotal, grand total, and appropriate payment info.
		
		//Main menu Method;
		//Return to the original menu for a new order. (Hint: you’ll want an array or ArrayList to keep track of what’s been ordered!)
		
		/*
		 * init a scanner
		 * *Method* print the ArrayList menu
		 * ask user for input (item and quantity)
		 * *Method* put the input into the ArrayList order (use for loop for quantity)
		 * after ordering an item, ask if they want to order another (n breaks loop)
		 * redisplay the menu (old method) on y, have a break option
		 * 
		 * 
		 * ArrayList<String, Double> menu
		 * ArrayList<String, Double, Int> cart
		 * 
		 * Method void printMenu()
		 * 
		 * Method addItem void(String item, int quantity)
		 * 
		 * Method calcTotal double()
		 * 
		 * Method takePay void(String paymentType)
		 * 
		 * Method fillMenu void()
		 */
		Scanner scnr = new Scanner(System.in);
		double total;
		String payType;
		List<ProductInfo> menu = new ArrayList<>();
		List<Product> cart = new ArrayList<>();
		
		fillMenu();
		
		do
		{
			total = 0;
			do
			{
				printMenu();
				System.out.println("What item would you like to order?");
				String item = scnr.nextLine();
				System.out.println("How many would you like?");
				String itemQuant = scnr.nextLine();
				addItem(item, itemQuant);
			}
			while (Validator.getYesNo(scnr, "Would you like to keep ordering?"));
			
			calcTotal();
			System.out.println("Would you like to pay with cash, credit, or check?");
			payType = scnr.nextLine();
			takePay(payType);
			
			printReceipt();
			
		}
		while(Validator.getYesNo(scnr, "Would you like start another order?"));
	}
	
}
