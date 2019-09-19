/*
 * @author Gabe Hedges
 * @version 9/11/19
 * 
 * 
 */

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*; //Allows files to be utilized

public class OOPReport {
	private ArrayList<Product> products; //Initiating ArrayList to hold all products
	

	public static void main(String[] args) {
		OOPReport report = new OOPReport();
		
		String fileName = report.getFileName(); //Getting filename from user
		System.out.println("\n" + "Product Inventory Summary Report\n" + "----------------------------------------------------------------------");
		String name, code, type;
		int r1, quant, price;
		List<Integer> ratings = new ArrayList<Integer>();
		ArrayList<String> file = new ArrayList<String>();
		List<Product> products = new ArrayList<Product>();
		System.out.println("\r\n" + 
				"Product Name              I Code    Type  Rating # Rat. Quant. Price \r\n" + 
				"------------------------ --------- ----  ------ ------ ------ ------");
		
		//Opening file
		try { 
			File testFile = new File(fileName);
			Scanner fileRead = new Scanner(testFile); //Initiating Scanner to read file
			
			//Input entire file into ArrayList
			int i = 0;
			while (fileRead.hasNextLine()) {
				file.add(fileRead.nextLine());
				i++;
			}

			int size = file.size();
			int count = 0;
			while (size > count) {
				Product p = new Product();
				name = file.get(count);
				p.setName(file.get(count));
				count++;
				p.setInventoryCode(file.get(count));
				count++;
				p.setQuantity(Integer.parseInt(file.get(count)));
				count++;
				p.setPrice(Integer.parseInt(file.get(count)));
				count++;
				p.setType(file.get(count));
				count++;
				r1 = Integer.parseInt(file.get(count));
				while (r1 >=0) { //While the rating is >=, add to ArrayList
					p.addUserRating(r1);
					count++;
					r1 = Integer.parseInt(file.get(count));
				}
				count++; //Increment to get past -1
				products.add(p); //add product to product ArrayList			
			} //End of while loop
			
			for (Product p : products) { //prints out each formatted product object
				report.format(p);
			}
			System.out.println("----------------------------------------------------------------------");
			System.out.println("Total products in database: " + products.size()); //Number of products
			System.out.println("Highest Average Ranked item: " + report.highestRanked(products).getName() + " ("
					+ report.toStar(report.highestRanked(products).getAvgUserRating()) + ")" ); //Use methods to get highest average ranked item
			System.out.println("Lowest Average Ranked item: " + report.lowestRanked(products).getName() + " ("
					+ report.toStar(report.lowestRanked(products).getAvgUserRating()) + ")" );
			System.out.println("Highest Total Dollar item: " + report.highestDollar(products).getName() + " (" + 
					report.dollarAmount(report.highestDollar(products).getQuantity()*report.highestDollar(products).getPrice()) +")");
			System.out.println("Lowest Total Dollar item: " + report.lowestDollar(products).getName() + " (" + 
					report.dollarAmount(report.lowestDollar(products).getQuantity()*report.lowestDollar(products).getPrice()) +")");
			System.out.println("----------------------------------------------------------------------");
			
		} catch (IOException e) {
			System.out.println("Error opening file"); }

	}
	
	public String getFileName() { //gets fileName from user input
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the file name: ");
		String name = kb.nextLine();
		return name;
	}
	
	public String dollarAmount(int price) { //obtain and return the dollar amount
		int thousand = 0;
		String total;
		int dollars = price / 100;
		int cents = price % 100; //remainder will be the cents
		if (dollars >= 1000) {
			thousand = dollars/1000;
			dollars = dollars%1000;
			total = "$" + thousand + "," + dollars + "." + cents;
		} else {
		 total = "$" + dollars + "." + cents; }
		return total;
	}
	
	

	public void format (Product p) {
	System.out.printf("%-25.25s %-9.9s %-5.5s %-8.8s %-5.5s %-5.5s %-7.7s \n", p.getName(), p.getInventoryCode(), p.getType(), 
			this.toStar(p.getAvgUserRating()), p.getUserRatingCount(), p.getQuantity(), 
			this.dollarAmount(p.getPrice()));	
	

	}
	
	public String toStar (int stars) {
		String star = "";

		if (stars > 0) { //Adds a start only if there are ratings. String "star" will be blank if no ratings
			for (int i = 1; i<= stars; i++)  {

			star += "*"; }
		} return star;
	}
	
	public Product newProduct() {
		Product p = new Product();
		
		return p;
	}
	public Product highestRanked(List<Product> p) {
		int large = 0;
		Product bigP = new Product();
		for (int g = 0; g <= p.size() -1; g++) {
			if (p.get(g).getAvgUserRating() > large) {
				large = p.get(g).getAvgUserRating();
				bigP = p.get(g);
			}
		} return bigP;
}
	public Product lowestRanked(List<Product> p) {
		int large = 5;
		Product smallP = new Product();
		for (int g = 0; g <= p.size() -1; g++) {
			if (p.get(g).getAvgUserRating() < large) {
				large = p.get(g).getAvgUserRating();
				smallP = p.get(g);
			}
		} return smallP;
}
	public Product highestDollar(List<Product> p) {
		int total = 0;
		Product largeP = new Product();
		for (int g = 0; g <= p.size() -1; g++) {
			if (p.get(g).getQuantity() * p.get(g).getPrice() > total) {
				total = p.get(g).getQuantity() * p.get(g).getPrice();
				largeP = p.get(g);
			}
		} return largeP;
}
	public Product lowestDollar(List<Product> p) {
		int total = p.get(0).getPrice()*p.get(0).getQuantity();
		Product littleP = new Product();
		for (int g = 0; g <= p.size() -1; g++) {
			if (p.get(g).getQuantity() * p.get(g).getPrice() < total) {
				total = p.get(g).getQuantity() * p.get(g).getPrice();
				littleP = p.get(g);
			}
		} return littleP;
}
	public int getLongest(List<Product> p) { //Gets the length of the name of the product with the longest name
		int length=0;
		for (int g = 0; g <= p.size() -1; g++) {
			if (p.get(g).getName().length() > length) {
				length = p.get(g).getName().length();
			}
		}
		return length;
	}
}
