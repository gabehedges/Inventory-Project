import java.util.ArrayList;
import java.util.Scanner;
/**
 * A simple program to test some of the functionality of the Product class. Note
 * that this is NOT meant to be exhaustive.
 *
 * @author Gabe Hedges
 * @version 9/11/2019
 *
 */
public class TestProduct {

    public static void main(String[] args) {
        Product p = new Product();  //Declaring all necessary variables
        String name = "PRS Tremonti";
        String type = "Electric Guitar";
        String code = "EG-PRS1";
        ArrayList<Integer> ratings = new ArrayList<Integer>();
        int quantity = 23;
        int price = 39985;
        p.setName(name); //Setting private class variable to equal value of declared variables
        p.setType(type);
        p.setInventoryCode(code);
        p.setQuantity(quantity);
        p.setPrice(price);
        ratings.add(4); //Adding ratings into ArrayList
        ratings.add(5);
        ratings.add(-2); //Should see error message, out of range
        ratings.add(3);
        ratings.add(6); //Should see error message, out of range
        ratings.add(5);
        
        for (Integer rating : ratings) { //Using for-each loop to add ratings into p's private ArrayList
        	p.addUserRating(rating);
        }
        System.out.println("The " + p.getName() + " is an " + p.getType()+ " that costs " + p.getPrice() + " with an average user rating of " + p.getAvgUserRating() + " stars." );
        System.out.println("It's product code is " + p.getInventoryCode() + " and there are " + p.getQuantity() + " in stock.");
    }
}
