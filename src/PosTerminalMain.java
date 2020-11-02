import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.FileInputStream;

public class PosTerminalMain {
	public static double orderTotal;
	public static String payType;
	public static Map<String, Double> menu = new HashMap<>();
	public static List<Product> cart = new ArrayList<>();
	private static Path filePath = Paths.get("Product.txt");
	public static Scanner scnr = new Scanner(System.in);
	public static void main(String[] args) {
		fakeLoad();
		do {
			cart.clear();
			orderTotal = 0;
			do {
				fillMenu();
				printMenu();
				String item = Validator.getItem(scnr, "What would you like to order?\r\n", menu);
				int itemQuant = Validator.getIntInRange(scnr, "How many would you like?\r\n", 1, 99);
				addItem(item, itemQuant);
			}
			while (Validator.getYesNo(scnr, "Would you like to keep ordering?\r\n"));
			
			printTotal();
			
			payType = takePay(Validator.getPaymentType(scnr, "How would you like to pay? (Cash/MasterCard/Check)"));
		//	takePay(payType);
			
//			System.out.println("Paid with " + payType);
			printReceipt();
			printTotal();
			
		}
		while(Validator.getYesNo(scnr, "Would you like start another order?\r\n"));
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
		{
		cart.add(new Product(item, menu.get(item)));
		orderTotal += menu.get(item);
		}
	}
	
	public static void printReceipt()
	{
		System.out.println("RECEIPT:");
		for(Product components : cart)
		{
			int i = 1;
			System.out.println(i + "." + components.getName() + "\t" +components.getPrice());
			i++;
		}
	}
	
	public static void printTotal()
	{
		System.out.println("Subtotal:\t" + orderTotal);
		System.out.println("Sales Tax:\t" + (orderTotal * .06));
		System.out.println("Grand Total:\t" + (orderTotal * 1.06));
	}
	
	public static void printMenu() {
	
	System.out.printf("Items" + "%16s" + "Price\r\n", "     ");
	System.out.println("--------------------------");

	for (Map.Entry<String, Double> entry : menu.entrySet()) {
		System.out.printf("%-16s" + "%-4s $" + entry.getValue() + "\r\n", entry.getKey(), "----");
	}
	System.out.println("--------------------------");
	}
	
	public static String takePay (String paymentType) { //need payment type validator - DONE
		paymentType = paymentType.toLowerCase();
		if (paymentType.equals("cash")) {
			System.out.println("Cash payment selected.");
			double cashAmnt = Validator.getDouble(scnr, "Please enter cash payment amount.\r\n");
			double changeTotal = cashAmnt - (orderTotal * 1.06);
			System.out.println("You paid with $" + cashAmnt + " cash.");
			System.out.println("Your change amount is $" + changeTotal);
			return "cash";
		} else if (paymentType.equals("check")) {
			System.out.println("Check payment selected.");
			String checkNum = Validator.getCheckNum(scnr, "Please enter your check number"); //need check number validator - DONE
			System.out.println("You paid with check number: " + checkNum);
			return "check";
		} else if (paymentType.equals("card")) {
			String cardNum;
			String cardExp;
			String cardCvv;
			System.out.println("Card payment selected. We only accept 16 digit card number MasterCards.");
			while(true) {
			cardNum = Validator.getCardNum(scnr, "Please enter your credit card number NOT including hyphens (-)"); // need card number validator (change type to long)
			boolean cardNumConf = Validator.getYesNo(scnr, "Is this the correct card number?\r\n" + cardNum + "\r\n");
			if (cardNumConf) {
				break;
			} else {
				System.out.println("Please re-enter your card number");
			}
			}
			while (true) {
			cardExp = Validator.getCardExp(scnr, "Please enter your card expiration date (mm/yy) format."); // need expiration validator
			boolean cardExpConf = Validator.getYesNo(scnr, "Is this the correct card expiration?\r\n" + cardExp + "\r\n");
			if (cardExpConf) {
				break;
			}
			}
			while (true) {
				cardCvv = Validator.getCardCvv(scnr, "Please enter the CVV code on the back of your card");
				boolean cardCvvConf = Validator.getYesNo(scnr, "Is this the correct card CVV code?\r\n" + cardCvv + "\r\n");
				if (cardCvvConf) {
					break;
				}
			}
			System.out.println("Card payment info:\r\n" + cardNum + "\r\n" + cardExp + "\r\n" + cardCvv + "\r\n");
		}
		return "card";
	}
	
	private static void fakeLoad ()
	{
		System.out.println("Loading.... Press enter to continue.");
		String engPassword = scnr.nextLine();
		if (engPassword.equals("hidden"))
		{
			engMode();
		}
	}
	private static void engMode ()
	{
		System.out.println("ENGINEERING MODE\rEnter a command:\r1) Add item");
		String input = scnr.nextLine();
	}
}