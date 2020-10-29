import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PosTerminalMain {
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
		//Ask for payment type�cash, credit, or check
		//For cash, ask for amount tendered and provide change
		//For check, get the check number.
		//For credit, get the credit card number, expiration, and CVV.
		
		//Main totalCalc Method;
		//At the end, display a receipt with all items ordered, subtotal, grand total, and appropriate payment info.
		
		//Main menu Method;
		//Return to the original menu for a new order. (Hint: you�ll want an array or ArrayList to keep track of what�s been ordered!)
		


	}

	public static Double calcTotal(int productCount,int price) {
		double total = productCount * price;
		
		
		
		return total;
		
	}
	
		public static  List<ProductInfo> fillMenu() {
			try {
				List<String> lines = Files.readAllLines(filePath);
				List<ProductInfo> things = new ArrayList<>();
				for (String line : lines) {
					String[] parts = line.split("~");
					String name = parts[0];
					double price = Double.parseDouble(parts[1]);

					things.add(new ProductInfo(name, price));
				}
				return things;

			} catch (IOException e) {
				System.out.println("Unable to read file.");
				return new ArrayList<>();
			}
		}
	
	
	
	
	}
	
	
	
	
	
	
	
	
	

