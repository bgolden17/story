import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import day12_abstract_class_interface.HourlyEmployee;

public class PosTerminalMain {

	public static double total;
	public static String payType;
	public static Map<String, Double> menu = new HashMap<>();
	public static List<ProductInfo> cart = new ArrayList<>();
	private static Path filePath = Paths.get("Product.txt");
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
		 * Method printTotal double()
		 * 
		 * Method takePay void(String paymentType)
		 * 
		 * Method fillMenu void()
		 */
		Scanner scnr = new Scanner(System.in);	
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
				int itemQuant = scnr.nextInt();
				addItem(item, itemQuant);
			}
			while (Validator.getYesNo(scnr, "Would you like to keep ordering?"));
			
			printTotal();
			System.out.println("Would you like to pay with cash, credit, or check?");
			payType = scnr.nextLine();
			takePay(payType);
			
			System.out.println("Paid with " + payType);
			printReceipt();
			printTotal();
			
		}
		while(Validator.getYesNo(scnr, "Would you like start another order?"));
		scnr.close();
	}
	
	public static void fillMenu() {
		try {
			List<String> lines = Files.readAllLines(filePath);
			for (String line : lines) {
				String[] parts = line.split("~");
				String name = parts[0];
				double price = Double.parseDouble(parts[1]);

				menu.put(name, price);
			}
		} catch (IOException e) {
			System.out.println("Unable to read file.");
		}
	}
	
	public static void addItem(String item, int itemQuant)
	{
		for(int i = itemQuant; i > 0; i--)
		cart.add(new ProductInfo(item, menu.get(item)));
		total += menu.get(item);
	}
	
	public static void printReceipt()
	{
		for(ProductInfo components : cart)
		{
			System.out.println(components.getName() + "\t" +components.getPrice());
		}
	}
	
	public static void printTotal()
	{
		System.out.println("Subtotal:\t" + total);
		System.out.println("Sales Tax:\t" + (total * .06));
		System.out.println("Grand Total:\t" + (total * 1.06));
	}
	
}
