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
	public static double total;
	public static String payType;
	public static Map<String, Double> menu = new HashMap<>();
	public static List<ProductInfo> cart = new ArrayList<>();
	private static Path filePath = Paths.get("Product.txt");
	public static Scanner scnr = new Scanner(System.in);
	public static void main(String[] args) {

		do {
			total = 0;
			do {
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
		//	takePay(payType);
			
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
	
	public static void printMenu() {
	
	System.out.println("Items\tPrice");
	System.out.println("------------");
	System.out.println("------------");

	for (Map.Entry<String, Double> entry : menu.entrySet()) {
		System.out.println("Key = " + "  " + entry.getKey() + "  " + "Value =" + entry.getValue());
	}
	}

}